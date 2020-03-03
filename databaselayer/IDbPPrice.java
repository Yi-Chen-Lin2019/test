package databaselayer;

import modellayer.PPrice;

public interface IDbPPrice {

	public PPrice getCurrentPrice();
    // Get Price by parking zone id
	public PPrice getPriceByZoneId(int zoneId) throws DatabaseLayerException;
    
}
