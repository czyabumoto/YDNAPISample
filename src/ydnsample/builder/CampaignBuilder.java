package ydnsample.builder;

import jp.yahooapis.im.V4.CampaignService.*;

public class CampaignBuilder {
	
	private Campaign campaign = new Campaign();
	
	public CampaignBuilder withId(long campaignId) {
		campaign.setCampaignId(campaignId);
		return this;
	}
	
	public CampaignBuilder withName(String campaignName) {
		campaign.setCampaignName(campaignName);
		return this;
	}
	
	public CampaignBuilder withAccount(long accountId) {
		campaign.setAccountId(accountId);
		return this;
	}
	
	public CampaignBuilder withProductType(String productType) {
		campaign.setAdProductType(productType);
		return this;
	}
	
	public CampaignBuilder withUserStatus(UserStatus status) {
		campaign.setUserStatus(status);
		return this;
	}
	
	public CampaignBuilder withServingStatus(CampaignServingStatus status) {
		campaign.setServingStatus(status);
		return this;
	}
	
	public CampaignBuilder withStartDate(String startDate) {
		campaign.setStartDate(startDate);
		return this;
	}
	
	public CampaignBuilder withEndDate(String endDate) {
		campaign.setEndDate(endDate);
		return this;
	}
	
	public CampaignBuilder withAdProductType(String adProductType) {
		campaign.setAdProductType(adProductType);
		return this;
	}
	
	public CampaignBuilder withBiddingStrategy(BiddingStrategyType biddingStrategyType) {
		BiddingStrategy bid = new ManualCPC();
		bid.setType(biddingStrategyType);
		campaign.setBiddingStrategy(bid);
		return this;
	}
	
	public CampaignBuilder withBudget(long ammount) {
		return withBudget(ammount, BudgetDeliveryMethod.STANDARD);
	}
	
	public CampaignBuilder withBudget(long ammount, BudgetDeliveryMethod method) {
		Budget budget = new Budget();
		budget.setAmount(ammount);
		budget.setDeliveryMethod(method);
		campaign.setBudget(budget);
		return this;
	}
	
	public Campaign make() {
		return campaign;
	}
}
