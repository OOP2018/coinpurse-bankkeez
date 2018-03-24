package coinpurse.stragety;

import java.util.ArrayList;
import java.util.List;

import Valuables.Valuable;

/**
 * This greedy class is for testing the JUnit, can't pass the advance withdraw
 * test.
 * 
 * @author Piyawat Setthitikun
 *
 */
public class GreedyWithdraw implements WithdrawStrategy {

	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		List<Valuable> tmpWithdraw = new ArrayList<>();
		List<Valuable> tmpCurrency = new ArrayList<>();
		double value2 = 0;
		try {
			value2 = amount.getValue();
		} catch (NullPointerException npe) {
			return null;
		}
		if (value2 < 0) {
			return null;
		}
		for (Valuable valuable : money) {
			if (valuable.getCurrency().equals(amount.getCurrency()))
				;
			tmpCurrency.add(valuable);
		}
		for (Valuable value : tmpCurrency) {
			if (value2 >= value.getValue()) {
				tmpWithdraw.add(value);
				value2 -= value.getValue();
			}
		}
		return tmpWithdraw;
	}

}
