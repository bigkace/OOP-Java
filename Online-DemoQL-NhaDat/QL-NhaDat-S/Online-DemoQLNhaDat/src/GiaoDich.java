import java.util.Scanner;

/*
 *Mục đích: Xử lý nghiệp vụ liên quan đến giao dịch
 *Người tạo: Vũ Nam Khánh
 *Ngày tạo: 23/12/2021
 *Version: 1.0 
 * */

public class GiaoDich extends NgayThangNam{
	
	//1. Attributes
	protected String maGiaoDich;
	protected float donGia;
	protected float dienTich;
	protected double thanhTien;
	
	//2. Get, set methods
	public String getMaGiaoDich() {
		return maGiaoDich;
	}
	
	public void setMaGiaoDich(String maGiaoDich) {
		this.maGiaoDich = maGiaoDich;
	}
	
	public float getDonGia() {
		return donGia;
	}
	
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	
	public float getDienTich() {
		return dienTich;
	}
	
	public void setDienTich(float dienTich) {
		this.dienTich = dienTich;
	}
	
	public double getThanhTien() {
		return thanhTien;
	}
		
	//3. Constructor methods
	public GiaoDich() {
		super();
	}
	
	public GiaoDich(String maGiaoDich, int ngay, int thang, int nam, float donGia, float dienTich) {
		super(ngay, thang, nam);
		this.maGiaoDich = maGiaoDich;
		this.donGia = donGia;
		this.dienTich = dienTich;
	}
		
	//4. Input, output methods
	@Override
	public void nhap(Scanner scan) {
		System.out.print("Nhập mã giao dịch: ");
		this.maGiaoDich = scan.nextLine();
		
		super.nhap(scan);
		
		System.out.print("Nhập đơn giá: ");
		this.donGia = Float.parseFloat(scan.nextLine());
		
		System.out.print("Nhập diện tích: ");
		this.dienTich = Float.parseFloat(scan.nextLine());
	}
	
	@Override
	public void xuat() {
		System.out.print("Mã GD: " + getMaGiaoDich() + "\tNgày GD: ");
		super.xuat();
		System.out.print("\tĐơn giá: " + getDonGia() + "\tDiện tích: " + getDienTich());
	}
	
	//5. Business methods
	public void tinhThanhTien() {
		this.thanhTien = 0;
	}


}
