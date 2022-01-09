import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * Mục đích: Xử lý nghiệp vụ liên quan đến danh sách Person
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 26/12/2021
 * Version: 1.0
 * */
public class ListPerson {
	
	//1. Attributes
	private ArrayList<Person> list;
	
	//2. Get, set methods
	public ArrayList<Person> getList() {
		return list;
	}
	
	public void setList(ArrayList<Person> list) {
		this.list = list;
	}
		
	//3. Constructor methods
	public ListPerson() {
		this.list = new ArrayList<Person>();
	}
	
	//4. Input, output methods
	public void nhap(Scanner scan) {
		boolean flag = true;
		Person obj;
		do {
			System.out.println("Nhập 1. Nhập sinh viên");
			System.out.println("Nhập 2. Nhập nhân viên");
			System.out.println("Nhập 3. Nhập khách hàng");
			System.out.println("Nhập 0. Thoát nhập");
			int luaChon = Integer.parseInt(scan.nextLine());
			switch (luaChon) {
			case 1:
				obj = new Student();
				obj.nhap(scan);
				this.list.add(obj);
				break;
			case 2:
				obj = new Employee();
				obj.nhap(scan);
				this.list.add(obj);
				break;
			case 3:
				obj = new Customer();
				obj.nhap(scan);
				this.list.add(obj);
				break;
			case 0:
				flag = false;
				break;
			default:
				System.out.println("Lựa chọn bạn nhập không hợp lệ! Hãy nhập lại!");
				break;
			}
		} while (flag);
	}
	
	public void dummyData() {
		Person obj;
		
		obj = new Student("bưởi", "Hà Nội", "S-01", "buoi@gmail.com", 7.8f, 9.2f, 8);
		this.list.add(obj);
		
		obj = new Employee("táo", "Nam Định", "E-01", "tao@gmail.com", 28, 1250);
		this.list.add(obj);
		
		obj = new Customer("bưởi", "Hải Dương", "C-01", "buoi_1@gmail.com", "SS", 42500, "Tốt");
		this.list.add(obj);
		
		obj = new Student("cam", "Hải Phòng", "S-02", "camd@gmail.com", 8.2f, 9, 7.5f);
		this.list.add(obj);
		
		obj = new Employee("mận", "Vĩnh Phúc", "E-02", "man@gmail.com", 28, 2250);
		this.list.add(obj);
		
		obj = new Customer("chuối", "Thanh Hoá", "C-02", "chuoi@gmail.com", "AP", 55000, "Tốt");
		this.list.add(obj);
		
		obj = new Student("chanh", "Nam Định", "S-03", "chanh@gmail.com", 10, 8.6f, 9.1f);
		this.list.add(obj);
		
		obj = new Employee("quất", "Hà Nội", "E-03", "quat@gmail.com", 27, 2500);
		this.list.add(obj);
		
		obj = new Customer("khế", "Hà Nội", "C-03", "khe@gmail.com", "FPT", 35000, "Tốt");
		this.list.add(obj);
	}
	
	public void xuat(ArrayList<Person> list) {
		for (Person obj : list) {
			obj.xuat();
		}
	}
	
	//5. Business methods
	public void xoaNhanVienTheoMa(Scanner scan) {
		System.out.print("Nhập mã cần xoá: ");
		String maCanXoa = scan.nextLine();
		for (Person obj : this.list) {
			if (obj.getMa().equalsIgnoreCase(maCanXoa)) {
				this.list.remove(obj);
				break;
			}
		}
	}
	
	private void interchangeSort(ArrayList<Person> objList) {
		for (int i = 0; i < objList.size() - 1; i++) {
			for (int j = i + 1; j < objList.size(); j++) {
				Person personI = objList.get(i);
				Person personII = objList.get(j);
				if (personII.getHoTen().compareToIgnoreCase(personI.getHoTen()) < 0) {
					Collections.swap(objList, i, j);
				}
						
			}
		}
	}
	
	public void sortName() {
		interchangeSort(this.list);
	}
	
}
