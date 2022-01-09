/*
 * Exercise: Manage list electrical bill
 * Author: Vu The Quan
 * Date: 05/07/2020
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
		System.out.println("*************Manage Elictrical Bills*************");
		System.out.println("1. Input customer");
		System.out.println("2. Output list bills");
		System.out.println("3. Amount of native customers");
		System.out.println("4. Amount of foreign customers");
		System.out.println("5. Average of native payment");
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
//				list.calculatePaymentAll();
				list.output();
				break;
			}
			case 3: {
				list.countCustomer();
				System.out.println("Amount of native customers: " + list.getCountNative());
				System.out.println("Sum of native customers' payment: " + list.getSumNative());
				break;
			}
			case 4: {
				list.countCustomer();
				System.out.println("Amount of foreign customers: " + list.getCountForeign());
				System.out.println("Sum of foreign customers' payment: " + list.getSumForeign());
				break;
			}
			case 5: {
				System.out.println("Average of foreign customers' payment: " + list.getAverageForeign());
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
