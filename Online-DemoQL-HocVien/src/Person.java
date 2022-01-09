import java.util.Scanner;

/*
 * Mục đích: Xử lý nghiệp vụ liên quan đến lớp cha Person
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 26/12/2021
 * Version: 1.0
 * */

public class Person {

	//1. Attributes
		protected String hoTen;	
		protected String diaChi;	
		protected String ma;	
		protected String email;
		
		//2. Get, set methods
		public String getHoTen() {
			return hoTen;
		}

		public void setHoTen(String hoTen) {
			this.hoTen = hoTen;
		}

		public String getDiaChi() {
			return diaChi;
		}

		public void setDiaChi(String diaChi) {
			this.diaChi = diaChi;
		}

		public String getMa() {
			return ma;
		}

		public void setMa(String ma) {
			this.ma = ma;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
		//3. Constructor methods
		public Person() {
			
		}
		
		public Person(String hoTen, String diaChi, String ma, String email) {
			this.hoTen = hoTen;
			this.diaChi = diaChi;
			this.ma = ma;
			this.email = email;
		}
		
		//4. Input, output methods
		public void nhap(Scanner scan) {
			System.out.print("Nhập họ tên: ");
			this.hoTen = scan.nextLine();
			
			System.out.print("Nhập địa chỉ: ");
			this.diaChi = scan.nextLine();
			
			System.out.print("Nhập mã: ");
			this.ma = scan.nextLine();
			
			System.out.print("Nhập email: ");
			this.email = scan.nextLine();
		}
		
		public void xuat() {
			System.out.print("Họ tên: " + this.hoTen
					+ "\tĐịa chỉ: " + this.diaChi
					+ "\tMã: " + this.ma
					+ "\tEmail: " + this.email);
		}
		
		//5. Business methods

}
