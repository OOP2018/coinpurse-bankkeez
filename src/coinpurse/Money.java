package coinpurse;

public class Money implements Valuable {

	protected double value;
	protected String currency;

	public Money(double value, String currency) {
		if (value > 0) {
			this.value = value;
		}
		this.currency = currency;
	}

	/**
	 * Gets the value of the coin.
	 * 
	 * @return value
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Gets the currency of the coin.
	 * 
	 * @return currency
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Compare two objects that implement Valuable. First compare them by
	 * currency, so that "Baht" < "Dollar". If both objects have the same
	 * currency, order them by value.
	 *
	 */
	public int compareTo(Valuable a) {
		// when currency is equal
		if (a.getCurrency().equals(this.getCurrency())) {
			if (a.getValue() > this.getValue())
				return 1;
			else if (a.getValue() < this.getValue())
				return -1;
			// when a == b
			else
				return 0;
			// when currency is different
		}
		// low or high up to alphabetical orders
		return a.getCurrency().compareTo(this.getCurrency());

	}

	/**
	 * Check the object whether it is a Coin or not, if Coin then check the
	 * currency and value.
	 * 
	 * @param Object
	 * @return return true if an object equals.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Coin coin = (Coin) obj;
		return this.value == coin.value && this.currency.equals(coin.currency);
	}
}