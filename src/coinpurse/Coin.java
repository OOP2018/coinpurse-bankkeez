package coinpurse;

/*
 * Coin represents coinage (money) with fixed value and currency.
 * @author Piyawat Setthitikun
 */
public class Coin implements Comparable<Coin> {
	private double value;
	private String currency;

	/**
	 * Creates a coin with value more than 0 and initialize the currency of the
	 * coin.
	 * 
	 * @param Value
	 *            of the coin.
	 * @param Type
	 *            of the coin.
	 */
	public Coin(double value, String currency) {
		if (value >= 0)
			this.value = value;
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
	 * @return
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Check the object whether it is a Coin or not, if Coin then check the
	 * currency and value.
	 * 
	 * @param an
	 *            object
	 * @return return true if an object equals.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Coin coin = (Coin) obj;
		return this.value == coin.value && this.currency == coin.currency;
	}

	/**
	 * @param Coin
	 *            to compare with an another one.
	 * @return
	 */
	@Override
	public int compareTo(Coin coin) {
		if (this.getValue() > coin.getValue())
			return 1;
		else if (this.getValue() < coin.getValue())
			return -1;
		else
			return 0;
	}

	@Override
	public String toString() {
		return value + "-" + currency;
	}

}
