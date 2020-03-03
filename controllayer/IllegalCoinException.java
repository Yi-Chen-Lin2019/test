package controllayer;

/**
 * Inspired by the book: Flexible, Reliable Software
 * Henrik Bærbak Christensen: Flexible, Reliable Software. Taylor and Francis Group, LLC 2010
 */

@SuppressWarnings("serial")
public class IllegalCoinException extends Exception {
  public IllegalCoinException( String e ) { super(e); }
}
