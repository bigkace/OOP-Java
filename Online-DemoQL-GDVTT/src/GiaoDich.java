import java.util.Scanner;

/*
 * Mục đích: Xử lý các nghiệp vụ liên quan đến giao dịch
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 25/12/2021
 * Version: 1.0
 * */

public class GiaoDich {
	
	//1. Attributes
	protected String maGiaoDich;
	protected int ngayGiaoDich;
	protected int thangGiaoDich;
	protected int namGiaoDich;
	protected float donGia;
	protected int soLuong;
	protected double thanhTien;
	
	//2. Get, set methods
	public String getMaGiaoDich() {
		return maGiaoDich;
	}
	
	public void setMaGiaoDich(String maGiaoDich) {
		this.maGiaoDich = maGiaoDich;
	}
	
	public int getNgayGiaoDich() {
		return ngayGiaoDich;
	}
	
	public void setNgayGiaoDich(int ngayGiaoDich) {
		this.ngayGiaoDich = ngayGiaoDich;
	}
	
	public int getThangGiaoDich() {
		return thangGiaoDich;
	}
	
	public void setThangGiaoDich(int thangGiaoDich) {
		this.thangGiaoDich = thangGiaoDich;
	}
	
	public int getNamGiaoDich() {
		return namGiaoDich;
	}
	
	public void setNamGiaoDich(int namGiaoDich) {
		this.namGiaoDich = namGiaoDich;
	}
	
	public float getDonGia() {
		return donGia;
	}
	
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	
	public int getSoLuong() {
		return soLuong;
	}
	
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	public double getThanhTien() {
		return thanhTien;
	}
		
	//3. Constructor methods
	public GiaoDich() {
		// TODO Auto-generated constructor stub
	}
	
	public GiaoDich(String maGiaoDich, int ngayGiaoDich, int thangGiaoDich, int namGiaoDich, float donGia,
			int soLuong) {
		super();
		this.maGiaoDich = maGiaoDich;
		this.ngayGiaoDich = ngayGiaoDich;
		this.thangGiaoDich = thangGiaoDich;
		this.namGiaoDich = namGiaoDich;
		this.donGia = donGia;
		this.soLuong = soLuong;
	}
		
	//4. Input, output methods
	public void nhap(Scanner scan) {
		System.out.print("Nhập mã giao dịch: ");
		this.maGiaoDich = scan.nextLine();
		
		System.out.print("Nhập ngày giao dịch: ");
		this.ngayGiaoDich = Integer.parseInt(scan.nextLine());
		
		System.out.print("Nhập tháng giao dịch: ");
		this.thangGiaoDich = Integer.parseInt(scan.nextLine());
		
		System.out.print("Nhập năm giao dịch: ");
		this.namGiaoDich = Integer.parseInt(scan.nextLine());
		
		System.out.print("Nhập đơn giá: ");
		this.donGia = Float.parseFloat(scan.nextLine());
		
		System.out.print("Nhập số lượng: ");
		this.soLuong = Integer.parseInt(scan.nextLine());
	}
	
	public void xuat() {
		System.out.print("Mã GD: " + this.maGiaoDich
				+ "\tNgày GD: " + this.ngayGiaoDich + "/" + this.thangGiaoDich + "/" + this.namGiaoDich
				+ "\tĐơn giá: " + this.donGia
				+ "\tSố lượng: " + this.soLuong);
	}
	
	//5. Business methods
	public void tinhThanhTien() {
		this.thanhTien = 0;
	}


}
