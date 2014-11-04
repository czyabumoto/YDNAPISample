package ydnsample;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import jp.yahooapis.im.V4.CampaignService.Campaign;
import ydnsample.builder.Factory;
import ydnsample.dao.AccountDao;
import ydnsample.dao.AdGroupDao;
import ydnsample.dao.CampaignDao;
import ydnsample.util.Constraint;

public class TestDataCreate {

	public static void main(String[] args) throws Exception {
		// キャンペーン一覧の初期化
		System.out.println("初期化します...");
		AccountDao.clearCampaigns(Constraint.ACCOUNT_ID);
		System.out.println("クリア確認用出力...");
		TestPrintAll.printAccount(Constraint.ACCOUNT_ID);

		System.out.println("データ作成...");
		// キャンペーン作成
		Campaign campaign1 = CampaignDao.addCampaign(Constraint.ACCOUNT_ID, Factory.createDefaultCampaign(Constraint.ACCOUNT_ID, 1L, "テストキャンペーン１").make());
		Campaign campaign2 = CampaignDao.addCampaign(Constraint.ACCOUNT_ID, Factory.createDefaultCampaign(Constraint.ACCOUNT_ID, 2L, "テストキャンペーン２").make());
		Campaign campaign3 = CampaignDao.addCampaign(Constraint.ACCOUNT_ID, Factory.createDefaultCampaign(Constraint.ACCOUNT_ID, 3L, "テストキャンペーン３").make());
		
		// AdGroup作成
		AdGroupDao.addAdGroup(Constraint.ACCOUNT_ID, Factory.createDefaultAdGroup(Constraint.ACCOUNT_ID, campaign1.getCampaignId(), 11L, "テストグループ１").make());
		AdGroupDao.addAdGroup(Constraint.ACCOUNT_ID, Factory.createDefaultAdGroup(Constraint.ACCOUNT_ID, campaign1.getCampaignId(), 12L, "テストグループ２").make());
		AdGroupDao.addAdGroup(Constraint.ACCOUNT_ID, Factory.createDefaultAdGroup(Constraint.ACCOUNT_ID, campaign2.getCampaignId(), 21L, "テストグループ２ー１").make());
		
		// Ad作成（テストでは不要）
//		MediaDao.addMedia(Constraint.ACCOUNT_ID, Factory.createDefaultMedia());
		
		// 確認用表示
		System.out.println("確認用出力...");
		TestPrintAll.printAccount(Constraint.ACCOUNT_ID);
	}
	
	private static int nowTimeStamp() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		return Integer.parseInt(format.format(cal.getTime()));
	}

}
