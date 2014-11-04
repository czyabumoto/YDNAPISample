package ydnsample.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

import jp.yahooapis.im.V4.CampaignService.ApiException;
import jp.yahooapis.im.V4.CampaignService.Campaign;
import jp.yahooapis.im.V4.CampaignService.CampaignOperation;
import jp.yahooapis.im.V4.CampaignService.CampaignPage;
import jp.yahooapis.im.V4.CampaignService.CampaignReturnValue;
import jp.yahooapis.im.V4.CampaignService.CampaignSelector;
import jp.yahooapis.im.V4.CampaignService.CampaignServiceInterface;
import jp.yahooapis.im.V4.CampaignService.CampaignServiceService;
import jp.yahooapis.im.V4.CampaignService.CampaignValues;
import jp.yahooapis.im.V4.CampaignService.Operator;
import jp.yahooapis.im.V4.CampaignService.Paging;
import jp.yahooapis.im.V4.CampaignService.Error;
import jp.yahooapis.im.V4.error.impl.CampaignServiceErrorEntityFactory;
import jp.yahooapis.im.V4.util.SoapUtils;
import ydnsample.util.Display;

public class CampaignDao {

	private static CampaignServiceInterface campaignService;

	static {
		try {
			campaignService = SoapUtils.createServiceInterface(CampaignServiceInterface.class, CampaignServiceService.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * アカウント内のキャンペーンを取得する
	 * 
	 * @param CampaignId
	 * @return
	 * @throws ApiException
	 */
	public static List<Campaign> findAll(long accountId) throws ApiException {
		CampaignSelector campaignSelector = new CampaignSelector();
		Paging campaignPaging = new Paging();
		campaignPaging.setStartIndex(1);
		campaignPaging.setNumberResults(20);

		campaignSelector.setAccountId(accountId);
		campaignSelector.setPaging(campaignPaging);

		// call API
		Holder<CampaignPage> getCampaignPageHolder = new Holder<CampaignPage>();
		Holder<List<Error>> getCampaignErrorHolder = new Holder<List<Error>>();
		campaignService.get(campaignSelector, getCampaignPageHolder, getCampaignErrorHolder);

		// if error
		if (getCampaignErrorHolder.value != null && getCampaignErrorHolder.value.size() > 0) {
			SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(getCampaignErrorHolder.value), true);
		}

		// response
		List<Campaign> Campaigns = new ArrayList<>();
		if (getCampaignPageHolder.value != null) {
			CampaignPage CampaignPage = getCampaignPageHolder.value;
			if (CampaignPage.getValues() != null && CampaignPage.getValues().size() > 0) {
				for (int i = 0; i < CampaignPage.getValues().size(); i++) {
					List<CampaignValues> values = CampaignPage.getValues();
					if (values.get(i).isOperationSucceeded()) {
						// display response
						Campaigns.add(values.get(i).getCampaign());
					} else {
						// if error
						SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(values.get(i).getError()), true);
					}
				}
			}
		}

		return Campaigns;
	}

	public static Campaign addCampaign(long accountId, Campaign campaign) throws ApiException {
		CampaignOperation campaignOperation = new CampaignOperation();
		campaignOperation.setOperator(Operator.ADD);
		campaignOperation.setAccountId(accountId);
		campaignOperation.getOperand().add(campaign);

		// call API
		Holder<CampaignReturnValue> CampaignReturnValueHolder = new Holder<CampaignReturnValue>();
		Holder<List<Error>> CampaignSetErrorHolder = new Holder<List<Error>>();
		campaignService.mutate(campaignOperation, CampaignReturnValueHolder, CampaignSetErrorHolder);

		// if error
		if (CampaignSetErrorHolder.value != null && CampaignSetErrorHolder.value.size() > 0) {
			SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(CampaignSetErrorHolder.value), true);
		}

		// response
		if (CampaignReturnValueHolder.value != null) {
			CampaignReturnValue returnValue = CampaignReturnValueHolder.value;
			if (returnValue.getValues() != null) {
				List<CampaignValues> campaignValuesList = returnValue.getValues();
				for (CampaignValues campaignValues : campaignValuesList) {
					if (campaignValues.isOperationSucceeded()) {
						// display response
						Campaign result = campaignValues.getCampaign();
						System.out.println(String.format("Set Campaign CampaignId=%d", result.getCampaignId()));
						Display.print(campaignValues.getCampaign());
						return result;
					} else {
						// if error
						SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(campaignValues.getError()), true);
					}
				}
			}
		}
		return null;
	}
	
	public static void clearCampaign(long accountId) throws Exception {
		for (Campaign campaign : findAll(accountId)) {
			// 対象のAdGroupクリア
			System.out.println(String.format("Removing adGroup campaignId=%d", campaign.getCampaignId()));
			AdGroupDao.clearAdGroup(accountId, campaign.getCampaignId());
			
			CampaignOperation campaignOperation = new CampaignOperation();
			campaignOperation.setOperator(Operator.REMOVE);
			campaignOperation.setAccountId(accountId);
			campaignOperation.getOperand().add(campaign);
			
			Holder<CampaignReturnValue> CampaignReturnValueHolder = new Holder<CampaignReturnValue>();
			Holder<List<Error>> CampaignSetErrorHolder = new Holder<List<Error>>();
			campaignService.mutate(campaignOperation, CampaignReturnValueHolder, CampaignSetErrorHolder);
			
			// if error
			if (CampaignSetErrorHolder.value != null && CampaignSetErrorHolder.value.size() > 0) {
				SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(CampaignSetErrorHolder.value), true);
			}

			// response
			if (CampaignReturnValueHolder.value != null) {
				CampaignReturnValue returnValue = CampaignReturnValueHolder.value;
				if (returnValue.getValues() != null) {
					List<CampaignValues> campaignValuesList = returnValue.getValues();
					for (CampaignValues campaignValues : campaignValuesList) {
						if (campaignValues.isOperationSucceeded()) {
							// display response
							System.out.println(String.format("Removed Campaign CampaignId=%d", campaign.getCampaignId()));
							Display.print(campaignValues.getCampaign());
						} else {
							// if error
							System.err.println(String.format("Removing Error Campaign CampaignId=%d", campaign.getCampaignId()));
							SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(campaignValues.getError()), true);
						}
					}
				}
			}
		}
	}
}
