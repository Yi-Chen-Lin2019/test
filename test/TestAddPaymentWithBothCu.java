package test;
import org.junit.*;
import static org.junit.Assert.*;
import controllayer.*;
import modellayer.Currency;

/**
 * Tests conducted by UCN Denmark, Computer Science students of group number 5
 * Test conducted in this class, checks if system handles expected parking time correctly when entering both currencies of euro and danish kronas.
 */

public class TestAddPaymentWithBothCu {
	ControlPayStation ps;
	
	@Before
	public void setUp() {
		ps = new ControlPayStation();
	}

	
	/**
	 * Entering 1 euro should display 40 minutes of parking time, while also entering 10 kronas, should display 54 minutes of parking time.
	 * Together both currencies should display total of 94 minutes of parking time.
	 */
	@Test
	public void shouldAddPaymentwithBOTH() throws IllegalCoinException{
		//Arrange
		int amount = 1;  //euro
		int expectedParkingTime = 40;  //minutes
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		ps.addPayment(amount, coinCurrency, coinType);
		
		int amount1 = 10; //kronas
		int expectedParkingTime1 = 54; //minutes
		Currency.ValidCurrency coinCurrency1 = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType1 = Currency.ValidCoinType.INTEGER;
		//Act
		ps.addPayment(amount1, coinCurrency1, coinType1);
		
		int total = expectedParkingTime+expectedParkingTime1;
		//Assert
		assertEquals("Should be 94: ", total, ps.readDisplay());
	}
	
	
	@After
	public void cleanUp() {
		ps.setReady();
	}

}
