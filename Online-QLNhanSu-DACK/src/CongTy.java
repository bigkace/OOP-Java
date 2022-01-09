import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * Mục đích: Xử lý các nghiệp vụ liên quan đến Công Ty
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 27/12/2021
 * Version: 1.0
 * */

public class CongTy {

	// 1. Attributes
	private String tenCongTy;
	private String maSoThue;
	private double doanhThuThang;
	DanhSachNhanSu objListNhanSu;

	// 2. Get, set methods
	public String getTenCongTy() {
		return tenCongTy;
	}

	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;
	}

	public String getMaSoThue() {
		return maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public DanhSachNhanSu getListNhanSu() {
		return objListNhanSu;
	}

	public void setListNhanSu(DanhSachNhanSu listNhanSu) {
		this.objListNhanSu = listNhanSu;
	}

	public double getDoanhThuThang() {
		return doanhThuThang;
	}

	public void setDoanhThuThang(double doanhThuThang) {
		this.doanhThuThang = doanhThuThang;
	}

	// 3. Constructor methods
	public CongTy() {
		this.objListNhanSu = new DanhSachNhanSu();
	}

	public CongTy(String tenCongTy, String maSoThue, double doanhThuThang) {
		this.tenCongTy = tenCongTy;
		this.maSoThue = maSoThue;
		this.doanhThuThang = doanhThuThang;
	}

	// 4. Input, output methods
	public void nhap(Scanner scan) {
		System.out.println("======== Nhập thông tin công ty ========");
		
		System.out.print("Nhập tên công ty: ");
		this.tenCongTy = scan.nextLine();

		System.out.print("Nhập mã số thuế: ");
		this.maSoThue = scan.nextLine();

		System.out.print("Nhập doanh thu tháng: ");
		this.doanhThuThang = Double.parseDouble(scan.nextLine());
	}

	public void xuat() {
		System.out.println("Tên công ty: " + this.tenCongTy);
		System.out.println("Mã số thuế: " + this.maSoThue);
		System.out.println("Doanh thu tháng: " + this.doanhThuThang);
		this.objListNhanSu.xuat();
	}

	// 5. Business methods
	public void tinhLuong() {
		this.objListNhanSu.tinhLuong();
	}

	public void dummyDataCty() {
		this.tenCongTy = "CyberSoft-CyberLearn";
		this.maSoThue = "01292332";
		this.doanhThuThang = 435334f;
	}

	public void dummyDataNhanSu() {
		NhanSu ns = new NhanSu();

		ns = new NhanVienThuong("NVT-01", "Lan", "09832", 20);
		objListNhanSu.themNhanSu(ns);
		ns = new NhanVienThuong("NVT-02", "Hưng", "098232", 23);
		objListNhanSu.themNhanSu(ns);
		ns = new NhanVienThuong("NVT-03", "Việt", "098132", 31);
		objListNhanSu.themNhanSu(ns);
		ns = new NhanVienThuong("NVT-04", "An", "091832", 25);
		objListNhanSu.themNhanSu(ns);
		ns = new NhanVienThuong("NVT-05", "Tuyết", "098432", 23);
		objListNhanSu.themNhanSu(ns);
		ns = new NhanVienThuong("NVT-06", "Mỹ", "092832", 31);
		objListNhanSu.themNhanSu(ns);

		ns = new TruongPhong("TP-01", "Mai", "098233", 24);
		objListNhanSu.themNhanSu(ns);
		ns = new TruongPhong("TP-02", "Luân", "091833", 21);
		objListNhanSu.themNhanSu(ns);
		ns = new TruongPhong("TP-03", "Kiệt", "0918233", 23);
		objListNhanSu.themNhanSu(ns);

		ns = new GiamDoc("GĐ-01", "Tiên", "0981", 19, 80);
		objListNhanSu.themNhanSu(ns);
		ns = new GiamDoc("GĐ-02", "Huệ", "09811", 21, 20);
		objListNhanSu.themNhanSu(ns);
	}

	/*
	 * Phân bổ nhân viên về phòng ban (Chỉ định Trưởng phòng cho nhân viên)
	 */

	public ArrayList<TruongPhong> layDSTruongPhong() {
		ArrayList<TruongPhong> list = new ArrayList<TruongPhong>();
		for (NhanSu ns : objListNhanSu.getListNhanSu()) {
			if (ns instanceof TruongPhong) {
				list.add((TruongPhong) ns);
			}
		}
		return list;
	}

	public void lietKeDSTruongPhong() {
		System.out.println("===Danh Sách Trưởng Phòng===");
		ArrayList<TruongPhong> list = layDSTruongPhong();
		for (NhanSu ns : list) {
			ns.xuatMaVaTen();
			System.out.print("\n");
		}
		System.out.println("============================");
	}

	public TruongPhong timTruongPhongTheoMa(String ma) {
		TruongPhong truongPhong = null;
		ArrayList<TruongPhong> list = layDSTruongPhong();
		for (NhanSu ns : list) {
			if (ns.getMaSo().compareTo(ma) == 0) {
				truongPhong = (TruongPhong) ns;
			}
		}
		return truongPhong;
	}

	public void phanBoMotNhanVienThuong(Scanner scan, NhanSu ns) {
		boolean flagChoose = true;
		do {
			lietKeDSTruongPhong();
			System.out.print("Nhân viên >> ");
			ns.xuatMaVaTen();
			System.out.println("\n================================================================");
			System.out.println("|| Bạn có muốn phân bổ nhân viên hiện tại về phòng ban không? ||");
			System.out.println("|| Nhập 1: Có                                                 ||");
			System.out.println("|| Nhập 0: Không                                              ||");
			System.out.println("================================================================");
			System.out.print("Lựa Chọn >> ");
			int luaChon = Integer.parseInt(scan.nextLine());
			switch (luaChon) {
			case 1:
				TruongPhong truongPhong = null;
				boolean flag = true;
				do {
					System.out.print("Nhập mã trưởng phòng bạn muốn phân bổ nhân sự về >> ");
					String ma = scan.nextLine();
					truongPhong = timTruongPhongTheoMa(ma);
					if (truongPhong != null) {
						((NhanVienThuong) ns).setTruongPhong(truongPhong);
						truongPhong.tangNVDuoiQuyen();
						flag = false;
					} else {
						System.out.println("Mã trưởng phòng không tồn tại!");
					}
				} while (flag);
				flagChoose = false;
				break;
			case 0:
				flagChoose = false;
				break;
			default:
				System.out.println("Lựa chọn bạn nhập không hợp lệ! Chỉ chọn '0' hoặc '1'!\n");
				break;
			}
		} while (flagChoose);
	}

	public void phanBoNhanSuThuong() {
		Scanner scan = new Scanner(System.in);

		for (NhanSu ns : objListNhanSu.getListNhanSu()) {
			if (ns instanceof NhanVienThuong) {
				phanBoMotNhanVienThuong(scan, ns);
			}
			System.out.println("");
		}
	}

	public void themNhanSuMoi(Scanner scan) {
		ArrayList<NhanVienThuong> list = this.objListNhanSu.nhap(scan);
		for (NhanVienThuong nvt : list) {
			phanBoMotNhanVienThuong(scan, nvt);
		}
	}

	/*
	 * Xoá nhân sự
	 */
	private void xoaNSLaGiamDoc(GiamDoc nhanSu) {
		this.objListNhanSu.xoaNhanSu(nhanSu);
	}

	private void xoaNSLaTruongPhong(TruongPhong nhanSu) {
		for (NhanSu ns : this.objListNhanSu.getListNhanSu()) {
			if (ns instanceof NhanVienThuong) {
				if (((NhanVienThuong) ns).getTruongPhong() != null) {
					if (((NhanVienThuong) ns).getTruongPhong().getMaSo().compareTo(nhanSu.getMaSo()) == 0) {
						((NhanVienThuong) ns).setTruongPhong(null);
					}
				}
			}
		}
		this.objListNhanSu.xoaNhanSu(nhanSu);
	}

	private void xoaNSLaNhanVienThuong(NhanVienThuong nhanSu) {
		if (nhanSu.getTruongPhong() != null) {
			nhanSu.getTruongPhong().giamNVDuoiQuyen();
		}
		this.objListNhanSu.xoaNhanSu(nhanSu);
	}

	public void xoaNhanSuCty(Scanner scan) {
		boolean flag = true;
		NhanSu nhanSu = null;
		do {
			System.out.print("Nhập mã nhân sự muốn xoá: ");
			String ma = scan.nextLine();
			for (NhanSu ns : this.objListNhanSu.getListNhanSu()) {
				if (ma.compareTo(ns.getMaSo()) == 0) {
					nhanSu = ns;
					flag = false;
					break;
				}
			}
			if (nhanSu == null) {
				System.out.println("Mã nhân sự không tồn tại!");
			}
		} while (flag);

		if (nhanSu instanceof NhanVienThuong) {
			xoaNSLaNhanVienThuong((NhanVienThuong) nhanSu);
		} else if (nhanSu instanceof TruongPhong) {
			xoaNSLaTruongPhong((TruongPhong) nhanSu);
		} else {
			xoaNSLaGiamDoc((GiamDoc) nhanSu);
		}
	}

	/*
	 * Tính tổng lương toàn công ty
	 */
	public double tinhTongLuongToanCty() {
		double tongLuong = 0;
		for (NhanSu ns : this.objListNhanSu.getListNhanSu()) {
			tongLuong += ns.getLuong();
		}
		return tongLuong;
	}

	/*
	 * Tìm nhân viên thường có lương cao nhất
	 */
	public int timNVTDauTien() {
		int indexFirst = -1;
		for (int i = 0; i < this.objListNhanSu.getListNhanSu().size(); i++) {
			NhanSu nhanSu = this.objListNhanSu.getListNhanSu().get(i);
			if (nhanSu instanceof NhanVienThuong) {
				indexFirst = i;
				break;
			}
		}
		return indexFirst;
	}

	public int timNVTLuongCaoNhatDauTien() {
		int indexMax = timNVTDauTien();
		if (indexMax == -1) {
			return indexMax;
		} else {
			NhanSu nhanSuMax = this.objListNhanSu.getListNhanSu().get(indexMax);
			for (int i = indexMax + 1; i < this.objListNhanSu.getListNhanSu().size(); i++) {
				NhanSu nhanSuCurrent = this.objListNhanSu.getListNhanSu().get(i);
				if (nhanSuCurrent instanceof NhanVienThuong) {
					if (nhanSuCurrent.getLuong() > nhanSuMax.getLuong()) {
						nhanSuMax = nhanSuCurrent;
						indexMax = i;
					}
				}
			}
			return indexMax;
		}
	}

	public void timNVTLuongCaoNhat() {
		int indexMaxFirst = timNVTLuongCaoNhatDauTien();
		if (indexMaxFirst == -1) {
			System.out.println("Danh sách dữ liệu không tồn tại nhân viên thường!");
		} else {
			NhanSu nhanSuMax = this.objListNhanSu.getListNhanSu().get(indexMaxFirst);
			for (int i = indexMaxFirst; i < this.objListNhanSu.getListNhanSu().size(); i++) {
				NhanSu nhanSuCurrent = this.objListNhanSu.getListNhanSu().get(i);
				if (nhanSuCurrent instanceof NhanVienThuong) {
					if (nhanSuCurrent.getLuong() == nhanSuMax.getLuong()) {
						nhanSuCurrent.xuat();
					}
				}
			}
		}
	}

	/*
	 * Tìm Trưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất
	 */
	public int timTPDauTien() {
		int indexFirst = -1;
		for (int i = 0; i < this.objListNhanSu.getListNhanSu().size(); i++) {
			NhanSu nhanSu = this.objListNhanSu.getListNhanSu().get(i);
			if (nhanSu instanceof TruongPhong) {
				indexFirst = i;
				break;
			}
		}
		return indexFirst;
	}

	public int timTPNVDuoiQuyenNNDauTien() {
		int indexMax = timTPDauTien();
		if (indexMax == -1) {
			return indexMax;
		} else {
			NhanSu nhanSuMax = this.objListNhanSu.getListNhanSu().get(indexMax);
			for (int i = indexMax + 1; i < this.objListNhanSu.getListNhanSu().size(); i++) {
				NhanSu nhanSuCurrent = this.objListNhanSu.getListNhanSu().get(i);
				if (nhanSuCurrent instanceof TruongPhong) {
					if (((TruongPhong) nhanSuCurrent).getSoLuongNVDuoiQuyen() > ((TruongPhong) nhanSuMax)
							.getSoLuongNVDuoiQuyen()) {
						nhanSuMax = nhanSuCurrent;
						indexMax = i;
					}
				}
			}
			return indexMax;
		}
	}

	public void timTPNVDuoiQuyenNN() {
		int indexMaxFirst = timTPNVDuoiQuyenNNDauTien();
		if (indexMaxFirst == -1) {
			System.out.println("Danh sách dữ liệu không tồn tại trưởng phòng!");
		} else {
			NhanSu nhanSuMax = this.objListNhanSu.getListNhanSu().get(indexMaxFirst);
			for (int i = indexMaxFirst; i < this.objListNhanSu.getListNhanSu().size(); i++) {
				NhanSu nhanSuCurrent = this.objListNhanSu.getListNhanSu().get(i);
				if (nhanSuCurrent instanceof TruongPhong) {
					if (((TruongPhong) nhanSuCurrent).getSoLuongNVDuoiQuyen() == ((TruongPhong) nhanSuMax)
							.getSoLuongNVDuoiQuyen()) {
						nhanSuCurrent.xuat();
					}
				}
			}
		}
	}

	/*
	 * Sắp xếp nhân viên toàn công ty theo thứ tự abc
	 */
	private void interchangeSortHoTen(ArrayList<NhanSu> objList) {
		for (int i = 0; i < objList.size() - 1; i++) {
			for (int j = i + 1; j < objList.size(); j++) {
				NhanSu nhanSuI = objList.get(i);
				NhanSu nhanSuII = objList.get(j);
				if (nhanSuII.getHoTen().compareToIgnoreCase(nhanSuI.getHoTen()) < 0) {
					Collections.swap(objList, i, j);
				}

			}
		}
	}

	public void sortName() {
		interchangeSortHoTen(this.objListNhanSu.getListNhanSu());
	}

	/*
	 * Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần
	 */
	private void interchangeSortLuong(ArrayList<NhanSu> objList) {
		for (int i = 0; i < objList.size() - 1; i++) {
			for (int j = i + 1; j < objList.size(); j++) {
				NhanSu nhanSuI = objList.get(i);
				NhanSu nhanSuII = objList.get(j);
				if (nhanSuII.getLuong() > nhanSuI.getLuong()) {
					Collections.swap(objList, i, j);
				}
			}
		}
	}

	public void sortSalary() {
		interchangeSortLuong(this.objListNhanSu.getListNhanSu());
	}

	/*
	 * Tìm giám đốc có số lượng cổ phần nhiều nhất
	 */
	public int timGDDauTien() {
		int indexFirst = -1;
		for (int i = 0; i < this.objListNhanSu.getListNhanSu().size(); i++) {
			NhanSu nhanSu = this.objListNhanSu.getListNhanSu().get(i);
			if (nhanSu instanceof GiamDoc) {
				indexFirst = i;
				break;
			}
		}
		return indexFirst;
	}

	public int timGDCoPhanNNDauTien() {
		int indexMax = timGDDauTien();
		if (indexMax == -1) {
			return indexMax;
		} else {
			NhanSu nhanSuMax = this.objListNhanSu.getListNhanSu().get(indexMax);
			for (int i = indexMax + 1; i < this.objListNhanSu.getListNhanSu().size(); i++) {
				NhanSu nhanSuCurrent = this.objListNhanSu.getListNhanSu().get(i);
				if (nhanSuCurrent instanceof GiamDoc) {
					if (((GiamDoc) nhanSuCurrent).getCoPhan() > ((GiamDoc) nhanSuMax).getCoPhan()) {
						nhanSuMax = nhanSuCurrent;
						indexMax = i;
					}
				}
			}
			return indexMax;
		}
	}

	public void timGDCoPhanNN() {
		int indexMaxFirst = timGDCoPhanNNDauTien();
		if (indexMaxFirst == -1) {
			System.out.println("Danh sách dữ liệu không tồn tại giám đốc!");
		} else {
			NhanSu nhanSuMax = this.objListNhanSu.getListNhanSu().get(indexMaxFirst);
			for (int i = indexMaxFirst; i < this.objListNhanSu.getListNhanSu().size(); i++) {
				NhanSu nhanSuCurrent = this.objListNhanSu.getListNhanSu().get(i);
				if (nhanSuCurrent instanceof GiamDoc) {
					if (((GiamDoc) nhanSuCurrent).getCoPhan() == ((GiamDoc) nhanSuMax).getCoPhan()) {
						nhanSuCurrent.xuat();
					}
				}
			}
		}
	}
	
	/*
	 * Tính thu nhập của từng giám đốc
	 * */
	private double tinhLoiNhuanCty() {
		double loiNhuan = this.doanhThuThang - tinhTongLuongToanCty();
		return loiNhuan;
	}
	
	public void tinhThuNhapGD() {
		double loiNhuanCty = tinhLoiNhuanCty();
		for (NhanSu ns : this.objListNhanSu.getListNhanSu()) {
			if (ns instanceof GiamDoc) {
				double thuNhap = ((GiamDoc) ns).getLuong() + (((GiamDoc) ns).getCoPhan() / 100) * loiNhuanCty;
				ns.xuatMaVaTen();
				System.out.println("\tThu nhập: " + thuNhap);
			}
		}
	}

}
