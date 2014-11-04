package ydnsample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
import jp.yahooapis.im.V4.AdGroupTargetService.AgeTarget;
import jp.yahooapis.im.V4.AdGroupTargetService.AgeTargetList;
import jp.yahooapis.im.V4.AdGroupTargetService.DayOfWeek;
import jp.yahooapis.im.V4.AdGroupTargetService.Gender;
import jp.yahooapis.im.V4.AdGroupTargetService.GenderTarget;
import jp.yahooapis.im.V4.AdGroupTargetService.GenderTargetList;
import jp.yahooapis.im.V4.AdGroupTargetService.GeoTarget;
import jp.yahooapis.im.V4.AdGroupTargetService.GeoTargetList;
import jp.yahooapis.im.V4.AdGroupTargetService.InterestCategoryTarget;
import jp.yahooapis.im.V4.AdGroupTargetService.InterestCategoryTargetList;
import jp.yahooapis.im.V4.AdGroupTargetService.SiteCategoryTarget;
import jp.yahooapis.im.V4.AdGroupTargetService.SiteCategoryTargetList;
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
import jp.yahooapis.im.V4.CampaignService.ManualCPC;
import jp.yahooapis.im.V4.MediaService.ImageMedia;
import jp.yahooapis.im.V4.MediaService.Media;
import jp.yahooapis.im.V4.MediaService.MediaOperation;
import jp.yahooapis.im.V4.MediaService.MediaPage;
import jp.yahooapis.im.V4.MediaService.MediaRecord;
import jp.yahooapis.im.V4.MediaService.MediaReturnValue;
import jp.yahooapis.im.V4.MediaService.MediaSelector;
import jp.yahooapis.im.V4.MediaService.MediaServiceInterface;
import jp.yahooapis.im.V4.MediaService.MediaServiceService;
import jp.yahooapis.im.V4.MediaService.MediaValues;
import jp.yahooapis.im.V4.MediaService.Operator;
import jp.yahooapis.im.V4.MediaService.Paging;
import jp.yahooapis.im.V4.MediaService.UserStatus;
import jp.yahooapis.im.V4.MediaService.Error;
import jp.yahooapis.im.V4.error.impl.AdGroupAdServiceErrorEntityFactory;
import jp.yahooapis.im.V4.error.impl.AdGroupServiceErrorEntityFactory;
import jp.yahooapis.im.V4.error.impl.AdGroupTargetServiceErrorEntityFactory;
import jp.yahooapis.im.V4.error.impl.CampaignServiceErrorEntityFactory;
import jp.yahooapis.im.V4.error.impl.MediaServiceErrorEntityFactory;
import jp.yahooapis.im.V4.util.SoapUtils;

/**
 * Sample Program for
 * CampaignService,AdGroupService,AdGroupAdService,AdGroupTargetService.
 * Copyright (C) 2012 Yahoo Japan Corporation. All Rights Reserved.
 */
public class MediaSample {

	// 1:ADD 2:VIEW 3:REMOVE 4:REMOVEALL
	private static int Action = 2;
//	private static long[] TargetIds = new long[] { 2458 };
	private static long[] TargetIds = new long[0];

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
			// MediaService
			// =================================================================
			MediaServiceInterface mediaService = SoapUtils.createServiceInterface(MediaServiceInterface.class, MediaServiceService.class);

