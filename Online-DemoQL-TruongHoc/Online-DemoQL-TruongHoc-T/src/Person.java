/*
 * Purpose: Manage teachers and students - superclass
 * Author: Vu The Quan
 * Date: 11/07/2020
 */

import java.util.Scanner;

public abstract class Person implements InOut {
	// 1. Fields
	protected String name;
	protected int birth;
	protected String bornPosition;
	protected String address;

	// 2. Getters, setters
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the birth
	 */
	public int getBirth() {
		return birth;
	}

	/**
	 * @param birth the birth to set
	 */
	public void setBirth(int birth) {
		this.birth = birth;
	}

	/**
	 * @return the birthPosition
	 */
	public String getBornPosition() {
		return bornPosition;
	}

	/**
	 * @param birthPosition the birthPosition to set
	 */
	public void setBornPosition(String bornPosition) {
		this.bornPosition = bornPosition;
	}

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

	// 3. Constructors
	public Person() {

	}

	/**
	 * @param name
	 * @param birth
	 * @param birthPosition
	 * @param address
	 */
	public Person(String name, int birth, String birthPosition, String address) {
		this.name = name;
		this.birth = birth;
		this.bornPosition = birthPosition;
		this.address = address;
	}

	// 4. Input, output methods
	public void input(Scanner scan) {
		System.out.print("Please input name: ");
		this.name = scan.nextLine();

		System.out.print("Please input birth year: ");
		this.birth = Integer.parseInt(scan.nextLine());

		System.out.print("Please input born position: ");
		this.bornPosition = scan.nextLine();

		System.out.print("Please input address: ");
		this.address = scan.nextLine();

	}

	public void output() {
		System.out.print("Name: " + this.name + "\t Birth Year: " + this.birth + "\t Born Position: "
				+ this.bornPosition + "\t Address: " + this.address);
	}

	// 5. Business methods
	public abstract void update(Scanner scan);
	
	public void printMenuUpdate() {
		System.out.println("================== UPDATE ==================");
		System.out.println("1. Name");
		System.out.println("2. Birth year");
		System.out.println("3. Born Position");
		System.out.println("4. Address");
	}

}
