import java.util.ArrayList;

/*
 * Mục đích: Xử lý các nghiệp vụ liến quan đến Phòng Ban
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 2/1/2022
 * Version: 1.0
 * */

public class PhongBan implements NhapXuat {
	
	//1. Attributes
	private String maPhongBan;
	private String tenPhongBan;
	private TruongPhong truongPhong;
	private ArrayList<NhanVienThuong> listNhanVien;
	private ArrayList<Task> listTask;

	//2. Get, set methods
	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public String getTenPhongBan() {
		return tenPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}

	public TruongPhong getTruongPhong() {
		return truongPhong;
	}

	public void setTruongPhong(TruongPhong truongPhong) {
		this.truongPhong = truongPhong;
	}
	
	public ArrayList<NhanVienThuong> getListNhanVien() {
		return listNhanVien;
	}

	public void setListNhanVien(ArrayList<NhanVienThuong> listNhanVien) {
		this.listNhanVien = listNhanVien;
	}

	public ArrayList<Task> getListTask() {
		return listTask;
	}

	public void setListTask(ArrayList<Task> listTask) {
		this.listTask = listTask;
	}

	//3. Constructor methods
	public PhongBan() {
		this.truongPhong = null;
		this.listNhanVien = new ArrayList<NhanVienThuong>();
		this.listTask = new ArrayList<Task>();
	}
	
	public PhongBan(String maPhongBan, String tenPhongBan) {
		this.maPhongBan = maPhongBan;
		this.tenPhongBan = tenPhongBan;
		this.listNhanVien = new ArrayList<NhanVienThuong>();
		this.listTask = new ArrayList<Task>();
	}
	
	public PhongBan(String maPhongBan, String tenPhongBan, DanhSachNhanSu objListNhanVien, DanhSachTask objListTask) {
		this.maPhongBan = maPhongBan;
		this.tenPhongBan = tenPhongBan;
		this.listNhanVien = new ArrayList<NhanVienThuong>();
		this.listTask = new ArrayList<Task>();
	}

	//4. Input, output methods
	@Override
	public void xuat() {
		System.out.print("Tên: " + this.tenPhongBan
				+ "\tMã: " + this.maPhongBan);
		if (this.truongPhong != null) {
			System.out.println("\tTrưởng phòng: " + this.truongPhong.getTenNS());
			this.truongPhong.xuat();
		} else {
			System.out.println("\tPhòng ban chưa có trưởng phòng");
		}
		System.out.println("Danh sách nhân sự của phòng ban");
		for (NhanVienThuong nvt : this.listNhanVien) {
			nvt.xuat();
		}
		System.out.println("Danh sách task của phòng ban");
		for (Task task : this.listTask) {
			task.xuat();
		}
	}
	
	public void xuatTenVaMa() {
		System.out.print("Tên: " + this.tenPhongBan
				+ "\tMã: " + this.maPhongBan);
		if (this.truongPhong != null) {
			System.out.println("\tTrưởng phòng: " + this.truongPhong.getTenNS());
		} else {
			System.out.println("\tPhòng ban chưa có trưởng phòng");
		}
	}
	
	//5. Business methods

}
