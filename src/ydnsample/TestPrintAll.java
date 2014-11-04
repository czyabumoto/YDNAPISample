package ydnsample;

import jp.yahooapis.im.V4.AccountService.Account;
import jp.yahooapis.im.V4.AdGroupAdService.AdGroupAd;
import jp.yahooapis.im.V4.AdGroupService.AdGroup;
import jp.yahooapis.im.V4.CampaignService.Campaign;
import jp.yahooapis.im.V4.MediaService.Media;
import jp.yahooapis.im.V4.MediaService.MediaRecord;
import ydnsample.builder.Factory;
import ydnsample.dao.AccountDao;
import ydnsample.dao.AdDao;
import ydnsample.dao.AdGroupDao;
import ydnsample.dao.CampaignDao;
import ydnsample.dao.MediaDao;
import ydnsample.util.Constraint;
import ydnsample.util.Display;

public class TestPrintAll {

	public static void main(String[] args) throws Exception {
		printAccount(Constraint.ACCOUNT_ID);
	}
	
	public static void printAccount(long accountId) throws Exception {
		for(Account account : AccountDao.findAll(accountId)) {
			Display.print(account, true);
			printCampaigns(account.getAccountId());
		}
	}
	
	public static void printCampaigns(long accountId) throws Exception {
		for (Campaign campaign : CampaignDao.findAll(accountId)) {
			Display.print(campaign, true);
			printAdGroups(accountId, campaign.getCampaignId());
		}
	}
	
	public static void printAdGroups(long accountId, long campaignId) throws Exception {
		for (AdGroup adGroup : AdGroupDao.findAll(accountId, campaignId)) {
			Display.print(adGroup, true);
			printAd(accountId, adGroup.getAdGroupId());
		}
	}
	
	public static void printAd(long accountId, long adGroupId) throws Exception {
		for (AdGroupAd ad : AdDao.findAll(accountId, adGroupId)) {
			Display.print(ad, true);
			printMedia(accountId, ad.getMediaId());
		}
	}
	
	public static void printMedia(long accountId, long mediaId) throws Exception {
		MediaRecord media = MediaDao.find(accountId, mediaId);
		Display.print(media, true);
	}

}
