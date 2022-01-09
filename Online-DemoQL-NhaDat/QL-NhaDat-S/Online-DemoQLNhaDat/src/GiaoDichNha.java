import java.util.Scanner;

/*
 * Mục đích: Xử lý các nghiệp vụ giao dịch nhà
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 23/12/2021
 * Version: 1.0
 * */

public class GiaoDichNha extends GiaoDich{
	
	final float tiGia = 0.9f;
	
	//1. Attributes
	private String loaiNha;
	private String diaChi;
	
	//2. Get, set methods
	public String getLoaiNha() {
		return loaiNha;
	}
	
	public void setLoaiNha(String loaiNha) {
		this.loaiNha = loaiNha;
	}
	
	public String getDiaChi() {
		return diaChi;
	}
	
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
		
	//3. Constructor methods
	public GiaoDichNha() {
		super();
	}
	
	public GiaoDichNha(String maGiaoDich, int ngayGD, int thangGD, int namGD, float donGia, float dienTich, String loaiNha, String diaChi) {
		super(maGiaoDich, ngayGD, thangGD, namGD, donGia, dienTich);
		this.loaiNha = loaiNha;
		this.diaChi = diaChi;
	}
		
	//4. Input, output methods
	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);
		
		System.out.print("Nhập loại nhà (Cao cấp, Thường): ");
		this.loaiNha = scan.nextLine();
		
		System.out.print("Nhập địa chỉ: ");
		this.diaChi = scan.nextLine();
	}
	
	@Override
	public void xuat() {
		super.xuat();
		System.out.println("\tLoại nhà: " + getLoaiNha() + "\tĐịa Chỉ: " + getDiaChi() + "\tThành tiền: " + getThanhTien());
	}
	
	//5. Business methods
	@Override
	public void tinhThanhTien() {
		if (this.loaiNha.equalsIgnoreCase("Thường")) {
			this.thanhTien = getDonGia() * getDienTich() * tiGia;
		} else {
			this.thanhTien = getDonGia() * getDienTich();
		}
	}


}
