import java.util.Scanner;

/*
 * Mục đích: Xử lý nghiệp vụ liên quan đến giao dịch đất
 * Người tạo: Vũ Nam Khánh
 * Ngày tao: 23/12/2021
 * Version: 1.0
 * */

public class GiaoDichDat extends GiaoDich {
	
	final float tiGia = 1.5f;
	
	//1. Attributes
	private String loaiDat;
	
	//2. Get, set methods
	public String getLoaiDat() {
		return loaiDat;
	}
	
	public void setLoaiDat(String loaiDat) {
		this.loaiDat = loaiDat;
	}
	
	//3. Constructor methods
	public GiaoDichDat() {
		super();
	}
	
	public GiaoDichDat(String maGiaoDich, int ngayGD, int thangGD, int namGD, float donGia, float dienTich, String loaiDat) {
		super(maGiaoDich, ngayGD, thangGD, namGD, donGia, dienTich);
		this.loaiDat = loaiDat;
	}
		
	//4. Input, output methods
	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);
		
		System.out.print("Nhập loại đất (Loại A, B, C): ");
		this.loaiDat = scan.nextLine();
	}
	
	@Override
	public void xuat() {
		super.xuat();
		System.out.println("\tLoại đất: " + getLoaiDat() + "\tThành tiền: " + getThanhTien());
	}
	
	//5. Business methods
	@Override
	public void tinhThanhTien() {
		if (this.loaiDat.equalsIgnoreCase("A")) {
			this.thanhTien = getDonGia() * getDienTich() * tiGia;
		} else {
			this.thanhTien = getDonGia() * getDienTich();
		}
	}
	
}
