package Factory;

import Valuables.BankNote;
import Valuables.Coin;
import Valuables.Valuable;

/**
 * This class creates thai money value and currency.
 * 
 * @author Piyawat Setthitkun
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {
	// Next bank note serial number
	private static long nextSerialNumber = 1000000;

	/**
	 * Create thai money with the inserted value.
	 * 
	 * @param value
	 *            to create thai money
	 * @throws IllegalArgumentException
	 */
	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException {
		// value for thai coins
		double money[] = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
		if (value < 20) {
			for (int i = 0; i < 4; i++) {
				if (money[i] == value)
					return new Coin(value, "Baht");
			}
		} else if (value <= 1000) {
			for (int i = 4; i < money.length; i++)
				if (money[i] == value) {
					nextSerialNumber++;
					return new BankNote(value, "Baht", nextSerialNumber++);
				}
		}
		throw new IllegalArgumentException();
	}
}
