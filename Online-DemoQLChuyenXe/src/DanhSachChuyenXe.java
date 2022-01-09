import java.util.ArrayList;
import java.util.Scanner;

/*
 * Mục đích: Xử lí nghiệp vụ liên quan đến danh sách chuyến xe
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 22/12/2021
 * Version: 1.0
 * */

public class DanhSachChuyenXe {

	// 1. Attributes
	private ArrayList<ChuyenXe> listChuyenXe;
	private float tongDoanhThu;
	private float doanhThuNoi;
	private float doanhThuNgoai;

	// 2. Get, set methods
	public ArrayList<ChuyenXe> getListChuyenXe() {
		return listChuyenXe;
	}

	public void setListChuyenXe(ArrayList<ChuyenXe> listChuyenXe) {
		this.listChuyenXe = listChuyenXe;
	}
	
	public float getTongDoanhThu() {
		return tongDoanhThu;
	}
	
	public float getDoanhThuNoi() {
		return doanhThuNoi;
	}
	
	public float getDoanhThuNgoai() {
		return doanhThuNgoai;
	}

	// 3. Constructor methods
	public DanhSachChuyenXe() {
		this.listChuyenXe = new ArrayList<ChuyenXe>();
	}

	// 4. Input, output methods
	public void nhap(Scanner scan) {
		boolean flag = true;
		ChuyenXe chuyenXe;
		do {
			System.out.println("Nhập 1. Chuyến xe nội thành");
			System.out.println("Nhập 2. Chuyến xe ngoại thành");
			System.out.println("Nhập 0. Thoát nhập");
			int luaChon = Integer.parseInt(scan.nextLine());
			switch (luaChon) {
			case 1:
				chuyenXe = new ChuyenXeNoiThanh();
				chuyenXe.nhap(scan);
				this.listChuyenXe.add(chuyenXe);
				break;
			case 2:
				chuyenXe = new ChuyenXeNgoaiThanh();
				chuyenXe.nhap(scan);
				this.listChuyenXe.add(chuyenXe);
				break;
			case 0:
				flag = false;
				break;
			}
		} while (flag);
	}
	
	public void dummyData() {
		ChuyenXe chuyenXe;
		
		chuyenXe = new ChuyenXeNoiThanh("01", "nội thành 1", "29A-123", 1300, "số 12", 14.3f);
		this.listChuyenXe.add(chuyenXe);
		
		chuyenXe = new ChuyenXeNgoaiThanh("01", "ngoại thành 1", "29A-456", 3000, "Bình Thuận", 2);
		this.listChuyenXe.add(chuyenXe);
		
		chuyenXe = new ChuyenXeNoiThanh("02", "nội thành 2", "29A-234", 1900, "số 5", 20.3f);
		this.listChuyenXe.add(chuyenXe);
		
		chuyenXe = new ChuyenXeNgoaiThanh("02", "ngoại thành 2", "29A-567", 2200, "Đà Lạt", 1);
		this.listChuyenXe.add(chuyenXe);
		
		chuyenXe = new ChuyenXeNoiThanh("03", "nội thành 3", "29A-345", 1500, "số 8", 25.3f);
		this.listChuyenXe.add(chuyenXe);
		
		chuyenXe = new ChuyenXeNgoaiThanh("03", "ngoại thành 3", "29A-678", 3200, "Bình Thuận", 2);
		this.listChuyenXe.add(chuyenXe);
	}

	public void xuat() {
		for (ChuyenXe cx : this.listChuyenXe) {
			cx.xuat();
		}
	}

	// 5. Business methods
	public void tinhTongDoanhThu() {
		this.tongDoanhThu = 0;
		for (ChuyenXe cx : this.listChuyenXe) {
			this.tongDoanhThu += cx.getDoanhThu();
		}
	}
	
	public void tinhDoanhThuNoi() {
		this.doanhThuNoi = 0;
		for (ChuyenXe cx : this.listChuyenXe) {
			if(cx instanceof ChuyenXeNoiThanh) {
				this.doanhThuNoi += cx.getDoanhThu();
			}
		}
	}
	
	public void tinhDoanhThuNgoai() {
		this.doanhThuNgoai = 0;
		for (ChuyenXe cx : this.listChuyenXe) {
			if(cx instanceof ChuyenXeNgoaiThanh) {
				this.doanhThuNgoai += cx.getDoanhThu();
			}
		}
	}
	
	public float tinhDTCXBinhThuan() {
		float doanhThu = 0;
		for (ChuyenXe cx : this.listChuyenXe) {
			if (cx instanceof ChuyenXeNgoaiThanh) {
				ChuyenXeNgoaiThanh ngoai = ((ChuyenXeNgoaiThanh) cx);   //Casting - ép kiểu trong đối tượng
				if (ngoai.getNoiDen().equalsIgnoreCase("Bình Thuận")) {
					doanhThu += ngoai.getDoanhThu();
				}
			}
		}
		return doanhThu;
	}
	
}
