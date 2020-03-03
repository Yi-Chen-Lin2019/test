package databaselayer;

import modellayer.PBuy;

public interface IDbPBuy {

    // insert new PBuy
 	public int insertParkingBuy(PBuy parkingBuy) throws DatabaseLayerException;
 		
 	// Delete PBuy
 	public int deleteParkingBuy(PBuy parkingBuy) throws DatabaseLayerException;
    
}
