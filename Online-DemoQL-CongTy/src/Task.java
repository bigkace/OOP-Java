/*
 * Mục đích: Xử lý các nghiệp vụ liên quan đến Task
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 2/1/2021
 * Version: 1.0
 * */

public class Task implements NhapXuat {
	
	//1. Attributes
	private String maTask;
	private String tenTask;
	private float thoiGianThucHien;
	private String maPhongBan;
	
	//2. Get, set methods
	public String getMaTask() {
		return maTask;
	}

	public void setMaTask(String maTask) {
		this.maTask = maTask;
	}

	public String getTenTask() {
		return tenTask;
	}

	public void setTenTask(String tenTask) {
		this.tenTask = tenTask;
	}

	public float getThoiGianThucHien() {
		return thoiGianThucHien;
	}

	public void setThoiGianThucHien(float thoiGianThucHien) {
		this.thoiGianThucHien = thoiGianThucHien;
	}

	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	//3. Constructor methods
	public void init() {
		this.maPhongBan = "-1";
	}
	
	public Task(String maTask, String tenTask, float thoiGianThucHien, String maPhongBan) {
		this.maTask = maTask;
		this.tenTask = tenTask;
		this.thoiGianThucHien = thoiGianThucHien;
		this.maPhongBan = maPhongBan;
	}

	public Task(String maTask, String tenTask, float thoiGianThucHien) {
		init();
		this.maTask = maTask;
		this.tenTask = tenTask;
		this.thoiGianThucHien = thoiGianThucHien;
	}

	//4. Input, ouput methods
	@Override
	public void xuat() {
		String temp = this.maPhongBan;
		if (this.maPhongBan.equalsIgnoreCase("-1")) {
			temp = "Chưa phân bổ";
		}
		System.out.println("Mã: " + this.maTask
				+ "\tTên: " + this.tenTask
				+ "\tThời gian thực hiện: " + this.thoiGianThucHien
				+ "\tMã phòng ban thực hiện: " + temp);
	}
	
	//5. Business methods

	


}
