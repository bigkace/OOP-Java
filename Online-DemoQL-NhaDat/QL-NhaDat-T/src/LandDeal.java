/*
 * Purpose: Manage land deal - subclass
 * Author: Vu The Quan
 * Date: 04/07/2020
 * Version: 1.0
 */

import java.util.Scanner;

public class LandDeal extends RealEstate{
	final float DEAL_A = 1.5f;
	final int A = 1;
	final int B = 2;
	final int C = 3;
	
	// 1. Fields
	private int landType;
	
	// 2. Getters, setters
	/**
	 * @return the landType
	 */
	public int getLandType() {
		return landType;
	}

	/**
	 * @param landType the landType to set
	 */
	public void setLandType(int landType) {
		this.landType = landType;
	}

	// 3. Constructors
	public LandDeal() {
		super();
		this.landType = 0;
	}

	/**
	 * @param dealDay
	 * @param dealMonth
	 * @param dealYear
	 * @param unitPrice
	 * @param acreage
	 */
	public LandDeal(String dealID, int dealDay, int dealMonth, int dealYear, float unitPrice, float acreage, int landtype) {
		super(dealID, dealDay, dealMonth, dealYear, unitPrice, acreage);
		this.landType = landtype;
	}
	
	// 4. Input, output methods
	@Override
	public void input(Scanner scan) {
		super.input(scan);
		do {
		System.out.print("Please input type of land (1.A, 2.B or 3.C): ");
		this.landType = Integer.parseInt(scan.nextLine());
		}while(this.landType < 1 || this.landType > 3);
		
	}
	
	@Override
	public void output() {
		System.out.print("Type: Land deal\t\tLand type: ");
		if(this.landType == A)
			System.out.print("A\t\t");
		else if(this.landType == B)
			System.out.print("B\t\t");
		else
			System.out.print("C\t\t");
		super.output();
		System.out.println();
	}

	// 5. Business methods
	@Override
	public void calculatePayment() {
		if(this.landType == 1) {
			this.payment = this.acreage*this.unitPrice*DEAL_A;
		}
		else{
			this.payment = this.acreage*this.unitPrice;
		}
	}


}
