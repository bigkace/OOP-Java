/*
 * Purpose: Manage foreign customer - subclass
 * Author: Vu The Quan
 * Date: 05/07/2020
 * Version: 1.0
 */

import java.util.Scanner;

public class ForeignCustomer extends Customer {
	// 1. Fields
	private String nation;

	// 2. Getters, setters
	/**
	 * @return the nation
	 */
	public String getNation() {
		return nation;
	}

	/**
	 * @param nation the nation to set
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}

	// 3. Constructors
	public ForeignCustomer() {

	}

	/**
	 * @param id
	 * @param name
	 * @param day
	 * @param month
	 * @param year
	 * @param amountKW
	 * @param unitPrice
	 */
	public ForeignCustomer(String id, String name, int day, int month, int year, float amountKW, float unitPrice,
			String nation) {
		super(id, name, day, month, year, amountKW, unitPrice);
		this.nation = nation;
	}

	// 4. Input, output methods
	@Override
	public void input(Scanner scan) {
		super.input(scan);
		System.out.println("Please input customer's nation: ");
		this.nation = scan.nextLine();
	}

	@Override
	public void output() {
		System.out.print("Nation: " + this.nation + "\t\t");
		super.output();
		System.out.println();
	}

	// 5. Business methods
	@Override
	public void calculatePayment() {
		super.calculatePayment();
	}

}
