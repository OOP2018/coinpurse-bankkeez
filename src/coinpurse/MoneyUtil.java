package coinpurse;

import java.util.ArrayList;
import java.util.List;

public class MoneyUtil {
	public static void main(String[] args) {
		List<Coin> coins = new ArrayList<Coin>();
		coins.add(new Coin(10.0, "Rupee"));
		coins.add(new Coin(10.0, "Satang"));
		coins.add(new Coin(5.0, "Rupee"));
		coins.add(new Coin(1.0, "Rupee"));
		sortCoins(coins);
		printCoins(coins);
	}

	/**
	 * Print every item in the List
	 * 
	 * @param List<Coin>
	 */
	public static void printCoins(List<Coin> coins) {
		for (Coin coin : coins) {
			System.out.println(coins);
		}
	}

	/**
	 * Sort any list of comparable object
	 * 
	 * @param List<Coin>
	 */
	public static void sortCoins(List<Coin> coins) {
		java.util.Collections.sort(coins);
	}
}
