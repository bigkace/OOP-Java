/*
 * Exercise: Manage school
 * Author: Vu The Quan
 * Date: 11/07/2020
 */

import java.util.Scanner;

public class Process {

	public Process() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		School listPerson = new School();
		listPerson.setDefaultData();
		listPerson.countTeachingYearAll();
		listPerson.computeAverageAll();
		listPerson.evaluateAll();
		doMenu(scan, listPerson);
		
	}
	
	public static void printMenu() {
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.println("****************** MANAGE SCHOOL ******************");
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.println("1. Input");
		System.out.println("2. Update information");
		System.out.println("3. Output all teachers and students");
		System.out.println("4. Output all teachers");
		System.out.println("5. Output all students");
		System.out.println("6. Teachers have the most teaching years");
		System.out.println("7. Natural teachers have more than 5 teaching years");
		System.out.println("8. List Students who have the most average");
		System.out.println("9. List Students sorted by descending average");
		System.out.println("10. List Student sorted by name");
		System.out.println("0. Exit.");
	}
	
	public static void doMenu(Scanner scan, School list) {
		boolean flag = true;
		do {
			printMenu();
			System.out.print("Please choose >>> ");
			int choose = Integer.parseInt(scan.nextLine());
			switch (choose) {
			case 1: {
				list.input(scan);
				break;
			}
			case 2: {
				list.update(scan);
				break;
			}
			case 3: {
				list.output();
				break;
			}
			case 4: {
				System.out.println("============================ TEACHERS ============================");
				for(Person obj: list.listPerson.getListPerson()) {
					if(obj instanceof Teacher) {
						obj.output();
					}
				}
				System.out.println("============================== END ===============================\n");
				break;
			}
			case 5: {
				System.out.println("============================ STUDENTS ============================");
				for(Person obj: list.listPerson.getListPerson()) {
					if(obj instanceof Student) {
						obj.output();
					}
				}
				System.out.println("============================== END ===============================\n");
				break;
			}
			case 6: {
				list.findMaxTeachingYearTeacher();
				break;
			}
			case 7: {
				list.findNatural5YearsTeacher();
				break;
			}
			case 8: {
				list.findMaxAverageStudent();
				break;
			}
			case 9: {
				list.sortStudentByAverage();
				break;
			}
			case 10: {
				list.sortStudentByName();
				break;
			}
			case 0: {
				flag = false;
				break;
			}
			default:{
				System.out.println("Please choose form 0 - 10.");
				break;
			}
			}
		} while (flag);

	}

}
