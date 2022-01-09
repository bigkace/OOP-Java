/*
 * Purpose: Manage native customer - subclass
 * Author: Vu The Quan
 * Date: 05/07/2020
 * Version: 1.0
 */

import java.util.Scanner;

public class NativeCustomer extends Customer {
	// 1. Fields
	private float standard; // Nguong su dung KW
	private String type;

	// 2. Getters, setters
	/**
	 * @return the standard
	 */
	public float getStandard() {
		return standard;
	}

	/**
	 * @param standard the standard to set
	 */
	public void setStandard(float standard) {
		this.standard = standard;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	// 3. Constructors
	public NativeCustomer() {

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
	public NativeCustomer(String id, String name, int day, int month, int year, float amountKW, float unitPrice,
			float standard, String type) {
		super(id, name, day, month, year, amountKW, unitPrice);
		this.standard = standard;
		this.type = type;
	}

	// 4. Input, output methods
	@Override
	public void input(Scanner scan) {
		super.input(scan);
		do {
			System.out.print("Please input standard: ");
			this.standard = Float.parseFloat(scan.nextLine());
		} while (this.standard < 1);

		System.out.println("Please input type of customer (Living, Business, Producing): ");
		this.type = scan.nextLine();
	}

	@Override
	public void output() {
		System.out.print("Type: " + this.type + "\t\t");
		super.output();
		System.out.println("\t\tStandard: " + this.standard);

	}

	// 5. Business methods
	@Override
	public void calculatePayment() {
		if (this.amountKW <= this.standard) {
			this.payment = this.amountKW * this.unitPrice;
		} else {
			this.payment = this.standard * this.unitPrice + (this.amountKW - this.standard) * this.unitPrice * 2.5f;
		}
	}

}
