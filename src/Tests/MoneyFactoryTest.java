package Tests;

import static org.junit.Assert.*;

import org.junit.Test;
import Factory.MalayMoneyFactory;
import Factory.MoneyFactory;
import Factory.ThaiMoneyFactory;

public class MoneyFactoryTest {
	@Test
	public void testSetAndGetInstanceThai() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		assertEquals(MoneyFactory.getInstance().getClass().getSimpleName(), "ThaiMoneyFactory");
	}

	@Test
	public void testSetAndGetInstanceMalay() {
		MoneyFactory.setFactory(new MalayMoneyFactory());
		assertEquals(MoneyFactory.getInstance().getClass().getSimpleName(), "MalayMoneyFactory");
	}

	@Test
	public void testBankNoteSeialNumber() {

	}
}
