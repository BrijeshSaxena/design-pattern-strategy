package org.trishinfotech.strategy;

public class Account {

	private long accountNo;
	private String accountHolderName;
	private AccountType accountType;
	private InterestCalculationStrategy interestStrategy;
	private double amount;

	public Account() {
		super();
	}

	public Account(long accountNo, String accountHolderName, AccountType accountType) {
		this();
		this.accountNo = accountNo;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
	}

	public Account(long accountNo, String accountHolderName, AccountType accountType,
			InterestCalculationStrategy interestStrategy) {
		this(accountNo, accountHolderName, accountType);
		this.interestStrategy = interestStrategy;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public InterestCalculationStrategy getInterestStrategy() {
		return interestStrategy;
	}

	public void setInterestStrategy(InterestCalculationStrategy interestStrategy) {
		this.interestStrategy = interestStrategy;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void deposit(double amount) {
		// check for only positive/valid amount
		if (amount > 0.0d) {
			this.amount += amount;
		}
	}

	public void withdraw(double amount) {
		// check for only positive/valid amount and also for below than the available
		// amount in account
		if (amount > 0.0d && amount < this.amount) {
			this.amount -= amount;
		}
	}

	public double getInterest(int term) {
		if (getInterestStrategy() != null && getAccountType() != null) {
			return getInterestStrategy().calculateInterest(getAmount(), getAccountType().getRate(), term);
		}
		return 0.0d;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [accountNo=").append(getAccountNo()).append(", accountHolderName=")
				.append(getAccountHolderName()).append(", accountType=").append(getAccountType()).append(", rate=")
				.append((getAccountType() != null) ? getAccountType().getRate() : 0.0d).append(", interestStrategy=")
				.append(getInterestStrategy()).append(", amount=").append(getAmount()).append("]");
		return builder.toString();
	}

}
