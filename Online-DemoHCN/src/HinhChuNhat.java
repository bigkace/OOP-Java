import java.util.Scanner;

/*
 * Mục đích: Xử lý các nghiệp vụ liên quan đến hình chữ nhật
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 12/12/2021
 * Version: 1.0
 * */

public class HinhChuNhat {
	
	//1. Các thuộc tính
	private float chieuDai;
	private float chieuRong;
	private float chuVi;
	private float dienTich;
	
	//2. Các phương thức get, set
	public float getChieuDai() {
		return this.chieuDai;
	}
	
	public void setChieuDai(float chieuDai) {
		this.chieuDai = chieuDai;
	}
	
	public float getChieuRong() {
		return this.chieuRong;
	}
	
	public void setChieuRong(float chieuRong) {
		this.chieuRong = chieuRong;
	}
	
	public float getChuVi() {
		return this.chuVi;
	}
	
	public float getDienTich() {
		return this.dienTich;
	}
	
	//3. Các phương thức khởi tạo
	public HinhChuNhat() {
		
	}
	
	public HinhChuNhat(float chieuDai, float chieuRong) {
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}
	
	//4. Các phương thức nhập xuất
	public void nhap(Scanner scan) {
		System.out.println("Nhập chiều dài: ");
		this.chieuDai = Float.parseFloat(scan.nextLine());
		
		System.out.println("Nhập chiều rộng: ");
		this.chieuRong = Float.parseFloat(scan.nextLine());
	}
	
	public void xuat() {
		System.out.println("Chu vi = " + this.chuVi);
		System.out.println("Diện tích = " + this.dienTich);
	}
	
	//5. Các phương thức xử lý nghiệp vụ liên quan đến lớp này
	public void tinhChuVi() {
		this.chuVi = (this.chieuDai + this.chieuRong) * 2;
	}
	
	public void tinhDienTich() {
		this.dienTich = this.chieuDai * this.chieuRong;
	}

}
