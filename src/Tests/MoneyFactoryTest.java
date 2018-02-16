package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Factory.MoneyFactory;
import Factory.ThaiMoneyFactory;

public class MoneyFactoryTest {
	@Test
	public void testSetAndGetInstance() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		assertEquals(MoneyFactory.getInstance().getClass().getSimpleName(), "ThaiMoneyFactory");
	}

	@Test
	public void testBankNoteSeialNumber() {
		
	}
}
