package Tests;

import java.util.Scanner;

import Factory.MoneyFactory;
import Factory.ThaiMoneyFactory;
import Valuables.Valuable;

public class MoneyFactoryDemo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		while (true) {
			MoneyFactory.setFactory(new ThaiMoneyFactory());
			MoneyFactory factory = MoneyFactory.getInstance();
			System.out.println("Insert: ");
//			String value = scanner.next();
//			if (value.equals("-1"))
//				break;
			Valuable money = factory.createMoney("50x");
			System.out.println(money);
//		}
//		scanner.close();
	}
}
