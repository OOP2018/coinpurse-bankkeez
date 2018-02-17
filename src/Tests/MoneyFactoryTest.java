package Tests;

import static org.junit.Assert.*;

import org.junit.Test;
import Factory.MalayMoneyFactory;
import Factory.MoneyFactory;
import Factory.ThaiMoneyFactory;

public class MoneyFactoryTest {
	@Test
	public void testSetGetInstanceThai() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		assertEquals(MoneyFactory.getInstance().getClass().getSimpleName(), "ThaiMoneyFactory");
	}

	@Test
	public void testSetGetInstanceMalay() {
		MoneyFactory.setFactory(new MalayMoneyFactory());
		assertEquals(MoneyFactory.getInstance().getClass().getSimpleName(), "MalayMoneyFactory");
	}

	@Test
	public void testBankNoteSeialNumber() {
		
	}
}
