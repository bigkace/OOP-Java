/*
 * Purpose: Manage Day bill - subclass
 * Author: Vu The Quan
 * Date: 06/07/2020
 * Version: 1.0
 */

import java.util.Scanner;

public class DayBill extends Bill {
	// 1. Fields
	private int amountDays;

	// 2. Getters, setters
	/**
	 * @return the amountDays
	 */
	public int getAmountDays() {
		return amountDays;
	}

	/**
	 * @param amountDays the amountDays to set
	 */
	public void setAmountDays(int amountDays) {
		this.amountDays = amountDays;
	}

	// 3. Constructors
	public DayBill() {
		super();
		this.amountDays = 0;
	}

	/**
	 * @param id
	 * @param day
	 * @param month
	 * @param year
	 * @param name
	 * @param roomID
	 * @param unitPrice
	 * @param payment
	 */
	public DayBill(String id, int day, int month, int year, String name, String roomID, float unitPrice, int amountDays) {
		super(id, day, month, year, name, roomID, unitPrice);
		this.amountDays = amountDays;
	}

	// 4. Input, output methods
	@Override
	public void input(Scanner scan) {
		super.input(scan);
		System.out.print("Please input amount of days: ");
		this.amountDays = Integer.parseInt(scan.nextLine());
	}
	
	@Override
	public void output() {
		System.out.print("Day bill\t");
		super.output();
		System.out.println("\t\tDays: "+ this.amountDays + "\t\tPayment: "+ this.payment);
	}

	// 5. Business methods
	@Override
	public void calculatePayment() {
		this.payment = this.amountDays*this.unitPrice;
	}

}
