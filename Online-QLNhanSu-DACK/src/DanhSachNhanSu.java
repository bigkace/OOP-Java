import java.util.ArrayList;
import java.util.Scanner;

/*
 * Mục đích: Xử lý nghiệp vụ liên quan đến danh sách nhân sự
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 27/12/2021
 * Version: 1.0
 * */

public class DanhSachNhanSu {

	// 1. Attributes
	private ArrayList<NhanSu> listNhanSu;

	// 2. Get, set methods
	public ArrayList<NhanSu> getListNhanSu() {
		return listNhanSu;
	}

	public void setListNhanSu(ArrayList<NhanSu> listNhanSu) {
		this.listNhanSu = listNhanSu;
	}

	// 3. Constructor methods
	public DanhSachNhanSu() {
		this.listNhanSu = new ArrayList<NhanSu>();
	}

	// 4. Input, output methods
	public ArrayList<NhanVienThuong> nhap(Scanner scan) {
		boolean flag = true;
		ArrayList<NhanVienThuong> listNVTMoi = new ArrayList<NhanVienThuong>();
		NhanSu nhanSu;
		do {
			System.out.println("========= Nhập nhân sự mới =========");
			System.out.println("|| Nhập 1. Nhập nhân viên thường  ||");
			System.out.println("|| Nhập 2. Nhập trưởng phòng      ||");
			System.out.println("|| Nhập 3. Nhập giám đốc          ||");
			System.out.println("|| Nhập 0. Thoát nhập             ||");
			System.out.println("====================================");
			System.out.print("Lựa chọn >> ");
			int luaChon = Integer.parseInt(scan.nextLine());
			switch (luaChon) {
			case 1:
				nhanSu = new NhanVienThuong();
				nhanSu.nhap(scan);
				this.listNhanSu.add(nhanSu);
				listNVTMoi.add((NhanVienThuong) nhanSu);
				break;
			case 2:
				nhanSu = new TruongPhong();
				nhanSu.nhap(scan);
				this.listNhanSu.add(nhanSu);
				break;
			case 3:
				nhanSu = new GiamDoc();
				nhanSu.nhap(scan);
				this.listNhanSu.add(nhanSu);
				break;
			case 0:
				flag = false;
				break;
			default:
				System.out.println("Lựa chọn bạn nhập không hợp lệ! Hãy nhập lại!");
				break;
			}
		} while (flag);
		return listNVTMoi;
	}
	
	public void xuat() {
		for (NhanSu ns : this.listNhanSu) {
			ns.xuat();
		}
	}

	// 5. Business methods
	public void tinhLuong() {
		for (NhanSu ns : this.listNhanSu) {
			ns.tinhLuong();
		}
	}
	
	public void themNhanSu(NhanSu ns) {
		this.listNhanSu.add(ns);
	}
	
	public void xoaNhanSu(NhanSu ns) {
		this.listNhanSu.remove(ns);
	}

}
