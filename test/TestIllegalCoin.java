package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.*;
import java.lang.reflect.Executable;

import org.junit.*;
import org.junit.jupiter.api.Assertions;

import controllayer.*;
import modellayer.Currency;

/**
 * Inspired by the book: Flexible, Reliable Software Henrik B�rbak Christensen:
 * Flexible, Reliable Software. Taylor and Francis Group, LLC 2010
 */

public class TestIllegalCoin {

	ControlPayStation ps;

	/** Fixture for pay station testing. */
	@Before
	public void setUp() {
		ps = new ControlPayStation();
	}

	/**
	 * Verify that illegal coins are rejected.
	 */
	
	// Norwegian coin
	@Test
	public void shouldRejectIllegalCurrencyNokCoin() throws IllegalCoinException {
		// Arrange
		int coinValue = 5;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.NOK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		
		// Assert
		Exception exception = assertThrows(IllegalCoinException.class, () ->
			// Act
			ps.addPayment(coinValue, coinCurrency, coinType));
			
	}
	// SEK
	@Test
	public void shouldRejectIllegalCurrencySekCoin() throws IllegalCoinException {
		//Arrange
		int coinValue = 5;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.SEK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		
		//Assert
		Assertions.assertThrows(IllegalCoinException.class, new org.junit.jupiter.api.function.Executable()
        {
             @Override
             public void execute() throws Throwable
             {
            	// Act
 				ps.addPayment(coinValue, coinCurrency, coinType);
             }
        });	
	}
	// unknown Euro coin value
	@Test
	public void shouldRejectIllegalEuroCoin() throws IllegalCoinException {
		//Arrange	
		int coinValue = 30;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
			
		// Assert
		Exception exception = assertThrows(IllegalCoinException.class, () ->
			// Act	
			ps.addPayment(coinValue, coinCurrency, coinType));
			
	}
	// unknown Euro coin value (cents)
	@Test
	public void shouldRejectIllegalEuroCoin2() throws IllegalCoinException {
		//Arrange	
		int coinValue = 30;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
				
		// Assert
		Exception exception = assertThrows(IllegalCoinException.class, () ->
			// Act	
			ps.addPayment(coinValue, coinCurrency, coinType));
				
		}
	
	// unknown DKK coin value
	@Test
	public void shouldRejectIllegalDkkCoin() throws IllegalCoinException {
		//Arrange	
		int coinValue = 30;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
			
		// Assert
		Exception exception = assertThrows(IllegalCoinException.class, () ->
			// Act	
			ps.addPayment(coinValue, coinCurrency, coinType));
			
	}
	// unknown DKK coin value (ore)
		@Test
		public void shouldRejectIllegalDkkCoin2() throws IllegalCoinException {
			//Arrange	
			int coinValue = 30;
			Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
			Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
				
			// Assert
			Exception exception = assertThrows(IllegalCoinException.class, () ->
				// Act	
				ps.addPayment(coinValue, coinCurrency, coinType));
				
		}
	
	
	
	
}
