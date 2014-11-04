package ydnsample.builder;

import jp.yahooapis.im.V4.AccountService.*;

public class AccountBuilder {
	
	private Account account = new Account();
	
	public AccountBuilder withId(long accountId) {
		account.setAccountId(accountId);
		return this;
	}
	
	public AccountBuilder withName(String accountName) {
		account.setAccountName(accountName);
		return this;
	}
	
	public AccountBuilder withAccountStatus(AccountStatus status) {
		account.setAccountStatus(status);
		return this;
	}
	
	public AccountBuilder withType(AccountType type) {
		account.setAccountType(type);
		return this;
	}
	
	public AccountBuilder withBudget(long ammount) {
		return withBudget(ammount, null, null, LimitChargeType.MONTHLY);
	}
	
	public AccountBuilder withBudget(long ammount, String startDate, String endDate, LimitChargeType limitType) {
		AccountBudget budget = new AccountBudget();
		budget.setAmount(ammount);
		budget.setStartDate(startDate);
		budget.setEndDate(endDate);
		budget.setLimitChargeType(limitType);
		account.setBudget(budget);
		return this;
	}
	
	public AccountBuilder withDeliveryStatus(DeliveryStatus status) {
		account.setDeliveryStatus(status);
		return this;
	}
	
	public Account make() {
		return account;
	}
}
