import java.util.Scanner;

/*
 * Mục đích: Xử lí các nghiệp vụ liên quan đến lớp cha NhanSu
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 27/12/2021
 * Version: 1.0
 * */

public class NhanSu {
	
	//1. Attributes
	protected String maSo;
	protected String hoTen;
	protected String soDienThoai;
	protected int soNgayLamViec;
	protected float luong;
	
	//2. Get, set methods
	public String getMaSo() {
		return maSo;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public int getSoNgayLamViec() {
		return soNgayLamViec;
	}

	public void setSoNgayLamViec(int soNgayLamViec) {
		this.soNgayLamViec = soNgayLamViec;
	}

	public float getLuong() {
		return luong;
	}
	
	//3. Constructor methods
	public NhanSu() {
		// TODO Auto-generated constructor stub
	}
	
	public NhanSu(String maSo, String hoTen, String soDienThoai, int soNgayLamViec) {
		this.maSo = maSo;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.soNgayLamViec = soNgayLamViec;
	}
	
	
	//4. Input, output methods
	public void nhap(Scanner scan) {
		System.out.print("Nhập mã số: ");
		this.maSo = scan.nextLine();
		
		System.out.print("Nhập họ tên: ");
		this.hoTen = scan.nextLine();
		
		System.out.print("Nhập số điện thoại: ");
		this.soDienThoai = scan.nextLine();
		
		System.out.print("Nhập số ngày làm việc: ");
		this.soNgayLamViec = Integer.parseInt(scan.nextLine());
	}
	
	public void xuat() {
		System.out.print("Mã số: " + this.maSo
				+ "\tHọ tên: " + this.hoTen
				+ "\tSố điện thoại: " + this.soDienThoai
				+ "\tSố ngày làm việc: " + this.soNgayLamViec);
	}
	
	public void xuatMaVaTen() {
		System.out.print("Mã số: " + this.maSo
				+ "\tHọ tên: " + this.hoTen);
	}
	
	//5. Business methods
	public void tinhLuong() {
		this.luong = 0;
	}

}
