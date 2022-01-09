/*
 * Mục đích: Xử lý các nghiệp vụ liên quan đến Nhân Sự
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 2/1/2021
 * Version: 1.0
 * */

public abstract class NhanSu implements NhapXuat {

	// 1. Attributes
	protected String maNS;
	protected String tenNS;
	protected String namSinh;
	protected String email;
	protected String soDienThoai;
	protected String maPhongBan;
	protected DanhSachTask objListTask;
	protected float luong;
	protected int soNgayLam;

	// 2. Get,set methods
	public String getMaNS() {
		return maNS;
	}

	public void setMaNS(String maNS) {
		this.maNS = maNS;
	}

	public String getTenNS() {
		return tenNS;
	}

	public void setTenNS(String tenNS) {
		this.tenNS = tenNS;
	}

	public String getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public DanhSachTask getObjListTask() {
		return objListTask;
	}

	public void setObjListTask(DanhSachTask objListTask) {
		this.objListTask = objListTask;
	}

	public int getSoNgayLam() {
		return soNgayLam;
	}

	public void setSoNgayLam(int soNgayLam) {
		this.soNgayLam = soNgayLam;
	}

	public float getLuong() {
		return luong;
	}

	// 3. Constructor methods
	private void init() {
		this.maPhongBan = "-1";
		this.objListTask = new DanhSachTask();
	}
	
	public NhanSu() {
		init();
	}
	
	public NhanSu(String maNS, String tenNS, String namSinh, String email, String soDienThoai, int soNgayLam) {
		init();
		this.maNS = maNS;
		this.tenNS = tenNS;
		this.namSinh = namSinh;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.soNgayLam = soNgayLam;
	}

	// 4. Input, output methods
	@Override
	public void xuat() {
		String temp = this.maPhongBan;
		if (this.maPhongBan.equalsIgnoreCase("-1")) {
			temp = "Chưa phân bổ";
		}
		
		System.out.println("Mã: " + this.maNS
				+ "\tTên: " + this.tenNS
				+ "\tNăm sinh: " + this.namSinh
				+ "\tEmail: " + this.email
				+ "\tSố điện thoại: " + this.soDienThoai
				+ "\tMã phòng ban: " + temp
				+ "\tSố ngày làm: " + this.soNgayLam
				+ "\tLương: " + this.luong);
		
		if (this.objListTask.getListTask().size() > 0) {
			System.out.println("Danh sách task nhân viên đang thực hiện");
			this.objListTask.xuat();
		}
	}
	
	public void xuatMaVaTen() {
		System.out.println("Mã: " + this.maNS + "\tTên: " + this.tenNS);
	}

	// 5. Business methods
	public abstract void tinhLuong();
	
	public void themTaskVaoList(Task task) {
		this.objListTask.getListTask().add(task);
	}
	
	public float tinhSoGioTask() {
		float soGioTask = 0;
		for (Task task : this.objListTask.getListTask()) {
			soGioTask += task.getThoiGianThucHien();
		}
		return soGioTask;
	}

}
