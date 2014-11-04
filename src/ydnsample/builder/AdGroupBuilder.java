package ydnsample.builder;

import jp.yahooapis.im.V4.AdGroupService.*;

public class AdGroupBuilder {
	
	private AdGroup adGroup = new AdGroup();
	
	public AdGroupBuilder withId(long adGroupId) {
		adGroup.setAdGroupId(adGroupId);
		return this;
	}
	
	public AdGroupBuilder withCampaignId(long campaignId) {
		adGroup.setCampaignId(campaignId);
		return this;
	}
	
	public AdGroupBuilder withName(String campaignName) {
		adGroup.setAdGroupName(campaignName);
		return this;
	}
	
	public AdGroupBuilder withAccount(long accountId) {
		adGroup.setAccountId(accountId);
		return this;
	}
	
	public AdGroupBuilder withUserStatus(UserStatus status) {
		adGroup.setUserStatus(status);
		return this;
	}
	
	public AdGroupBuilder withDevice(DeviceType type) {
		adGroup.getDevice().add(type);
		return this;
	}
	
	public AdGroupBuilder withDeviceAppType(DeviceAppType deviceAppType) {
		adGroup.getDeviceApp().add(deviceAppType);
		return this;
	}
	
	public AdGroupBuilder withDeviceOs(DeviceOsType argName) {
		adGroup.getDeviceOs().add(argName);
		return this;
	}
	
	public AdGroupBuilder withBid(BiddingStrategyType bidType) {
		ManualCPCAdGroupBid bid = new ManualCPCAdGroupBid();
		bid.setType(bidType);
		bid.setMaxCpc(1000L);
		adGroup.setBid(bid);
		return this;
	}
	
	public AdGroup make() {
		return adGroup;
	}
}
