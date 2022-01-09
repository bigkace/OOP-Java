/*
 * Purpose: Manage list bills
 * Author: Vu The Quan
 * Date: 06/07/2020
 * Version: 1.0
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ListBill {
	// 1. Fields
	private ArrayList<Bill> listBill;
	private int countDayBill;
	private int countHourBill;
	private float sumDayBill;
	private float sumHourBill;


	// 2. Getters, setters
	/**
	 * @return the listBill
	 */
	public ArrayList<Bill> getListBill() {
		return listBill;
	}

	/**
	 * @param listBill the listBill to set
	 */
	public void setListBill(ArrayList<Bill> listBill) {
		this.listBill = listBill;
	}

	/**
	 * @return the countDayBill
	 */
	public int getCountDayBill() {
		return countDayBill;
	}

	/**
	 * @param countDayBill the countDayBill to set
	 */
	public void setCountDayBill(int countDayBill) {
		this.countDayBill = countDayBill;
	}

	/**
	 * @return the countHourBill
	 */
	public int getCountHourBill() {
		return countHourBill;
	}

	/**
	 * @param countHourBill the countHourBill to set
	 */
	public void setCountHourBill(int countHourBill) {
		this.countHourBill = countHourBill;
	}

	/**
	 * @return the sumDayBill
	 */
	public float getSumDayBill() {
		return sumDayBill;
	}

	/**
	 * @param sumDayBill the sumDayBill to set
	 */
	public void setSumDayBill(float sumDayBill) {
		this.sumDayBill = sumDayBill;
	}

	/**
	 * @return the sumHourBill
	 */
	public float getSumHourBill() {
		return sumHourBill;
	}

	/**
	 * @param sumHourBill the sumHourBill to set
	 */
	public void setSumHourBill(float sumHourBill) {
		this.sumHourBill = sumHourBill;
	}

	// 3. Constructors
	public ListBill() {
		this.listBill = new ArrayList<Bill>();
	}

	// 4. Input, output methods
	public void input(Scanner scan) {
		boolean flag = true;
		do {
			System.out.println("Choose to input customer");
			System.out.println("1. Input daily customer ");
			System.out.println("2. Input hourly customer");
			System.out.println("0. Exit");
			System.out.print("Please choose: ");
			int choose = Integer.parseInt(scan.nextLine());
			switch (choose) {
			case 1: {
				Bill customer = new DayBill();
				customer.input(scan);
				this.listBill.add(customer);
				break;
			}
			case 2: {
				Bill customer = new HourBill();
				customer.input(scan);
				this.listBill.add(customer);
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
		Bill Day1 = new DayBill("001", 9, 9, 2013, "Quan", "101", 800, 4);
		this.listBill.add(Day1);

		Bill Hour1 = new HourBill("002", 12, 9, 2016, "David", "102", 1500, 8, 100);
		this.listBill.add(Hour1);

		Bill Day2 = new DayBill("003", 20, 9, 2013, "Hoang", "103", 950, 5);
		this.listBill.add(Day2);

		Bill Hour2 = new HourBill("004", 4, 7, 2019, "Quyen", "104", 1000, 30, 100);
		this.listBill.add(Hour2);

		Bill Day3 = new DayBill("005", 28, 9, 2013, "Quy", "105", 950.5f, 5);
		this.listBill.add(Day3);

		Bill Hour3 = new HourBill("006", 12, 5, 2020, "John", "106", 1500, 47, 150);
		this.listBill.add(Hour3);

		Bill Day4 = new DayBill("007", 1, 11, 2018, "Tuan", "107", 800, 4);
		this.listBill.add(Day4);

		Bill Hour4 = new HourBill("008", 22, 9, 2013, "Justin", "108", 1080, 18, 80);
		this.listBill.add(Hour4);

		Bill Day5 = new DayBill("009", 1, 1, 2017, "Khang", "109", 950, 2);
		this.listBill.add(Day5);

		Bill Hour5 = new HourBill("010", 1, 9, 2013, "Ngoc", "110", 1500, 35, 100);
		this.listBill.add(Hour5);
	}

	
	public void output() {
		for (Bill customer : this.listBill) {
			customer.output();
		}
	}

	public void printHelper(ArrayList<Bill> list) {
		for (Bill customer : list) {
			customer.output();
		}
	}


	// 5. Business methods
	public void calculatePaymentAll() {
		for (Bill cusotmer : this.listBill) {
			cusotmer.calculatePayment();
		}
	}

	public void countCustomer() {
		this.countDayBill = 0;
		this.sumDayBill = 0;
		this.countHourBill = 0;
		this.sumHourBill = 0;
		for (Bill customer : this.listBill) {
			if (customer instanceof DayBill) {
				++this.countDayBill;
				this.sumDayBill += customer.getPayment();
			} else {
				++this.countHourBill;
				this.sumHourBill += customer.getPayment();
			}
		}
	}

	public float getAverageHourBills() {
		return this.sumHourBill / this.countHourBill;
	}

	public void exportInTime(int month, int year) {
		System.out.println("---------------------------------------");
		System.out.println("List bills in " + month + '/' + year);
		for (Bill customer : this.listBill) {
			if (customer.getMonth() == month && customer.getYear() == year) {
				customer.output();
			}
		}
	}


}
