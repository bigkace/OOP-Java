/*
 * Purpose: Manage house deal - subclass
 * Author: Vu The Quan
 * Date: 04/07/2020
 * Version: 1.0
 */

import java.util.Scanner;

public class HouseDeal extends RealEstate {
	final int PREMIUM = 1;
	final int NORMAL = 2;

	// 1. Fields
	private String address;
	private int houseType;

	// 2. Getters, setters
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the houseType
	 */
	public int getHouseType() {
		return houseType;
	}

	/**
	 * @param houseType the houseType to set
	 */
	public void setHouseType(int houseType) {
		this.houseType = houseType;
	}

	// 3. Constructors
	public HouseDeal() {
		super();
		this.address = "";
		this.houseType = 0;
	}

	/**
	 * @param dealDay
	 * @param dealMonth
	 * @param dealYear
	 * @param unitPrice
	 * @param acreage
	 */
	public HouseDeal(String dealID, int dealDay, int dealMonth, int dealYear, float unitPrice, float acreage, String address,
			int houseType) {
		super(dealID, dealDay, dealMonth, dealYear, unitPrice, acreage);
		this.address = address;
		this.houseType = houseType;
	}

	// 4. Input, output methods
	@Override
	public void input(Scanner scan) {
		super.input(scan);
		System.out.print("Please input address: ");
		this.address = scan.nextLine();
		do {
			System.out.print("Please input type of house ((1) premium, (2) normal): ");
			this.houseType = Integer.parseInt(scan.nextLine());
		} while (this.houseType < 1 || this.houseType > 2);
	}

	@Override
	public void output() {
		System.out.print("Type: House deal\tHouse type: ");
		if(this.houseType == NORMAL)
			System.out.print("Normal\t");
		else
			System.out.print("Premium\t");
		super.output();
		System.out.println("\t\tAdress: "+this.address);
		
	}
	// 5. Business methods
	@Override
	public void calculatePayment() {
		if(this.houseType == 1) {
			this.payment = this.acreage*this.unitPrice;
		}else {
			this.payment = this.acreage*this.unitPrice*0.9f;
		}
	}
}
