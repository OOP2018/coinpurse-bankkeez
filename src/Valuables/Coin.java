package Valuables;

/*
 * Coin represents coinage (money) with fixed value and currency.
 * @author Piyawat Setthitikun
 */
public class Coin extends Money{
	/**
	 * Creates a coin with value more than 0 and initialize the currency of the
	 * coin.
	 * 
	 * @param value
	 *            of the coin.
	 * @param currency
	 *            of the coin.
	 */
	public Coin(double value, String currency) {
		super(value, currency);
	}

	@Override
	public String toString() {
		return value + "-" + currency;
	}

}
