package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.lang.reflect.Executable;

import org.junit.*;

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
	@Test(expected = IllegalCoinException.class)
	public void shouldRejectIllegalCurrencyNokCoin() throws IllegalCoinException {
		// Arrange
		int expectedParkingTime = 3;	// In minutes
		int coinValue = 5;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.NOK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
					
		// Assert
		assertEquals("NOK is invalid coins", coinValue, 0);
	}
	// unknown Euro coin value
	@Test(expected = IllegalCoinException.class)
	public void shouldRejectIllegalEuroCoin() throws IllegalCoinException {
		//Arrange
		int expectedParkingTime = 3;	// In minutes
		int coinValue = 5;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.SEK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		// Act
		ps.addPayment(coinValue, coinCurrency, coinType);
					
		// Assert
		assertEquals("Invalid coins", coinValue, 0);
	}
	//@Test
	//public void testIllegalCoinException() {	
		//Exception exception = assertThrows(IllegalCoinException.class, () ->
		//sc.test2();
		// Maybe also verify that stock is unchanged...
			
	//}
}
