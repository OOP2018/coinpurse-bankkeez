package Utilities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Valuables.Coin;
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
	public static void sortValue(List<Valuable> value) {
		java.util.Collections.sort(value, comparable);
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
	public static List<Valuable> filterByCurrency(List<Valuable> money, String currency) {
		List<Valuable> tempCurrency = new ArrayList<>();
		for (Valuable value : money) {
			if (value.getCurrency().equals(currency))
				tempCurrency.add(value);
		}
		return tempCurrency;
	}

	public static void main(String[] args) {
		List<Valuable> value = new ArrayList<Valuable>();
		value.add(new Coin(10.0, "Rupee"));
		value.add(new Coin(10.0, "Satang"));
		value.add(new Coin(5.0, "Rupee"));
		value.add(new Coin(1.0, "Rupee"));
		sortValue(value);
		printValue(value);
	}
}
