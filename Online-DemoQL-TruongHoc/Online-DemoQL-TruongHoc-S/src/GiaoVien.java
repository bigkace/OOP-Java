import java.util.Scanner;

/*
 * Mục đích: Xử lý các nghiệp vụ liên quan đến Giáo Viên
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 2/1/2022
 * Version: 1.0
 * */

public class GiaoVien extends ThanhVien implements NhapXuat {
	
	final int NAM_HIEN_TAI = 2022;
	
	//1. Attributes
	private int namBatDauDay;
	private String chuyenMon;
	private int thamNien;
	
	//2. Get, set methods
	public int getNamBatDauDay() {
		return namBatDauDay;
	}

	public void setNamBatDauDay(int namBatDauDay) {
		this.namBatDauDay = namBatDauDay;
	}

	public String getChuyenMon() {
		return chuyenMon;
	}

	public void setChuyenMon(String chuyenMon) {
		this.chuyenMon = chuyenMon;
	}
	
	public int getThamNien() {
		return thamNien;
	}

	//3. Constructor methods
	public GiaoVien() {
		super();
		this.thamNien = -1;
	}
	
	public GiaoVien(String ma, String hoTen, String namSinh, String noiSinh, String diaChi, int namBatDauDay, String chuyenMon) {
		super(ma, hoTen, namSinh, noiSinh, diaChi);
		this.namBatDauDay = namBatDauDay;
		this.chuyenMon = chuyenMon;
		this.thamNien = -1;
	}

	//4. Input, output methods
	@Override
	public void nhap() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		super.nhap();
		
		System.out.print("Nhập năm bắt đầu dạy: ");
		this.namBatDauDay = Integer.parseInt(scan.nextLine());
		
		System.out.print("Nhập chuyên môn (Tự nhiên hoặc Xã hội): ");
		this.chuyenMon = scan.nextLine();
	}
	
	@Override
	public void xuat() {
		super.xuat();
		System.out.print("\tNăm bắt đầu dạy: " + this.namBatDauDay
				+ "\tChuyên môn: " + this.chuyenMon
				+ "\tThâm niên: ");
		if (this.thamNien == -1) {
			System.out.println("Chưa tính");
		} else {
			System.out.println(this.thamNien);
		}
	}
	
	//5. Business methods
	public void tinhThamNien() {
		this.thamNien = NAM_HIEN_TAI - this.namBatDauDay;
	}
	
	private String formatCellNamBDDay(int number) {
		String paddLeft = "%6s";
		String paddRight = "%-11s";
		return String.format(paddLeft, " ") + String.format(paddRight, number);
	}
	
	private String formatCellChuyenMon(String text) {
		String paddLeft = "%3s";
		String paddRight = "%-11s";
		return String.format(paddLeft, " ") + String.format(paddRight, text);
	}
	
	private String formatCellThamNien(int number) {
		String paddLeft1 = "%5s";
		String paddLeft2 = "%8s";
		String paddRight1 = "%-14s";
		String paddRight2 = "%-11s";
		if (this.thamNien == -1) {
			return String.format(paddLeft1, " ") + String.format(paddRight1, "Chưa tính");
		} else {
			return String.format(paddLeft2, " ") + String.format(paddRight2, number);
		}
	}
		
	public void xuatRowFormatGiaoVien() {
		super.xuatRowFormat();
		String text;
		text = formatCellNamBDDay(this.namBatDauDay) + "|";
		text += formatCellChuyenMon(this.chuyenMon) + "|";
		text += formatCellThamNien(this.thamNien) + "||";
		System.out.println(text);
	}

}
