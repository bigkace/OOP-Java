import java.util.ArrayList;
import java.util.Scanner;

/*
 * Mục đích: Xử lý nghiệp vụ liên quan đến danh sách giao dịch
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 23/12/2021
 * Version: 1.0
 * */

public class DanhSachGiaoDich {
	
	//1. Attributes
	private ArrayList<GiaoDich> listGiaoDich;
	
	//2. Get, set methods
	public ArrayList<GiaoDich> getListGiaoDich() {
		return listGiaoDich;
	}
	
	public void setListGiaoDich(ArrayList<GiaoDich> listGiaoDich) {
		this.listGiaoDich = listGiaoDich;
	}
		
	//3. Constructor methods
	public DanhSachGiaoDich() {
		this.listGiaoDich = new ArrayList<GiaoDich>();
	}
	
	//4. Input, ouput methods
	public void nhap(Scanner scan) {
		boolean flag = true;
		GiaoDich giaoDich;
		do {
			System.out.println("Nhập 1. Giao dịch đất");
			System.out.println("Nhập 2. Giao dịch nhà");
			System.out.println("Nhập 0. Thoát nhập");
			int luaChon = Integer.parseInt(scan.nextLine());
			switch (luaChon) {
			case 1:
				giaoDich = new GiaoDichDat();
				giaoDich.nhap(scan);
				this.listGiaoDich.add(giaoDich);
				break;
			case 2:
				giaoDich = new GiaoDichNha();
				giaoDich.nhap(scan);
				this.listGiaoDich.add(giaoDich);
				break;
			case 0:
				flag = false;
				break;
			}
		} while (flag);
	}
	
	public void dummyData() {
		GiaoDich giaoDich;
		
		giaoDich = new GiaoDichDat("GDĐ-01", 22, 12, 2015, 3000, 180.5f, "A");
		this.listGiaoDich.add(giaoDich);
		
		giaoDich = new GiaoDichNha("GDN-01", 5, 7, 2015, 2000, 180.5f, "Cao cấp", "Cầu Giấy");
		this.listGiaoDich.add(giaoDich);
		
		giaoDich = new GiaoDichDat("GDĐ-02", 2, 9, 2013, 2200, 190, "B");
		this.listGiaoDich.add(giaoDich);
		
		giaoDich = new GiaoDichNha("GDN-02", 6, 6, 2015, 2450, 210, "Thường", "Trường Chinh");
		this.listGiaoDich.add(giaoDich);
		
		giaoDich = new GiaoDichDat("GDĐ-03", 23, 6, 2015, 3200, 175.5f, "A");
		this.listGiaoDich.add(giaoDich);
		
		giaoDich = new GiaoDichNha("GDN-03", 12, 9, 2013, 2340, 180.5f, "Cao cấp", "Cầu Giấy");
		this.listGiaoDich.add(giaoDich);
		
		giaoDich = new GiaoDichDat("GDĐ-04", 12, 12, 2015, 2500, 200, "C");
		this.listGiaoDich.add(giaoDich);
		
		giaoDich = new GiaoDichNha("GDN-04", 8, 9, 2013, 3000, 200.5f, "Cao cấp", "Hoàn Kiếm");
		this.listGiaoDich.add(giaoDich);
		
		giaoDich = new GiaoDichDat("GDĐ-05", 22, 12, 2015, 2800, 210.5f, "B");
		this.listGiaoDich.add(giaoDich);
		
		giaoDich = new GiaoDichNha("GDN-05", 25, 7, 2015, 2750, 195.5f, "Thường", "Cầu Giấy");
		this.listGiaoDich.add(giaoDich);
	}
	
	public void xuat(ArrayList<GiaoDich> list) {
		for (GiaoDich gd : list) {
			gd.tinhThanhTien();
			gd.xuat();
		}
	}
	
	//5. Busniess methods
	public ArrayList<GiaoDich> listGDDat() {
		ArrayList<GiaoDich> listGD = new ArrayList<GiaoDich>();
		for (GiaoDich gd : this.listGiaoDich) {
			if (gd instanceof GiaoDichDat) {
				listGD.add(gd);
			}
		}
		return listGD;
	}
	
	public ArrayList<GiaoDich> listGDNha() {
		ArrayList<GiaoDich> listGD = new ArrayList<GiaoDich>();
		for (GiaoDich gd : this.listGiaoDich) {
			if (gd instanceof GiaoDichNha) {
				listGD.add(gd);
			}
		}
		return listGD;
	}
	
	public void tinhTongSLTungLoai() {
		int demGDDat = 0;
		int demGDDatLoaiA = 0;
		int demGDDatLoaiB = 0;
		int demGDDatLoaiC = 0;
		int demGDNha = 0;
		int demGDNhaCC = 0;
		int demGDNhaT = 0;
		for (GiaoDich gd : this.listGiaoDich) {
			if (gd instanceof GiaoDichDat) {
				demGDDat++;
				GiaoDichDat giaoDich = (GiaoDichDat) gd;
				if (giaoDich.getLoaiDat().equalsIgnoreCase("A")) {
					demGDDatLoaiA++;
				} else if (giaoDich.getLoaiDat().equalsIgnoreCase("B")) {
					demGDDatLoaiB++;
				} else {
					demGDDatLoaiC++;
				}
			} else {
				demGDNha++;
				GiaoDichNha giaoDich = (GiaoDichNha) gd;
				if (giaoDich.getLoaiNha().equalsIgnoreCase("Thường")) {
					demGDNhaT++;
				} else {
					demGDNhaCC++;
				}
			}
		}
		System.out.println("Số lượng giao dịch đất        : " + demGDDat);
		System.out.println("Số lượng giao dịch đất loại A : " + demGDDatLoaiA);
		System.out.println("Số lượng giao dịch đất loại B : " + demGDDatLoaiB);
		System.out.println("Số lượng giao dịch đất loại C : " + demGDDatLoaiC);
		System.out.println("Số lượng giao dịch nhà        : " + demGDNha);
		System.out.println("Số lượng giao dịch nhà cao cấp: " + demGDNhaCC);
		System.out.println("Số lượng giao dịch nhà thường : " + demGDNhaT);
	}
	
	public double tinhTBThanhTienGDD() {
		int dem = 0;
		double tongThanhTien = 0;
		for (GiaoDich gd : this.listGiaoDich) {
			if (gd instanceof GiaoDichDat) {
				tongThanhTien += gd.getThanhTien();
				dem++;
			}
		}
		return (tongThanhTien / dem);
	}
	
	public ArrayList<GiaoDich> listGDT9N2013() {
		ArrayList<GiaoDich> listGD = new ArrayList<GiaoDich>();
		for (GiaoDich gd : this.listGiaoDich) {
			if (gd.getThang() == 9 && gd.getNam() == 2013) {
				listGD.add(gd);
			}
		}
		return listGD;
	}


}
