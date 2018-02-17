package Factory;

import Valuables.BankNote;
import Valuables.Coin;
import Valuables.Valuable;

public class MalayMoneyFactory extends MoneyFactory {
	// Next bank note serial number
	private static long nextSerialNumber = 1000000;

	/**3
	 * Create Malay money with the inserted value.
	 * 
	 * @param value
	 *            to create malay money
	 * @throws IlleaglArgumentExpression
	 * 
	 */
	@Override
	public Valuable createMoney(double value) throws IllegalArgumentException {
		// value for Malay coins
		double money[] = { 0.05, 0.10, 0.20, 0.50, 1, 2, 5, 10, 20, 50, 100 };
		if (value < 1) {
			for (int i = 0; i < 4; i++) {
				if (money[i] == value)
					return new Coin(money[i], "Sen");
			}
		} else if (value <= 1000) {
			for (int i = 4; i < money.length; i++)
				if (money[i] == value) {
					return new BankNote(money[i], "Ringgit", nextSerialNumber++);
				}
		}
		throw new IllegalArgumentException();
	}
}
