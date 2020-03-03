package controllayer;

import java.time.LocalDate;

import modellayer.*;
import databaselayer.DatabaseLayerException;
import databaselayer.IDbPBuy;
import databaselayer.DatabasePBuy;

/**
 * Inspired by the book: Flexible, Reliable Software Henrik B�rbak Christensen:
 * Flexible, Reliable Software. Taylor and Francis Group, LLC 2010
 */

public class ControlPayStation {

	private PPayStation payStation;
	private ControlPrice controlPrice;
	
	public ControlPayStation() {
		this.payStation = new PPayStation(1, "P-423E");
		this.controlPrice = new ControlPrice();
	}

	// Receive one coin as input
	public void addPayment(int amount, Currency.ValidCurrency currency, Currency.ValidCoinType coinType) throws IllegalCoinException {
	
		Coin coin = new Coin(amount, currency, coinType);
		
		// Test if coin is valid
		try {	
			payStation.validateCoin(coin);
		}
		catch (IllegalCoinException coinError) {
			throw new IllegalCoinException(
					"Invalid coin: " + currency.toString() + ", " + coinType.toString() + ", " + amount);
		}
		
		PPrice currentPrice = controlPrice.getCurrentPrice();
		// Add amount
		payStation.addAmount(coin, currentPrice);	
	}

	// Process the buy
	public PReceipt buy() throws DatabaseLayerException {
		LocalDate currentTime = java.time.LocalDate.now();
		
		// create buy
		PBuy thisBuy = new PBuy();
		thisBuy.setAssociatedPaystation(payStation);
		thisBuy.setBuyTime(currentTime);
		
		// Save in Parkingsystem db
		IDbPBuy dbBuy = new DatabasePBuy();
		dbBuy.insertParkingBuy(thisBuy);
		//
		ControlReceipt ctrlReceipt = new ControlReceipt(payStation.getTimeBoughtInMinutes());
		
		reset();	
		PReceipt buyReceipt = ctrlReceipt.getParkingReceipt();		
		return buyReceipt;
	}

	/**
	 * Calculate the corresponding parking time in minutes
	 * (calculated seconds and convert to minutes - rounded up)
	*/
	public int readDisplay() {
		return payStation.getTimeBoughtInMinutes();
	}	
	
	public void setReady() {
		reset();
	}

	public void cancel() {
		reset();
	}

	private void reset() {
		payStation.setAmount(0);
	}
	

	

	

	

}
