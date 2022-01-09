import java.util.ArrayList;
import java.util.Collections;

/*
 * Mục đích: Xử lý nghiệp vụ liên quan đến Trường Học
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 2/1/2022
 * Version: 1.0
 * */

public class TruongHoc implements NhapXuat {

	// 1. Attributes
	private DanhSachThanhVien objDSThanhVien;

	// 2. Get, set methods
	public DanhSachThanhVien getObjDSThanhVien() {
		return objDSThanhVien;
	}

	public void setObjDSThanhVien(DanhSachThanhVien objDSThanhVien) {
		this.objDSThanhVien = objDSThanhVien;
	}

	// 3. Constructor methods
	public TruongHoc() {
		this.objDSThanhVien = new DanhSachThanhVien();
	}

	// 4. Input, output methods
	@Override
	public void nhap() {
		this.objDSThanhVien.nhap();
	}

	@Override
	public void xuat() {
		this.objDSThanhVien.xuat();
	}

	// 5. Business methods
	public void taoDuLieu() {
		this.objDSThanhVien.taoDuLieuGiaoVien();
		this.objDSThanhVien.taoDuLieuHocSinh();
	}

	/*
	 * Lấy danh sách Giáo Viên
	 */
	public ArrayList<GiaoVien> layDSGiaoVien() {
		ArrayList<GiaoVien> dsGiaoVien = new ArrayList<GiaoVien>();
		for (ThanhVien tv : this.objDSThanhVien.getDsThanhVien()) {
			if (tv instanceof GiaoVien) {
				dsGiaoVien.add((GiaoVien) tv);
			}
		}
		return dsGiaoVien;
	}

	/*
	 * Tính thâm niên Giáo Viên
	 */
	public void tinhThamNien() {
		ArrayList<GiaoVien> dsGiaoVien = layDSGiaoVien();
		for (GiaoVien gv : dsGiaoVien) {
			gv.tinhThamNien();
		}
		System.out.println("Tính thâm niên thành công!");
	}

	/*
	 * Tìm Giáo Viên có thâm niên cao nhất
	 */
	// Tìm vị trí giáo viên có thâm niên cao nhất đầu tiên
	private int timGVThamNienCaoNhatDauTien() {
		ArrayList<GiaoVien> dsGiaoVien = layDSGiaoVien();
		int indexMax = 0;
		GiaoVien gvMax = dsGiaoVien.get(indexMax);
		for (int i = 1; i < dsGiaoVien.size(); i++) {
			GiaoVien gvCurrent = dsGiaoVien.get(i);
			if (gvCurrent.getThamNien() > gvMax.getThamNien()) {
				indexMax = i;
				gvMax = gvCurrent;
			}
		}
		return indexMax;
	}

	// Các giáo viên có cùng thâm niên cao nhất
	public ArrayList<GiaoVien> timGVThamNienCaoNhat() {
		ArrayList<GiaoVien> ds = new ArrayList<GiaoVien>();
		ArrayList<GiaoVien> dsGiaoVien = layDSGiaoVien();
		int indexMax = timGVThamNienCaoNhatDauTien();
		GiaoVien gvMax = dsGiaoVien.get(indexMax);
		for (int i = indexMax; i < dsGiaoVien.size(); i++) {
			GiaoVien gvCurrent = dsGiaoVien.get(i);
			if (gvCurrent.getThamNien() == gvMax.getThamNien()) {
				ds.add(gvCurrent);
			}
		}
		return ds;
	}

	/*
	 * Tìm Giáo Viên có thâm niên > 5 và thuộc khối tự nhiên
	 */
	public ArrayList<GiaoVien> timGVThamNienLonHon5VaKhoiTN() {
		ArrayList<GiaoVien> ds = new ArrayList<GiaoVien>();
		ArrayList<GiaoVien> dsGiaoVien = layDSGiaoVien();
		for (GiaoVien gv : dsGiaoVien) {
			if (gv.getThamNien() > 5 && gv.getChuyenMon().equalsIgnoreCase("Tự nhiên")) {
				ds.add(gv);
			}
		}
		return ds;
	}

	/*
	 * Tính điểm trung bình học sinh
	 */
	public void tinhDiemTB() {
		for (ThanhVien tv : this.objDSThanhVien.getDsThanhVien()) {
			if (tv instanceof HocSinh) {
				((HocSinh) tv).tinhDiemTB();
			}
		}
		System.out.println("Tính điểm trung bình thành công!");
	}
	
	/*
	 * Tìm điểm trung bình cao nhất của học sinh
	 * */
	// Tìm Học Sinh đầu tiên
		private int timHSDauTien() {
			int indexFirst = -1;
			int i = 0;
			for (ThanhVien tv : this.objDSThanhVien.getDsThanhVien()) {
				if (tv instanceof HocSinh) {
					indexFirst = i;
					break;
				}
				i++;
			}
			return indexFirst;
		}

