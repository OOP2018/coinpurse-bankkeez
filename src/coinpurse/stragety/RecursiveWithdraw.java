package coinpurse.stragety;

import java.util.ArrayList;
import java.util.List;

import Valuables.Valuable;

/**
 * This class contain a strategy for with draw method. It works recursively to
 * withdraw the amount of money.
 * 
 * @author Piyawat Setthitikun
 *
 */
public class RecursiveWithdraw implements WithdrawStrategy {

	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		return helper(amount.getValue(), money);
	}

	public List<Valuable> helper(double target, List<Valuable> money) {
		if (target == 0)
			return new ArrayList<>();
		if (money.size() == 0)
			if (target != 0)
				return null;
		if (target < 0)
			return null;
		List<Valuable> temp = helper(target - money.get(0).getValue(), money.subList(1, money.size()));
		if (temp == null) {
			return helper(target, money.subList(1, money.size()));
		} else {
			temp.add(money.get(0));
			return temp;
		}
	}

}
