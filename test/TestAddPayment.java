package test;
import org.junit.*;
import static org.junit.Assert.*;
import controllayer.*;
import modellayer.Currency;

/**
* Tests conducted by UCN Denmark, Computer Science students of group number 5
* Test conducted in this class, checks if the most important method of this program, AddPayment is behaving as expected.
* To verify it behaves as expected, 1 euro is tested to display 40 minutes of parking time.
*/

public class TestAddPayment {
	ControlPayStation ps;
	
	@Before
	public void setUp() {
		ps = new ControlPayStation();
	}

	
	/**
	 * Entering 1 euro should display 40 minutes of parking time.
	 */
	@Test
	public void shouldAddPaymentwithEUR() throws IllegalCoinException{
		//Arrange
		int amount = 1;  //euro
		int expectedParkingTime = 40;  //minutes
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		//Act
		ps.addPayment(amount, coinCurrency, coinType);
		//Assert
		assertEquals("Should add payment of 1 eur succesfully: ", expectedParkingTime, ps.readDisplay());
	}
	
	
	@After
	public void cleanUp() {
		ps.setReady();
	}
	
	
	
	
}
