package coinpurse;

import java.util.ResourceBundle;

import Factory.MoneyFactory;

public class ReadFile {
	public static MoneyFactory read() {
		// create a ResourceBundle from file "purse.properties" on the classpath
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		// get the value of "moneyfactory" property
		String factoryclass = bundle.getString("moneyfactory");
		MoneyFactory factory = null;
		try {
			factory = (MoneyFactory) Class.forName(factoryclass).newInstance();
		} catch (ClassCastException cce) {
			// the object could not be cast to type MoneyFactory
			System.out.println(factory + " is not type MoneyFactory");
		} catch (Exception ex) {
			// any other exception means we could not create an object
			System.out.println("Error creating MoneyFactory " + ex.getMessage());
		}
		// if no factory then quit
		if (factory == null)
			System.exit(1);
		return factory;
	}
}
