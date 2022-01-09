/*
 * Purpose: Manage list bill
 * Author: Vu The Quan
 * Date: 05/07/2020
 * Version: 1.0
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ListBill {
	// 1. Fields
	private ArrayList<Customer> listCustomer;
	private int countNative;
	private float sumNative;
	private int countForeign;
	private float sumForeign;
	private float averageForeign;

	// 2. Getters, setters
	/**
	 * @return the listCustomer
	 */
	public ArrayList<Customer> getListCustomer() {
		return listCustomer;
	}

	/**
	 * @param listCustomer the listCustomer to set
	 */
	public void setListCustomer(ArrayList<Customer> listCustomer) {
		this.listCustomer = listCustomer;
	}
	
	/**
	 * @return the countNative
	 */
	public int getCountNative() {
		return countNative;
	}

	/**
	 * @param countNative the countNative to set
	 */
	public void setCountNative(int countNative) {
		this.countNative = countNative;
	}

	/**
	 * @return the sumNative
	 */
	public float getSumNative() {
		return sumNative;
	}

	/**
	 * @param sumNative the sumNative to set
	 */
	public void setSumNative(float sumNative) {
		this.sumNative = sumNative;
	}

	/**
	 * @return the countForeign
	 */
	public int getCountForeign() {
		return countForeign;
	}

	/**
	 * @param countForeign the countForeign to set
	 */
	public void setCountForeign(int countForeign) {
		this.countForeign = countForeign;
	}

	/**
	 * @return the sumForeign
	 */
	public float getSumForeign() {
		return sumForeign;
	}

	/**
	 * @param sumForeign the sumForeign to set
	 */
	public void setSumForeign(float sumForeign) {
		this.sumForeign = sumForeign;
	}

	/**
	 * @param averageForeign the averageForeign to set
	 */
	public void setAverageForeign(float averageForeign) {
		this.averageForeign = averageForeign;
	}

	// 3. Constructors
	public ListBill() {
		this.listCustomer = new ArrayList<Customer>();
	}

	// 4. Input, output methods
	public void input(Scanner scan) {
		boolean flag = true;
		do {
			System.out.println("Choose to input customer");
			System.out.println("1. Input native customer");
			System.out.println("2. Input foreign customer");
			System.out.println("0. Exit");
			System.out.print("Please choose: ");
			int choose = Integer.parseInt(scan.nextLine());
			switch (choose) {
			case 1: {
				Customer customer = new NativeCustomer();
				customer.input(scan);
				this.listCustomer.add(customer);
				break;
			}
			case 2: {
				Customer customer = new ForeignCustomer();
				customer.input(scan);
				this.listCustomer.add(customer);
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
		Customer native1 = new NativeCustomer("001", "Quan", 9, 9, 2013, 150, 2, 100, "Living");
		this.listCustomer.add(native1);

		Customer foreign1 = new ForeignCustomer("002", "David", 12, 9, 2016, 80, 4, "USA");
		this.listCustomer.add(foreign1);

		Customer native2 = new NativeCustomer("003", "Hai", 10, 5, 2017, 120, 2, 160, "Business");
		this.listCustomer.add(native2);

		Customer foreign2 = new ForeignCustomer("004", "Jonh", 21, 9, 2013, 100, 4, "UK");
		this.listCustomer.add(foreign2);

		Customer native3 = new NativeCustomer("005", "Trang", 19, 2, 2013, 400, 2, 200, "Producing");
		this.listCustomer.add(native3);

		Customer foreign3 = new ForeignCustomer("006", "Selena", 10, 1, 2016, 100.5f, 5, "Canada");
		this.listCustomer.add(foreign3);

		Customer native4 = new NativeCustomer("007", "Thuy", 14, 9, 2013, 100.5f, 2, 80, "Living");
		this.listCustomer.add(native4);

		Customer foreign4 = new ForeignCustomer("008", "SaSaki", 30, 7, 2016, 150, 4, "Japan");
		this.listCustomer.add(foreign4);

		Customer native5 = new NativeCustomer("009", "Quynh", 16, 9, 2013, 150, 4, 100, "Business");
		this.listCustomer.add(native5);

		Customer foreign5 = new ForeignCustomer("010", "Mohamed", 15, 8, 2016, 100, 4.5f, "Egypt");
		this.listCustomer.add(foreign5);
	}


	public void output() {
		for (Customer customer : this.listCustomer) {
			customer.output();
		}
	}

	public void printHelper(ArrayList<Customer> list) {
		for (Customer customer : list) {
			customer.output();
		}
	}

	// 5. Business methods
	public void calculatePaymentAll() {
		for (Customer cusotmer : this.listCustomer) {
			cusotmer.calculatePayment();
		}
	}

	public void countCustomer() {
		this.countNative = 0;
		this.sumNative = 0;
		this.countForeign = 0;
		this.sumForeign = 0;
		for (Customer customer : this.listCustomer) {
			if (customer instanceof NativeCustomer) {
				++this.countNative;
				this.sumNative += customer.getPayment();
			} else {
				++this.countForeign;
				this.sumForeign += customer.getPayment();
			}
		}
	}

	public float getAverageForeign() {
		return this.sumForeign / this.countForeign;
	}

	public void exportInTime(int month, int year) {
		System.out.println("---------------------------------------");
		System.out.println("List bills in " + month + '/' + year);
		for (Customer customer : this.listCustomer) {
			if (customer.getMonth() == month && customer.getYear() == year) {
				customer.output();
			}
		}
	}

}
