package test;

import org.junit.*;
import static org.junit.Assert.*;

import controllayer.*;
import modellayer.*;

/**
 * Inspired by the book: Flexible, Reliable Software Henrik B�rbak Christensen:
 * Flexible, Reliable Software. Taylor and Francis Group, LLC 2010
 */

public class TestCalculationCurrencyMixed {

	ControlPayStation ps;

	/** Fixture for pay station testing. */
	@Before
	public void setUp() {
		ps = new ControlPayStation();
	}

	/**
	 * Entering 1 cent and 50 �re should make the display report 4 minutes parking time.
	 */
	@Test
	public void shouldDisplay4MinFor1CentAnd1Ore() throws IllegalCoinException {
		// Arrange
		int amountOfCents = 1;
		int amountOfOres = 50;
		int expectedTime = 4;   //minutes
		Currency.ValidCurrency currencyOfCents = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType typeOfCents = Currency.ValidCoinType.FRACTION;
		
		Currency.ValidCurrency currencyOfOres = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType typeOfOres = Currency.ValidCoinType.FRACTION;
		
		// Act
		ps.addPayment(amountOfCents, currencyOfCents, typeOfCents);
		ps.addPayment(amountOfOres, currencyOfOres, typeOfOres);
		// Assert
		//assertEquals("Dummy", 0, 1);
		assertEquals("Entering 1 cent and 50 �re, 4 minutes parking time: ", expectedTime, ps.readDisplay());
	}

	
	/** Fixture for pay station testing. */
	@After
	public void cleanUp() {
		ps.setReady();
	}
	
}
