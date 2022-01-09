import java.util.Scanner;

/*
 * Mục đích: Xử lý nghiệp vụ liên quan đến lớp Employee
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 26/12/2021
 * Version: 1.0
 * */

public class Employee extends Person{
	
	//1. Attributes
	private int soNgayLamViec;
	private float luongTheoNgay;
	
	//2. Get, set methods
	public int getSoNgayLamViec() {
		return soNgayLamViec;
	}

	public void setSoNgayLamViec(int soNgayLamViec) {
		this.soNgayLamViec = soNgayLamViec;
	}

	public float getLuongTheoNgay() {
		return luongTheoNgay;
	}

	public void setLuongTheoNgay(float luongTheoNgay) {
		this.luongTheoNgay = luongTheoNgay;
	}
	
	//3. Constructor methods
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String hoTen, String diaChi, String ma, String email, int soNgayLamViec, float luongTheoNgay) {
		super(hoTen, diaChi, ma, email);
		this.soNgayLamViec = soNgayLamViec;
		this.luongTheoNgay = luongTheoNgay;
	}
	
	//4. Input, output methods
	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);
		
		System.out.print("Nhập số ngày làm việc: ");
		this.soNgayLamViec = Integer.parseInt(scan.nextLine());
		
		System.out.print("Nhập lương theo ngày: ");
		this.luongTheoNgay = Float.parseFloat(scan.nextLine());
	}
	
	@Override
	public void xuat() {
		super.xuat();
		System.out.println("\tSố ngày làm việc: " + this.soNgayLamViec
				+ "\tLương theo ngày: " + this.luongTheoNgay);
	}
	
	//5. Business methods


}
