import java.util.Scanner;

/*
 * Mục đích: Xử lý các nghiệp vụ liên quan đến Học Sinh
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 2/1/2022
 * Version: 1.0
 * */

public class HocSinh extends ThanhVien implements NhapXuat {
	
	//1. Attributes
	private float diemToan;
	private float diemVan;
	private float diemNgoaiNgu;
	private float diemTB;
	private String xepLoai;
	
	//2. Get, set methods
	public float getDiemToan() {
		return diemToan;
	}
	public void setDiemToan(float diemToan) {
		this.diemToan = diemToan;
	}
	public float getDiemVan() {
		return diemVan;
	}
	public void setDiemVan(float diemVan) {
		this.diemVan = diemVan;
	}
	public float getDiemNgoaiNgu() {
		return diemNgoaiNgu;
	}
	public void setDiemNgoaiNgu(float diemNgoaiNgu) {
		this.diemNgoaiNgu = diemNgoaiNgu;
	}
	
	public float getDiemTB() {
		return diemTB;
	}
	
	public String getXepLoai() {
		return xepLoai;
	}
	
	public void setXepLoai(String xepLoai) {
		this.xepLoai = xepLoai;
	}
	
	//3. Constructor methods
	private void init() {
		this.diemTB = -1;
		this.xepLoai = null;
	}
	
	public HocSinh() {
		super();
		init();
	}
	
	public HocSinh(String ma, String hoTen, String namSinh, String noiSinh, String diaChi, float diemToan, float diemVan, float diemNgoaiNgu) {
		super(ma, hoTen, namSinh, noiSinh, diaChi);
		this.diemToan = diemToan;
		this.diemVan = diemVan;
		this.diemNgoaiNgu = diemNgoaiNgu;
		init();
	}
	
	//4. Input, output methods
	@Override
	public void nhap() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		super.nhap();
		
		System.out.print("Nhập điểm toán: ");
		this.diemToan = Float.parseFloat(scan.nextLine());
		
		System.out.print("Nhập điểm văn: ");
		this.diemVan = Float.parseFloat(scan.nextLine());
		
		System.out.print("Nhập điểm ngoại ngữ: ");
		this.diemNgoaiNgu = Float.parseFloat(scan.nextLine());
	}
	
	@Override
	public void xuat() {
		String temp = this.xepLoai;
		if (this.xepLoai == null) {
			temp = "Chưa xếp loại";
		}
		super.xuat();
		System.out.print("\tToán: " + this.diemToan
				+ "\tVăn: " + this.diemVan
				+ "\tNgoại ngữ: " + this.diemNgoaiNgu
				+ "\tĐiểm trung bình: ");
		if (this.diemTB == -1) {
			System.out.print("Chưa tính");
		} else {
			System.out.print(this.diemTB);
		}
		System.out.println("\tXếp loại: " + temp);
	}
	
	//5. Business methods
	public void tinhDiemTB() {
		this.diemTB = (this.diemToan + this.diemVan + this.diemNgoaiNgu) / 3;
	}
	
	public void xepLoai() {
		if (this.diemTB < 5) {
			this.xepLoai = "Yếu";
		} else if (this.diemTB < 7) {
			this.xepLoai = "Trung bình";
		} else if (this.diemTB < 8) {
			this.xepLoai = "Khá";
		} else if (this.diemTB < 9) {
			this.xepLoai = "Giỏi";
		} else {
			this.xepLoai = "Xuất sắc";
		}
	}
	
	private String formatCellDiemToan(float number) {
		String paddLeft = "%5s";
		String paddRight = "%-10s";
		return String.format(paddLeft, " ") + String.format(paddRight, number);
	}
	
	private String formatCellDiemVan(float number) {
		String paddLeft = "%5s";
		String paddRight = "%-9s";
		return String.format(paddLeft, " ") + String.format(paddRight, number);
	}
	
	private String formatCellDiemNN(float number) {
		String paddLeft = "%8s";
		String paddRight = "%-12s";
		return String.format(paddLeft, " ") + String.format(paddRight, number);
	}
	
	private String formatCellDiemTB(float number) {
		String paddLeft = "%7s";
		String paddRight = "%-14s";
		if (this.diemTB == -1) {
			return String.format(paddLeft, " ") + String.format(paddRight, "Chưa tính");
		} else {
			return String.format(paddLeft, " ") + String.format(paddRight, number);
		}
	}
	
	private String formatCellXepLoai(String text) {
		String paddLeft1 = "%3s";
		String paddLeft2 = "%6s";
		String paddRight1 = "%-15s";
		String paddRight2 = "%-12s";
		if (this.xepLoai == null) {
			return String.format(paddLeft1, " ") + String.format(paddRight1, "Chưa xếp loại");
		} else {
			return String.format(paddLeft2, " ") + String.format(paddRight2, text);
		}
	}
		
	public void xuatRowFormatHocSinh() {
		super.xuatRowFormat();
		String text;
		text = formatCellDiemToan(this.diemToan) + "|";
		text += formatCellDiemVan(this.diemVan) + "|";
		text += formatCellDiemNN(this.diemNgoaiNgu) + "|";
		text += formatCellDiemTB(this.diemTB) + "|";
		text += formatCellXepLoai(this.xepLoai) + "||";
		System.out.println(text);
	}

}
