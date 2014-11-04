package ydnsample.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

import jp.yahooapis.im.V4.AdGroupService.ApiException;
import jp.yahooapis.im.V4.AdGroupService.AdGroup;
import jp.yahooapis.im.V4.AdGroupService.AdGroupOperation;
import jp.yahooapis.im.V4.AdGroupService.AdGroupPage;
import jp.yahooapis.im.V4.AdGroupService.AdGroupReturnValue;
import jp.yahooapis.im.V4.AdGroupService.AdGroupSelector;
import jp.yahooapis.im.V4.AdGroupService.AdGroupServiceInterface;
import jp.yahooapis.im.V4.AdGroupService.AdGroupServiceService;
import jp.yahooapis.im.V4.AdGroupService.AdGroupValues;
import jp.yahooapis.im.V4.AdGroupService.Operator;
import jp.yahooapis.im.V4.AdGroupService.Paging;
import jp.yahooapis.im.V4.AdGroupService.Error;
import jp.yahooapis.im.V4.error.impl.AdGroupServiceErrorEntityFactory;
import jp.yahooapis.im.V4.util.SoapUtils;
import ydnsample.util.Display;

public class AdGroupDao {

	private static AdGroupServiceInterface adGroupService;

	static {
		try {
			adGroupService = SoapUtils.createServiceInterface(AdGroupServiceInterface.class, AdGroupServiceService.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * アカウント内のキャンペーンを取得する
	 * 
	 * @param adGroupId
	 * @return
	 * @throws ApiException
	 */
	public static List<AdGroup> findAll(long accountId, long campaignId) throws ApiException {
		AdGroupSelector adGroupSelector = new AdGroupSelector();
		Paging adGroupPaging = new Paging();
		adGroupPaging.setStartIndex(1);
		adGroupPaging.setNumberResults(20);
		
		adGroupSelector.setAccountId(accountId);
		adGroupSelector.getCampaignIds().add(campaignId);
		adGroupSelector.setPaging(adGroupPaging);

		// call API
		Holder<AdGroupPage> getadGroupPageHolder = new Holder<AdGroupPage>();
		Holder<List<Error>> getadGroupErrorHolder = new Holder<List<Error>>();
		adGroupService.get(adGroupSelector, getadGroupPageHolder, getadGroupErrorHolder);

		// if error
		if (getadGroupErrorHolder.value != null && getadGroupErrorHolder.value.size() > 0) {
			SoapUtils.displayErrors(new AdGroupServiceErrorEntityFactory(getadGroupErrorHolder.value), true);
		}

		// response
		List<AdGroup> adGroups = new ArrayList<>();
		if (getadGroupPageHolder.value != null) {
			AdGroupPage adGroupPage = getadGroupPageHolder.value;
			if (adGroupPage.getValues() != null && adGroupPage.getValues().size() > 0) {
				for (int i = 0; i < adGroupPage.getValues().size(); i++) {
					List<AdGroupValues> values = adGroupPage.getValues();
					if (values.get(i).isOperationSucceeded()) {
						// display response
						adGroups.add(values.get(i).getAdGroup());
					} else {
						// if error
						SoapUtils.displayErrors(new AdGroupServiceErrorEntityFactory(values.get(i).getError()), true);
					}
				}
			}
		}

		return adGroups;
	}

	public static AdGroup addAdGroup(long accountId, AdGroup adGroup) throws ApiException {
		AdGroupOperation adGroupOperation = new AdGroupOperation();
		adGroupOperation.setOperator(Operator.ADD);
		adGroupOperation.setAccountId(accountId);
		adGroupOperation.setCampaignId(adGroup.getCampaignId());
		adGroupOperation.getOperand().add(adGroup);

		// call API
		Holder<AdGroupReturnValue> adGroupReturnValueHolder = new Holder<AdGroupReturnValue>();
		Holder<List<Error>> adGroupSetErrorHolder = new Holder<List<Error>>();
		adGroupService.mutate(adGroupOperation, adGroupReturnValueHolder, adGroupSetErrorHolder);

		// if error
		if (adGroupSetErrorHolder.value != null && adGroupSetErrorHolder.value.size() > 0) {
			SoapUtils.displayErrors(new AdGroupServiceErrorEntityFactory(adGroupSetErrorHolder.value), true);
		}

		// response
		if (adGroupReturnValueHolder.value != null) {
			AdGroupReturnValue returnValue = adGroupReturnValueHolder.value;
			if (returnValue.getValues() != null) {
				List<AdGroupValues> adGroupValuesList = returnValue.getValues();
				for (AdGroupValues adGroupValues : adGroupValuesList) {
					if (adGroupValues.isOperationSucceeded()) {
						// display response
						AdGroup result = adGroupValues.getAdGroup();
						System.out.println(String.format("Set AdGroup adGroupId=%s", result.getAdGroupId()));
						Display.print(result);
						return result;
					} else {
						// if error
						System.err.println(String.format("Setting Error AdGroup AdGroupId=%d", adGroup.getAdGroupId()));
						SoapUtils.displayErrors(new AdGroupServiceErrorEntityFactory(adGroupValues.getError()), true);
					}
				}
			}
		}
		return null;
	}
	
	public static void clearAdGroup(long accountId, long campaignId) throws Exception {
		for (AdGroup adGroup : findAll(accountId, campaignId)) {
			// 対象のAdを全て消す
			System.out.println(String.format("Removing ad adGroupId=%d", adGroup.getAdGroupId()));
			AdDao.clearAd(accountId, adGroup.getAdGroupId());
			
			AdGroupOperation adGroupOperation = new AdGroupOperation();
			adGroupOperation.setOperator(Operator.REMOVE);
			adGroupOperation.setAccountId(accountId);
			adGroupOperation.setCampaignId(campaignId);
			adGroupOperation.getOperand().add(adGroup);

			// call API
			Holder<AdGroupReturnValue> adGroupReturnValueHolder = new Holder<AdGroupReturnValue>();
			Holder<List<Error>> adGroupSetErrorHolder = new Holder<List<Error>>();
			adGroupService.mutate(adGroupOperation, adGroupReturnValueHolder, adGroupSetErrorHolder);

			// if error
			if (adGroupSetErrorHolder.value != null && adGroupSetErrorHolder.value.size() > 0) {
				SoapUtils.displayErrors(new AdGroupServiceErrorEntityFactory(adGroupSetErrorHolder.value), true);
			}

			// response
			if (adGroupReturnValueHolder.value != null) {
				AdGroupReturnValue returnValue = adGroupReturnValueHolder.value;
				if (returnValue.getValues() != null) {
					List<AdGroupValues> adGroupValuesList = returnValue.getValues();
					for (AdGroupValues adGroupValues : adGroupValuesList) {
						if (adGroupValues.isOperationSucceeded()) {
							// display response
							System.out.println(String.format("Removed AdGroup adGroupId=%d", adGroup.getAdGroupId()));
							Display.print(adGroupValues.getAdGroup());
						} else {
							// if error
							SoapUtils.displayErrors(new AdGroupServiceErrorEntityFactory(adGroupValues.getError()), true);
						}
					}
				}
			}
		}
	}
}
