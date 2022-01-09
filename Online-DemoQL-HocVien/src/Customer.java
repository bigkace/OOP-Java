import java.util.Scanner;

/*
 * Mục đích: Xử lý nghiệp vụ liên quan đến lớp Customer
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 26/12/2021
 * Version: 1.0
 * */

public class Customer extends Person{
	
	//1. Attributes
	private String tenCongTy;
	private double triGiaHoaDon;
	private String danhGia;
	
	//2. Get, set methods
	public String getTenCongTy() {
		return tenCongTy;
	}
	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;
	}
	public double getTriGiaHoaDon() {
		return triGiaHoaDon;
	}
	public void setTriGiaHoaDon(double triGiaHoaDon) {
		this.triGiaHoaDon = triGiaHoaDon;
	}
	public String getDanhGia() {
		return danhGia;
	}
	public void setDanhGia(String danhGia) {
		this.danhGia = danhGia;
	}
	
	//3. Constructor methods
	public Customer() {
		
	}
	
	public Customer(String hoTen, String diaChi, String ma, String email, String tenCongTy, double triGiaHoaDon, String danhGia) {
		super(hoTen, diaChi, ma, email);
		this.tenCongTy = tenCongTy;
		this.triGiaHoaDon = triGiaHoaDon;
		this.danhGia = danhGia;
	}
	
	//4. Input, ouput methods
	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);
		
		System.out.print("Nhập tên công ty: ");
		this.tenCongTy = scan.nextLine();
		
		System.out.print("Nhập trị giá hoá đơn: ");
		this.triGiaHoaDon = Double.parseDouble(scan.nextLine());
		
		System.out.print("Nhập đánh giá: ");
		this.danhGia = scan.nextLine();
	}
	
	@Override
	public void xuat() {
		super.xuat();
		System.out.println("\tTên công ty: " + this.tenCongTy
				+ "\tTrị giá hoá đơn: " + this.triGiaHoaDon
				+ "\tĐánh giá: " + this.danhGia); 
	}
	
	//5. Business methods

}
