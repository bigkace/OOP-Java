/*
 * Purpose: Manage hour bill - subclass
 * Author: Vu The Quan
 * Date: 06/07/2020
 * Version: 1.0
 */

import java.util.Scanner;

public class HourBill extends Bill {
	// 1. Fields
	private int hours;
	private float unitPriceHour;

	// 2. Getters, setters
	/**
	 * @return the hours
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * @param hours the hours to set
	 */
	public void setHours(int hours) {
		this.hours = hours;
	}

	/**
	 * @return the unitPriceHour
	 */
	public float getUnitPriceHour() {
		return unitPriceHour;
	}

	/**
	 * @param unitPriceHour the unitPriceHour to set
	 */
	public void setUnitPriceHour(float unitPriceHour) {
		this.unitPriceHour = unitPriceHour;
	}

	// 3. Constructors
	public HourBill() {
		super();
		this.hours = 0;
		this.unitPriceHour = 0;
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
	public HourBill(String id, int day, int month, int year, String name, String roomID, float unitPrice, int hours,
			float unitPriceHour) {
		super(id, day, month, year, name, roomID, unitPrice);
		this.hours = hours;
		this.unitPriceHour = unitPriceHour;
	}

	// 4. Input, output methods
	@Override
	public void input(Scanner scan) {
		super.input(scan);
		System.out.print("Please input amount of hours: ");
		this.hours = Integer.parseInt(scan.nextLine());

		System.out.print("Please input unit price each hour: ");
		this.unitPriceHour = Float.parseFloat(scan.nextLine());
	}

	@Override
	public void output() {
		System.out.print("Hour bill\t");
		super.output();
		System.out.println("\tHours: " + this.hours + "\tHourly unit price: " + this.unitPriceHour + "\t\tPayment: "
				+ this.payment);
	}

	// 5. Business methods
	@Override
	public void calculatePayment() {
		if (this.hours <= 30 && this.hours > 24) {
			this.payment = 24 * this.unitPriceHour;
		} else if (this.hours > 30) {
			float day = (1.0f*this.hours) / 24;
			this.payment = (1.0f) * this.unitPrice * day;
		} else {
			this.payment = this.unitPriceHour * this.hours;
		}

	}

}
