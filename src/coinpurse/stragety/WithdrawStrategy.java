package coinpurse.stragety;

import java.util.List;

import Valuables.Valuable;

/**
 * WithdrawStragety class contains withdraw method that help class that
 * implements to decide on each withdraw without removing any Valuable on the
 * actual one.
 * 
 * @author Piyawat Setthitikun
 *
 */
public interface WithdrawStrategy {
	/**
	 * Find and return items from the collection whose total value equals the
	 * requested amount.
	 * 
	 * @param amount
	 *            is the amount of money to withdraw, with currency
	 * @param money
	 *            the contents that are available for the possible withdraw.
	 * @return if a solution is found, return the aList containing references
	 *         from the money parameter (List) whose sum equals the amount.
	 */
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money);
}