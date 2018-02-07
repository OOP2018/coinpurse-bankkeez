package coinpurse;

import java.util.Comparator;

/**
 * This class is for comparing different values.
 * 
 * @author Piyawat Setthitkun
 *
 */
public class ValueComparator implements Comparator<Valuable> {
	/**
	 * Compare two objects that implement Valuable. First compare them by
	 * currency, so that "Baht" < "Dollar". If both objects have the same
	 * currency, order them by value.
	 *
	 */
	public int compare(Valuable a, Valuable b) {
		// when currency is equal
		if (a.getCurrency().equals(b.getCurrency())) {
			if (a.getValue() > b.getValue())
				return 1;
			else if (a.getValue() < b.getValue())
				return -1;
			// when a == b
			else
				return 0;
			// when currency is different
		}
		// low or high up to alphabetical orders
		return a.getCurrency().compareTo(b.getCurrency());

	}
}
