import java.util.ArrayList;
import java.util.Scanner;

/*
 * Mục đích: Xử lý nghiệp vụ liên quan đến danh sách các giao dịch
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 25/12/2021
 * Version: 1.0
 * */

public class DanhSachGiaoDich {
	
	final static int MOT_TY = 10000;

	// 1. Attributes
	private ArrayList<GiaoDich> listGiaoDich;

	// 2. Get, set methods

	public ArrayList<GiaoDich> getListGiaoDich() {
		return listGiaoDich;
	}

	public void setListGiaoDich(ArrayList<GiaoDich> listGiaoDich) {
		this.listGiaoDich = listGiaoDich;
	}

	// 3. Constructor methods
	public DanhSachGiaoDich() {
		this.listGiaoDich = new ArrayList<GiaoDich>();
	}

	// 4. Input, output methods
	public void nhap(Scanner scan) {
		boolean flag = true;
		GiaoDich giaoDich;
		do {
			System.out.println("Nhập 1. Giao dịch vàng");
			System.out.println("Nhập 2. Giao dịch tiền tệ");
			System.out.println("Nhập 0. Thoát nhập");
			int luaChon = Integer.parseInt(scan.nextLine());
			switch (luaChon) {
			case 1:
				giaoDich = new GiaoDichVang();
				giaoDich.nhap(scan);
				this.listGiaoDich.add(giaoDich);
				break;
			case 2:
				giaoDich = new GiaoDichTienTe();
				giaoDich.nhap(scan);
				this.listGiaoDich.add(giaoDich);
				break;
			case 0:
				flag = false;
				break;
			default:
				System.out.println("Lựa chọn bạn nhập không hợp lệ! Hãy nhập lại!");
				break;
			}
		} while (flag);
	}
	
	public void dummyData() {
		GiaoDich giaoDich;
		
		giaoDich = new GiaoDichVang("GDV-01", 22, 12, 2021, 1200, 12, "9999");
		this.listGiaoDich.add(giaoDich);
		
		giaoDich = new GiaoDichTienTe("GDTT-01", 2, 12, 2021, 1750, 10, 1300, 1);
		this.listGiaoDich.add(giaoDich);
		
		giaoDich = new GiaoDichVang("GDV-02", 2, 2, 2021, 900, 15, "9999");
		this.listGiaoDich.add(giaoDich);
		
		giaoDich = new GiaoDichTienTe("GDTT-02", 25, 6, 2021, 1800, 8, 1500, 2);
		this.listGiaoDich.add(giaoDich);
		
		giaoDich = new GiaoDichVang("GDV-03", 15, 9, 2021, 1500, 13, "SJC");
		this.listGiaoDich.add(giaoDich);
		
		giaoDich = new GiaoDichTienTe("GDTT-03", 2, 10, 2021, 1800, 10, 900, 1);
		this.listGiaoDich.add(giaoDich);
		
		giaoDich = new GiaoDichVang("GDV-04", 22, 5, 2021, 1010, 9, "9999");
		this.listGiaoDich.add(giaoDich);
		
		giaoDich = new GiaoDichTienTe("GDTT-04", 6, 6, 2021, 1000, 12, 1000, 3);
		this.listGiaoDich.add(giaoDich);
		
		giaoDich = new GiaoDichVang("GDV-05", 22, 1, 2021, 1300, 11, "SJC");
		this.listGiaoDich.add(giaoDich);
		
		giaoDich = new GiaoDichTienTe("GDTT-05", 21, 2, 2021, 1900, 15, 1000, 1);
		this.listGiaoDich.add(giaoDich);
	}

	public void xuat(ArrayList<GiaoDich> list) {
		for (GiaoDich gd : list) {
			gd.tinhThanhTien();
			gd.xuat();
		}
	}

	// 5. Business methods
	public ArrayList<GiaoDich> listGDVang() {
		ArrayList<GiaoDich> listGiaoDich = new ArrayList<GiaoDich>();
		for (GiaoDich gd : this.listGiaoDich) {
			if (gd instanceof GiaoDichVang) {
				listGiaoDich.add(gd);
			}
		}
		return listGiaoDich;
	}
	
	public ArrayList<GiaoDich> listGDTienTe() {
		ArrayList<GiaoDich> listGiaoDich = new ArrayList<GiaoDich>();
		for (GiaoDich gd : this.listGiaoDich) {
			if (gd instanceof GiaoDichTienTe) {
				listGiaoDich.add(gd);
			}
		}
		return listGiaoDich;
	}
	
	public void tongSLGDTungLoai() {
		int demGDVang = 0;
		int demGDTienTe = 0;
		for (GiaoDich gd : this.listGiaoDich) {
			if (gd instanceof GiaoDichVang) {
				demGDVang += gd.getSoLuong();
			} else {
				demGDTienTe += gd.getSoLuong();
			}
		}
		System.out.println("Số lượng giao dịch vàng: " + demGDVang);
		System.out.println("Số lượng giao dịch tiền tệ: " + demGDTienTe);
	}
	
	public void tinhTBThanhTienGDTienTe() {
		int demGDTienTe = 0;
		double tongThanhTienGDTT = 0;
		for (GiaoDich gd : this.listGiaoDich) {
			if (gd instanceof GiaoDichTienTe) {
				demGDTienTe += gd.getSoLuong();
				tongThanhTienGDTT += gd.getThanhTien();
			}
		}
		double tbThanhTienGDTT = tongThanhTienGDTT / demGDTienTe;
		System.out.println("Trung bình thành tiền giao dịch tiền tệ: " + tbThanhTienGDTT);
	}
	
	public ArrayList<GiaoDich> listGDLonHon1Ty() {
		ArrayList<GiaoDich> listGiaoDich = new ArrayList<GiaoDich>();
		for (GiaoDich gd : this.listGiaoDich) {
			if (gd.getThanhTien() > MOT_TY) {
				listGiaoDich.add(gd);
			}
		}
		return listGiaoDich;
	}
	
}
