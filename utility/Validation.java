package utility;

import controllayer.IllegalCoinException;
import modellayer.Coin;
import modellayer.Currency;

public class Validation {
	
	public static void validateCoin(Coin coin) throws IllegalCoinException {
		
		int coinValue = coin.getAmount();
		Currency.ValidCurrency currency = coin.getCurrency();

		if (currency == Currency.ValidCurrency.EURO) {
			boolean euroCoinOk = validateEuro(coin);
			if (!euroCoinOk) {
				throw new IllegalCoinException("Invalid Euro coin: " + coinValue);
			}
		} else if (currency == Currency.ValidCurrency.DKK) {
			boolean dkkCoinOk = validateDkk(coin);
			if (!dkkCoinOk) {
				throw new IllegalCoinException("Invalid Dkk coin: " + coinValue);
			}
		} else {
			throw new IllegalCoinException("Invalid coin: " + coinValue);
		}
	}
	
	private static boolean validateEuro(Coin coin) {
		boolean euroCoinOk = false;
		Currency.ValidCoinType coinType = coin.getCoinType();
		
		if (coinType == Currency.ValidCoinType.FRACTION) {
			euroCoinOk = testCentCoin(coin.getAmount());
		}
		if (coinType == Currency.ValidCoinType.INTEGER) {
			euroCoinOk = testEuroCoin(coin.getAmount());
		}
		
		return euroCoinOk;
	}
	
	private static boolean validateDkk(Coin coin) {
		boolean dkkCoinOk = false;
		Currency.ValidCoinType coinType = coin.getCoinType();
		
		if (coinType == Currency.ValidCoinType.FRACTION) {
			dkkCoinOk = testOreCoin(coin.getAmount());
		}
		if (coinType == Currency.ValidCoinType.INTEGER) {
			dkkCoinOk = testDkkCoin(coin.getAmount());
		}
		
		return dkkCoinOk;
	}
	
	private static boolean testCentCoin(int coinValue) {
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
	
	private static boolean testEuroCoin(int coinValue) {
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
	
	private static boolean testOreCoin(int coinValue) {
		boolean coinIsOk = true;
		switch (coinValue) {
			case 50:
				break;
			default:
				coinIsOk = false;
		}
		return coinIsOk;
	}
	
	private static boolean testDkkCoin(int coinValue) {
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

}
