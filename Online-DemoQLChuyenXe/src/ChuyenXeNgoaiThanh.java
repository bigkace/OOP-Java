import java.util.Scanner;

/*
 * Mục đích: Quản lí nghiệp vụ liên quan đến chuyến xe ngoại thành
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 21/12/2021
 * Version: 1.0
 * */

public class ChuyenXeNgoaiThanh extends ChuyenXe{
	
	//1. Attributes
	private String noiDen;
	private int soNgayDiDuoc;
	
	//2. Get, set methods
	public String getNoiDen() {
		return noiDen;
	}
	
	public void setNoiDen(String noiDen) {
		this.noiDen = noiDen;
	}
	
	public int getSoNgayDiDuoc() {
		return soNgayDiDuoc;
	}
	
	public void setSoNgayDiDuoc(int soNgayDiDuoc) {
		this.soNgayDiDuoc = soNgayDiDuoc;
	}
	
	//3. Constructor methods
	public ChuyenXeNgoaiThanh() {
		super();
	}
	
	public ChuyenXeNgoaiThanh(String maSoChuyen, String hoTenTaiXe, String soXe, float doanhThu, String noiDen, int soNgayDiDuoc) {
		super(maSoChuyen, hoTenTaiXe, soXe, doanhThu);
		this.noiDen = noiDen;
		this.soNgayDiDuoc = soNgayDiDuoc;
	}
	
	//4. Input, output methods
	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);
		
		System.out.println("Nhập nơi đến: ");
		this.noiDen = scan.nextLine();
		
		System.out.println("Nhập số ngày đi được: ");
		this.soNgayDiDuoc = Integer.parseInt(scan.nextLine());
	}
	
	@Override
	public void xuat() {
		super.xuat();
		System.out.println("\tNơi đến: " + this.noiDen
				          + "\tSố ngày đi được: " + this.soNgayDiDuoc);
	}
	
	//5. Business methods
	


}
