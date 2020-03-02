package test;
import org.junit.*;
import static org.junit.Assert.*;
import controllayer.*;
import modellayer.Currency;

public class TestAddPayment {
	ControlPayStation ps;
	
	@Before
	public void setUp() {
		ps = new ControlPayStation();
	}

	@Test
	public void shouldAddPaymentwithEUR() throws IllegalCoinException{
		
		int amount = 1;
		int expectedParkingTime = 40;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		ps.addPayment(amount, coinCurrency, coinType);
		
		assertEquals("Should add payment of 1 eur succesfully: ", expectedParkingTime, ps.readDisplay());
	}
	
	
	@After
	public void cleanUp() {
		ps.setReady();
	}
	
	
	
	
}
