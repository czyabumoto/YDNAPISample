package ydnsample.builder;

import jp.yahooapis.im.V4.AdGroupAdService.*;

public class AdGroupAdBuilder {
	
	private AdGroupAd ad = new AdGroupAd();
	
	public AdGroupAdBuilder withAccountId(long accountId) {
		ad.setAccountId(accountId);
		return this;
	}
	
	public AdGroupAdBuilder withId(long adId) {
		ad.setAdId(adId);
		return this;
	}
	
	public AdGroupAdBuilder withCampaignId(long campaignId) {
		ad.setCampaignId(campaignId);
		return this;
	}
	
	public AdGroupAdBuilder withAdGroupId(long adGroupId) {
		ad.setAdGroupId(adGroupId);
		return this;
	}
	
	public AdGroupAdBuilder withAdName(String adName) {
		ad.setAdName(adName);
		return this;
	}
	
	public AdGroupAdBuilder withStyle(AdStyle style) {
		ad.setAdStyle(style);
		return this;
	}
	
	public AdGroupAdBuilder withMediaId(long mediaId) {
		ad.setMediaId(mediaId);
		return this;
	}
	
	public AdGroupAdBuilder withUserStatus(UserStatus status) {
		ad.setUserStatus(status);
		return this;
	}
	
	public AdGroupAdBuilder withAd(Ad adType) {
		ad.setAd(adType);
		return this;
	}
	
	public AdGroupAd make() {
		return ad;
	}
}
