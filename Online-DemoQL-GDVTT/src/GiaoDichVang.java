import java.util.Scanner;

/*
 * Mục đích: Xử lý các nghiệp vụ liên quan đến giao dịch vàng
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 25/12/2021
 * Version: 1.0
 * */

public class GiaoDichVang extends GiaoDich{
	
	//1. Attributes
	private String loaiVang;
	
	//2. Get, set methods
	public String getLoaiVang() {
		return loaiVang;
	}
	
	public void setLoaiVang(String loaiVang) {
		this.loaiVang = loaiVang;
	}
		
	//3. Constructor methods
	public GiaoDichVang() {
		super();
	}
	
	public GiaoDichVang(String maGiaoDich, int ngayGiaoDich, int thangGiaoDich, int namGiaoDich, float donGia, int soLuong, String loaiVang) {
		super(maGiaoDich, ngayGiaoDich, thangGiaoDich, namGiaoDich, donGia, soLuong);
		this.loaiVang = loaiVang;
	}
		
	//4. Input, output methods
	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);
		System.out.print("Nhập loại vàng: ");
		this.loaiVang = scan.nextLine();
	}
	
	@Override
	public void xuat() {
		super.xuat();
		System.out.println("\tLoại vàng: " + this.loaiVang
				+ "\tThành tiền: " + this.thanhTien);
	}
	
	//5. Business methods
	@Override
	public void tinhThanhTien() {
		this.thanhTien = this.soLuong * this.donGia;
	}

}
