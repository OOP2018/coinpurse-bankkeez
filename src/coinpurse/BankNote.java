package coinpurse;

/**
 * Bank note class containing fixed value, serial number, and currency. Also
 * contain methods for bank notes.
 * 
 * @author Piyawat Setthitikun
 *
 */
public class BankNote extends Money {
	// Next bank note serial number
	private static long nextSerialNumber = 1000000;
	// Bank note serial number
	private long serialNumber;

	/**
	 * Creating a bank note with value, currency, and serial number.
	 * 
	 * @param value
	 *            of bank note
	 * @param currency
	 *            of bank note
	 */
	public BankNote(double value, String currency) {
		super(value, currency);
		this.serialNumber = nextSerialNumber;
		nextSerialNumber++;
	}

	/**
	 * Get the serial number of the bank note.
	 * 
	 * @return serial number
	 */
	public long getSerial() {
		return this.serialNumber;
	}

	/**
	 * Represent the bank note is a sentence.
	 * 
	 * @return phrase representing bank note
	 */
	@Override
	public String toString() {
		return String.format("%.0f-%s note [%d]", value, currency, serialNumber);
	}
}
