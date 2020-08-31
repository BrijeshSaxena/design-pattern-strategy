package org.trishinfotech.strategy;

public class StrategyFactory {

	public InterestCalculationStrategy createStrategy(String strategyType) {
		InterestCalculationStrategy strategy = null;
		if (strategyType != null) {
			if ("COMPOUND".equalsIgnoreCase(strategyType)) {
				strategy = new CompundInterestCalculator();
			} else if ("SIMPLE".equalsIgnoreCase(strategyType)) {
				strategy = new SimpleInterestCalculator();
			} else {
				System.err.println("Unknown/unsupported strategy-type");
			}
		}
		return strategy;
	}
}
