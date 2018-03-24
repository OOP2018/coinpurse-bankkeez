package coinpurse.stragety;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Factory.MoneyFactory;
import Valuables.Money;
import Valuables.Valuable;

/**
 * This class uses JUnit to test the withdraw method from each strategy that is
 * set.
 * 
 * @author Piyawat Setthtikun
 *
 */
public class WithdrawTest {

	private WithdrawStrategy stragety;
	private MoneyFactory factory;
	private List<Valuable> wallet;

	@Before
	public void setUp() {
		stragety = new GreedyWithdraw();
		wallet = new ArrayList<>();
		factory = MoneyFactory.getInstance();
	}

	@Before
	public void init() {
		wallet.clear();
	}

	@Test
	public void testWithdrawEverything() {
		wallet.add(factory.createMoney(10));
		wallet.add(factory.createMoney(20));
		wallet.add(factory.createMoney(5));
		stragety.withdraw(new Money(35, "Baht"), wallet);
		assertTrue(wallet.size() == 0);
	}

	@Test
	public void testWithdrawSome() {
		wallet.add(factory.createMoney(10));
		wallet.add(factory.createMoney(20));
		wallet.add(factory.createMoney(5));
		wallet.add(factory.createMoney(1));
		stragety.withdraw(new Money(30, "Baht"), wallet);
		assertTrue(wallet.size() == 2);
	}

	@Test
	public void testWithdrawExceptOne() {
		wallet.add(factory.createMoney(10));
		wallet.add(factory.createMoney(20));
		wallet.add(factory.createMoney(5));
		wallet.add(factory.createMoney(1));
		stragety.withdraw(new Money(35, "Baht"), wallet);
		assertTrue(wallet.size() == 1);
	}

	@Test
	public void testOverDraw() {
		wallet.add(factory.createMoney(10));
		wallet.add(factory.createMoney(20));
		stragety.withdraw(new Money(35, "Baht"), wallet);
		assertTrue(wallet.size() == 2);
	}

	@Test
	public void testFailWithdraw() {
		List<Valuable> temp = stragety.withdraw(new Money(1, "Baht"), wallet);
		assertNull(temp);
	}

	@Test
	public void testAdvanceWithdraw() {
		wallet.add(factory.createMoney(5));
		wallet.add(factory.createMoney(2));
		wallet.add(factory.createMoney(2));
		wallet.add(factory.createMoney(2));
		stragety.withdraw(new Money(6, "Baht"), wallet);
		assertTrue(wallet.size() == 1);
	}

}
