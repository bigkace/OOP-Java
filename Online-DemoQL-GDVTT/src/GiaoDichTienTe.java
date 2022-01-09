import java.util.Scanner;

/*
 * Mục đích: Xử lý các nghiệp vụ liên quan đến giao dịch tiền tệ
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 25/12/2021
 * Version: 1.0
 * */

public class GiaoDichTienTe extends GiaoDich{
	
	//1. Attributes
	private float tiGia;
	private int loaiTienTe;
	
	//2. Get, set methods
	public float getTiGia() {
		return tiGia;
	}

	public void setTiGia(float tiGia) {
		this.tiGia = tiGia;
	}

	public int getLoaiTienTe() {
		return loaiTienTe;
	}

	public void setLoaiTienTe(int loaiTienTe) {
		this.loaiTienTe = loaiTienTe;
	}
	
	//3. Constructor methods
	public GiaoDichTienTe() {
		super();
	}

	public GiaoDichTienTe(String maGiaoDich, int ngayGiaoDich, int thangGiaoDich, int namGiaoDich, float donGia, int soLuong, float tiGia, int loaiTienTe) {
		super(maGiaoDich, ngayGiaoDich, thangGiaoDich, namGiaoDich, donGia, soLuong);
		this.tiGia = tiGia;
		this.loaiTienTe = loaiTienTe;
	}
	
	//4. Input, output methods
	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);
		
		System.out.print("Nhập tỉ giá: ");
		this.tiGia = Float.parseFloat(scan.nextLine());
		
		System.out.print("Nhập loại tiền tệ (1.VND , 2.USD , 3.EURO): ");
		this.loaiTienTe = Integer.parseInt(scan.nextLine());
	}
	
	@Override
	public void xuat() {
		String temp = "";
		if (this.loaiTienTe == 1) {
			temp = "VNĐ";
		} else if (this.loaiTienTe == 2) {
			temp = "USD";
		} else {
			temp = "EURO";
		}
		
		super.xuat();
		System.out.println("\tTỉ giá: " + this.tiGia
				+ "\tLoại tiền tệ: " + temp
				+ "\t Thành tiền: " + this.thanhTien);
	}
	
	//5. Business methods
	@Override
	public void tinhThanhTien() {
		if (this.loaiTienTe == 1) {
			this.thanhTien = this.donGia * this.soLuong;
		} else {
			this.thanhTien = this.donGia * this.soLuong * this.tiGia;
		}
	}
	
}
