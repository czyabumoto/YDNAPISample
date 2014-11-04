package ydnsample.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.ws.Holder;

import ydnsample.util.Display;
import jp.yahooapis.im.V4.AccountService.Account;
import jp.yahooapis.im.V4.AccountService.AccountOperation;
import jp.yahooapis.im.V4.AccountService.AccountPage;
import jp.yahooapis.im.V4.AccountService.AccountReturnValue;
import jp.yahooapis.im.V4.AccountService.AccountSelector;
import jp.yahooapis.im.V4.AccountService.AccountServiceInterface;
import jp.yahooapis.im.V4.AccountService.AccountServiceService;
import jp.yahooapis.im.V4.AccountService.AccountStatus;
import jp.yahooapis.im.V4.AccountService.AccountType;
import jp.yahooapis.im.V4.AccountService.AccountValues;
import jp.yahooapis.im.V4.AccountService.ApiException;
import jp.yahooapis.im.V4.AccountService.DeliveryStatus;
import jp.yahooapis.im.V4.AccountService.Error;
import jp.yahooapis.im.V4.AccountService.Operator;
import jp.yahooapis.im.V4.AccountService.Paging;
import jp.yahooapis.im.V4.error.impl.AccountServiceErrorEntityFactory;
import jp.yahooapis.im.V4.util.SoapUtils;

public class AccountDao {

	private static AccountServiceInterface accountService;

	static {
		try {
			accountService = SoapUtils.createServiceInterface(AccountServiceInterface.class, AccountServiceService.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * アカウントを取得する
	 * 
	 * @param accountId
	 * @return
	 * @throws ApiException
	 */
	public static List<Account> findAll(long accountId) throws ApiException {
		AccountSelector accountSelector = new AccountSelector();
		Paging accountPaging = new Paging();
		accountPaging.setStartIndex(1);
		accountPaging.setNumberResults(20);

		// -----------------------------------------------
		// AccountService::get(with accountIds)
		// -----------------------------------------------
		// request
		accountSelector.getAccountIds().add(accountId);
		accountSelector.getAccountStatuses().addAll(Arrays.asList(AccountStatus.SERVING, AccountStatus.ENDED));
		accountSelector.getAccountTypes().addAll(Arrays.asList(AccountType.INVOICE, AccountType.PREPAY));
		Paging getAccoutPaging = new Paging();
		getAccoutPaging.setStartIndex(1);
		getAccoutPaging.setNumberResults(20);
		accountSelector.setPaging(getAccoutPaging);

		// call API
		Holder<AccountPage> getAccountPageHolder = new Holder<AccountPage>();
		Holder<List<Error>> getAccountErrorHolder = new Holder<List<Error>>();
		accountService.get(accountSelector, getAccountPageHolder, getAccountErrorHolder);

		// if error
		if (getAccountErrorHolder.value != null && getAccountErrorHolder.value.size() > 0) {
			SoapUtils.displayErrors(new AccountServiceErrorEntityFactory(getAccountErrorHolder.value), true);
		}

		// response
		List<Account> accounts = new ArrayList<>();
		if (getAccountPageHolder.value != null) {
			AccountPage accountPage = getAccountPageHolder.value;
			if (accountPage.getValues() != null && accountPage.getValues().size() > 0) {
				for (int i = 0; i < accountPage.getValues().size(); i++) {
					List<AccountValues> values = accountPage.getValues();
					if (values.get(i).isOperationSucceeded()) {
						// display response
						accounts.add(values.get(i).getAccount());
					} else {
						// if error
						SoapUtils.displayErrors(new AccountServiceErrorEntityFactory(values.get(i).getError()), true);
					}
				}
			}
		}

		return accounts;
	}

	public static void setAccount(Account account) throws ApiException {
		AccountOperation accountOperation = new AccountOperation();
		accountOperation.setOperator(Operator.SET);

		Account accountOperand = new Account();
		accountOperand.setAccountId(account.getAccountId());
		accountOperand.setAccountName(account.getAccountName());
		accountOperand.setAccountStatus(account.getAccountStatus());
		accountOperand.setAccountType(account.getAccountType());
		accountOperand.setDeliveryStatus(DeliveryStatus.PAUSED);

		accountOperation.setOperand(accountOperand);

		// call API
		Holder<AccountReturnValue> accountReturnValueHolder = new Holder<AccountReturnValue>();
		Holder<List<Error>> accountSetErrorHolder = new Holder<List<Error>>();
		accountService.mutate(accountOperation, accountReturnValueHolder, accountSetErrorHolder);

		// if error
		if (accountSetErrorHolder.value != null && accountSetErrorHolder.value.size() > 0) {
			SoapUtils.displayErrors(new AccountServiceErrorEntityFactory(accountSetErrorHolder.value), true);
		}

		// response
		if (accountReturnValueHolder.value != null) {
			AccountReturnValue returnValue = accountReturnValueHolder.value;
			if (returnValue.getValues() != null) {
				AccountValues accountValues = returnValue.getValues();
				if (accountValues.isOperationSucceeded()) {
					// display response
					System.out.println(String.format("Set Account AccountId=%d", account.getAccountId()));
					Display.print(accountValues.getAccount());
				} else {
					// if error
					SoapUtils.displayErrors(new AccountServiceErrorEntityFactory(accountValues.getError()), true);
				}
			}
		}
	}
	
	public static void clearCampaigns(long accountId) throws Exception {
		System.out.println(String.format("Removing Campaigns AccountId=%s", accountId));
		CampaignDao.clearCampaign(accountId);
	}
}
