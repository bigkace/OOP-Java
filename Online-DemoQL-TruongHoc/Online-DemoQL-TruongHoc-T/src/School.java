/*
 * Purpose: Manage list teachers in school
 * Author: Vu The Quan
 * Date: 11/07/2020
 */

import java.util.Scanner;

public class School implements InOut {
	// 1. Fields
	ListPerson listPerson;

	// 2. Getters, setters
	/**
	 * @return the listPerson
	 */
	public synchronized ListPerson getListPerson() {
		return listPerson;
	}

	/**
	 * @param listPerson the listPerson to set
	 */
	public synchronized void setListPerson(ListPerson listPerson) {
		this.listPerson = listPerson;
	}

	// 3. Constructors
	public School() {
		this.listPerson = new ListPerson();
	}

	// 4. Input, output methods
	@Override
	public void input(Scanner scan) {
		this.listPerson.input(scan);
	}

	@Override
	public void output() {
		this.listPerson.output();
	}

	public void setDefaultData() {
		this.listPerson.createDataTeacher();
		this.listPerson.createDataStudent();
	}

	// 5. Business methods
	public void update(Scanner scan) {
		this.listPerson.update(scan);
	}
	public void computeAverageAll() {
		this.listPerson.computeAverageAll();
	}

	public void evaluateAll() {
		this.listPerson.evaluateAll();
	}

	public void countTeachingYearAll() {
		this.listPerson.countTeachingYearAll();
	}

	public void findMaxTeachingYearTeacher() {
		this.listPerson.findMaxTeachingYearTeacher();
	}

	public void findNatural5YearsTeacher() {
		this.listPerson.findNatural5YearsTeacher();
	}

	public void findMaxAverageStudent() {
		this.listPerson.findMaxAverageStudent();
	}

	public void sortStudentByAverage() {
		this.listPerson.sortStudentByAverage();
	}

	public void sortStudentByName() {
		this.listPerson.sortStudentByName();
	}
}
