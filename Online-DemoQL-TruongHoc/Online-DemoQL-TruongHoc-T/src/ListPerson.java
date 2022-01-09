
/*
 * Purpose: Manage list teachers and students
 * Author: Vu The Quan
 * Date: 11/07/2020
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ListPerson implements InOut {
	// 1. Fields
	ArrayList<Person> listPerson;

	// 2. Getters, setters
	/**
	 * @return the listPerson
	 */
	public synchronized ArrayList<Person> getListPerson() {
		return listPerson;
	}

	/**
	 * @param listPerson the listPerson to set
	 */
	public synchronized void setListPerson(ArrayList<Person> listPerson) {
		this.listPerson = listPerson;
	}

	// 3. Constructors
	public ListPerson() {
		this.listPerson = new ArrayList<Person>();
	}

	// 4. Input, output methods
	@Override
	public void input(Scanner scan) {
		Person obj = null;
		System.out.println("============================ INPUT INFO ============================");
		boolean flag = true;
		do {
			System.out.println("Choose '1' to input a Teacher, '2' to input a Student, '0 to exit.'");
			System.out.print("Please choose >>> ");
			int choose = Integer.parseInt(scan.nextLine());
			switch(choose) {
			case 1:{
				obj = new Teacher();
				obj.input(scan);
				((Teacher)obj).countTeachingYear();
				this.listPerson.add(obj);
				break;
			}
			case 2: {
				obj = new Student();
				obj.input(scan);
				((Student)obj).computeAverage();
				((Student)obj).evaluateStudent();
				this.listPerson.add(obj);
				break;
			}
			case 0:{
				flag = false;
				break;
			}
			default: {
				System.out.println("Plesase choose only 1, 2 or 0!");
				break;
			}
			}
		} while(flag);
		System.out.println("================================ END ===============================");
		System.out.println();
	}

	@Override
	public void output() {
		evaluateAll();
		System.out.println("============================ TEACHERS & STUDENTS ============================");
		for (Person obj : this.listPerson) {
			obj.output();
		}
		System.out.println("===================================== END ===================================");
		System.out.println();
	}

	public void createDataTeacher() {
		try {
			// Create reader object
			FileReader reader = new FileReader("src/ListTeacher.txt");

			// Create buffered reader object
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line;

			// Read each line
			while ((line = bufferedReader.readLine()) != null) {
				// System.out.println(line);
				String[] listInfo = line.split(" # ");
				Person person = new Teacher(listInfo[0], Integer.parseInt(listInfo[1]), listInfo[2], listInfo[3],
						Integer.parseInt(listInfo[4]), listInfo[5]);

				// Add to list
				this.listPerson.add(person);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createDataStudent() {
		try {
			// Create reader object
			FileReader reader = new FileReader("src/ListStudent.txt");

			// Create buffered reader object
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line;

			// Read each line
			while ((line = bufferedReader.readLine()) != null) {
				// System.out.println(line);
				String[] listInfo = line.split(" # ");
				Person person = new Student(listInfo[0], Integer.parseInt(listInfo[1]), listInfo[2], listInfo[3],
						Float.parseFloat(listInfo[4]), Float.parseFloat(listInfo[5]), Float.parseFloat(listInfo[6]));

				// Add to list
				this.listPerson.add(person);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 5. Business methods
	public void computeAverageAll() {
		for (Person student : this.listPerson) {
			if (student instanceof Student) {
				((Student) student).computeAverage();
			}
		}
	}

	public void evaluateAll() {
		for (Person student : this.listPerson) {
			if (student instanceof Student) {
				((Student) student).evaluateStudent();
			}
		}
	}

	public void countTeachingYearAll() {
		for (Person teacher : this.listPerson) {
			if (teacher instanceof Teacher) {
				((Teacher) teacher).countTeachingYear();
			}
		}
	}

	public ArrayList<Teacher> takeListTeacher() {
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		for (Person obj : this.listPerson) {
			if (obj instanceof Teacher)
				list.add((Teacher) obj);
		}
		return list;
	}

	public void findMaxTeachingYearTeacher() {
		ArrayList<Teacher> listTeacher = takeListTeacher();
		Teacher maxTeachingYearTeacher = listTeacher.get(0);
		for (Teacher current : listTeacher) {
			if (current.getTeachingYear() > maxTeachingYearTeacher.getTeachingYear()) {
				maxTeachingYearTeacher = current;
			}
		}
		System.out.println("================= Maximum teaching years Teacher =================");
		for (Teacher current : listTeacher) {
			if (current.getTeachingYear() == maxTeachingYearTeacher.getTeachingYear())
				current.output();
		}
		System.out.println("============================== END ===============================");
		System.out.println();
	}

	public void findNatural5YearsTeacher() {
		System.out.println("================= Natural teachers have more than 5 teaching years =================");
		for (Person obj : this.listPerson) {
			if (obj instanceof Teacher) {
				if (((Teacher) obj).getSpecialize().equalsIgnoreCase("Natural")) {
					if (((Teacher) obj).getTeachingYear() > 5) {
						obj.output();
					}
				}
			}
		}
		System.out.println("====================================== END ========================================");
		System.out.println();
	}

	public float findMaxAverage() {
		Student maxAverage = null;
		// Find the first student
		maxAverage = findTheFirstStudent();

		// Find max average student
		for (Person obj : this.listPerson) {
			if (obj instanceof Student && ((Student) obj).getAverage() > maxAverage.getAverage()) {
				maxAverage = (Student) obj;
			}
		}
		if (maxAverage != null)
			return maxAverage.getAverage();
		else
			return 0;
	}

	private Student findTheFirstStudent() {
		Student firstStudent = null;
		for (Person obj : this.listPerson) {
			if (obj instanceof Student) {
				firstStudent = (Student) obj;
				break;
			}
		}
		return firstStudent;
	}

	public void findMaxAverageStudent() {
		float maxAverage = findMaxAverage();
		if (maxAverage > 0) {
			System.out.println("================= Max average students =================");
			for (Person obj : this.listPerson) {
				if (obj instanceof Student) {
					if (((Student) obj).getAverage() == maxAverage) {
						obj.output();
					}
				}
			}
			System.out.println("========================= END ==========================");
			System.out.println();
		} else
			System.out.println("There isn't any student in list.");
	}

	public void quickSort(ArrayList<Student> list, int left, int right) {
		Student pivot = list.get((left + right) / 2);
		int i = left, j = right;
		do { // divide array
			while (list.get(i).getAverage() > pivot.getAverage())
				++i;
			while (list.get(j).getAverage() < pivot.getAverage())
				--j;
			if (i <= j) {
				Collections.swap(list, i, j);
				++i;
				--j;
			}
		} while (i < j);
		if (left < j)
			quickSort(list, left, j);
		if (right > i)
			quickSort(list, i, right);
	}

	public ArrayList<Student> takeListStudent() {
		ArrayList<Student> list = new ArrayList<Student>();
		for (Person obj : this.listPerson) {
			if (obj instanceof Student)
				list.add((Student) obj);
		}
		return list;
	}

	public void printStudentHelper(ArrayList<Student> list) {
		for (Person obj : list) {
			obj.output();
		}
	}

	public void sortStudentByAverage() {
		ArrayList<Student> listStudent = takeListStudent();
		quickSort(listStudent, 0, listStudent.size() - 1);
		System.out.println("================= List students sorted by descending average =================");
		printStudentHelper(listStudent);
		System.out.println("===================================== END ====================================");
		System.out.println();

	}

	public void bubbleSort(ArrayList<Student> list) {
		int i, j;
		for (i = 0; i < list.size(); ++i) {
			for (j = list.size() - 1; j > i; --j) {
				if (list.get(j).getName().compareToIgnoreCase(list.get(j - 1).getName()) < 0) {
					Collections.swap(list, j, j - 1);
				}
			}
		}
	}

	public void sortStudentByName() {
		ArrayList<Student> listStudent = takeListStudent();
		bubbleSort(listStudent);
		System.out.println("================= List students sorted by name =================");
		printStudentHelper(listStudent);
		System.out.println("=============================== END =============================");
		System.out.println();

	}

	public void updatePerson(Person obj, Scanner scan) {
		System.out.println("Choose '1' to update, '2' to skip");
		System.out.print("Please chooose >>> ");
		int choose = Integer.parseInt(scan.nextLine());
		switch (choose) {
		case 1: {
			obj.update(scan);
			break;
		}
		case 2: {
			break;
		}
		default: {
			System.out.println("Please choose only 1 or 2");
			break;
		}
		}
	}

	public void update(Scanner scan) {
		boolean flag = true;
		String name;
		int birthYear;
		System.out.println("==================== UPDATE INFO ====================");
		do {
			System.out.println("Choose '1' to update, '0' to exit");
			System.out.print("Please choose >>> ");
			int choose = Integer.parseInt(scan.nextLine());
			switch (choose) {
			case 1: {
				System.out.print("Please input name: ");
				name = scan.nextLine();
				System.out.print("Please input birth year: ");
				birthYear = Integer.parseInt(scan.nextLine());
				for (Person obj : this.listPerson) {
					if (obj.getName().equalsIgnoreCase(name) && obj.getBirth() == birthYear) {
						System.out.println("*************** Processing **************");
						obj.output();
						updatePerson(obj, scan);
					}
				}
				break;
			}
			case 0: {
				flag = false;
				break;
			}
			default: {
				System.out.println("Please choose only '1' or '0'");
			}
			}

		} while (flag);
		System.out.println("======================== END ========================");
		System.out.println();
	}

}
