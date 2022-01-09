import java.util.Scanner;

/*
 * Mục đích: Xử lý các nghiệp vụ liên quan đến sinh viên
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 12/12/2021
 * Version: 1.0
 * */

public class SinhVien {

	// 1. Attribute
	private String tenSV;
	private int maSV;
	private float diemToan;
	private float diemLy;
	private float diemHoa;
	private float diemTB;
	private String xepLoai;

	// 2.Get, set methods
	public String getTenSV() {
		return this.tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}

	public int getMaSV() {
		return this.maSV;
	}

	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}

	public float getDiemToan() {
		return this.diemToan;
	}

	public void setDiemToan(float diemToan) {
		this.diemToan = diemToan;
	}

	public float getDiemLy() {
		return this.diemLy;
	}

	public void setDiemLy(float diemLy) {
		this.diemLy = diemLy;
	}

	public float getDiemHoa() {
		return this.diemHoa;
	}

	public void setDiemHoa(float diemHoa) {
		this.diemHoa = diemHoa;
	}

	public float getDiemTB() {
		return this.diemTB;
	}

	public String getXepLoai() {
		return this.xepLoai;
	}

	// 3.Constructors methods
	public SinhVien() {

	}

	public SinhVien(String tenSinhVien, int maSinhVien, float diemToan, float diemLy, float diemHoa) {
		this.tenSV = tenSinhVien;
		this.maSV = maSinhVien;
		this.diemToan = diemToan;
		this.diemLy = diemLy;
		this.diemHoa = diemHoa;
	}

	// 4.Input, output methods
	public void nhap(Scanner scan) {
		System.out.println("Nhập tên sinh viên: ");
		this.tenSV = scan.nextLine();

		System.out.println("Nhập mã sinh viên: ");
		this.maSV = Integer.parseInt(scan.nextLine());

		System.out.println("Nhập điểm toán: ");
		this.diemToan = Float.parseFloat(scan.nextLine());

		System.out.println("Nhập điểm lý: ");
		this.diemLy = Float.parseFloat(scan.nextLine());

		System.out.println("Nhập điểm hoá: ");
		this.diemHoa = Float.parseFloat(scan.nextLine());
	}

	public void xuat() {
		System.out.println("Sinh Viên - Mã:  " + this.maSV + "\tTên: " + this.tenSV + "\tĐiểm toán: " + this.diemToan
				+ "\tĐiểm Lý: " + this.diemLy + "\tĐiểm Hoá: " + this.diemHoa + "\tĐTB: " + this.diemTB + "\tXếp loại: "
				+ this.xepLoai);
	}

	// 5.Business methods
	public void tinhDiemTB() {
		this.diemTB = (this.diemToan + this.diemLy + this.diemHoa) / 3;
	}

	public void xepLoai() {
		if (this.diemTB >= 9) {
			this.xepLoai = "Xuất sắc";
		} else if (this.diemTB >= 8) {
			this.xepLoai = "Giỏi";
		} else if (this.diemTB >= 7) {
			this.xepLoai = "Khá";
		} else if (this.diemTB >= 6) {
			this.xepLoai = "Trung bình khá";
		} else if (this.diemTB >= 5) {
			this.xepLoai = "Trung bình";
		} else {
			this.xepLoai = "Yếu";
		}
	}

	private String formatNumCell(Number num) {
		String paddLeft = "%5s";
		String paddRight = "%-8s";
		return String.format(paddLeft, " ") + String.format(paddRight, num) + "|";
	}

	private String formatTextCell(String text) {
		String paddLeft = "%-15s";
		return String.format(paddLeft, " " + text);
	}
	
	public void xuatRowFormat() {
		String text;
		text = formatNumCell(this.maSV);
		text += formatTextCell(this.tenSV) + "|";
		text += formatNumCell(this.diemToan);
		text += formatNumCell(this.diemLy);
		text += formatNumCell(this.diemHoa);
		
		double dtb = Math.round(this.diemTB*100.0)/100.0; //làm tròn đến 2 chữ số phần thập phân
		text += formatNumCell(dtb);
		
		text += formatTextCell(this.xepLoai) + "||";
		
		System.out.println(text);
	}

}
