package test;
import org.junit.*;
import static org.junit.Assert.*;
import controllayer.*;
import modellayer.Currency;

public class TestAddPaymentWithBothCu {
	ControlPayStation ps;
	
	@Before
	public void setUp() {
		ps = new ControlPayStation();
	}

	@Test
	public void shouldAddPaymentwithBOTH() throws IllegalCoinException{
		
		int amount = 1;
		int expectedParkingTime = 40;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
		ps.addPayment(amount, coinCurrency, coinType);
		
		int amount1 = 10;
		int expectedParkingTime1 = 54;
		Currency.ValidCurrency coinCurrency1 = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType1 = Currency.ValidCoinType.INTEGER;
		ps.addPayment(amount1, coinCurrency1, coinType1);
		
		int total = expectedParkingTime+expectedParkingTime1;
		
		assertEquals("Should be 94: ", total, ps.readDisplay());
	}
	
	
	@After
	public void cleanUp() {
		ps.setReady();
	}

}
