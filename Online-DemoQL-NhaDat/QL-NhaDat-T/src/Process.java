/*
 * Exercise: Manage real estate
 * Author: Vu The Quan
 * Date: 04/07/2020
 * Version: 1.0
 */

import java.util.Scanner;

public class Process {

	public Process() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		ListDeal listDeal = new ListDeal();
		listDeal.setDefault();
		doMenu(scan, listDeal);
	}

	private static void printMenu() {
		System.out.println("--------------------------------------------");
		System.out.println("*************Manage Real Estate*************");
		System.out.println("1. Input deal");
		System.out.println("2. Output list deal");
		System.out.println("3. Amount of land deal");
		System.out.println("4. Amount of house deal");
		System.out.println("5. Average of land deal");
		System.out.println("6. Export deals in particular time");
		System.out.print("Plesase choose: ");
	}

	private static void doMenu(Scanner scan, ListDeal list) {
		boolean flag = true;
		do {
			printMenu();
			int choose = Integer.parseInt(scan.nextLine());
			switch (choose) {
			case 1: {
				list.input(scan);
				break;
			}
			case 2: {
				list.calculatePaymentAll();
				list.output();
				break;
			}
			case 3: {
				list.countLandDeal();
				System.out.println("Amount of land deal: " + list.getLandDealAmount());
				System.out.println("Sum of land deal payment: " + list.getSumLandDeal());
				break;
			}
			case 4: {
				list.countHouseDeal();
				System.out.println("Amount of house deal: " + list.getHouseDealAmount());
				System.out.println("Sum of house deal payment: " + list.getSumHouseDeal());
				break;
			}
			case 5: {
				System.out.println("Average of land deal payment: " + list.averageLandDeal());
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
				list.exportDeal(month, year);
				break;
			}
			default:
				break;
			}
		} while (flag);

	}

}
