import java.util.Scanner;

/*
 * Mục đích: Xử lý các nghiệp vụ liên quan đến lớp Trưởng Phòng
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 27/12/2021
 * Version: 1.0
 * */

public class TruongPhong extends NhanSu{
	
	//Constants
	final static int LUONG_NGAY = 200;
	final static int PHU_CAP_MOI_NV_QLY = 100;
	
	//1. Attributes
	private int soLuongNVDuoiQuyen;
	
	//2. Get, set methods
	public int getSoLuongNVDuoiQuyen() {
		return soLuongNVDuoiQuyen;
	}
	
	public void setSoLuongNVDuoiQuyen(int soLuongNVDuoiQuyen) {
		this.soLuongNVDuoiQuyen = soLuongNVDuoiQuyen;
	}
		
	//3. Constructor methods
	public TruongPhong() {
		// TODO Auto-generated constructor stub
	}
	
	public TruongPhong(String maSo, String hoTen, String soDienThoai, int soNgayLamViec) {
		super(maSo, hoTen, soDienThoai, soNgayLamViec);
//		this.soLuongNVDuoiQuyen = soLuongNVDuoiQuyen;
	}
		
	//4. Input, ouput methods
	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);
		
		System.out.print("Nhập số lượng nhân viên dưới quyền: ");
		this.soLuongNVDuoiQuyen = Integer.parseInt(scan.nextLine());
	}
	
	@Override
	public void xuat() {
		super.xuat();
		System.out.println("\tSố lượng nhân viên dưới quyền: " + this.soLuongNVDuoiQuyen
				+ "\tLương: " + this.luong);
	}
	
	//5. Business methods
	@Override
	public void tinhLuong() {
		this.luong = LUONG_NGAY * this.soNgayLamViec + PHU_CAP_MOI_NV_QLY * this.soLuongNVDuoiQuyen;
	}
	
	public void tangNVDuoiQuyen() {
		this.soLuongNVDuoiQuyen++;
	}
	
	public void giamNVDuoiQuyen() {
		this.soLuongNVDuoiQuyen--;
	}

}
