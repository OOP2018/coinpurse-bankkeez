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
		} else {
			// either a or b is more still get the correct currency value
			if (a.getCurrency().charAt(0) < b.getCurrency().charAt(0))
				return 1;
			else
				return -1;
		}
	}
}
