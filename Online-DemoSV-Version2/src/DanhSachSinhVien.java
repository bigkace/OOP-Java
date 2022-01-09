import java.util.ArrayList;
import java.util.Scanner;

/*
 * Mục đích: Quản lí danh sách sinh viên
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 13/12/2021
 * Version: 1.0
 * */

public class DanhSachSinhVien {
	
	//1. Attributes
	private ArrayList<SinhVien> listSV;
	
	
	//2. Get, set methods
	public ArrayList<SinhVien> getListSV() {
		return listSV;
	}


	public void setListSV(ArrayList<SinhVien> listSV) {
		this.listSV = listSV;
	}

	//3. Constructors methods
	public DanhSachSinhVien() {
		thietLapDefault();
	}
	
	private void thietLapDefault() {
		this.listSV = new ArrayList<SinhVien>();
	}
	
	//4. Input, output methods
	public void nhap(Scanner scan) {
		for (SinhVien sv: this.listSV) {
			sv.nhap(scan);
		}
	}
	
	public void themSinhVien(SinhVien sv) {
		this.listSV.add(sv);
	}
	
	public void xuat() {
		for (SinhVien sv: this.listSV) {
			sv.xuat();
		}
	}
	
	//5. Business methods
	public void tinhDiemTB() {
		for (SinhVien sv: this.listSV) {
			sv.tinhDiemTB();
		}
	}
	
	public void xepLoai() {
		for (SinhVien sv: this.listSV) {
			sv.xepLoai();
		}
	}

}