			// -----------------------------------------------
			// MediaService::mutate(ADD)
			// -----------------------------------------------
			// request
			if (Action == 1) {
				ImageMedia imageMedia = new ImageMedia();
				imageMedia.setData(getMediaData("SampleMedia.jpg"));

				MediaRecord addMediaOperand = new MediaRecord();
				addMediaOperand.setAccountId(accountId);
				addMediaOperand.setMediaName("SampleMedia_CreateOn_" + SoapUtils.getCurrentTimestamp() + ".jpg");
				addMediaOperand.setMediaTitle("SampleMedia_CreateOn_" + SoapUtils.getCurrentTimestamp());
				addMediaOperand.setUserStatus(UserStatus.ACTIVE);
				addMediaOperand.setMedia(imageMedia);

				MediaOperation addMediaOperation = new MediaOperation();
				addMediaOperation.setOperator(Operator.ADD);
				addMediaOperation.setAccountId(accountId);
				addMediaOperation.getOperand().add(addMediaOperand);

				// call API
				System.out.println("############################################");
				System.out.println("MediaService::mutate(ADD)");
				System.out.println("############################################");
				Holder<MediaReturnValue> addMediaReturnValueHolder = new Holder<MediaReturnValue>();
				Holder<List<Error>> addMediaErrorHolder = new Holder<List<Error>>();
				mediaService.mutate(addMediaOperation, addMediaReturnValueHolder, addMediaErrorHolder);

				// if error
				if (addMediaErrorHolder.value != null && addMediaErrorHolder.value.size() > 0) {
					SoapUtils.displayErrors(new MediaServiceErrorEntityFactory(addMediaErrorHolder.value), true);
				}

				// response
				long mediaId = -1;
				if (addMediaReturnValueHolder.value != null) {
					MediaReturnValue returnValue = addMediaReturnValueHolder.value;
					if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
						List<MediaValues> values = returnValue.getValues();
						for (int i = 0; i < values.size(); i++) {
							if (values.get(i).isOperationSucceeded()) {
								// display response
								MediaRecord media = values.get(i).getMediaRecord();
								mediaId = media.getMediaId();
								displayMedia(media);
							} else {
								// if error
								SoapUtils.displayErrors(new MediaServiceErrorEntityFactory(values.get(i).getError()), true);
							}
						}
					}
				}
			}
			// -----------------------------------------------
			// MediaService::get
			// -----------------------------------------------
			if (Action == 2 || Action == 4) {
				List<Long> ids = new ArrayList<>();
				MediaSelector mediaSelector = new MediaSelector();
				mediaSelector.setAccountId(accountId);
				for (long targetId : TargetIds) {
					mediaSelector.getMediaIds().add(targetId);
				}
				mediaSelector.getUserStatuses().addAll(Arrays.asList(UserStatus.ACTIVE, UserStatus.PAUSED));
				Paging paging = new Paging();
				paging.setStartIndex(1);
				paging.setNumberResults(20);
				mediaSelector.setPaging(paging);

				// call API
				System.out.println("############################################");
				System.out.println("MediaService::get");
				System.out.println("############################################");
				Holder<MediaPage> mediaPageHolder = new Holder<MediaPage>();
				Holder<List<Error>> getMediaErrorHolder = new Holder<List<Error>>();
				mediaService.get(mediaSelector, mediaPageHolder, getMediaErrorHolder);

				// if error
				if (getMediaErrorHolder.value != null && getMediaErrorHolder.value.size() > 0) {
					SoapUtils.displayErrors(new MediaServiceErrorEntityFactory(getMediaErrorHolder.value), true);
				}

				// response
				if (mediaPageHolder.value != null) {
					MediaPage mediaPage = mediaPageHolder.value;
					if (mediaPage.getValues() != null && mediaPage.getValues().size() > 0) {
						List<MediaValues> values = mediaPage.getValues();
						for (int i = 0; i < values.size(); i++) {
							if (values.get(i).isOperationSucceeded()) {
								MediaRecord r = values.get(i).getMediaRecord();
								ids.add(r.getMediaId());
								displayMedia(r);
							} else {
								// if error
								SoapUtils.displayErrors(new MediaServiceErrorEntityFactory(values.get(i).getError()), true);
							}
						}
					}
				}
				if (Action == 4) {
					TargetIds = new long[ids.size()];
					for (int i = 0; i < ids.size(); i++) {
						TargetIds[i] = ids.get(i);
					}
				}
			}
			// -----------------------------------------------
			// MediaService::mutate(SET)
			// -----------------------------------------------
			// request
			// MediaRecord setMediaOperand = new MediaRecord();
			// setMediaOperand.setAccountId(accountId);
			// setMediaOperand.setMediaId(mediaId);
			// setMediaOperand.setMediaTitle("SampleMedia_UpdateOn_" +
			// SoapUtils.getCurrentTimestamp());
			// setMediaOperand.setUserStatus(UserStatus.PAUSED);
			//
			// MediaOperation setMediaOperation = new MediaOperation();
			// setMediaOperation.setOperator(Operator.SET);
			// setMediaOperation.setAccountId(accountId);
			// setMediaOperation.getOperand().add(setMediaOperand);
			//
			// //call API
			// System.out.println("############################################");
			// System.out.println("MediaService::mutate(SET)");
			// System.out.println("############################################");
			// Holder<MediaReturnValue> setMediaReturnValueHolder = new
			// Holder<MediaReturnValue>();
			// Holder<List<Error>> setMediaErrorHolder = new
			// Holder<List<Error>>();
			// mediaService.mutate(setMediaOperation, setMediaReturnValueHolder,
			// setMediaErrorHolder);
			//
			// //if error
			// if(setMediaErrorHolder.value != null &&
			// setMediaErrorHolder.value.size() > 0){
			// SoapUtils.displayErrors(new
			// MediaServiceErrorEntityFactory(setMediaErrorHolder.value), true);
			// }
			//
			// //response
			// if(setMediaReturnValueHolder.value != null){
			// MediaReturnValue returnValue = setMediaReturnValueHolder.value;
			// if(returnValue.getValues() != null &&
			// returnValue.getValues().size() > 0){
			// List<MediaValues> values = returnValue.getValues();
			// for(int i=0; i<values.size(); i++){
			// if(values.get(i).isOperationSucceeded()){
			// //display response
			// displayMedia(values.get(i).getMediaRecord());
			// }else{
			// //if error
			// SoapUtils.displayErrors(new
			// MediaServiceErrorEntityFactory(values.get(i).getError()), true);
			// }
			// }
			// }
			// }
			//
			// //=================================================================
			// // CampaignService
			// //=================================================================
			// CampaignServiceInterface campaignService =
			// SoapUtils.createServiceInterface(CampaignServiceInterface.class,
			// CampaignServiceService.class);
			//
			// //-----------------------------------------------
			// // CampaignService::mutate(ADD)
			// //-----------------------------------------------
			// //request
			// Campaign addCampaignOperand = new Campaign();
			// addCampaignOperand.setAccountId(accountId);
			// addCampaignOperand.setCampaignName("SampleCampaign_CreateOn_" +
			// SoapUtils.getCurrentTimestamp());
			// addCampaignOperand.setUserStatus(jp.yahooapis.im.V4.CampaignService.UserStatus.ACTIVE);
			// addCampaignOperand.setStartDate("20300101");
			// addCampaignOperand.setEndDate("20301231");
			//
			// Budget addCampaignBudget = new Budget();
			// addCampaignBudget.setAmount((long)1000);
			// addCampaignBudget.setDeliveryMethod(
			// BudgetDeliveryMethod.STANDARD);
			// addCampaignOperand.setBudget(addCampaignBudget);
			//
			// ManualCPC addCampaignManualCpc = new ManualCPC();
			// addCampaignManualCpc.setType(BiddingStrategyType.MANUAL_CPC);
			// addCampaignOperand.setBiddingStrategy(addCampaignManualCpc);
			// addCampaignOperand.setAdProductType("INTEREST_MATCH");
			//
			// CampaignOperation addCampaignOperation = new CampaignOperation();
			// addCampaignOperation.setOperator(jp.yahooapis.im.V4.CampaignService.Operator.ADD);
			// addCampaignOperation.setAccountId(accountId);
			// addCampaignOperation.getOperand().add(addCampaignOperand);
			//
			// //call API
			// System.out.println("############################################");
			// System.out.println("CampaignService::mutate(ADD)");
			// System.out.println("############################################");
			// Holder<CampaignReturnValue> addCampaignReturnValueHolder = new
			// Holder<CampaignReturnValue>();
			// Holder<List<jp.yahooapis.im.V4.CampaignService.Error>>
			// addCampaignErrorHolder = new
			// Holder<List<jp.yahooapis.im.V4.CampaignService.Error>>();
			// campaignService.mutate(addCampaignOperation,
			// addCampaignReturnValueHolder, addCampaignErrorHolder);
			//
			// //if error
			// if(addCampaignErrorHolder.value != null &&
			// addCampaignErrorHolder.value.size() > 0){
			// SoapUtils.displayErrors(new
			// CampaignServiceErrorEntityFactory(addCampaignErrorHolder.value),
			// true);
			// }
			//
			// //response
			// long campaignId = -1;
			// if(addCampaignReturnValueHolder.value != null){
			// CampaignReturnValue returnValue =
			// addCampaignReturnValueHolder.value;
			// if(returnValue.getValues() != null &&
			// returnValue.getValues().size() > 0){
			// List<CampaignValues>values = returnValue.getValues();
			// for(int i=0; i<values.size(); i++){
			// if(values.get(i).isOperationSucceeded()){
			// //display response
			// Campaign campaign = values.get(i).getCampaign();
			// campaignId = campaign.getCampaignId();
			// displayCampaign(campaign);
			// }else{
			// //if error
			// SoapUtils.displayErrors(new
			// CampaignServiceErrorEntityFactory(values.get(i).getError()),
			// true);
			// }
			// }
			// }
			// }
			//
			// //-----------------------------------------------
			// // CampaignService::get
			// //-----------------------------------------------
			// CampaignSelector campaignSelector = new CampaignSelector();
			// campaignSelector.setAccountId(accountId);
			// campaignSelector.getCampaignIds().add(campaignId);
			// campaignSelector.getUserStatus().addAll(Arrays.asList(jp.yahooapis.im.V4.CampaignService.UserStatus.ACTIVE,
			// jp.yahooapis.im.V4.CampaignService.UserStatus.PAUSED));
			//
			// jp.yahooapis.im.V4.CampaignService.Paging getCampaignPaging = new
			// jp.yahooapis.im.V4.CampaignService.Paging();
			// getCampaignPaging.setStartIndex(1);
			// getCampaignPaging.setNumberResults(20);
			// campaignSelector.setPaging(getCampaignPaging);
			//
			// //call API
			// System.out.println("############################################");
			// System.out.println("CampaignService::get");
			// System.out.println("############################################");
			//
			// Holder<CampaignPage> campaignPageHolder = new
			// Holder<CampaignPage>();
			// Holder<List<jp.yahooapis.im.V4.CampaignService.Error>>
			// getCampaignErrorHolder = new
			// Holder<List<jp.yahooapis.im.V4.CampaignService.Error>>();
			// campaignService.get(campaignSelector, campaignPageHolder,
			// getCampaignErrorHolder);
			//
			// //if error
			// if(getCampaignErrorHolder.value != null &&
			// getCampaignErrorHolder.value.size() > 0){
			// SoapUtils.displayErrors(new
			// CampaignServiceErrorEntityFactory(getCampaignErrorHolder.value),
			// true);
			// }
			//
			// //response
			// if(campaignPageHolder.value != null){
			// CampaignPage campaignPage = campaignPageHolder.value;
			// if(campaignPage.getValues() != null &&
			// campaignPage.getValues().size() > 0){
			// List<CampaignValues> values = campaignPage.getValues();
			// for(int i=0; i<values.size(); i++){
			// if(values.get(i).isOperationSucceeded()){
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
			//
			// //-----------------------------------------------
			// // CampaignService::mutate(SET)
			// //-----------------------------------------------
			// //request
			// Campaign setCampaignOperand = new Campaign();
			// setCampaignOperand.setAccountId(accountId);
			// setCampaignOperand.setCampaignId(campaignId);
			// setCampaignOperand.setCampaignName("SampleCampaign_UpdateOn_" +
			// SoapUtils.getCurrentTimestamp());
			// setCampaignOperand.setUserStatus(jp.yahooapis.im.V4.CampaignService.UserStatus.PAUSED);
			// setCampaignOperand.setStartDate("20300101");
			// setCampaignOperand.setEndDate("20301231");
			//
			// Budget setCampaignBudget = new Budget();
			// setCampaignBudget.setAmount((long) 1000);
			// setCampaignBudget.setDeliveryMethod(BudgetDeliveryMethod.STANDARD);
			//
			// ManualCPC setCampaignManualCpc = new ManualCPC();
			// setCampaignManualCpc.setType(BiddingStrategyType.MANUAL_CPC);
			// setCampaignOperand.setBiddingStrategy(setCampaignManualCpc);
			//
			// CampaignOperation setCampaignOperation = new CampaignOperation();
			// setCampaignOperation.setOperator(jp.yahooapis.im.V4.CampaignService.Operator.SET);
			// setCampaignOperation.setAccountId(accountId);
			// setCampaignOperation.getOperand().add(setCampaignOperand);
			//
			// //call API
			// System.out.println("############################################");
			// System.out.println("CampaignService::mutate(SET)");
			// System.out.println("############################################");
			// Holder<CampaignReturnValue> setCampaignReturnValueHolder = new
			// Holder<CampaignReturnValue>();
			// Holder<List<jp.yahooapis.im.V4.CampaignService.Error>>
			// setCampaignErrorHolder = new
			// Holder<List<jp.yahooapis.im.V4.CampaignService.Error>>();
			// campaignService.mutate(setCampaignOperation,
			// setCampaignReturnValueHolder, setCampaignErrorHolder);
			//
			// //if error
			// if(setCampaignErrorHolder.value != null &&
			// setCampaignErrorHolder.value.size() > 0){
			// SoapUtils.displayErrors(new
			// CampaignServiceErrorEntityFactory(setCampaignErrorHolder.value),
			// true);
			// }
			//
			// //response
			// if(setCampaignReturnValueHolder.value != null){
			// CampaignReturnValue returnValue =
			// setCampaignReturnValueHolder.value;
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
			//
			// //=================================================================
			// // AdGroupService
			// //=================================================================
			// AdGroupServiceInterface adGroupService =
			// SoapUtils.createServiceInterface(AdGroupServiceInterface.class,
			// AdGroupServiceService.class);
			//
			// //-----------------------------------------------
			// // AdGroupService::mutate(ADD)
			// //-----------------------------------------------
			// //request
			// AdGroup addAdGroupOperand = new AdGroup();
			// addAdGroupOperand.setAccountId(accountId);
			// addAdGroupOperand.setCampaignId(campaignId);
			// addAdGroupOperand.setAdGroupName("SampleAdGroup_CreateOn_" +
			// SoapUtils.getCurrentTimestamp());
			// addAdGroupOperand.setUserStatus(jp.yahooapis.im.V4.AdGroupService.UserStatus.ACTIVE);
			// ManualCPCAdGroupBid addAdGroupManualCpc = new
			// ManualCPCAdGroupBid();
			// addAdGroupManualCpc.setType(jp.yahooapis.im.V4.AdGroupService.BiddingStrategyType.MANUAL_CPC);
			// addAdGroupManualCpc.setMaxCpc((long)120);
			// addAdGroupOperand.setBid(addAdGroupManualCpc);
			// addAdGroupOperand.getDevice().add(DeviceType.SMARTPHONE);
			// addAdGroupOperand.getDeviceOs().add(DeviceOsType.IOS);
			// addAdGroupOperand.getDeviceApp().add(DeviceAppType.APP);
			//
			// AdGroupOperation addAdGroupOperation = new AdGroupOperation();
			// addAdGroupOperation.setOperator(jp.yahooapis.im.V4.AdGroupService.Operator.ADD);
			// addAdGroupOperation.setAccountId(accountId);
			// addAdGroupOperation.setCampaignId(campaignId);
			// addAdGroupOperation.getOperand().add(addAdGroupOperand);
			//
			// //call API
			// System.out.println("############################################");
			// System.out.println("AdGroupService::mutate(ADD)");
			// System.out.println("############################################");
			// Holder<AdGroupReturnValue> addAdgroupReturnValueHolder = new
			// Holder<AdGroupReturnValue>();
			// Holder<List<jp.yahooapis.im.V4.AdGroupService.Error>>
			// addAdGroupErrorHolder = new
			// Holder<List<jp.yahooapis.im.V4.AdGroupService.Error>>();
			// adGroupService.mutate(addAdGroupOperation,
			// addAdgroupReturnValueHolder, addAdGroupErrorHolder);
			//
			// //if error
			// if(addAdGroupErrorHolder.value != null &&
			// addAdGroupErrorHolder.value.size() > 0){
			// SoapUtils.displayErrors(new
			// AdGroupServiceErrorEntityFactory(addAdGroupErrorHolder.value),
			// true);
			// }
			//
			// long adGroupId = -1;
			// //response
			// if(addAdgroupReturnValueHolder.value != null){
			// AdGroupReturnValue returnValue =
			// addAdgroupReturnValueHolder.value;
			// if(returnValue.getValues() != null &&
			// returnValue.getValues().size() > 0){
			// List<AdGroupValues> values = returnValue.getValues();
			// for(int i=0; i<values.size(); i++){
			// if(values.get(i).isOperationSucceeded()){
			// //display response
			// AdGroup adGroup = values.get(i).getAdGroup();
			// adGroupId = adGroup.getAdGroupId();
			// displayAdGroup(adGroup);
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
			// // AdGroupService::get
			// //-----------------------------------------------
			// AdGroupSelector adGroupSelector = new AdGroupSelector();
			// adGroupSelector.setAccountId(accountId);
			// adGroupSelector.getCampaignIds().add(campaignId);
			// adGroupSelector.getAdGroupIds().add(adGroupId);
			// adGroupSelector.getUserStatuses().addAll(Arrays.asList(jp.yahooapis.im.V4.AdGroupService.UserStatus.ACTIVE,
			// jp.yahooapis.im.V4.AdGroupService.UserStatus.PAUSED));
			// jp.yahooapis.im.V4.AdGroupService.Paging getAdGroup = new
			// jp.yahooapis.im.V4.AdGroupService.Paging();
			// getAdGroup.setStartIndex(1);
			// getAdGroup.setNumberResults(20);
			// adGroupSelector.setPaging(getAdGroup);
			//
			// //call API
			// System.out.println("############################################");
			// System.out.println("AdGroupService::get");
			// System.out.println("############################################");
			// Holder<AdGroupPage> adGroupPageHolder = new
			// Holder<AdGroupPage>();
			// Holder<List<jp.yahooapis.im.V4.AdGroupService.Error>>
			// getAdGroupErrorHolder = new
			// Holder<List<jp.yahooapis.im.V4.AdGroupService.Error>>();
			// adGroupService.get(adGroupSelector, adGroupPageHolder,
			// getAdGroupErrorHolder);
			//
			// //if error
			// if(getAdGroupErrorHolder.value != null &&
			// getAdGroupErrorHolder.value.size() > 0){
			// SoapUtils.displayErrors(new
			// AdGroupServiceErrorEntityFactory(getAdGroupErrorHolder.value),
			// true);
			// }
			//
			// //response
			// if(adGroupPageHolder.value != null){
			// AdGroupPage adGroupPage = adGroupPageHolder.value;
			// if(adGroupPage.getValues() != null &&
			// adGroupPage.getValues().size() > 0){
			// List<AdGroupValues> values = adGroupPage.getValues();
			// for(int i=0; i<values.size(); i++){
			// if(values.get(i).isOperationSucceeded()){
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
			// ManualCPCAdGroupBid setAdGroupManualCpc = new
			// ManualCPCAdGroupBid();
			// setAdGroupManualCpc.setMaxCpc((long)120);
			// setAdGroupManualCpc.setType(jp.yahooapis.im.V4.AdGroupService.BiddingStrategyType.MANUAL_CPC);
			// setAdGroupOperand.setBid(setAdGroupManualCpc);
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
			// //=================================================================
			// // AdGroupAdService
			// //=================================================================
			// AdGroupAdServiceInterface adGroupAdService =
			// SoapUtils.createServiceInterface(AdGroupAdServiceInterface.class,
			// AdGroupAdServiceService.class);
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
			// addAdGroupAdOperand.setAdName("SampleAdGroupAd_CreateOn_" +
			// SoapUtils.getCurrentTimestamp());
			// addAdGroupAdOperand.setAdStyle(AdStyle.IMAGE);
			// addAdGroupAdOperand.setMediaId(mediaId);
			// addAdGroupAdOperand.setUserStatus(jp.yahooapis.im.V4.AdGroupAdService.UserStatus.ACTIVE);
			// ManualCPCAdGroupAdBid addAdGroupAd = new ManualCPCAdGroupAdBid();
			// addAdGroupAd.setMaxCpc((long)50);
			// addAdGroupAd.setType(jp.yahooapis.im.V4.AdGroupAdService.BiddingStrategyType.MANUAL_CPC);
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
			// Holder<AdGroupAdReturnValue>addAdGroupAdReturnValueHolder = new
			// Holder<AdGroupAdReturnValue>();
			// Holder<List<jp.yahooapis.im.V4.AdGroupAdService.Error>>addAdGroupAdErrorHolder
			// = new Holder<List<jp.yahooapis.im.V4.AdGroupAdService.Error>>();
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
			// adGroupAdSelector.getCampaignIds().add((long)campaignId);
			// adGroupAdSelector.getAdGroupIds().add((long)adGroupId);
			// adGroupAdSelector.getAdIds().add((long) adGroupAdId);
			// adGroupAdSelector.getUserStatuses().addAll(Arrays.asList(jp.yahooapis.im.V4.AdGroupAdService.UserStatus.ACTIVE,
			// jp.yahooapis.im.V4.AdGroupAdService.UserStatus.PAUSED));
			// jp.yahooapis.im.V4.AdGroupAdService.Paging getAdGroupAdPaging =
			// new jp.yahooapis.im.V4.AdGroupAdService.Paging();
			// getAdGroupAdPaging.setNumberResults(20);
			// getAdGroupAdPaging.setStartIndex(1);
			// adGroupAdSelector.setPaging(getAdGroupAdPaging);
			//
			// //call API
			// System.out.println("############################################");
			// System.out.println("AdGroupAdService::get");
			// System.out.println("############################################");
			// Holder<AdGroupAdPage> adGroupAdPageHolder = new
			// Holder<AdGroupAdPage>();
			// Holder<List<jp.yahooapis.im.V4.AdGroupAdService.Error>>getAdGroupAdErrorHolder
			// = new Holder<List<jp.yahooapis.im.V4.AdGroupAdService.Error>>();
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
			//
			// //sleep 10 second for review.
			// System.out.println("***** sleep 10 seconds for ad review *****");
			// Thread.sleep(10000);
			//
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
			// ManualCPCAdGroupAdBid setAdGroupAdManualCpc = new
			// ManualCPCAdGroupAdBid();
			// setAdGroupAdManualCpc.setType(jp.yahooapis.im.V4.AdGroupAdService.BiddingStrategyType.MANUAL_CPC);
			// setAdGroupAdManualCpc.setMaxCpc((long)60);
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
			// Holder<AdGroupAdReturnValue>setAdGroupAdReturnValueHolder = new
			// Holder<AdGroupAdReturnValue>();
			// Holder<List<jp.yahooapis.im.V4.AdGroupAdService.Error>>setAdGroupAdErrorHolder
			// = new Holder<List<jp.yahooapis.im.V4.AdGroupAdService.Error>>();
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
			//
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
			//
			// GenderTargetList setGenderTargetList = new GenderTargetList();
			// setGenderTargetList.setAccountId(accountId);
			// setGenderTargetList.setCampaignId(campaignId);
			// setGenderTargetList.setAdGroupId(adGroupId);
			// setGenderTargetList.setType(TargetType.GENDER_TARGET);
			// setGenderTargetList.getTargets().add(setGenderTarget1);
			//
			// AdGroupTargetList setAdGroupTargetOperand = new
			// AdGroupTargetList();
			// setAdGroupTargetOperand.setAccountId(accountId);
			// setAdGroupTargetOperand.setCampaignId(campaignId);
			// setAdGroupTargetOperand.setAdGroupId(adGroupId);
			// setAdGroupTargetOperand.getTargets().addAll(Arrays.asList(setAdScheduleTargetList,
			// setGenderTargetList));
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
			// Holder<AdGroupTargetReturnValue>setAdGroupTargetReturnValueHolder
			// = new Holder<AdGroupTargetReturnValue>();
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
			// AdGroupTargetSelector adGroupTargetSelector = new
			// AdGroupTargetSelector();
			// adGroupTargetSelector.setAccountId(accountId);
			// adGroupTargetSelector.getCampaignIds().add((long)campaignId);
			// adGroupTargetSelector.getAdGroupIds().add((long)adGroupId);
			//
			// //call API
			// System.out.println("############################################");
			// System.out.println("AdGroupTargetService::get");
			// System.out.println("############################################");
			// Holder<AdGroupTargetPage>adGroupTargetPageHolder = new
			// Holder<AdGroupTargetPage>();
			// Holder<List<jp.yahooapis.im.V4.AdGroupTargetService.Error>>getAdGroupTargetErrorHolder
			// = new
			// Holder<List<jp.yahooapis.im.V4.AdGroupTargetService.Error>>();
			// adGroupTargetService.get(adGroupTargetSelector,
			// adGroupTargetPageHolder, getAdGroupTargetErrorHolder);
			//
			// //if error
			// if(getAdGroupTargetErrorHolder.value != null &&
			// getAdGroupTargetErrorHolder.value.size() > 0){
			// SoapUtils.displayErrors(new
			// AdGroupTargetServiceErrorEntityFactory(getAdGroupTargetErrorHolder.value),
			// true);
			// }
			//
			// //response
			// if(adGroupTargetPageHolder.value != null){
			// AdGroupTargetPage adGroupTargetPage =
			// adGroupTargetPageHolder.value;
			// if(adGroupTargetPage.getValues() != null &&
			// adGroupTargetPage.getValues().size() > 0){
			// List<AdGroupTargetValues> values = adGroupTargetPage.getValues();
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
			// //=================================================================
			// // remove AdGroupAd, AdGroup, Campaign
			// //=================================================================
			// //-----------------------------------------------
			// // AdGroupAdService::mutate(REMOVE)
			// //-----------------------------------------------
			// //request
			// AdGroupAd removeAdGroupAdOperand = new AdGroupAd();
			// removeAdGroupAdOperand.setAccountId(accountId);
			// removeAdGroupAdOperand.setCampaignId(campaignId);
			// removeAdGroupAdOperand.setAdGroupId(adGroupId);
			// removeAdGroupAdOperand.setAdId(adGroupAdId);
			//
			// AdGroupAdOperation removeAdGroupAdOperation = new
			// AdGroupAdOperation();
			// removeAdGroupAdOperation.setOperator(jp.yahooapis.im.V4.AdGroupAdService.Operator.REMOVE);
			// removeAdGroupAdOperation.setAccountId(accountId);
			// removeAdGroupAdOperation.setCampaignId(campaignId);
			// removeAdGroupAdOperation.setAdGroupId(adGroupId);
			// removeAdGroupAdOperation.getOperand().add(removeAdGroupAdOperand);
			//
			// //call API
			// System.out.println("############################################");
			// System.out.println("AdGroupAdService::mutate(REMOVE)");
			// System.out.println("############################################");
			// Holder<AdGroupAdReturnValue>removeAdGroupAdReturnValueHolder =
			// new Holder<AdGroupAdReturnValue>();
			// Holder<List<jp.yahooapis.im.V4.AdGroupAdService.Error>>removeAdGroupAdErrorHolder
			// = new Holder<List<jp.yahooapis.im.V4.AdGroupAdService.Error>>();
			// adGroupAdService.mutate(removeAdGroupAdOperation,
			// removeAdGroupAdReturnValueHolder, removeAdGroupAdErrorHolder);
			//
			// //if error
			// if(removeAdGroupAdErrorHolder.value != null &&
			// removeAdGroupAdErrorHolder.value.size() > 0){
			// SoapUtils.displayErrors(new
			// AdGroupAdServiceErrorEntityFactory(removeAdGroupAdErrorHolder.value),
			// true);
			// }
			//
			// //response
			// if(removeAdGroupAdReturnValueHolder.value != null){
			// AdGroupAdReturnValue returnValue =
			// removeAdGroupAdReturnValueHolder.value;
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
			// Holder<AdGroupReturnValue>removeAdgroupReturnValueHolder = new
			// Holder<AdGroupReturnValue>();
			// Holder<List<jp.yahooapis.im.V4.AdGroupService.Error>>removeAdGroupErrorHolder
			// = new Holder<List<jp.yahooapis.im.V4.AdGroupService.Error>>();
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
			// Holder<CampaignReturnValue>removeCampaignReturnValueHolder = new
			// Holder<CampaignReturnValue>();
			// Holder<List<jp.yahooapis.im.V4.CampaignService.Error>>
			// removeCampaignErrorHolder = new
			// Holder<List<jp.yahooapis.im.V4.CampaignService.Error>>();
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
			//
			// -----------------------------------------------
			// MediaService::mutate(REMOVE)
			// -----------------------------------------------
			// request
			if (Action == 3) {
				for (long targetId : TargetIds) {

					MediaRecord removeMediaOperand = new MediaRecord();
					removeMediaOperand.setAccountId(accountId);
					removeMediaOperand.setMediaId(targetId);

					MediaOperation removeMediaOperation = new MediaOperation();
					removeMediaOperation.setOperator(Operator.REMOVE);
					removeMediaOperation.setAccountId(accountId);
					removeMediaOperation.getOperand().add(removeMediaOperand);

					// call API
					System.out.println("############################################");
					System.out.println("MediaService::mutate(REMOVE)");
					System.out.println("############################################");
					Holder<MediaReturnValue> removeMediaReturnValueHolder = new Holder<MediaReturnValue>();
					Holder<List<Error>> removeMediaErrorHolder = new Holder<List<Error>>();
					mediaService.mutate(removeMediaOperation, removeMediaReturnValueHolder, removeMediaErrorHolder);

					// if error
					if (removeMediaErrorHolder.value != null && removeMediaErrorHolder.value.size() > 0) {
						SoapUtils.displayErrors(new MediaServiceErrorEntityFactory(removeMediaErrorHolder.value), true);
					}

					// response
					if (removeMediaReturnValueHolder.value != null) {
						MediaReturnValue returnValue = removeMediaReturnValueHolder.value;
						if (returnValue.getValues() != null && returnValue.getValues().size() > 0) {
							List<MediaValues> values = returnValue.getValues();
							for (int i = 0; i < values.size(); i++) {
								if (values.get(i).isOperationSucceeded()) {
									// display response
									displayMedia(values.get(i).getMediaRecord());
								} else {
									// if error
									SoapUtils.displayErrors(new MediaServiceErrorEntityFactory(values.get(i).getError()), true);
								}
							}
						}
					}
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * get upload data.
	 * 
	 * @param media
	 *            Media entity for display.
	 */
	private static byte[] getMediaData(String filename) throws FileNotFoundException {
		File uploadDir = new File(new File(".").getAbsolutePath() + "/upload");
		File uploadFile = new File(uploadDir, filename);
		if (!uploadFile.exists()) {
			throw new FileNotFoundException("upload file not found. file=" + uploadFile.getAbsolutePath());
		}
		int len = (int) uploadFile.length();
		byte[] buf = new byte[len];

		InputStream is = null;
		try {
			is = new FileInputStream(uploadFile);
			is.read(buf);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			if (is != null)
				try {
					is.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
		}
		return buf;
	}

	/**
	 * display Media entity to stdout.
	 * 
	 * @param media
	 *            Media entity for display.
	 */
	private static void displayMedia(MediaRecord mediaRecord) {
		System.out.println("accountId = " + mediaRecord.getAccountId());
		System.out.println("mediaId = " + mediaRecord.getMediaId());
		System.out.println("mediaName = " + mediaRecord.getMediaName());
		System.out.println("mediaTitle = " + mediaRecord.getMediaTitle());
		System.out.println("userStatus = " + mediaRecord.getUserStatus().toString());
		System.out.println("approvalStatus = " + mediaRecord.getApprovalStatus().toString());
		if (mediaRecord.getMedia() != null) {
			Media media = mediaRecord.getMedia();
			if (media instanceof ImageMedia) {
				ImageMedia imageMedia = (ImageMedia) media;
				System.out.println("media/mediaFileType = " + imageMedia.getMediaFileType());
				System.out.println("media/mediaAdFormat = " + imageMedia.getMediaAdFormat());
				System.out.println("media/fileSize = " + imageMedia.getFileSize());
				System.out.println("media/width = " + imageMedia.getWidth());
				System.out.println("media/height = " + imageMedia.getHeight());
				System.out.println("media/downloadUrl = " + imageMedia.getDownloadUrl());
			}
		}
		System.out.println("---------");
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
		System.out.println("device = " + adGroup.getDevice());
		System.out.println("deviceOs = " + adGroup.getDeviceOs());
		System.out.println("deviceApp = " + adGroup.getDeviceApp());
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
				System.out.println("ad/mobileCarerrir = " + mobileAd.getMobileCarriers());
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
				}
			}
		}
		System.out.println("---------");
	}
}
