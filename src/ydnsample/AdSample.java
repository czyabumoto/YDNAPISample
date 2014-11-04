package ydnsample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

import jp.yahooapis.im.V4.AdGroupAdService.Ad;
import jp.yahooapis.im.V4.AdGroupAdService.AdGroupAd;
import jp.yahooapis.im.V4.AdGroupAdService.AdGroupAdOperation;
import jp.yahooapis.im.V4.AdGroupAdService.AdGroupAdPage;
import jp.yahooapis.im.V4.AdGroupAdService.AdGroupAdReturnValue;
import jp.yahooapis.im.V4.AdGroupAdService.AdGroupAdSelector;
import jp.yahooapis.im.V4.AdGroupAdService.AdGroupAdServiceInterface;
import jp.yahooapis.im.V4.AdGroupAdService.AdGroupAdServiceService;
import jp.yahooapis.im.V4.AdGroupAdService.AdGroupAdValues;
import jp.yahooapis.im.V4.AdGroupAdService.AdStyle;
import jp.yahooapis.im.V4.AdGroupAdService.AdType;
import jp.yahooapis.im.V4.AdGroupAdService.ManualCPCAdGroupAdBid;
import jp.yahooapis.im.V4.AdGroupAdService.MobileAd;
import jp.yahooapis.im.V4.AdGroupAdService.PosAd;
import jp.yahooapis.im.V4.AdGroupAdService.TextAd;
import jp.yahooapis.im.V4.AdGroupService.AdGroup;
import jp.yahooapis.im.V4.AdGroupService.AdGroupOperation;
import jp.yahooapis.im.V4.AdGroupService.AdGroupPage;
import jp.yahooapis.im.V4.AdGroupService.AdGroupReturnValue;
import jp.yahooapis.im.V4.AdGroupService.AdGroupSelector;
import jp.yahooapis.im.V4.AdGroupService.AdGroupServiceInterface;
import jp.yahooapis.im.V4.AdGroupService.AdGroupServiceService;
import jp.yahooapis.im.V4.AdGroupService.AdGroupValues;
import jp.yahooapis.im.V4.AdGroupService.DeviceAppType;
import jp.yahooapis.im.V4.AdGroupService.DeviceOsType;
import jp.yahooapis.im.V4.AdGroupService.DeviceType;
import jp.yahooapis.im.V4.AdGroupService.ManualCPCAdGroupBid;
import jp.yahooapis.im.V4.AdGroupTargetService.AdGroupTargetList;
import jp.yahooapis.im.V4.AdGroupTargetService.AdGroupTargetOperation;
import jp.yahooapis.im.V4.AdGroupTargetService.AdGroupTargetPage;
import jp.yahooapis.im.V4.AdGroupTargetService.AdGroupTargetReturnValue;
import jp.yahooapis.im.V4.AdGroupTargetService.AdGroupTargetSelector;
import jp.yahooapis.im.V4.AdGroupTargetService.AdGroupTargetServiceInterface;
import jp.yahooapis.im.V4.AdGroupTargetService.AdGroupTargetServiceService;
import jp.yahooapis.im.V4.AdGroupTargetService.AdGroupTargetValues;
import jp.yahooapis.im.V4.AdGroupTargetService.AdScheduleTarget;
import jp.yahooapis.im.V4.AdGroupTargetService.AdScheduleTargetList;
import jp.yahooapis.im.V4.AdGroupTargetService.Age;
import jp.yahooapis.im.V4.AdGroupTargetService.AgeTarget;
import jp.yahooapis.im.V4.AdGroupTargetService.AgeTargetList;
import jp.yahooapis.im.V4.AdGroupTargetService.DayOfWeek;
import jp.yahooapis.im.V4.AdGroupTargetService.EstimateFlg;
import jp.yahooapis.im.V4.AdGroupTargetService.Gender;
import jp.yahooapis.im.V4.AdGroupTargetService.GenderTarget;
import jp.yahooapis.im.V4.AdGroupTargetService.GenderTargetList;
import jp.yahooapis.im.V4.AdGroupTargetService.GeoTarget;
import jp.yahooapis.im.V4.AdGroupTargetService.GeoTargetList;
import jp.yahooapis.im.V4.AdGroupTargetService.InterestCategoryTarget;
import jp.yahooapis.im.V4.AdGroupTargetService.InterestCategoryTargetList;
import jp.yahooapis.im.V4.AdGroupTargetService.SearchTarget;
import jp.yahooapis.im.V4.AdGroupTargetService.SearchTargetList;
import jp.yahooapis.im.V4.AdGroupTargetService.SiteCategoryTarget;
import jp.yahooapis.im.V4.AdGroupTargetService.SiteCategoryTargetList;
import jp.yahooapis.im.V4.AdGroupTargetService.SiteRetargetingTarget;
import jp.yahooapis.im.V4.AdGroupTargetService.SiteRetargetingTargetList;
import jp.yahooapis.im.V4.AdGroupTargetService.TargetList;
import jp.yahooapis.im.V4.AdGroupTargetService.TargetType;
import jp.yahooapis.im.V4.CampaignService.BiddingStrategyType;
import jp.yahooapis.im.V4.CampaignService.Budget;
import jp.yahooapis.im.V4.CampaignService.BudgetDeliveryMethod;
import jp.yahooapis.im.V4.CampaignService.Campaign;
import jp.yahooapis.im.V4.CampaignService.CampaignOperation;
import jp.yahooapis.im.V4.CampaignService.CampaignPage;
import jp.yahooapis.im.V4.CampaignService.CampaignReturnValue;
import jp.yahooapis.im.V4.CampaignService.CampaignSelector;
import jp.yahooapis.im.V4.CampaignService.CampaignServiceInterface;
import jp.yahooapis.im.V4.CampaignService.CampaignServiceService;
import jp.yahooapis.im.V4.CampaignService.CampaignValues;
import jp.yahooapis.im.V4.CampaignService.Error;
import jp.yahooapis.im.V4.CampaignService.FrequencyCap;
import jp.yahooapis.im.V4.CampaignService.FrequencyLevel;
import jp.yahooapis.im.V4.CampaignService.FrequencyTimeUnit;
import jp.yahooapis.im.V4.CampaignService.ManualCPC;
import jp.yahooapis.im.V4.CampaignService.Paging;
import jp.yahooapis.im.V4.error.impl.AdGroupAdServiceErrorEntityFactory;
import jp.yahooapis.im.V4.error.impl.AdGroupServiceErrorEntityFactory;
import jp.yahooapis.im.V4.error.impl.AdGroupTargetServiceErrorEntityFactory;
import jp.yahooapis.im.V4.error.impl.CampaignServiceErrorEntityFactory;
import jp.yahooapis.im.V4.util.SoapUtils;

