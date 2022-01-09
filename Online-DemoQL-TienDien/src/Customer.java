/*
 * Purpose: Manage customer - superclass
 * Author: Vu The Quan
 * Date: 05/07/2020
 * Version: 1.0
 */

import java.util.Scanner;

public class Customer {
	// 1. Fields
	protected String id;
	protected String name;
	protected int day;
	protected int month;
	protected int year;
	protected float amountKW;
	protected float unitPrice;
	protected float payment;

	// 2. Getters, setters
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the amountKW
	 */
	public float getAmountKW() {
		return amountKW;
	}

	/**
	 * @param amountKW the amountKW to set
	 */
	public void setAmountKW(float amountKW) {
		this.amountKW = amountKW;
	}

	/**
	 * @return the unitPrice
	 */
	public float getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * @return the payment
	 */
	public float getPayment() {
		return payment;
	}

	// 3. Constructors
	public Customer() {
		this.id = "";
		this.name = "";
		this.day = 0;
		this.month = 0;
		this.year = 0;
		this.amountKW = 0;
		this.unitPrice = 0;
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
	public Customer(String id, String name, int day, int month, int year, float amountKW, float unitPrice) {
		this.id = id;
		this.name = name;
		this.day = day;
		this.month = month;
		this.year = year;
		this.amountKW = amountKW;
		this.unitPrice = unitPrice;
	}

	// 4. Input, output methods
	public void input(Scanner scan) {
		System.out.print("Please input bill's ID: ");
		this.id = scan.nextLine();

		System.out.print("Please input customer's name: ");
		this.name = scan.nextLine();

		do {
			System.out.print("Please input day: ");
			this.day = Integer.parseInt(scan.nextLine());
		} while (this.day < 1 || this.day > 31);

		do {
			System.out.print("Please input month: ");
			this.month = Integer.parseInt(scan.nextLine());
		} while (this.month < 1 || this.month > 12);

		do {
			System.out.print("Please input year: ");
			this.year = Integer.parseInt(scan.nextLine());
		} while (this.year < 2000);

		do {
			System.out.print("Please input amount of used KW: ");
			this.amountKW = Float.parseFloat(scan.nextLine());
		} while (this.amountKW < 1);

		do {
			System.out.print("Please input unit price: ");
			this.unitPrice = Float.parseFloat(scan.nextLine());
		} while (this.unitPrice < 1);
	}

	public void output() {
		System.out.print("ID: " + this.id + "\t\tName: " + this.name + "\t\tDate: " + this.day + '/' + this.month
				+ '/' + this.year + "\t\tAmount of KW: " + this.amountKW + "\t\tUnit Price: " + this.unitPrice
				+ "\t\tPayment: " + this.payment);
	}
	// 5. Business methods
	public void calculatePayment() {
		this.payment = this.amountKW*this.unitPrice;
	}

}
