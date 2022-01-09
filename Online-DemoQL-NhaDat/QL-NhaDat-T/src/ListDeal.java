/*
 * Purpose: Manage list deal 
 * Author: Vu The Quan
 * Date: 04/07/2020
 * Version: 1.0
 */

import java.util.Scanner;
import java.util.ArrayList;;

public class ListDeal {
	// 1. Fields
	private ArrayList<RealEstate> listDeal;
	private int landDealAmount;
	private float sumLandDeal;
	private int houseDealAmount;
	private float sumHouseDeal;

	// 2. Getters, setters
	/**
	 * @return the listDeal
	 */
	public ArrayList<RealEstate> getListDeal() {
		return listDeal;
	}

	/**
	 * @param listDeal the listDeal to set
	 */
	public void setListDeal(ArrayList<RealEstate> listDeal) {
		this.listDeal = listDeal;
	}

	/**
	 * @return the landDealAmount
	 */
	public int getLandDealAmount() {
		return landDealAmount;
	}

	/**
	 * @return the sumLandDeal
	 */
	public float getSumLandDeal() {
		return sumLandDeal;
	}

	/**
	 * @return the houseDealAmount
	 */
	public int getHouseDealAmount() {
		return houseDealAmount;
	}

	/**
	 * @return the sumhouseDeal
	 */
	public float getSumHouseDeal() {
		return sumHouseDeal;
	}

	// 3. Constructors
	public ListDeal() {
		this.listDeal = new ArrayList<RealEstate>();
	}

	// 4. Input, output methods
	public void input(Scanner scan) {
		boolean flag = true;
		do {
			System.out.println("Choose to input deal");
			System.out.println("1. Input land deal");
			System.out.println("2. Input house deal");
			System.out.println("0. Exit");
			System.out.print("Please choose: ");
			int choose = Integer.parseInt(scan.nextLine());
			switch (choose) {
			case 1: {
				RealEstate landDeal = new LandDeal();
				landDeal.input(scan);
				this.listDeal.add(landDeal);
				break;
			}
			case 2: {
				RealEstate houseDeal = new HouseDeal();
				houseDeal.input(scan);
				this.listDeal.add(houseDeal);
				break;
			}
			case 0: {
				flag = false;
				break;
			}
			default:
				break;
			}
		} while (flag);
	}

	public void setDefault() {
		RealEstate land1 = new LandDeal("001", 12, 9, 2013, 15, 150, 1);
		this.listDeal.add(land1);

		RealEstate house1 = new HouseDeal("002", 19, 9, 2013, 50, 150, "Ha Noi", 1);
		this.listDeal.add(house1);

		RealEstate land2 = new LandDeal("003", 20, 9, 2013, 10, 120, 2);
		this.listDeal.add(land2);

		RealEstate house2 = new HouseDeal("004", 15, 2, 2019, 30, 75, "Binh Thuan", 2);
		this.listDeal.add(house2);

		RealEstate land3 = new LandDeal("005", 1, 10, 2018, 15, 300, 1);
		this.listDeal.add(land3);

		RealEstate house3 = new HouseDeal("006", 1, 9, 2013, 40, 80, "Ha Tinh", 1);
		this.listDeal.add(house3);

		RealEstate land4 = new LandDeal("007", 30, 9, 2013, 8, 100, 3);
		this.listDeal.add(land4);

		RealEstate house4 = new HouseDeal("008", 31, 7, 2017, 45, 120.5f, "Da Nang", 2);
		this.listDeal.add(house4);

		RealEstate land5 = new LandDeal("009", 6, 4, 2020, 10, 450, 2);
		this.listDeal.add(land5);

		RealEstate house5 = new HouseDeal("010", 7, 9, 2013, 80, 100.6f, "Nha Trang", 1);
		this.listDeal.add(house5);
	}

	public void output() {
		for (RealEstate deal : this.listDeal) {
			deal.output();
		}
	}

	public void printHelper(ArrayList<RealEstate> list) {
		for (RealEstate deal : list) {
			deal.output();
		}
	}

	// 5. Business methods
	public void calculatePaymentAll() {
		for (RealEstate deal : this.listDeal) {
			deal.calculatePayment();
		}
	}

	public void countLandDeal() {
		this.landDealAmount = 0;
		this.sumLandDeal = 0;
		for (RealEstate deal : this.listDeal) {
			if (deal instanceof LandDeal) {
				++this.landDealAmount;
				this.sumLandDeal += deal.payment;
			}
		}
	}

	public void countHouseDeal() {
		this.houseDealAmount = 0;
		this.sumHouseDeal = 0;
		for (RealEstate deal : this.listDeal) {
			if (deal instanceof HouseDeal) {
				++this.houseDealAmount;
				this.sumHouseDeal += deal.payment;
			}
		}
	}

	public float averageLandDeal() {
		return this.sumLandDeal / (this.landDealAmount * 1.0f);
	}

	public void exportDeal(int month, int year) {
		System.out.println("----------------------------------");
		System.out.println("List deal of " + month + '/' + year);
		for (RealEstate deal : this.listDeal) {
			if (deal.month == month && deal.year == year) {
				deal.output();
			}
		}

	}
}