/**
 * Sample Program for
 * CampaignService,AdGroupService,AdGroupAdService,AdGroupTargetService.
 * Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class AdSample {

	// 1:追加
	// 2:参照
	// 3:全AdGroupAdを削除
	public static int Mode = 2;
	private static List<Long> campaignIds = new ArrayList<>();
	private static List<Long> adGroupIds = new ArrayList<>();

	static class AGA {
		public long campaign_id;
		public long ad_group_id;
		public long ad_group_ad_id;

		public AGA(long campaign_id, long ad_group_id, long ad_group_ad_id) {
			super();
			this.campaign_id = campaign_id;
			this.ad_group_id = ad_group_id;
			this.ad_group_ad_id = ad_group_ad_id;
		}

		@Override
		public String toString() {
			return "(" + campaign_id + ", " + ad_group_id + ", " + ad_group_ad_id + ")";
		}
	}

	private static List<AGA> agaIds = new ArrayList<>();

	/**
	 * main method for AdSample
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {

		try {
			long accountId = SoapUtils.getAccountId();

			// =================================================================
			// CampaignService
			// =================================================================
			CampaignServiceInterface campaignService = SoapUtils.createServiceInterface(CampaignServiceInterface.class, CampaignServiceService.class);

			// =================================================================
			// AdGroupService
			// =================================================================
			AdGroupServiceInterface adGroupService = SoapUtils.createServiceInterface(AdGroupServiceInterface.class, AdGroupServiceService.class);

			// =================================================================
			// AdGroupTargetService
			// =================================================================
			AdGroupTargetServiceInterface adGroupTargetService = SoapUtils.createServiceInterface(AdGroupTargetServiceInterface.class, AdGroupTargetServiceService.class);
			// =================================================================
			// AdGroupAdService
			// =================================================================
			AdGroupAdServiceInterface adGroupAdService = SoapUtils.createServiceInterface(AdGroupAdServiceInterface.class, AdGroupAdServiceService.class);

			// -----------------------------------------------
			// CampaignService::mutate(ADD)
			// -----------------------------------------------
			// request
			if (Mode == 1) {
				Campaign addCampaignOperand = new Campaign();
				addCampaignOperand.setAccountId(accountId);
				addCampaignOperand.setCampaignName("SampleCampaign_CreateOn_" + SoapUtils.getCurrentTimestamp());
				addCampaignOperand.setUserStatus(jp.yahooapis.im.V4.CampaignService.UserStatus.ACTIVE);
				addCampaignOperand.setStartDate("20141008");
				addCampaignOperand.setEndDate("20301231");
				Budget budget = new Budget();
				budget.setAmount((long) 1000);
				budget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);
				addCampaignOperand.setBudget(budget);
				ManualCPC manualCPC = new ManualCPC();
				manualCPC.setType(BiddingStrategyType.MANUAL_CPC);
				addCampaignOperand.setBiddingStrategy(manualCPC);
				addCampaignOperand.setAdProductType("TARGET_MATCH");
				FrequencyCap frequencyCap = new FrequencyCap();
				frequencyCap.setLevel(FrequencyLevel.CAMPAIGN);
				frequencyCap.setTimeUnit(FrequencyTimeUnit.WEEK);
				frequencyCap.setImpression((long) 10);
				addCampaignOperand.setFrequencyCap(frequencyCap);

				CampaignOperation addCampaignOperation = new CampaignOperation();
				addCampaignOperation.setOperator(jp.yahooapis.im.V4.CampaignService.Operator.ADD);
				addCampaignOperation.setAccountId(accountId);
				addCampaignOperation.getOperand().add(addCampaignOperand);

				// call API
				System.out.println("############################################");
				System.out.println("CampaignService::mutate(ADD)");
				System.out.println("############################################");
				Holder<CampaignReturnValue> addCampaignReturnValueHolder = new Holder<CampaignReturnValue>();
				Holder<List<Error>> addCampaignErrorHolder = new Holder<List<Error>>();
				campaignService.mutate(addCampaignOperation, addCampaignReturnValueHolder, addCampaignErrorHolder);

				// if error
				if (addCampaignErrorHolder.value != null && addCampaignErrorHolder.value.size() > 0) {
					SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(addCampaignErrorHolder.value), true);
				}

				// response
				long campaignId = -1;
				if (addCampaignReturnValueHolder.value != null) {
					CampaignReturnValue returnValue = addCampaignReturnValueHolder.value;
					if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
						List<CampaignValues> values = returnValue.getValues();
						for (int i = 0; i < values.size(); i++) {
							if (values.get(i).isOperationSucceeded()) {
								// display response
								Campaign campaign = values.get(i).getCampaign();
								campaignId = campaign.getCampaignId();
								displayCampaign(campaign);
							} else {
								// if error
								SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(values.get(i).getError()), true);
							}
						}
					}
				}

				// -----------------------------------------------
				// AdGroupService::mutate(ADD)
				// -----------------------------------------------
				// request
				AdGroup addAdGroupOperand = new AdGroup();
				addAdGroupOperand.setAccountId(accountId);
				addAdGroupOperand.setCampaignId(campaignId);
				addAdGroupOperand.setAdGroupName("SampleAdGroup_CreateOn_" + SoapUtils.getCurrentTimestamp());
				addAdGroupOperand.setUserStatus(jp.yahooapis.im.V4.AdGroupService.UserStatus.ACTIVE);
				ManualCPCAdGroupBid addAdGroupBid = new ManualCPCAdGroupBid();
				addAdGroupBid.setType(jp.yahooapis.im.V4.AdGroupService.BiddingStrategyType.MANUAL_CPC);
				addAdGroupBid.setMaxCpc((long) 120);
				addAdGroupOperand.setBid(addAdGroupBid);
				addAdGroupOperand.getDevice().add(DeviceType.SMARTPHONE);
				addAdGroupOperand.getDeviceOs().add(DeviceOsType.IOS);
				addAdGroupOperand.getDeviceApp().add(DeviceAppType.APP);

				AdGroupOperation addAdGroupOperation = new AdGroupOperation();
				addAdGroupOperation.setOperator(jp.yahooapis.im.V4.AdGroupService.Operator.ADD);
				addAdGroupOperation.setAccountId(accountId);
				addAdGroupOperation.setCampaignId(campaignId);
				addAdGroupOperation.getOperand().add(addAdGroupOperand);

				// call API
				System.out.println("############################################");
				System.out.println("AdGroupService::mutate(ADD)");
				System.out.println("############################################");
				Holder<AdGroupReturnValue> addAdgroupReturnValueHolder = new Holder<AdGroupReturnValue>();
				Holder<List<jp.yahooapis.im.V4.AdGroupService.Error>> addAdGroupErrorHolder = new Holder<List<jp.yahooapis.im.V4.AdGroupService.Error>>();
				adGroupService.mutate(addAdGroupOperation, addAdgroupReturnValueHolder, addAdGroupErrorHolder);

				// if error
				if (addAdGroupErrorHolder.value != null && addAdGroupErrorHolder.value.size() > 0) {
					SoapUtils.displayErrors(new AdGroupServiceErrorEntityFactory(addAdGroupErrorHolder.value), true);
				}

				long adGroupId = -1;
				// response
				if (addAdgroupReturnValueHolder.value != null) {
					AdGroupReturnValue returnValue = addAdgroupReturnValueHolder.value;
					if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
						List<AdGroupValues> values = returnValue.getValues();
						for (int i = 0; i < values.size(); i++) {
							if (values.get(i).isOperationSucceeded()) {
								// display response
								AdGroup adGroup = values.get(i).getAdGroup();
								adGroupId = adGroup.getAdGroupId();
								displayAdGroup(adGroup);
							} else {
								// if error
								SoapUtils.displayErrors(new AdGroupServiceErrorEntityFactory(values.get(i).getError()), true);
							}
						}
					}
				}
			}

			// -----------------------------------------------
			// CampaignService::get
			// -----------------------------------------------
			CampaignSelector campaignSelector = new CampaignSelector();
			campaignSelector.setAccountId(accountId);
			campaignSelector.getUserStatus().addAll(Arrays.asList(jp.yahooapis.im.V4.CampaignService.UserStatus.ACTIVE, jp.yahooapis.im.V4.CampaignService.UserStatus.PAUSED));
			Paging campaignPaging = new Paging();
			campaignPaging.setStartIndex(1);
			campaignPaging.setNumberResults(20);
			campaignSelector.setPaging(campaignPaging);

			// call API
			System.out.println("############################################");
			System.out.println("CampaignService::get");
			System.out.println("############################################");
			Holder<CampaignPage> campaignPageHolder = new Holder<CampaignPage>();
			Holder<List<Error>> getCampaignErrorHolder = new Holder<List<Error>>();
			campaignService.get(campaignSelector, campaignPageHolder, getCampaignErrorHolder);

			// if error
			if (getCampaignErrorHolder.value != null && getCampaignErrorHolder.value.size() > 0) {
				SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(getCampaignErrorHolder.value), true);
			}

			// response
			if (campaignPageHolder.value != null) {
				CampaignPage campaignPage = campaignPageHolder.value;
				if (campaignPage.getValues() != null && campaignPage.getValues().size() > 0) {
					List<CampaignValues> values = campaignPage.getValues();
					for (int i = 0; i < values.size(); i++) {
						if (values.get(i).isOperationSucceeded()) {
							Campaign campaign = values.get(i).getCampaign();
							campaignIds.add(campaign.getCampaignId());
							displayCampaign(campaign);
						} else {
							// if error
							SoapUtils.displayErrors(new CampaignServiceErrorEntityFactory(values.get(i).getError()), true);
						}
					}
				}
			}

			// -----------------------------------------------
			// AdGroupService::get
			// -----------------------------------------------
			AdGroupSelector adGroupSelector = new AdGroupSelector();
			adGroupSelector.setAccountId(accountId);
			// adGroupSelector.getCampaignIds().add(campaignId);
			// adGroupSelector.getAdGroupIds().add(adGroupId);
			adGroupSelector.getUserStatuses().addAll(Arrays.asList(jp.yahooapis.im.V4.AdGroupService.UserStatus.ACTIVE, jp.yahooapis.im.V4.AdGroupService.UserStatus.PAUSED));
			jp.yahooapis.im.V4.AdGroupService.Paging adGroupPaging = new jp.yahooapis.im.V4.AdGroupService.Paging();
			adGroupPaging.setStartIndex(1);
			adGroupPaging.setNumberResults(20);
			adGroupSelector.setPaging(adGroupPaging);

			// call API
			System.out.println("############################################");
			System.out.println("AdGroupService::get");
			System.out.println("############################################");
			Holder<AdGroupPage> adGroupPageHolder = new Holder<AdGroupPage>();
			Holder<List<jp.yahooapis.im.V4.AdGroupService.Error>> getAdGroupErrorHolder = new Holder<List<jp.yahooapis.im.V4.AdGroupService.Error>>();
			adGroupService.get(adGroupSelector, adGroupPageHolder, getAdGroupErrorHolder);

			// if error
			if (getAdGroupErrorHolder.value != null && getAdGroupErrorHolder.value.size() > 0) {
				SoapUtils.displayErrors(new AdGroupServiceErrorEntityFactory(getAdGroupErrorHolder.value), true);
			}

			// response
			if (adGroupPageHolder.value != null) {
				AdGroupPage adGroupPage = adGroupPageHolder.value;
				if (adGroupPage.getValues() != null && adGroupPage.getValues().size() > 0) {
					List<AdGroupValues> values = adGroupPage.getValues();
					for (int i = 0; i < values.size(); i++) {
						if (values.get(i).isOperationSucceeded()) {
							AdGroup g = values.get(i).getAdGroup();
							adGroupIds.add(g.getAdGroupId());
							displayAdGroup(g);
						} else {
							// if error
							SoapUtils.displayErrors(new AdGroupServiceErrorEntityFactory(values.get(i).getError()), true);
						}
					}
				}
			}

			// -----------------------------------------------
			// AdGroupAdService::get
			// -----------------------------------------------
			AdGroupAdSelector adGroupAdSelector = new AdGroupAdSelector();
			adGroupAdSelector.setAccountId(accountId);
			for (Long campaignId : campaignIds) {
				adGroupAdSelector.getCampaignIds().add(campaignId);
			}
			for (Long adGroupId : adGroupIds) {
				adGroupAdSelector.getAdGroupIds().add(adGroupId);
			}
			adGroupAdSelector.getUserStatuses().addAll(Arrays.asList(jp.yahooapis.im.V4.AdGroupAdService.UserStatus.ACTIVE, jp.yahooapis.im.V4.AdGroupAdService.UserStatus.PAUSED));
			jp.yahooapis.im.V4.AdGroupAdService.Paging adGroupAdPaging = new jp.yahooapis.im.V4.AdGroupAdService.Paging();
			adGroupAdPaging.setStartIndex(1);
			adGroupAdPaging.setNumberResults(20);
			adGroupAdSelector.setPaging(adGroupAdPaging);

			// call API
			System.out.println("############################################");
			System.out.println("AdGroupAdService::get");
			System.out.println("############################################");
			Holder<AdGroupAdPage> adGroupAdPageHolder = new Holder<AdGroupAdPage>();
			Holder<List<jp.yahooapis.im.V4.AdGroupAdService.Error>> getAdGroupAdErrorHolder = new Holder<List<jp.yahooapis.im.V4.AdGroupAdService.Error>>();
			adGroupAdService.get(adGroupAdSelector, adGroupAdPageHolder, getAdGroupAdErrorHolder);

			// if error
			if (getAdGroupAdErrorHolder.value != null && getAdGroupAdErrorHolder.value.size() > 0) {
				SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(getAdGroupAdErrorHolder.value), true);
			}

			// response
			if (adGroupAdPageHolder.value != null) {
				AdGroupAdPage adGroupAdPage = adGroupAdPageHolder.value;
				if (adGroupAdPage.getValues() != null && adGroupAdPage.getValues().size() > 0) {
					List<AdGroupAdValues> values = adGroupAdPage.getValues();
					for (int i = 0; i < values.size(); i++) {
						if (values.get(i).isOperationSucceeded()) {
							AdGroupAd ad = values.get(i).getAdGroupAd();
							AGA aga = new AGA(ad.getCampaignId(), ad.getAdGroupId(), ad.getAdId());
							agaIds.add(aga);
							displayAdGroupAd(ad);
						} else {
							// if error
							SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(values.get(i).getError()), true);
						}
					}
				}
			}

			//
			// //-----------------------------------------------
			// // AdGroupService::mutate(SET)
			// //-----------------------------------------------
			// //request
			// AdGroup setAdGroupOperand = new AdGroup();
			// setAdGroupOperand.setAccountId(accountId);
			// setAdGroupOperand.setCampaignId(campaignId);
			// setAdGroupOperand.setAdGroupId(adGroupId);
			// setAdGroupOperand.setAdGroupName("SampleAdGroup_UpdateOn_" +
			// SoapUtils.getCurrentTimestamp());
			// setAdGroupOperand.setUserStatus(jp.yahooapis.im.V4.AdGroupService.UserStatus.PAUSED);
			// ManualCPCAdGroupBid setAdGroupBid = new ManualCPCAdGroupBid();
			// setAdGroupBid.setMaxCpc((long)120);
			// setAdGroupBid.setType(jp.yahooapis.im.V4.AdGroupService.BiddingStrategyType.MANUAL_CPC);
			// setAdGroupOperand.setBid(setAdGroupBid);
			// setAdGroupOperand.getDevice().add(DeviceType.SMARTPHONE);
			// setAdGroupOperand.getDeviceOs().add(DeviceOsType.IOS);
			// setAdGroupOperand.getDeviceApp().add(DeviceAppType.APP);
			//
			// AdGroupOperation setAdGroupOperation = new AdGroupOperation();
			// setAdGroupOperation.setOperator(jp.yahooapis.im.V4.AdGroupService.Operator.SET);
			// setAdGroupOperation.setAccountId(accountId);
			// setAdGroupOperation.setCampaignId(campaignId);
			// setAdGroupOperation.getOperand().add(setAdGroupOperand);
			//
			// //call API
			// System.out.println("############################################");
			// System.out.println("AdGroupService::mutate(SET)");
			// System.out.println("############################################");
			// Holder<AdGroupReturnValue> setAdgroupReturnValueHolder = new
			// Holder<AdGroupReturnValue>();
			// Holder<List<jp.yahooapis.im.V4.AdGroupService.Error>>
			// setAdGroupErrorHolder = new
			// Holder<List<jp.yahooapis.im.V4.AdGroupService.Error>>();
			// adGroupService.mutate(setAdGroupOperation,
			// setAdgroupReturnValueHolder, setAdGroupErrorHolder);
			//
			// //if error
			// if(setAdGroupErrorHolder.value != null &&
			// setAdGroupErrorHolder.value.size() > 0){
			// SoapUtils.displayErrors(new
			// AdGroupServiceErrorEntityFactory(setAdGroupErrorHolder.value),
			// true);
			// }
			//
			// //response
			// if(setAdgroupReturnValueHolder.value != null){
			// AdGroupReturnValue returnValue =
			// setAdgroupReturnValueHolder.value;
			// if(returnValue.getValues() != null &&
			// returnValue.getValues().size() > 0){
			// List<AdGroupValues> values = returnValue.getValues();
			// for(int i=0; i<values.size(); i++){
			// if(values.get(i).isOperationSucceeded()){
			// //display response
			// displayAdGroup(values.get(i).getAdGroup());
			// }else{
			// //if error
			// SoapUtils.displayErrors(new
			// AdGroupServiceErrorEntityFactory(values.get(i).getError()),
			// true);
			// }
			// }
			// }
			// }

			//
			// //-----------------------------------------------
			// // AdGroupAdService::mutate(ADD)
			// //-----------------------------------------------
			// //request
			// TextAd addTextAd = new TextAd();
			// addTextAd.setType(AdType.TEXT_LONG_AD_1);
			// addTextAd.setUrl("http://www.yahoo.co.jp/");
			// addTextAd.setDisplayUrl("www.yahoo.co.jp");
			// addTextAd.setHeadline("sample headline");
			// addTextAd.setDescription("sample ad desc");
			// addTextAd.setDescription2("sample ad desc2");
			//
			// AdGroupAd addAdGroupAdOperand = new AdGroupAd();
			// addAdGroupAdOperand.setAccountId(accountId);
			// addAdGroupAdOperand.setCampaignId(campaignId);
			// addAdGroupAdOperand.setAdGroupId(adGroupId);
			// addAdGroupAdOperand.setAdStyle(AdStyle.TEXT);
			// addAdGroupAdOperand.setAdName("SampleAdGroupAd_CreateOn_" +
			// SoapUtils.getCurrentTimestamp());
			// addAdGroupAdOperand.setUserStatus(jp.yahooapis.im.V4.AdGroupAdService.UserStatus.ACTIVE);
			// ManualCPCAdGroupAdBid addAdBid = new ManualCPCAdGroupAdBid();
			// addAdBid.setMaxCpc((long)50);
			// addAdBid.setType(jp.yahooapis.im.V4.AdGroupAdService.BiddingStrategyType.MANUAL_CPC);
			// addAdGroupAdOperand.setBid(addAdBid);
			// addAdGroupAdOperand.setAd(addTextAd);
			//
			// AdGroupAdOperation addAdGroupAdOperation = new
			// AdGroupAdOperation();
			// addAdGroupAdOperation.setOperator(jp.yahooapis.im.V4.AdGroupAdService.Operator.ADD);
			// addAdGroupAdOperation.setAccountId(accountId);
			// addAdGroupAdOperation.setCampaignId(campaignId);
			// addAdGroupAdOperation.setAdGroupId(adGroupId);
			// addAdGroupAdOperation.getOperand().add(addAdGroupAdOperand);
			//
			// //call API
			// System.out.println("############################################");
			// System.out.println("AdGroupAdService::mutate(ADD)");
			// System.out.println("############################################");
			// Holder<AdGroupAdReturnValue> addAdGroupAdReturnValueHolder = new
			// Holder<AdGroupAdReturnValue>();
			// Holder<List<jp.yahooapis.im.V4.AdGroupAdService.Error>>
			// addAdGroupAdErrorHolder = new
			// Holder<List<jp.yahooapis.im.V4.AdGroupAdService.Error>>();
			// adGroupAdService.mutate(addAdGroupAdOperation,
			// addAdGroupAdReturnValueHolder, addAdGroupAdErrorHolder);
			//
			// //if error
			// if(addAdGroupAdErrorHolder.value != null &&
			// addAdGroupAdErrorHolder.value.size() > 0){
			// SoapUtils.displayErrors(new
			// AdGroupAdServiceErrorEntityFactory(addAdGroupAdErrorHolder.value),
			// true);
			// }
			//
			// long adGroupAdId = -1;
			// //response
			// if(addAdGroupAdReturnValueHolder.value != null){
			// AdGroupAdReturnValue returnValue =
			// addAdGroupAdReturnValueHolder.value;
			// if(returnValue.getValues() != null &&
			// returnValue.getValues().size() > 0){
			// List<AdGroupAdValues> values = returnValue.getValues();
			// for(int i=0; i<values.size(); i++){
			// if(values.get(i).isOperationSucceeded()){
			// //display response
			// AdGroupAd adGroupAd = values.get(i).getAdGroupAd();
			// adGroupAdId = adGroupAd.getAdId();
			// displayAdGroupAd(adGroupAd);
			// }else{
			// //if error
			// SoapUtils.displayErrors(new
			// AdGroupAdServiceErrorEntityFactory(values.get(i).getError()),
			// true);
			// }
			// }
			// }
			// }
			//
			// //-----------------------------------------------
			// // AdGroupAdService::get
			// //-----------------------------------------------
			// AdGroupAdSelector adGroupAdSelector = new AdGroupAdSelector();
			// adGroupAdSelector.setAccountId(accountId);
			// adGroupAdSelector.getCampaignIds().add(campaignId);
			// adGroupAdSelector.getAdGroupIds().add(adGroupId);
			// adGroupAdSelector.getAdIds().add(adGroupAdId);
			// adGroupAdSelector.getUserStatuses().addAll(Arrays.asList(jp.yahooapis.im.V4.AdGroupAdService.UserStatus.ACTIVE,
			// jp.yahooapis.im.V4.AdGroupAdService.UserStatus.PAUSED));
			// jp.yahooapis.im.V4.AdGroupAdService.Paging adPaging = new
			// jp.yahooapis.im.V4.AdGroupAdService.Paging();
			// adPaging.setStartIndex(1);
			// adPaging.setNumberResults(20);
			// adGroupAdSelector.setPaging(adPaging);
			//
			// //call API
			// System.out.println("############################################");
			// System.out.println("AdGroupAdService::get");
			// System.out.println("############################################");
			// Holder<AdGroupAdPage> adGroupAdPageHolder = new
			// Holder<AdGroupAdPage>();
			// Holder<List<jp.yahooapis.im.V4.AdGroupAdService.Error>>
			// getAdGroupAdErrorHolder = new
			// Holder<List<jp.yahooapis.im.V4.AdGroupAdService.Error>>();
			// adGroupAdService.get(adGroupAdSelector, adGroupAdPageHolder,
			// getAdGroupAdErrorHolder);
			//
			// //if error
			// if(getAdGroupAdErrorHolder.value != null &&
			// getAdGroupAdErrorHolder.value.size() > 0){
			// SoapUtils.displayErrors(new
			// AdGroupAdServiceErrorEntityFactory(getAdGroupAdErrorHolder.value),
			// true);
			// }
			//
			// //response
			// if(adGroupAdPageHolder.value != null){
			// AdGroupAdPage adGroupAdPage = adGroupAdPageHolder.value;
			// if(adGroupAdPage.getValues() != null &&
			// adGroupAdPage.getValues().size() > 0){
			// List<AdGroupAdValues> values = adGroupAdPage.getValues();
			// for(int i=0; i<values.size(); i++){
			// if(values.get(i).isOperationSucceeded()){
			// //display response
			// displayAdGroupAd(values.get(i).getAdGroupAd());
			// }else{
			// //if error
			// SoapUtils.displayErrors(new
			// AdGroupAdServiceErrorEntityFactory(values.get(i).getError()),
			// true);
			// }
			// }
			// }
			// }

			// sleep 10 second for review.
			System.out.println("***** complete *****");
			// Thread.sleep(10000);

			// //-----------------------------------------------
			// // AdGroupAdService::mutate(SET)
			// //-----------------------------------------------
			// //request
			// TextAd setTextAd = new TextAd();
			// setTextAd.setType(AdType.TEXT_LONG_AD_1);
			// setTextAd.setUrl("http://www.yahoo.co.jp/");
			// setTextAd.setDisplayUrl("www.yahoo.co.jp");
			// setTextAd.setHeadline("sample headline");
			// setTextAd.setDescription("sample ad desc");
			// setTextAd.setDescription2("sample ad desc2");
			//
			// AdGroupAd setAdGroupAdOperand = new AdGroupAd();
			// setAdGroupAdOperand.setAccountId(accountId);
			// setAdGroupAdOperand.setCampaignId(campaignId);
			// setAdGroupAdOperand.setAdGroupId(adGroupId);
			// setAdGroupAdOperand.setAdId(adGroupAdId);
			// setAdGroupAdOperand.setAdName("SampleAdGroupAd_UpdateOn_" +
			// SoapUtils.getCurrentTimestamp());
			// setAdGroupAdOperand.setUserStatus(jp.yahooapis.im.V4.AdGroupAdService.UserStatus.PAUSED);
			// ManualCPCAdGroupAdBid setAdBid = new ManualCPCAdGroupAdBid();
			// setAdBid.setMaxCpc((long)60);
			// setAdBid.setType(jp.yahooapis.im.V4.AdGroupAdService.BiddingStrategyType.MANUAL_CPC);
			// setAdGroupAdOperand.setBid(setAdBid);
			// setAdGroupAdOperand.setAd(setTextAd);
			//
			// AdGroupAdOperation setAdGroupAdOperation = new
			// AdGroupAdOperation();
			// setAdGroupAdOperation.setOperator(jp.yahooapis.im.V4.AdGroupAdService.Operator.SET);
			// setAdGroupAdOperation.setAccountId(accountId);
			// setAdGroupAdOperation.setCampaignId(campaignId);
			// setAdGroupAdOperation.setAdGroupId(adGroupId);
			// setAdGroupAdOperation.getOperand().add(setAdGroupAdOperand);
			//
			// //call API
			// System.out.println("############################################");
			// System.out.println("AdGroupAdService::mutate(SET)");
			// System.out.println("############################################");
			// Holder<AdGroupAdReturnValue> setAdGroupAdReturnValueHolder = new
			// Holder<AdGroupAdReturnValue>();
			// Holder<List<jp.yahooapis.im.V4.AdGroupAdService.Error>>
			// setAdGroupAdErrorHolder = new
			// Holder<List<jp.yahooapis.im.V4.AdGroupAdService.Error>>();
			// adGroupAdService.mutate(setAdGroupAdOperation,
			// setAdGroupAdReturnValueHolder, setAdGroupAdErrorHolder);
			//
			// //if error
			// if(setAdGroupAdErrorHolder.value != null &&
			// setAdGroupAdErrorHolder.value.size() > 0){
			// SoapUtils.displayErrors(new
			// AdGroupAdServiceErrorEntityFactory(setAdGroupAdErrorHolder.value),
			// true);
			// }
			//
			// //response
			// if(setAdGroupAdReturnValueHolder.value != null){
			// AdGroupAdReturnValue returnValue =
			// setAdGroupAdReturnValueHolder.value;
			// if(returnValue.getValues() != null &&
			// returnValue.getValues().size() > 0){
			// List<AdGroupAdValues> values = returnValue.getValues();
			// for(int i=0; i<values.size(); i++){
			// if(values.get(i).isOperationSucceeded()){
			// //display response
			// displayAdGroupAd(values.get(i).getAdGroupAd());
			// }else{
			// //if error
			// SoapUtils.displayErrors(new
			// AdGroupAdServiceErrorEntityFactory(values.get(i).getError()),
			// true);
			// }
			// }
			// }
			// }
			//
			// //=================================================================
			// // AdGroupTargetService
			// //=================================================================
			// AdGroupTargetServiceInterface adGroupTargetService =
			// SoapUtils.createServiceInterface(AdGroupTargetServiceInterface.class,
			// AdGroupTargetServiceService.class);
			//
			// //-----------------------------------------------
			// // AdGroupTargetService::mutate(SET)
			// //-----------------------------------------------
			// //request
			// AdScheduleTarget setAdScheduleTarget1 = new AdScheduleTarget();
			// setAdScheduleTarget1.setType(TargetType.AD_SCHEDULE_TARGET);
			// setAdScheduleTarget1.setDayOfWeek(DayOfWeek.MONDAY);
			// setAdScheduleTarget1.setStartHour(13);
			// setAdScheduleTarget1.setEndHour(14);
			// AdScheduleTarget setAdScheduleTarget2 = new AdScheduleTarget();
			// setAdScheduleTarget2.setType(TargetType.AD_SCHEDULE_TARGET);
			// setAdScheduleTarget2.setDayOfWeek(DayOfWeek.TUESDAY);
			// setAdScheduleTarget2.setStartHour(14);
			// setAdScheduleTarget2.setEndHour(15);
			//
			// AdScheduleTargetList setAdScheduleTargetList = new
			// AdScheduleTargetList();
			// setAdScheduleTargetList.setAccountId(accountId);
			// setAdScheduleTargetList.setCampaignId(campaignId);
			// setAdScheduleTargetList.setAdGroupId(adGroupId);
			// setAdScheduleTargetList.setType(TargetType.AD_SCHEDULE_TARGET);
			// setAdScheduleTargetList.getTargets().addAll(Arrays.asList(setAdScheduleTarget1,setAdScheduleTarget2));
			//
			// GenderTarget setGenderTarget1 = new GenderTarget();
			// setGenderTarget1.setType(TargetType.GENDER_TARGET);
			// setGenderTarget1.setGender(Gender.ST_MALE);
			// setGenderTarget1.setEstimateFlg(EstimateFlg.ACTIVE);
			//
			// GenderTarget setGenderTarget2 = new GenderTarget();
			// setGenderTarget2.setType(TargetType.GENDER_TARGET);
			// setGenderTarget2.setGender(Gender.ST_UNKNOWN);
			//
			// GenderTargetList setGenderTargetList = new GenderTargetList();
			// setGenderTargetList.setAccountId(accountId);
			// setGenderTargetList.setCampaignId(campaignId);
			// setGenderTargetList.setAdGroupId(adGroupId);
			// setGenderTargetList.setType(TargetType.GENDER_TARGET);
			// setGenderTargetList.getTargets().addAll(Arrays.asList(setGenderTarget1,setGenderTarget2));
			//
			// AgeTarget setAgeTarget1 = new AgeTarget();
			// setAgeTarget1.setType(TargetType.AGE_TARGET);
			// setAgeTarget1.setAge(Age.GT_UNKNOWN);
			//
			// AgeTargetList setAgeTargetList = new AgeTargetList();
			// setAgeTargetList.setAccountId(accountId);
			// setAgeTargetList.setCampaignId(campaignId);
			// setAgeTargetList.setAdGroupId(adGroupId);
			// setAgeTargetList.setType(TargetType.AGE_TARGET);
			// setAgeTargetList.getTargets().add(setAgeTarget1);
			//
			// AdGroupTargetList setAdGroupTargetOperand = new
			// AdGroupTargetList();
			// setAdGroupTargetOperand.setAccountId(accountId);
			// setAdGroupTargetOperand.setCampaignId(campaignId);
			// setAdGroupTargetOperand.setAdGroupId(adGroupId);
			// setAdGroupTargetOperand.getTargets().addAll(Arrays.asList(setAdScheduleTargetList,
			// setGenderTargetList, setAgeTargetList));
			//
			// AdGroupTargetOperation setAdGroupTargetOperation = new
			// AdGroupTargetOperation();
			// setAdGroupTargetOperation.setOperator(jp.yahooapis.im.V4.AdGroupTargetService.Operator.SET);
			// setAdGroupTargetOperation.setAccountId(accountId);
			// setAdGroupTargetOperation.setCampaignId(campaignId);
			// setAdGroupTargetOperation.getOperand().add(setAdGroupTargetOperand);
			//
			// //call API
			// System.out.println("############################################");
			// System.out.println("AdGroupTargetService::mutate(SET)");
			// System.out.println("############################################");
			// Holder<AdGroupTargetReturnValue>
			// setAdGroupTargetReturnValueHolder = new
			// Holder<AdGroupTargetReturnValue>();
			// Holder<List<jp.yahooapis.im.V4.AdGroupTargetService.Error>>
			// setAdGroupTargetErrorHolder = new
			// Holder<List<jp.yahooapis.im.V4.AdGroupTargetService.Error>>();
			// adGroupTargetService.mutate(setAdGroupTargetOperation,
			// setAdGroupTargetReturnValueHolder, setAdGroupTargetErrorHolder);
			//
			// //if error
			// if(setAdGroupTargetErrorHolder.value != null &&
			// setAdGroupTargetErrorHolder.value.size() > 0){
			// SoapUtils.displayErrors(new
			// AdGroupTargetServiceErrorEntityFactory(setAdGroupTargetErrorHolder.value),
			// true);
			// }
			//
			// //response
			// if(setAdGroupTargetReturnValueHolder.value != null){
			// AdGroupTargetReturnValue returnValue =
			// setAdGroupTargetReturnValueHolder.value;
			// if(returnValue.getValues() != null &&
			// returnValue.getValues().size() > 0){
			// List<AdGroupTargetValues> values = returnValue.getValues();
			// for(int i=0; i<values.size(); i++){
			// if(values.get(i).isOperationSucceeded()){
			// //display response
			// displayAdGroupTargetList(values.get(i).getTargetList());
			// }else{
			// //if error
			// SoapUtils.displayErrors(new
			// AdGroupTargetServiceErrorEntityFactory(values.get(i).getError()),
			// true);
			// }
			// }
			// }
			// }
			//
			//
			// //-----------------------------------------------
			// // AdGroupTargetService::get
			// //-----------------------------------------------
			// //request
			AdGroupTargetSelector adGroupTargetSelector = new AdGroupTargetSelector();
			adGroupTargetSelector.setAccountId(accountId);
			// adGroupTargetSelector.getCampaignIds().add(campaignId);
			// adGroupTargetSelector.getAdGroupIds().add(adGroupId);

			// call API
			System.out.println("############################################");
			System.out.println("AdGroupTargetService::get");
			System.out.println("############################################");
			Holder<AdGroupTargetPage> adGroupTargetPageHolder = new Holder<AdGroupTargetPage>();
			Holder<List<jp.yahooapis.im.V4.AdGroupTargetService.Error>> getAdGroupTargetErrorHolder = new Holder<List<jp.yahooapis.im.V4.AdGroupTargetService.Error>>();
			adGroupTargetService.get(adGroupTargetSelector, adGroupTargetPageHolder, getAdGroupTargetErrorHolder);

			// if error
			if (getAdGroupTargetErrorHolder.value != null && getAdGroupTargetErrorHolder.value.size() > 0) {
				SoapUtils.displayErrors(new AdGroupTargetServiceErrorEntityFactory(getAdGroupTargetErrorHolder.value), true);
			}

			// response
			if (adGroupTargetPageHolder.value != null) {
				AdGroupTargetPage adGroupTargetPage = adGroupTargetPageHolder.value;
				if (adGroupTargetPage.getValues() != null && adGroupTargetPage.getValues().size() > 0) {
					List<AdGroupTargetValues> values = adGroupTargetPage.getValues();
					for (int i = 0; i < values.size(); i++) {
						if (values.get(i).isOperationSucceeded()) {
							// display response
							displayAdGroupTargetList(values.get(i).getTargetList());
						} else {
							// if error
							SoapUtils.displayErrors(new AdGroupTargetServiceErrorEntityFactory(values.get(i).getError()), true);
						}
					}
				}
			}

			// //=================================================================
			// // remove AdGroupAd, AdGroup, Campaign
			// //=================================================================
			// //-----------------------------------------------
			// // AdGroupAdService::mutate(REMOVE)
			// //-----------------------------------------------
			// request
			for (AGA aga : agaIds) {
				AdGroupAd removeAdGroupAdOperand = new AdGroupAd();
				removeAdGroupAdOperand.setAccountId(accountId);
				removeAdGroupAdOperand.setCampaignId(aga.campaign_id);
				removeAdGroupAdOperand.setAdGroupId(aga.ad_group_id);
				removeAdGroupAdOperand.setAdId(aga.ad_group_ad_id);

				AdGroupAdOperation removeAdGroupAdOperation = new AdGroupAdOperation();
				removeAdGroupAdOperation.setOperator(jp.yahooapis.im.V4.AdGroupAdService.Operator.REMOVE);
				removeAdGroupAdOperation.setAccountId(accountId);
				removeAdGroupAdOperation.setCampaignId(aga.campaign_id);
				removeAdGroupAdOperation.setAdGroupId(aga.ad_group_id);
				removeAdGroupAdOperation.getOperand().add(removeAdGroupAdOperand);

				// call API
				System.out.println("############################################");
				System.out.println("AdGroupAdService::mutate(REMOVE)");
				System.out.println("############################################");
				Holder<AdGroupAdReturnValue> removeAdGroupAdReturnValueHolder = new Holder<AdGroupAdReturnValue>();
				Holder<List<jp.yahooapis.im.V4.AdGroupAdService.Error>> removeAdGroupAdErrorHolder = new Holder<List<jp.yahooapis.im.V4.AdGroupAdService.Error>>();
				System.out.println(aga);
				adGroupAdService.mutate(removeAdGroupAdOperation, removeAdGroupAdReturnValueHolder, removeAdGroupAdErrorHolder);

				// if error
				if (removeAdGroupAdErrorHolder.value != null && removeAdGroupAdErrorHolder.value.size() > 0) {
					SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(removeAdGroupAdErrorHolder.value), true);
				}

				// response
				if (removeAdGroupAdReturnValueHolder.value != null) {
					AdGroupAdReturnValue returnValue = removeAdGroupAdReturnValueHolder.value;
					if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
						List<AdGroupAdValues> values = returnValue.getValues();
						for (int i = 0; i < values.size(); i++) {
							if (values.get(i).isOperationSucceeded()) {
								// display response
								displayAdGroupAd(values.get(i).getAdGroupAd());
							} else {
								// if error
								SoapUtils.displayErrors(new AdGroupAdServiceErrorEntityFactory(values.get(i).getError()), true);
							}
						}
					}
				}
			}
			//
			// //-----------------------------------------------
			// // AdGroupService::mutate(REMOVE)
			// //-----------------------------------------------
			// AdGroup removeAdGroupOperand = new AdGroup();
			// removeAdGroupOperand.setAccountId(accountId);
			// removeAdGroupOperand.setCampaignId(campaignId);
			// removeAdGroupOperand.setAdGroupId(adGroupId);
			//
			// AdGroupOperation removeAdGroupOperation = new AdGroupOperation();
			// removeAdGroupOperation.setOperator(jp.yahooapis.im.V4.AdGroupService.Operator.REMOVE);
			// removeAdGroupOperation.setAccountId(accountId);
			// removeAdGroupOperation.setCampaignId(campaignId);
			// removeAdGroupOperation.getOperand().add(removeAdGroupOperand);
			//
			// //call API
			// System.out.println("############################################");
			// System.out.println("AdGroupService::mutate(REMOVE)");
			// System.out.println("############################################");
			// Holder<AdGroupReturnValue> removeAdgroupReturnValueHolder = new
			// Holder<AdGroupReturnValue>();
			// Holder<List<jp.yahooapis.im.V4.AdGroupService.Error>>
			// removeAdGroupErrorHolder = new
			// Holder<List<jp.yahooapis.im.V4.AdGroupService.Error>>();
			// adGroupService.mutate(removeAdGroupOperation,
			// removeAdgroupReturnValueHolder, removeAdGroupErrorHolder);
			//
			// //if error
			// if(removeAdGroupErrorHolder.value != null &&
			// removeAdGroupErrorHolder.value.size() > 0){
			// SoapUtils.displayErrors(new
			// AdGroupServiceErrorEntityFactory(removeAdGroupErrorHolder.value),
			// true);
			// }
			//
			// //response
			// if(removeAdgroupReturnValueHolder.value != null){
			// AdGroupReturnValue returnValue =
			// removeAdgroupReturnValueHolder.value;
			// if(returnValue.getValues() != null &&
			// returnValue.getValues().size() > 0){
			// List<AdGroupValues> values = returnValue.getValues();
			// for(int i=0; i<values.size(); i++){
			// if(values.get(i).isOperationSucceeded()){
			// //display response
			// displayAdGroup(values.get(i).getAdGroup());
			// }else{
			// //if error
			// SoapUtils.displayErrors(new
			// AdGroupServiceErrorEntityFactory(values.get(i).getError()),
			// true);
			// }
			// }
			// }
			// }
			//
			// //-----------------------------------------------
			// // CampaignService::mutate(REMOVE)
			// //-----------------------------------------------
			// //request
			// Campaign removeCampaignOperand = new Campaign();
			// removeCampaignOperand.setAccountId(accountId);
			// removeCampaignOperand.setCampaignId(campaignId);
			//
			// CampaignOperation removeCampaignOperation = new
			// CampaignOperation();
			// removeCampaignOperation.setOperator(jp.yahooapis.im.V4.CampaignService.Operator.REMOVE);
			// removeCampaignOperation.setAccountId(accountId);
			// removeCampaignOperation.getOperand().add(removeCampaignOperand);
			//
			// //call API
			// System.out.println("############################################");
			// System.out.println("CampaignService::mutate(REMOVE)");
			// System.out.println("############################################");
			// Holder<CampaignReturnValue> removeCampaignReturnValueHolder = new
			// Holder<CampaignReturnValue>();
			// Holder<List<Error>> removeCampaignErrorHolder = new
			// Holder<List<Error>>();
			// campaignService.mutate(removeCampaignOperation,
			// removeCampaignReturnValueHolder, removeCampaignErrorHolder);
			//
			// //if error
			// if(removeCampaignErrorHolder.value != null &&
			// removeCampaignErrorHolder.value.size() > 0){
			// SoapUtils.displayErrors(new
			// CampaignServiceErrorEntityFactory(removeCampaignErrorHolder.value),
			// true);
			// }
			//
			// //response
			// if(removeCampaignReturnValueHolder.value != null){
			// CampaignReturnValue returnValue =
			// removeCampaignReturnValueHolder.value;
			// if(returnValue.getValues() != null &&
			// returnValue.getValues().size() > 0){
			// List<CampaignValues> values = returnValue.getValues();
			// for(int i=0; i<values.size(); i++){
			// if(values.get(i).isOperationSucceeded()){
			// //display response
			// displayCampaign(values.get(i).getCampaign());
			// }else{
			// //if error
			// SoapUtils.displayErrors(new
			// CampaignServiceErrorEntityFactory(values.get(i).getError()),
			// true);
			// }
			// }
			// }
			// }

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * display Campaign entity to stdout.
	 * 
	 * @param campaign
	 *            Campaign entity for display.
	 */
	private static void displayCampaign(Campaign campaign) {
		System.out.println("accountId = " + campaign.getAccountId());
		System.out.println("campaignId = " + campaign.getCampaignId());
		System.out.println("campaignName = " + campaign.getCampaignName());
		System.out.println("userStatus = " + campaign.getUserStatus().toString());
		System.out.println("servingStatus = " + campaign.getServingStatus().toString());
		System.out.println("startDate = " + campaign.getStartDate());
		System.out.println("endDate = " + campaign.getEndDate());
		if (campaign.getBudget() != null) {
			System.out.println("budget/amount = " + campaign.getBudget().getAmount());
			System.out.println("budget/deliveryMethod = " + campaign.getBudget().getDeliveryMethod().toString());
		}
		if (campaign.getBiddingStrategy() != null) {
			System.out.println("biddingStrategy = " + campaign.getBiddingStrategy().getType().toString());
		}
		System.out.println("adProductType = " + campaign.getAdProductType());
		if (campaign.getFrequencyCap() != null) {
			System.out.println("frequencyCap/level = " + campaign.getFrequencyCap().getLevel());
			System.out.println("frequencyCap/timeUnit = " + campaign.getFrequencyCap().getTimeUnit());
			System.out.println("frequencyCap/impression = " + campaign.getFrequencyCap().getImpression());
		}
		System.out.println("---------");
	}

	/**
	 * display AdGroup entity to stdout.
	 * 
	 * @param adGroup
	 *            AdGroup entity for display.
	 */
	private static void displayAdGroup(AdGroup adGroup) {
		System.out.println("accountId = " + adGroup.getAccountId());
		System.out.println("campaignId = " + adGroup.getCampaignId());
		System.out.println("campaignName = " + adGroup.getCampaignName());
		System.out.println("adGroupId = " + adGroup.getAdGroupId());
		System.out.println("adGroupName = " + adGroup.getAdGroupName());
		System.out.println("userStatus = " + adGroup.getUserStatus().toString());
		if (adGroup.getBid() != null) {
			System.out.println("bid/type = " + ((ManualCPCAdGroupBid) adGroup.getBid()).getType().toString());
			System.out.println("bid/maxCpc = " + ((ManualCPCAdGroupBid) adGroup.getBid()).getMaxCpc().toString());
		}
		System.out.println("device = " + SoapUtils.arrayToLine(adGroup.getDevice().toArray()));
		System.out.println("deviceOs = " + SoapUtils.arrayToLine(adGroup.getDeviceOs().toArray()));
		System.out.println("deviceApp = " + SoapUtils.arrayToLine(adGroup.getDeviceApp().toArray()));
		System.out.println("---------");
	}

	/**
	 * display AdGroupAd entity to stdout.
	 * 
	 * @param adGroupAd
	 *            AdGroupAd entity for display.
	 */
	private static void displayAdGroupAd(AdGroupAd adGroupAd) {
		System.out.println("accountId = " + adGroupAd.getAccountId());
		System.out.println("campaignId = " + adGroupAd.getCampaignId());
		System.out.println("campaignName = " + adGroupAd.getCampaignName());
		System.out.println("adGroupId = " + adGroupAd.getAdGroupId());
		System.out.println("adGreoupName = " + adGroupAd.getAdGroupName());
		System.out.println("adId = " + adGroupAd.getAdId());
		System.out.println("adName = " + adGroupAd.getAdName());
		System.out.println("adStyle = " + adGroupAd.getAdStyle().toString());
		System.out.println("mediaId = " + adGroupAd.getMediaId());
		System.out.println("userStatus = " + adGroupAd.getUserStatus().toString());
		System.out.println("approvalStatus = " + adGroupAd.getApprovalStatus().toString());
		if (adGroupAd.getBid() != null) {
			System.out.println("bid/type = " + ((ManualCPCAdGroupAdBid) adGroupAd.getBid()).getType().toString());
			System.out.println("bid/maxCpc = " + ((ManualCPCAdGroupAdBid) adGroupAd.getBid()).getMaxCpc().toString());
		}
		if (adGroupAd.getAd() != null) {
			Ad ad = adGroupAd.getAd();
			if (ad instanceof TextAd) {
				TextAd textAd = (TextAd) ad;
				System.out.println("ad/type = " + textAd.getType().toString());
				System.out.println("ad/url = " + textAd.getUrl());
				System.out.println("ad/displayUrl = " + textAd.getDisplayUrl());
				System.out.println("ad/headline = " + textAd.getHeadline());
				System.out.println("ad/description = " + textAd.getDescription());
				System.out.println("ad/description2 = " + textAd.getDescription2());
			} else if (ad instanceof MobileAd) {
				MobileAd mobileAd = (MobileAd) ad;
				System.out.println("ad/type = " + mobileAd.getType().toString());
				System.out.println("ad/url = " + mobileAd.getUrl());
				System.out.println("ad/displayUrl = " + mobileAd.getDisplayUrl());
				System.out.println("ad/headline = " + mobileAd.getHeadline());
				System.out.println("ad/description = " + mobileAd.getDescription());
				System.out.println("ad/description2 = " + mobileAd.getDescription2());
				System.out.println("ad/mobileCarerrir = " + SoapUtils.arrayToLine(mobileAd.getMobileCarriers().toArray()));
			} else if (ad instanceof PosAd) {
				PosAd posAd = (PosAd) ad;
				System.out.println("ad/type = " + posAd.getType().toString());
				System.out.println("ad/url = " + posAd.getUrl());
				System.out.println("ad/description = " + posAd.getDescription());
			}
		}
		System.out.println("---------");
	}

	/**
	 * display AdGroupTargetList entity to stdout.
	 * 
	 * @param adGroupTargetList
	 *            AdGroupTargetList entity for display.
	 */
	private static void displayAdGroupTargetList(AdGroupTargetList adGroupTargetList) {
		System.out.println("accountId = " + adGroupTargetList.getAccountId());
		System.out.println("campaignId = " + adGroupTargetList.getCampaignId());
		System.out.println("adGroupId = " + adGroupTargetList.getAdGroupId());
		if (adGroupTargetList.getTargets() != null && adGroupTargetList.getTargets().size() > 0) {
			List<TargetList> targetList = adGroupTargetList.getTargets();
			for (int j = 0; j < targetList.size(); j++) {
				System.out.println("targets---------");
				System.out.println("targets/accountId = " + targetList.get(j).getAccountId());
				System.out.println("targets/campaignId = " + targetList.get(j).getCampaignId());
				System.out.println("targets/adGroupId = " + targetList.get(j).getAdGroupId());
				System.out.println("targets/type = " + targetList.get(j).getType().toString());
				if (targetList.get(j) instanceof AdScheduleTargetList) {
					AdScheduleTargetList adScheduleTargetList = (AdScheduleTargetList) targetList.get(j);
					List<AdScheduleTarget> adScheduleTarget = adScheduleTargetList.getTargets();
					for (int k = 0; k < adScheduleTarget.size(); k++) {
						System.out.println("targets/targets---------");
						System.out.println("targets/targets/type = " + adScheduleTarget.get(k).getType().toString());
						System.out.println("targets/targets/dayOfWeek = " + adScheduleTarget.get(k).getDayOfWeek().toString());
						System.out.println("targets/targets/startHour = " + adScheduleTarget.get(k).getStartHour());
						System.out.println("targets/targets/endHour = " + adScheduleTarget.get(k).getEndHour());

					}
				} else if (targetList.get(j) instanceof GenderTargetList) {
					GenderTargetList genderTargetList = (GenderTargetList) targetList.get(j);
					List<GenderTarget> genderTarget = genderTargetList.getTargets();
					for (int k = 0; k < genderTarget.size(); k++) {
						System.out.println("targets/targets---------");
						System.out.println("targets/targets/type = " + genderTarget.get(k).getType().toString());
						System.out.println("targets/targets/gender = " + genderTarget.get(k).getGender().toString());
						System.out.println("targets/targets/estimateFlg = " + genderTarget.get(k).getEstimateFlg());
					}
				} else if (targetList.get(j) instanceof GeoTargetList) {
					GeoTargetList geoTargetList = (GeoTargetList) targetList.get(j);
					List<GeoTarget> geoTarget = geoTargetList.getTargets();
					for (int k = 0; k < geoTarget.size(); k++) {
						System.out.println("targets/targets---------");
						System.out.println("targets/targets/type = " + geoTarget.get(k).getType().toString());
						System.out.println("targets/targets/geo = " + geoTarget.get(k).getGeo());
					}
				} else if (targetList.get(j) instanceof AgeTargetList) {
					AgeTargetList ageTargetList = (AgeTargetList) targetList.get(j);
					List<AgeTarget> ageTarget = ageTargetList.getTargets();
					for (int k = 0; k < ageTarget.size(); k++) {
						System.out.println("targets/targets---------");
						System.out.println("targets/targets/type = " + ageTarget.get(k).getType().toString());
						System.out.println("targets/targets/age = " + ageTarget.get(k).getAge().toString());
					}
				} else if (targetList.get(j) instanceof InterestCategoryTargetList) {
					InterestCategoryTargetList interestCategoryTargetList = (InterestCategoryTargetList) targetList.get(j);
					List<InterestCategoryTarget> interestCategoryTarget = interestCategoryTargetList.getTargets();
					for (int k = 0; k < interestCategoryTarget.size(); k++) {
						System.out.println("targets/targets---------");
						System.out.println("targets/targets/type = " + interestCategoryTarget.get(k).getType().toString());
						System.out.println("targets/targets/category = " + interestCategoryTarget.get(k).getCategory());
					}
				} else if (targetList.get(j) instanceof SiteCategoryTargetList) {
					SiteCategoryTargetList siteCategoryTargetList = (SiteCategoryTargetList) targetList.get(j);
					List<SiteCategoryTarget> siteCategoryTarget = siteCategoryTargetList.getTargets();
					for (int k = 0; k < siteCategoryTarget.size(); k++) {
						System.out.println("targets/targets---------");
						System.out.println("targets/targets/type = " + siteCategoryTarget.get(k).getType().toString());
						System.out.println("targets/targets/category = " + siteCategoryTarget.get(k).getCategory());
					}
				} else if (targetList.get(j) instanceof SiteRetargetingTargetList) {
					SiteRetargetingTargetList siteRetargetingTargetList = (SiteRetargetingTargetList) targetList.get(j);
					List<SiteRetargetingTarget> siteRetargetingTarget = siteRetargetingTargetList.getTargets();
					for (int k = 0; k < siteRetargetingTarget.size(); k++) {
						System.out.println("targets/targets---------");
						System.out.println("targets/targets/type = " + siteRetargetingTarget.get(k).getType().toString());
						System.out.println("targets/targets/targetListId = " + siteRetargetingTarget.get(k).getTargetListId());
						System.out.println("targets/targets/targetListName = " + siteRetargetingTarget.get(k).getTargetListName().toString());
						System.out.println("targets/targets/targetListStatus = " + siteRetargetingTarget.get(k).getTargetListStatus().toString());
					}
				} else if (targetList.get(j) instanceof SearchTargetList) {
					SearchTargetList searchTargetList = (SearchTargetList) targetList.get(j);
					List<SearchTarget> searchTarget = searchTargetList.getTargets();
					for (int k = 0; k < searchTarget.size(); k++) {
						System.out.println("targets/targets---------");
						System.out.println("targets/targets/type = " + searchTarget.get(k).getType());
						System.out.println("targets/targets/searchKeywordListId = " + searchTarget.get(k).getSearchKeywordListId());
						System.out.println("targets/targets/searchKeywordListName = " + searchTarget.get(k).getSearchKeywordListName());
						System.out.println("targets/targets/searchKeywordListStatus = " + searchTarget.get(k).getSearchKeywordListStatus());
					}
				}
			}
		}
		System.out.println("---------");
	}
}
