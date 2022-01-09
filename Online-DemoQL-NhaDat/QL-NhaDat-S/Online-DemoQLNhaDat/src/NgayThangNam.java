import java.util.Scanner;

/*
 * Mục đích: Xử lý nhập ngày tháng năm
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 23/12/2021
 * Version: 1.0
 * */

public class NgayThangNam {
	
	//1. Attributes
	protected int ngay;
	protected int thang;
	protected int nam;
	
	//2. Get, set methods
	public int getNgay() {
		return ngay;
	}
	
	public void setNgay(int ngay) {
		this.ngay = ngay;
	}
	
	public int getThang() {
		return thang;
	}
	
	public void setThang(int thang) {
		this.thang = thang;
	}
	
	public int getNam() {
		return nam;
	}
	
	public void setNam(int nam) {
		this.nam = nam;
	}
	
	//3. Constructor methods
	public NgayThangNam() {
		
	}
	
	public NgayThangNam(int ngay, int thang, int nam) {
		this.ngay = ngay;
		this.thang = thang;
		this.nam = nam;
	}
	
	//4. Input, output methods
	public void nhap(Scanner scan) {
		System.out.print("Nhập ngày giao dịch: ");
		this.ngay = Integer.parseInt(scan.nextLine());
		
		System.out.print("Nhập tháng giao dịch: ");
		this.thang = Integer.parseInt(scan.nextLine());
		
		System.out.print("Nhập năm giao dịch: ");
		this.nam = Integer.parseInt(scan.nextLine());
	}
	
	public void xuat() {
		System.out.print(getNgay() + "/" + getThang() + "/" + getNam());
	}
	
	//5. Business methods
	


}
