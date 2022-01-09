import java.util.ArrayList;

/*
 * Mục đích: Quản lí nghiệp vụ liên quan trường học
 * Người tạo: Vũ Nam Khánh
 * Ngày tao: 14/12/2021
 * Version: 1.0
 * */

public class TruongHoc {

	// 1. Attributes
	private DanhSachSinhVien dsSVToanTruong;

	// 2. Get, set methods
	public DanhSachSinhVien getDsSVToanTruong() {
		return dsSVToanTruong;
	}

	public void setDsSVToanTruong(DanhSachSinhVien dsSVToanTruong) {
		this.dsSVToanTruong = dsSVToanTruong;
	}

	// 3. Constructor methods
	public TruongHoc() {
		this.dsSVToanTruong = new DanhSachSinhVien();
	}

	// 4. Input, output methods
	public void nhap() {
		SinhVien sv = new SinhVien("Lan", 1, 9.2f, 9, 9);
		this.dsSVToanTruong.themSinhVien(sv);

		sv = new SinhVien("Hùng", 2, 4.2f, 4, 5.3f);
		this.dsSVToanTruong.themSinhVien(sv);

		sv = new SinhVien("lan", 3, 7.2f, 4, 9);
		this.dsSVToanTruong.themSinhVien(sv);

		sv = new SinhVien("Yến", 4, 3.2f, 4, 4);
		this.dsSVToanTruong.themSinhVien(sv);

		sv = new SinhVien("Toán", 5, 9.2f, 10, 10);
		this.dsSVToanTruong.themSinhVien(sv);

		sv = new SinhVien("Hữu", 6, 7.2f, 7, 6);
		this.dsSVToanTruong.themSinhVien(sv);

		sv = new SinhVien("Lýn", 7, 3.2f, 3, 3);
		this.dsSVToanTruong.themSinhVien(sv);

		sv = new SinhVien("Trung", 8, 9.2f, 10, 10);
		this.dsSVToanTruong.themSinhVien(sv);

		sv = new SinhVien("Quyền", 9, 7.2f, 7, 8);
		this.dsSVToanTruong.themSinhVien(sv);

		sv = new SinhVien("Linh", 10, 5.2f, 5, 6);
		this.dsSVToanTruong.themSinhVien(sv);
	}

	public void themSinhVien(SinhVien sv) {
		this.dsSVToanTruong.themSinhVien(sv);
	}

	public void xuat() {
		this.dsSVToanTruong.xuat();
	}

	// 5. Business methods
	public void tinhDiemTB() {
		this.dsSVToanTruong.tinhDiemTB();
	}

	public void xepLoai() {
		this.dsSVToanTruong.xepLoai();
	}

	public ArrayList<SinhVien> timDSSVCoDTBCaoNhat() {
		return this.dsSVToanTruong.timDSSVCoDTBCaoNhat();
	}

	public ArrayList<SinhVien> timDSSVYeu() {
		return this.dsSVToanTruong.timDSSVYeu();
	}

	public void xuatHelper(ArrayList<SinhVien> list) {
		for (SinhVien sv : list) {
			sv.xuat();
		}
	}

	public ArrayList<SinhVien> timSVTheoTen(String tenSV) {
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();

		for (SinhVien sv : dsSVToanTruong.getListSV()) {
			if (sv.getTenSV().equalsIgnoreCase(tenSV)) { // bỏ phân biệt chữ hoa chữ thường
				list.add(sv);
			}
		}

		return list;
	}

	public SinhVien timSVTheoMa(int maSV) {
		return this.dsSVToanTruong.timSVTheoMa(maSV);
	}

	public boolean xoaSVTheoMa(int maSV) {
		return this.dsSVToanTruong.xoaSVTheoMa(maSV);
	}

	private void xuatLine() {
		String text = String.format("%-115s", " ").replace(" ", "=");
		System.out.println(text);
	}

	private String formatCell(String paddLeft, String title, String paddRight) {
		return String.format(paddLeft, " ") + title + String.format(paddRight, " ");
	}
	
	private void xuatRowHeader() {
		String paddString1 = "%3s";
		String paddString2 = "%4s";
		String paddString3 = "%5s";
		String paddString4 = "%6s";
		
		xuatLine();
		
		String text;
		text = "||" + formatCell(paddString1, "STT", paddString1);
		text += "|" + formatCell(paddString2, "Mã SV", paddString2);
		text += "|" + formatCell(paddString3, "Tên SV", paddString2);
		text += "|" + formatCell(paddString3, "Toán", paddString2);
		text += "|" + formatCell(paddString3, "Lý", paddString4);
		text += "|" + formatCell(paddString3, "Hoá", paddString3);
		text += "|" + formatCell(paddString3, "ĐTB", paddString3);
		text += "|" + formatCell(paddString2, "Xếp Loại", paddString1) + "||";
		System.out.println(text);
		
		xuatLine();
	}
	
	private void xuatCellThuTu(int i) {
		String paddLeft = "%3s";
		String paddRight = "%-6s";
		String text = "||" + String.format(paddLeft, " ") + String.format(paddRight, "" + i) + "|";
		System.out.print(text);
	}
	
	public void xuatTheoFormat(ArrayList<SinhVien> list) {
		 xuatRowHeader();
		 int i = 1;
		 for (SinhVien sv : list) {
			  xuatCellThuTu(i);
			  sv.xuatRowFormat();
			  i++;
		 }
		 xuatLine();
	}
}
