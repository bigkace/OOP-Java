import java.util.Scanner;

/*
 * Mục đích: Xử lý các nghiệp vụ liên quan đến thành viên trường học (Giáo Viên, Học Sinh)
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 2/1/2022
 * Version: 1.0
 * */

public class ThanhVien implements NhapXuat{
	
	//1. Attributes
	protected String ma;
	protected String hoTen;
	protected String namSinh;
	protected String noiSinh;
	protected String diaChi;
	
	//2. Get, set methods
	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}

	public String getNoiSinh() {
		return noiSinh;
	}

	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	//3. Constructor methods
	public ThanhVien() {
		
	}

	public ThanhVien(String ma, String hoTen, String namSinh, String noiSinh, String diaChi) {
		this.ma = ma;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.noiSinh = noiSinh;
		this.diaChi = diaChi;
	}

	//4. Input, output methods
	@Override
	public void nhap() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Nhập họ tên: ");
		this.hoTen = scan.nextLine();
		
		System.out.print("Nhập năm sinh: ");
		this.namSinh = scan.nextLine();
		
		System.out.print("Nhập nơi sinh: ");
		this.noiSinh = scan.nextLine();
		
		System.out.print("Nhập địa chỉ: ");
		this.diaChi = scan.nextLine();
	}

	@Override
	public void xuat() {
		System.out.print("Họ tên: " + this.hoTen
				+ "\tNăm sinh: " + this.namSinh
				+ "\tNơi sinh: " + this.noiSinh
				+ "\tĐịa chỉ: " + this.diaChi);
	}
		
	//5. Business methods
	private String formatCellHoTen(String text) {
		String paddLeft = "%1s";
		String paddRight = "%-23s";
		return String.format(paddLeft, " ") + String.format(paddRight, text);
	}
	
	private String formatCellNamSinh(String text) {
		String paddLeft = "%6s";
		String paddRight = "%-12s";
		return String.format(paddLeft, " ") + String.format(paddRight, text);
	}
	
	private String formatCellNoiSinh(String text) {
		String paddLeft = "%5s";
		String paddRight = "%-13s";
		return String.format(paddLeft, " ") + String.format(paddRight, text);
	}
	
	private String formatCellDiaChi(String text) {
		String paddLeft = "%5s";
		String paddRight = "%-12s";
		return String.format(paddLeft, " ") + String.format(paddRight, text);
	}
	
	public void xuatRowFormat() {
		String text;
		text = formatCellHoTen(this.hoTen) + "|";
		text += formatCellNamSinh(this.namSinh) + "|";
		text += formatCellNoiSinh(this.noiSinh) + "|";
		text += formatCellDiaChi(this.diaChi) + "|";
		System.out.print(text);
	}

}
