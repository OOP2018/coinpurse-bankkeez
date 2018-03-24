package Factory;

import Valuables.Valuable;

/**
 * This is an abstract class for subclasses that extend to create money with
 * their own value and currency.
 * 
 * @author Piyawat Setthitikun
 *
 */
public abstract class MoneyFactory {
	/** Singleton instance of MoneyFactory */
	private static MoneyFactory instance;

	/**
	 * Get the MoneyFacrtory instance.
	 * 
	 * @return MoneyFactory
	 */
	public static MoneyFactory getInstance() {
		if (instance == null) {
			instance = new ThaiMoneyFactory();
		}
		return instance;
	}

	/**
	 * Create the money with value inserted.
	 * 
	 * @param value
	 *            for money to be created
	 * @return Valuable which money created
	 * @throws IllegalArgumentException
	 *             when the argument isn't double
	 */
	public abstract Valuable createMoney(double value);

	public Valuable createMoney(String value) throws IllegalArgumentException {
		double money = 0;
		try {
			money = Double.parseDouble(value);
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException("Cannot create money", ex);
//			System.out.println("Cannot parse from String to double!");
		}
		// return Valuable which created by the method
		return createMoney(money);
	}

	public static void setFactory(MoneyFactory factory) {
		instance = factory;
	}
}
