import java.util.Scanner;

/*
 * Mục đích: Quản lí nghiệp vụ liên quan đến chuyến xe nội thành
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 21/12/2021
 * Version: 1.0
 * */

public class ChuyenXeNoiThanh extends ChuyenXe{
	
	//1. Attributes
	private String soTuyen;
	private float soKMDiDuoc;
	
	//2. Get, set methods
	public String getSoTuyen() {
		return soTuyen;
	}
	
	public void setSoTuyen(String soTuyen) {
		this.soTuyen = soTuyen;
	}
	
	public float getSoKMDiDuoc() {
		return soKMDiDuoc;
	}
	
	public void setSoKMDiDuoc(float soKMDiDuoc) {
		this.soKMDiDuoc = soKMDiDuoc;
	}
	
	//3. Constructor methods
	public ChuyenXeNoiThanh() {
		super();
	}
	
	public ChuyenXeNoiThanh(String maSoChuyen, String hoTenTaiXe, String soXe, float doanhThu, String soTuyen, float soKMDiDuoc) {
		super(maSoChuyen, hoTenTaiXe, soXe, doanhThu);
		this.soTuyen = soTuyen;
		this.soKMDiDuoc = soKMDiDuoc;
	}
		
	//4. Input, output methods
	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);
		
		System.out.println("Nhập số tuyến: ");
		this.soTuyen = scan.nextLine();
		
		System.out.println("Nhập số km đi được: ");
		this.soKMDiDuoc = Float.parseFloat(scan.nextLine());
	}
	
	@Override
	public void xuat() {
		super.xuat();
		System.out.println("\tSố tuyến: " + this.soTuyen
				           + "\tSố km đi được: " + this.soKMDiDuoc);
	}
	
	//5. Business methods
	


}
