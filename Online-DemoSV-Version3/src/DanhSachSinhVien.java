import java.util.ArrayList;
import java.util.Scanner;

/*
 * Mục đích: Quản lí danh sách sinh viên
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 13/12/2021
 * Version: 1.0
 * */

public class DanhSachSinhVien {

	// 1. Attributes
	private ArrayList<SinhVien> listSV;

	// 2. Get, set methods
	public ArrayList<SinhVien> getListSV() {
		return listSV;
	}

	public void setListSV(ArrayList<SinhVien> listSV) {
		this.listSV = listSV;
	}

	// 3. Constructors methods
	public DanhSachSinhVien() {
		thietLapDefault();
	}

	private void thietLapDefault() {
		this.listSV = new ArrayList<SinhVien>();
	}

	// 4. Input, output methods
	public void nhap(Scanner scan) {
		for (SinhVien sv : this.listSV) {
			sv.nhap(scan);
		}
	}

	public void themSinhVien(SinhVien sv) {
		this.listSV.add(sv);
	}

	public void xuat() {
		for (SinhVien sv : this.listSV) {
			sv.xuat();
		}
	}

	// 5. Business methods
	public void tinhDiemTB() {
		for (SinhVien sv : this.listSV) {
			sv.tinhDiemTB();
		}
	}

	public void xepLoai() {
		for (SinhVien sv : this.listSV) {
			sv.xepLoai();
		}
	}

	public ArrayList<SinhVien> timDSSVCoDTBCaoNhat() {
		
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();

		if (this.listSV.size() > 0) {

			SinhVien svMax = this.listSV.get(0);
			int viTriMaxDauTien = 0;
			for (int i = 0; i < this.listSV.size(); i++) {
				SinhVien svCurrent = this.listSV.get(i);
				if (svCurrent.getDiemTB() > svMax.getDiemTB()) {
					svMax = svCurrent;
					viTriMaxDauTien = i;
				}
			}

			// Thêm svMax vào list
			list.add(svMax);

			for (int i = viTriMaxDauTien + 1; i < this.listSV.size(); i++) {
				SinhVien svCurrent = this.listSV.get(i);
				if (svCurrent.getDiemTB() == svMax.getDiemTB()) {
					list.add(svCurrent);
				}
			}

		}

		return list;
	}
	
	public ArrayList<SinhVien> timDSSVYeu() {
		
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		
		for (SinhVien sv : this.listSV) {
			if(sv.getDiemTB() < 5) {
				list.add(sv);
			}
		}
		
		return list;
		
	}
	
	public SinhVien timSVTheoMa(int maSV) {
		SinhVien sv = null;
		for (SinhVien sv1 : this.listSV) {
			if(sv1.getMaSV() == maSV) {
				sv = sv1;
				break;
			}
		}
		return sv;
	}
	
	public boolean xoaSVTheoMa(int maSV) {
		boolean xoa = false;
		for (SinhVien sv : this.listSV) {
			if(sv.getMaSV() == maSV) {
				this.listSV.remove(sv);
				xoa = true;
				break;
			}
		}
		return xoa;
	}

}
