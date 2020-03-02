package modellayer;

import controllayer.IllegalCoinException;

public class PPayment {

	private double amount = 0;
	
	public PPayment() {
		
	}
	
	public PPayment(double amount) {
		this.amount = amount;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void addAmount(double amount, Currency.ValidCurrency currency,
			Currency.ValidCoinType coinType) {
		
		double valueInCent = 0;

		if (currency == Currency.ValidCurrency.DKK) {
			PPrice nowPrice = new PPrice();
			valueInCent = getDkkCoinValueInCent(amount, coinType, nowPrice);
		} else {
			valueInCent = getEuroCoinValueInCent(amount, coinType);
		}
		
		this.amount += valueInCent;
	}
	
	public int getTimeBoughtInMinutes() {
		PPrice aPrice = new PPrice();
		int timeBoughtInMinutes = 0;

		double timeBoughtInSeconds = this.amount * aPrice.getParkingPrice();
		timeBoughtInMinutes = (int) ((timeBoughtInSeconds + 59) / 60);

		return timeBoughtInMinutes;
	}
	
	public void validateCoin(int coinValue, Currency.ValidCurrency currency, Currency.ValidCoinType coinType) throws IllegalCoinException {

		if (currency == Currency.ValidCurrency.EURO) {
			boolean euroCoinOk = validateEuro(coinValue, coinType);
			if (!euroCoinOk) {
				throw new IllegalCoinException("Invalid Euro coin: " + coinValue);
			}
		} else if (currency == Currency.ValidCurrency.DKK) {
			boolean dkkCoinOk = validateDkk(coinValue, coinType);
			if (!dkkCoinOk) {
				throw new IllegalCoinException("Invalid Dkk coin: " + coinValue);
			}
		} else {
			throw new IllegalCoinException("Invalid coin: " + coinValue);
		}
	}

	private boolean validateEuro(int coinValue, Currency.ValidCoinType coinType) {
		boolean euroCoinOk = false;
		
		if (coinType == Currency.ValidCoinType.FRACTION) {
			euroCoinOk = testCentCoin(coinValue);
		}
		if (coinType == Currency.ValidCoinType.INTEGER) {
			euroCoinOk = testEuroCoin(coinValue);
		}
		
		return euroCoinOk;
	}
	
	private boolean validateDkk(int coinValue, Currency.ValidCoinType coinType) {
		boolean dkkCoinOk = false;
		
		if (coinType == Currency.ValidCoinType.FRACTION) {
			dkkCoinOk = testOreCoin(coinValue);
		}
		if (coinType == Currency.ValidCoinType.INTEGER) {
			dkkCoinOk = testDkkCoin(coinValue);
		}
		
		return dkkCoinOk;
	}
	
	private boolean testCentCoin(int coinValue) {
		boolean coinIsOk = true;
		switch (coinValue) {
			case 1:
			case 2:
			case 5:
			case 10:
			case 20:
			case 50:
				break;
			default:
				coinIsOk = false;
		}
		return coinIsOk;
	}
	
	private boolean testEuroCoin(int coinValue) {
		boolean coinIsOk = true;
		switch (coinValue) {
			case 1:
			case 2:
				break;
			default:
				coinIsOk = false;
		}
		return coinIsOk;
	}	
	
	private boolean testOreCoin(int coinValue) {
		boolean coinIsOk = true;
		switch (coinValue) {
			case 50:
				break;
			default:
				coinIsOk = false;
		}
		return coinIsOk;
	}
	
	private boolean testDkkCoin(int coinValue) {
		boolean coinIsOk = true;
		switch (coinValue) {
			case 1:
			case 2:
			case 5:
			case 10:
			case 20:
				break;
			default:
				coinIsOk = false;
		}
		return coinIsOk;
	}	
	
	private double getEuroCoinValueInCent(double coinValue, Currency.ValidCoinType coinType) {
		double valueInCent = 0;

		if (coinType == Currency.ValidCoinType.INTEGER) {
			valueInCent = coinValue * 100;
		} else {
			valueInCent = coinValue;
		}

		return valueInCent;
	}

	private double getDkkCoinValueInCent(double coinValue, Currency.ValidCoinType coinType, PPrice price) {
		double valueInCent = 0;

		if (coinType == Currency.ValidCoinType.INTEGER) {
			valueInCent = (coinValue * 100) / price.getExchangeEuroDkk();
		} else {
			valueInCent = coinValue / price.getExchangeEuroDkk();
		}

		return valueInCent;
	}	

	
}
