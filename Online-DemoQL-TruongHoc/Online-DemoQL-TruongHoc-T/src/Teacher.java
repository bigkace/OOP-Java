/*
 * Purpose: Manage teachers - subclass
 * Author: Vu The Quan
 * Date: 11/07/2020
 */

import java.util.Scanner;

public class Teacher extends Person {
	final int CURRENT_YEAR = 2020;

	// 1. Fields
	private int startYear;
	private String specialize;
	private int teachingYear;

	// 2. Getters, setters
	/**
	 * @return the startYear
	 */
	public int getStartYear() {
		return startYear;
	}

	/**
	 * @param startYear the startYear to set
	 */
	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	/**
	 * @return the specialize
	 */
	public String getSpecialize() {
		return specialize;
	}

	/**
	 * @param specialze the specialize to set
	 */
	public void setSpecialize(String specialze) {
		this.specialize = specialze;
	}

	/**
	 * @return the teachingYear
	 */
	public int getTeachingYear() {
		return teachingYear;
	}

	// 3. Constructors
	public Teacher() {

	}

	public Teacher(String name, int birth, String bornPosition, String address, int startYear, String specialize) {
		super(name, birth, bornPosition, address);
		this.startYear = startYear;
		this.specialize = specialize;
	}

	// 4. Input, output methods
	@Override
	public void input(Scanner scan) {
		super.input(scan);
		do {
			System.out.print("Please input start teaching year: ");
			this.startYear = Integer.parseInt(scan.nextLine());
		} while (this.startYear < 1980 || this.startYear > CURRENT_YEAR);

		int choose;
		do {
			System.out.print("Please input specialize (1. Natural, 2. Social): ");
			choose = Integer.parseInt(scan.nextLine());
		} while (choose <= 0 || choose > 2);
		this.specialize = (choose == 1) ? "Natural" : "Social";
	}

	@Override
	public void output() {
		System.out.print("Teacher - \t");
		super.output();
		System.out.println("\t Start year: " + this.startYear + "\t Specialize: " + this.specialize
				+ "\t Teaching years: " + this.teachingYear);
	}

	// 5. Business methods
	@Override
	public void update(Scanner scan) {
		boolean flag = true;
		do {
			printMenuUpdate();
			System.out.println("5. Start teaching year");
			System.out.println("6. Specialize");
			System.out.println("0. Exit");
			System.out.print("Please choose >>> ");
			int choose = Integer.parseInt(scan.nextLine());
			switch (choose) {
			case 1: {
				System.out.print("Please input name: ");
				this.name = scan.nextLine();
				break;
			}
			case 2: {
				System.out.print("Please input birth year: ");
				this.birth = Integer.parseInt(scan.nextLine());
				break;
			}
			case 3: {
				System.out.print("Please input born position: ");
				this.bornPosition = scan.nextLine();
				break;
			}
			case 4: {
				System.out.print("Please input address: ");
				this.address = scan.nextLine();
				break;
			}
			case 5: {
				do {
					System.out.print("Please input start teaching year: ");
					this.startYear = Integer.parseInt(scan.nextLine());
				} while (this.startYear < 1980 || this.startYear > 2020);
				break;
			}
			case 6: {
				int type;
				do {
					System.out.print("Please input specialize (1. Natural, 2. Social): ");
					type = Integer.parseInt(scan.nextLine());
				} while (type <= 0 || type > 2);
				this.specialize = (type == 1) ? "Natural" : "Social";
				break;
			}
			case 0: {
				flag = false;
				break;
			}
			default: {
				System.out.println("Please choose only 0 - 6.");
				break;
			}
			}
			System.out.println("=================== END ===================\n");
		} while (flag);
	}

	public void countTeachingYear() {
		this.teachingYear = CURRENT_YEAR - this.startYear;
	}

}
