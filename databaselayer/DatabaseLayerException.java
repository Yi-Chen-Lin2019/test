package databaselayer;

@SuppressWarnings("serial")
public class DatabaseLayerException extends Exception {
	
	public DatabaseLayerException () {

    }

    public DatabaseLayerException(String message) {
        super (message);
    }

    public DatabaseLayerException(Throwable cause) {
        super (cause);
    }

    public DatabaseLayerException(String message, Throwable cause) {
        super (message, cause);
    }

}
