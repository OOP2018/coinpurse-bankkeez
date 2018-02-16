package Utilities;

import java.util.ArrayList;
import java.util.List;

import Valuables.Money;
import Valuables.Valuable;
import Valuables.ValueComparator;

import java.util.Collections;
import java.util.Comparator;

/**
 * A purse contains valuables. You can insert any valuables, withdraw them, check the
 * balance, and check if the purse is full.
 * 
 * @author Piyawat Setthitikun
 */
public class Purse {
	/** Collection of objects in the purse. */
	List<Valuable> money;

	/**
	 * Capacity is maximum number of items the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;

	// ValueComparator object
	private Comparator<Valuable> comparable = new ValueComparator();

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		money = new ArrayList<>(capacity);
	}

	/**
	 * Count and return the number of valuables in the purse. This is the number of
	 * valuable inserted, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double sum = 0;
		for (Valuable value : money)
			sum += value.getValue();
		return sum;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		return money.size() >= capacity;
	}

	/**
	 * Insert money into the purse. The money is only inserted if the purse has
	 * space for it and the money has positive value. No worthless money!
	 * 
	 * @param coin
	 *            is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Valuable value) {
		if (value.getValue() > 0 && !isFull()) {
			money.add(value);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Valuables
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of VAluable objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {

		Money money = new Money(amount,"Baht");
		return withdraw(money);
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Valuables
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Valuable objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	private Valuable[] withdraw(Valuable amount) {
		List<Valuable> tmpWithdraw = new ArrayList<>();
		List<Valuable> tmpCurrency = new ArrayList<>();
		Collections.sort(money, comparable);
		Collections.reverse(money);
		double value2 = amount.getValue();
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
		if (value2 == 0) {
			for (Valuable value : tmpWithdraw) {
				money.remove(value);
			}
		} else {
			return null;
		}
		Valuable[] tmp = new Valuable[tmpWithdraw.size()];
		tmpWithdraw.toArray(tmp);

		return tmp;
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 */
	public String toString() {
		return String.format("The total money are %d with the value of %f", this.count(), this.getBalance());
	}

}
