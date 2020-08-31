package org.trishinfotech.strategy;

public enum AccountType {

	SAVING(2.0d), CURRENT(1.0d);

	private double rate;

	AccountType(final double rate) {
		this.rate = rate;
	}

	public double getRate() {
		return rate;
	}

}
