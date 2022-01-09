/*
 * Purpose: Manage real estate - superclass
 * Author: Vu The Quan
 * Date: 04/07/2020
 * Version: 1.0
 */

import java.util.Scanner;

public class RealEstate {
	// 1. Fields
	protected String dealID;
	protected int day;
	protected int month;
	protected int year;
	protected float unitPrice;
	protected float acreage;
	protected float payment;

	// 2. Getters, setters
	/**
	 * @return the dealID
	 */
	public String getDealID() {
		return dealID;
	}

	/**
	 * @param dealID the dealID to set
	 */
	public void setDealID(String dealID) {
		this.dealID = dealID;
	}

	/**
	 * @return the dealDay
	 */
	public int getDealDay() {
		return day;
	}

	/**
	 * @param dealDay the dealDay to set
	 */
	public void setDealDay(int dealDay) {
		this.day = dealDay;
	}

	/**
	 * @return the dealMonth
	 */
	public int getDealMonth() {
		return month;
	}

	/**
	 * @param dealMonth the dealMonth to set
	 */
	public void setDealMonth(int dealMonth) {
		this.month = dealMonth;
	}

	/**
	 * @return the dealYear
	 */
	public int getDealYear() {
		return year;
	}

	/**
	 * @param dealYear the dealYear to set
	 */
	public void setDealYear(int dealYear) {
		this.year = dealYear;
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
	 * @return the acreage
	 */
	public float getAcreage() {
		return acreage;
	}

	/**
	 * @param acreage the acreage to set
	 */
	public void setAcreage(float acreage) {
		this.acreage = acreage;
	}

	/**
	 * @return the payment
	 */
	public float getPayment() {
		return payment;
	}

	// 3. Constructors
	public RealEstate() {
		// Default
		this.day = 0;
		this.month = 0;
		this.year = 0;
		this.unitPrice = 0;
		this.acreage = 0;
	}

	/**
	 * @param dealDay
	 * @param dealMonth
	 * @param dealYear
	 * @param unitPrice
	 * @param acreage
	 */
	public RealEstate(String dealID, int dealDay, int dealMonth, int dealYear, float unitPrice, float acreage) {
		this.dealID = dealID;
		this.day = dealDay;
		this.month = dealMonth;
		this.year = dealYear;
		this.unitPrice = unitPrice;
		this.acreage = acreage;
	}

	// 4. Input, output methods
	public void input(Scanner scan) {

		System.out.print("Please input deal's ID: ");
		this.dealID = scan.nextLine();

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
			System.out.print("Please input unit price: ");
			this.unitPrice = Float.parseFloat(scan.nextLine());
		} while (this.unitPrice < 1);

		do {
			System.out.print("Please input acreage: ");
			this.acreage = Float.parseFloat(scan.nextLine());
		} while (this.acreage < 1);
	}

	public void output() {
		System.out.print("Deal ID: " + this.dealID + "\t\tDate: " + this.day + '/' + this.month + '/' + this.year
				+ "\t\tUnitPrice: " + this.unitPrice + "\t\tAcreage: " + this.acreage + "\t\tPayment: " + this.payment);
	}

	// 5. Business methods
	public void calculatePayment() {
		this.payment = 0;
	}
}