		// Tìm Học Sinh có điểm trung bình cao nhất đầu tiên
		private int timHSDiemTBCaoNhatDauTien() {
			int indexMax = timHSDauTien();
			if (indexMax == -1) {
				return indexMax;
			} else {
				HocSinh hsMax = (HocSinh) this.objDSThanhVien.getDsThanhVien().get(indexMax);
				for (int i = indexMax + 1; i < this.objDSThanhVien.getDsThanhVien().size(); i++) {
					ThanhVien tv = this.objDSThanhVien.getDsThanhVien().get(i);
					if (tv instanceof HocSinh) {
						HocSinh hsCurrent = (HocSinh) tv;
						if (hsCurrent.getDiemTB() > hsMax.getDiemTB()) {
							indexMax = i;
							hsMax = hsCurrent;
						}
					}
				}
				return indexMax;
			}
		}
	
	public void timDiemTBCaoNhat() {
		int indexMax = timHSDiemTBCaoNhatDauTien();
		HocSinh hsMax = (HocSinh) this.objDSThanhVien.getDsThanhVien().get(indexMax);
		float diemMax = hsMax.getDiemTB();
		System.out.println("Điểm trung bình cao nhất toàn trường: " + diemMax);
	}

	/*
	 * Tìm Học Sinh có điểm trung bình cao nhất
	 */
	public void timHSDiemTBCaoNhat() {
		ArrayList<HocSinh> ds = new ArrayList<HocSinh>();
		int indexMax = timHSDiemTBCaoNhatDauTien();
		if (indexMax == -1) {
			System.out.println("Danh sách không tồn tại học sinh!");
		} else {
			HocSinh hsMax = (HocSinh) this.objDSThanhVien.getDsThanhVien().get(indexMax);
			for (int i = indexMax; i < this.objDSThanhVien.getDsThanhVien().size(); i++) {
				ThanhVien tv = this.objDSThanhVien.getDsThanhVien().get(i);
				if (tv instanceof HocSinh) {
					HocSinh hsCurrent = (HocSinh) tv;
					if (hsCurrent.getDiemTB() == hsMax.getDiemTB()) {
						ds.add(hsCurrent);
					}
				}
			}
			xuatTheoFormatHocSinh(ds);
		}
	}

	/*
	 * Method xếp loại học sinh
	 */
	public void xepLoai() {
		for (ThanhVien tv : this.objDSThanhVien.getDsThanhVien()) {
			if (tv instanceof HocSinh) {
				((HocSinh) tv).xepLoai();
			}
		}
		System.out.println("Xếp loại thành công!");
	}

	/*
	 * Sắp xếp học sinh theo điểm trung bình giảm dần (Quick Sort)
	 */
	private ArrayList<HocSinh> quickSort(ArrayList<HocSinh> ds, int left, int right) {
		HocSinh hs = ds.get((left + right) / 2);
		int i = left;
		int j = right;
		do {
			while (ds.get(i).getDiemTB() > hs.getDiemTB()) {
				i++;
			}
			while (ds.get(j).getDiemTB() < hs.getDiemTB()) {
				j--;
			}
			if (i <= j) {
				Collections.swap(ds, i, j);
				i++;
				j--;
			}
		} while (i < j);
		if (j > left) {
			quickSort(ds, left, j);
		}
		if (i < right) {
			quickSort(ds, i, right);
		}
		return ds;
	}

	public ArrayList<HocSinh> layDSHocSinh() {
		ArrayList<HocSinh> dsHocSinh = new ArrayList<HocSinh>();
		for (ThanhVien tv : this.objDSThanhVien.getDsThanhVien()) {
			if (tv instanceof HocSinh) {
				dsHocSinh.add((HocSinh) tv);
			}
		}
		return dsHocSinh;
	}

	public void sapXepHSDiemTBGiam() {
		ArrayList<HocSinh> dsHocSinh = layDSHocSinh();
		dsHocSinh = quickSort(dsHocSinh, 0, dsHocSinh.size() - 1);
		xuatTheoFormatHocSinh(dsHocSinh);
	}
	
	/*
	 * Sắp xếp danh sách học sinh theo ABC (Bubble Sort)
	 * */
	private ArrayList<HocSinh> bubbleSort(ArrayList<HocSinh> dsHocSinh) {
		for (int i = 0; i < dsHocSinh.size() - 1; i++) {
			for (int j = dsHocSinh.size() - 1; j > i; j--) {
				HocSinh hocSinhI = dsHocSinh.get(i);
				HocSinh hocSinhII = dsHocSinh.get(j);
				if (hocSinhII.getHoTen().compareToIgnoreCase(hocSinhI.getHoTen()) < 0) {
					Collections.swap(dsHocSinh, i, j);
				}
			}
		}
		return dsHocSinh;
	}
	
	public void sortName() {
		ArrayList<HocSinh> dsHocSinh = layDSHocSinh();
		dsHocSinh = bubbleSort(dsHocSinh);
		xuatTheoFormatHocSinh(dsHocSinh);
	}
	
	/*
	 * Xuất theo format Học Sinh
	 * */
	public void xuatTheoFormatHocSinh(ArrayList<HocSinh> ds) {
		this.objDSThanhVien.xuatTheoFormatHS(ds);
	}
	
	/*
	 * Xuất theo format Giáo Viên
	 * */
	public void xuatTheoFormatGiaoVien(ArrayList<GiaoVien> ds) {
		this.objDSThanhVien.xuatTheoFormatGV(ds);
	}

}
