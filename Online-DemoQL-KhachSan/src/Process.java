/*
 * Exercise: Manage list hotel bill
 * Author: Vu The Quan
 * Date: 06/07/2020
 * Version: 1.0
 */

import java.util.Scanner;

public class Process {

	public Process() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		ListBill listBill = new ListBill();
		listBill.setDefault();
		doMenu(scan, listBill);
	}

	private static void printMenu() {
		System.out.println("--------------------------------------------");
		System.out.println("*************Manage Hotel Bills*************");
		System.out.println("1. Input customer");
		System.out.println("2. Output list bills");
		System.out.println("3. Amount of day bills");
		System.out.println("4. Amount of hour bills");
		System.out.println("5. Average of hour bills");
		System.out.println("6. Export bills in particular time");
		System.out.print("Plesase choose: ");
	}

	private static void doMenu(Scanner scan, ListBill list) {
		boolean flag = true;
		do {
			list.calculatePaymentAll();
			printMenu();
			int choose = Integer.parseInt(scan.nextLine());
			switch (choose) {
			case 1: {
				list.input(scan);
				break;
			}
			case 2: {
				list.output();
				break;
			}
			case 3: {
				list.countCustomer();
				System.out.println("Amount of day bills: " + list.getCountDayBill());
				System.out.println("Sum of day bills' payment: " + list.getSumDayBill());
				break;
			}
			case 4: {
				list.countCustomer();
				System.out.println("Amount of hour bills: " + list.getCountHourBill());
				System.out.println("Sum of hour bills' payment: " + list.getSumHourBill());
				break;
			}
			case 5: {
				System.out.println("Average of hour bills' payment: " + list.getAverageHourBills());
				break;
			}
			case 6: {
				int month, year;
				do {
					System.out.print("Please input month: ");
					month = Integer.parseInt(scan.nextLine());
				} while (month < 1 && month > 12);

				do {
					System.out.print("Please input year: ");
					year = Integer.parseInt(scan.nextLine());
				} while (year < 2000);
				list.exportInTime(month, year);
				break;
			}
			default:
				break;
			}
		} while (flag);

	}
}
