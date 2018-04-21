package Utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import Valuables.BankNote;
import Valuables.Coin;
import Valuables.Money;
import Valuables.Valuable;
import Valuables.ValueComparator;

public class MoneyUtil {
	/** Create a ValueComparator object */
	private static Comparator<Valuable> comparable = new ValueComparator();

	/**
	 * Print every item in the List
	 * 
	 * @param List<Valuable>
	 */
	public static void printValue(List<Valuable> value) {
		for (Valuable values : value) {
			System.out.println(values);
		}
	}

	/**
	 * Sort any list of comparable object
	 * 
	 * @param List<Valuable>
	 */
	public static void sortMoney(List<? extends Valuable> money) {
		java.util.Collections.sort(money, comparable);
	}

	/*
	 * Filter the money by currency.
	 * 
	 * @param money
	 * 
	 * @param currency
	 * 
	 * @return List<Valuable>
	 */
	public static <E extends Valuable> List<E> filterByCurrency(List<E> money, String currency) {
		List<E> tempCurrency = new ArrayList<>();
		for (E value : money) {
			if (value.getCurrency().equals(currency))
				tempCurrency.add(value);
		}
		return tempCurrency;
	}

	/**
	 * A main method in this class for testing.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Money m1 = new BankNote(100, "Baht", 1000000);
		Money m2 = new BankNote(500, "Baht", 1000001);
		Money m3 = new Coin(20, "Baht");
		Money max = MoneyUtil.max(m1, m2, m3);
		String max1 = MoneyUtil.max("dog", "zebra", "cat");
		System.out.println(max1);
		System.out.println(max);
		List<BankNote> list = new ArrayList<>();
		list.add(new BankNote(10.0, "USD", 1000004));
		list.add(new BankNote(500.0, "Baht", 1000005));
		MoneyUtil.sortMoney(list);
		list.forEach((x) -> System.out.println(x));
		List<Coin> coins = Arrays.asList(new Coin(5, "Baht"), new Coin(0.1, "Ringgit"), new Coin(5, "Cent"));
		List<Coin> result = MoneyUtil.filterByCurrency(coins, "Baht");
		result.forEach((x) -> System.out.println(x));

	}

	/**
	 * Return the larger argument, based on sort order, using the objects' own
	 * compareTo method for comparing.
	 * 
	 * @param args
	 *            one or more Comparable objects to compare.
	 * @return the argument that would be last if sorted the elements.
	 * @throws IllegalArgumentException
	 *             if no arguments given.
	 */
	public static <E extends Comparable<? super E>> E max(E... args) throws IllegalArgumentException {
		E max = args[0];
		for (int i = 0; i < args.length; i++) {
			if (max.compareTo(args[i]) < 0) {
				max = args[i];
			}
		}
		return max;
	}
}
