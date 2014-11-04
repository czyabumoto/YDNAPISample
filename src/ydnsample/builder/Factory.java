package ydnsample.builder;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jp.yahooapis.im.V4.AccountService.AccountStatus;
import jp.yahooapis.im.V4.AccountService.DeliveryStatus;
import jp.yahooapis.im.V4.AdGroupService.DeviceAppType;
import jp.yahooapis.im.V4.AdGroupService.DeviceOsType;
import jp.yahooapis.im.V4.AdGroupService.DeviceType;
import jp.yahooapis.im.V4.CampaignService.BiddingStrategyType;
import jp.yahooapis.im.V4.CampaignService.UserStatus;

public class Factory {

	public static AccountBuilder createAccount() {
		return new AccountBuilder();
	}

	public static CampaignBuilder createCampaign() {
		return new CampaignBuilder();
	}

	public static AdGroupBuilder createAdGroup() {
		return new AdGroupBuilder();
	}

	public static AdGroupAdBuilder createAd() {
		return new AdGroupAdBuilder();
	}

	public static MediaBuilder createMedia() {
		return new MediaBuilder();
	}

	public static AccountBuilder createDefaultAccount(long accountId, String accountName) {
		/* @formatter:off */
		return Factory.createAccount()
				.withId(accountId)
				.withName(accountName)
				.withAccountStatus(AccountStatus.SERVING)
				.withDeliveryStatus(DeliveryStatus.ACTIVE);
		/* @formatter:on */
	}

	public static CampaignBuilder createDefaultCampaign(long accountId, long campaignId, String campaignName) {
		/* @formatter:off */
		return Factory.createCampaign()
				.withAccount(accountId)
				.withId(campaignId)
				.withName(campaignName)
				.withAdProductType("TARGET_MATCH")
				.withBudget(100000)
				.withStartDate(getFutureDate(0))
				.withEndDate(getFutureDate(100))
				.withBiddingStrategy(BiddingStrategyType.MANUAL_CPC)
				.withUserStatus(UserStatus.ACTIVE);
		/* @formatter:on */
	}

	public static AdGroupBuilder createDefaultAdGroup(long accountId, long campaignId, long adGroupId, String adGroupName) {
		/* @formatter:off */
		return Factory.createAdGroup()
				.withAccount(accountId)
				.withCampaignId(campaignId)
				.withId(adGroupId)
				.withName(adGroupName)
				.withUserStatus(jp.yahooapis.im.V4.AdGroupService.UserStatus.ACTIVE)
				.withBid(jp.yahooapis.im.V4.AdGroupService.BiddingStrategyType.MANUAL_CPC)
				.withDevice(DeviceType.SMARTPHONE)
				.withDeviceAppType(DeviceAppType.APP)
				.withDeviceOs(DeviceOsType.IOS)
				.withDeviceOs(DeviceOsType.ANDROID);
		/* @formatter:on */
	}
	
	// 今回のテストでは不要・・
//	public static AdGroupAdBuilder createDefaultAd(long accountId, long adGroupId, long adId) {
//		
//	}

	public static MediaBuilder createDefaultMedia(long accountId, long mediaId, String fileName) {
		/* @formatter:off */
		String[] path = fileName.split("\\");
		String simpleName = path[path.length - 1];
		String key = simpleName.split(".")[0];
		return Factory.createMedia()
				.withAccountId(accountId)
				.withId(mediaId)
				.withMedia(new File(fileName), "http://test.com")
				.withName(simpleName)
				.withTitle(key)
				.withUserStatus(jp.yahooapis.im.V4.MediaService.UserStatus.ACTIVE);
		/* @formatter:on */
	}
	
	private static String getFutureDate(int futureDays) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, futureDays);
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		return format.format(cal.getTime());
	}
}
