/*
 * Purpose: Manage students - subclass
 * Author: Vu The Quan
 * Date: 11/07/2020
 */

import java.util.Scanner;

public class Student extends Person {
	// 1. Fields
	private float math;
	private float literature;
	private float english;
	private float average;
	private String evaluate;

	// 2. Getters, setters
	/**
	 * @return the math
	 */
	public synchronized float getMath() {
		return math;
	}

	/**
	 * @param math the math to set
	 */
	public synchronized void setMath(float math) {
		this.math = math;
	}

	/**
	 * @return the literature
	 */
	public synchronized float getLiterature() {
		return literature;
	}

	/**
	 * @param literature the literature to set
	 */
	public synchronized void setLiterature(float literature) {
		this.literature = literature;
	}

	/**
	 * @return the english
	 */
	public synchronized float getEnglish() {
		return english;
	}

	/**
	 * @param english the english to set
	 */
	public synchronized void setEnglish(float english) {
		this.english = english;
	}

	/**
	 * @return the average
	 */
	public synchronized float getAverage() {
		return average;
	}

	/**
	 * @return the evaluate
	 */
	public synchronized String getEvaluate() {
		return evaluate;
	}

	// 3. Constructors
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int birth, String bornPosition, String address, float math, float literature,
			float english) {
		super(name, birth, bornPosition, address);
		this.math = math;
		this.literature = literature;
		this.english = english;
	}

	// 4. Input, output methods
	@Override
	public void input(Scanner scan) {
		super.input(scan);
		do {
			System.out.print("Please input math score: ");
			this.math = Float.parseFloat(scan.nextLine());
		} while (this.math < 0 || this.math > 10);

		do {
			System.out.print("Please input literature score: ");
			this.literature = Float.parseFloat(scan.nextLine());
		} while (this.literature < 0 || this.math > 10);

		do {
			System.out.print("Please input english score: ");
			this.english = Float.parseFloat(scan.nextLine());
		} while (this.english < 0 || this.math > 10);
	}

	@Override
	public void output() {
		System.out.print("Student - \t");
		super.output();
		System.out.println("\t Math: " + this.math + "\t\t Literature: " + this.literature + "\t English: " + this.english
				+ "\t Average: " + this.average + "\t Evaluate: " + this.evaluate);
	}

	// 5. Business methods
	@Override
	public void update(Scanner scan) {
		boolean flag = true;
		do {
			printMenuUpdate();
			System.out.println("5. Math's score");
			System.out.println("6. Literature's score");
			System.out.println("7. English's score");
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
					System.out.print("Please input math score: ");
					this.math = Float.parseFloat(scan.nextLine());
				} while (this.math < 0 || this.math > 10);
				break;
			}
			case 6: {
				do {
					System.out.print("Please input literature score: ");
					this.literature = Float.parseFloat(scan.nextLine());
				} while (this.literature < 0 || this.math > 10);
				break;
			}
			case 7: {
				do {
					System.out.print("Please input english score: ");
					this.english = Float.parseFloat(scan.nextLine());
				} while (this.english < 0 || this.math > 10);
				break;
			}
			case 0: {
				flag = false;
				break;
			}
			default: {
				System.out.println("Please choose only 0 - 7.");
				break;
			}
			}
			System.out.println("Update successfully!");
		} while (flag);
		System.out.println("=================== END ===================\n");
		System.out.println();
	}

	public void computeAverage() {
		this.average = (float) (Math.round(((this.math + this.literature + this.english) / 3)*100.0)/100.0);
	}

	public void evaluateStudent() {
		if (this.average > 9)
			this.evaluate = "Exellent";
		else if (this.average >= 8)
			this.evaluate = "Good";
		else if (this.average >= 7)
			this.evaluate = "Average good";
		else if (this.average >= 5)
			this.evaluate = "Average";
		else
			this.evaluate = "Weak";

	}

}
