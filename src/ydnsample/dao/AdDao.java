package ydnsample.dao;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;

import jp.yahooapis.im.V4.AdGroupAdService.*;
import jp.yahooapis.im.V4.AdGroupAdService.Error;
import jp.yahooapis.im.V4.error.impl.AdGroupAdServiceErrorEntityFactory;
import jp.yahooapis.im.V4.util.SoapUtils;
import ydnsample.util.Display;

public class AdDao {

	private static AdGroupAdServiceInterface adService;

	static {
		try {
			adService = SoapUtils.createServiceInterface(AdGroupAdServiceInterface.class, AdGroupAdServiceService.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * AfGroup内のAdGroupAdを取得する
	 * 
	 * @param adId
	 * @return
	 * @throws ApiException
	 */
	public static List<AdGroupAd> findAll(long accountId, long adGroupId) throws ApiException {
		AdGroupAdSelector adSelector = new AdGroupAdSelector();
		Paging adPaging = new Paging();
		adPaging.setStartIndex(1);
		adPaging.setNumberResults(20);

		adSelector.setAccountId(accountId);
		adSelector.getAdGroupIds().add(adGroupId);
		adSelector.setPaging(adPaging);

		// call API
		Holder<AdGroupAdPage> getAdPageHolder = new Holder<AdGroupAdPage>();
		Holder<List<Error>> getAdErrorHolder = new Holder<List<Error>>();
		adService.get(adSelector, getAdPageHolder, getAdErrorHolder);

		// if error
		if (getAdErrorHolder.value != null && getAdErrorHolder.value.size() > 0) {
			SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(getAdErrorHolder.value), true);
		}

		// response
		List<AdGroupAd> ads = new ArrayList<>();
		if (getAdPageHolder.value != null) {
			AdGroupAdPage adPage = getAdPageHolder.value;
			if (adPage.getValues() != null && adPage.getValues().size() > 0) {
				for (int i = 0; i < adPage.getValues().size(); i++) {
					List<AdGroupAdValues> values = adPage.getValues();
					if (values.get(i).isOperationSucceeded()) {
						// display response
						ads.add(values.get(i).getAdGroupAd());
					} else {
						// if error
						SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(values.get(i).getError()), true);
					}
				}
			}
		}

		return ads;
	}

	public static void addAd(long accountId, AdGroupAd ad) throws ApiException {
		AdGroupAdOperation adOperation = new AdGroupAdOperation();
		adOperation.setOperator(Operator.ADD);
		adOperation.setAccountId(accountId);

		adOperation.getOperand().add(ad);

		// call API
		Holder<AdGroupAdReturnValue> adReturnValueHolder = new Holder<AdGroupAdReturnValue>();
		Holder<List<Error>> adSetErrorHolder = new Holder<List<Error>>();
		adService.mutate(adOperation, adReturnValueHolder, adSetErrorHolder);

		// if error
		if (adSetErrorHolder.value != null && adSetErrorHolder.value.size() > 0) {
			SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(adSetErrorHolder.value), true);
		}

		// response
		if (adReturnValueHolder.value != null) {
			AdGroupAdReturnValue returnValue = adReturnValueHolder.value;
			if (returnValue.getValues() != null) {
				List<AdGroupAdValues> adValuesList = returnValue.getValues();
				for (AdGroupAdValues adValues : adValuesList) {
					if (adValues.isOperationSucceeded()) {
						// display response
						System.out.println(String.format("Set Ad AdId=%d", ad.getAdId()));
						Display.print(adValues.getAdGroupAd());
					} else {
						// if error
						SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(adValues.getError()), true);
					}
				}
			}
		}
	}

	public static void clearAd(long accountId, long adGroupId) throws Exception {
		for (AdGroupAd ad : findAll(accountId, adGroupId)) {
			
			AdGroupAdOperation adOperation = new AdGroupAdOperation();
			adOperation.setOperator(Operator.REMOVE);
			adOperation.setAccountId(accountId);

			adOperation.getOperand().add(ad);

			// call API
			Holder<AdGroupAdReturnValue> adReturnValueHolder = new Holder<AdGroupAdReturnValue>();
			Holder<List<Error>> adSetErrorHolder = new Holder<List<Error>>();
			adService.mutate(adOperation, adReturnValueHolder, adSetErrorHolder);

			// if error
			if (adSetErrorHolder.value != null && adSetErrorHolder.value.size() > 0) {
				SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(adSetErrorHolder.value), true);
			}

			// response
			if (adReturnValueHolder.value != null) {
				AdGroupAdReturnValue returnValue = adReturnValueHolder.value;
				if (returnValue.getValues() != null) {
					List<AdGroupAdValues> adValuesList = returnValue.getValues();
					for (AdGroupAdValues adValues : adValuesList) {
						if (adValues.isOperationSucceeded()) {
							// display response
							System.out.println(String.format("Removed Ad AdId=%d", ad.getAdId()));
							Display.print(adValues.getAdGroupAd());
						} else {
							// if error
							System.err.println(String.format("Removing Errr Ad AdId=%d", ad.getAdId()));
							SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(adValues.getError()), true);
						}
					}
				}
			}
			
			// 対象のメディアを消す
			System.out.println(String.format("Removing media MediaId=%d", ad.getMediaId()));
			MediaDao.removeMedia(accountId, ad.getMediaId());
		}
	}
}
