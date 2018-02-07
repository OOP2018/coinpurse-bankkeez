package coinpurse;

/**
 * Bank note class containing fixed value, serial number, and currency. Also
 * contain methods for bank notes.
 * 
 * @author Piyawat Setthitikun
 *
 */
public class BankNote implements Valuable {
	// Next bank note serial number
	private static long nextSerialNumber = 1000000;
	// Bank note value
	private double value;
	// bank note currency
	private String currency;
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
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber;
		nextSerialNumber++;
	}

	/**
	 * Get the value of the bank note.
	 * 
	 * @return value
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Get the currency of the bank note.
	 * 
	 * @return currency
	 */
	public String getCurrency() {
		return this.currency;
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
	 * Check if the object is BankNote value and currency are the same or not.
	 * 
	 * @param object
	 * @return true if object is BankNote with same currency and value
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		BankNote banknote = (BankNote) obj;
		return this.value == banknote.value && this.currency.equals(banknote.currency);
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
