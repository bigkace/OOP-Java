/*
 * Mục đích: Xử lý các nghiệp vụ liên quan đến Nhân Viên Thường
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 2/1/2022
 * Version: 1.0
 * */

public class NhanVienThuong extends NhanSu {
	
	final int LUONG_NGAY = 200;
	final int PHU_CAP_1 = 300;
	final int PHU_CAP_2 = 1000;
	
	//1. Attributes
	//2. Get, set methods
	//3. Constructor methods
	public NhanVienThuong() {
		
	}
	
	public NhanVienThuong(String maNS, String tenNS, String namSinh, String email, String soDienThoai, int soNgayLam) {
		super(maNS, tenNS, namSinh, email, soDienThoai, soNgayLam);
	}
	
	//4. Input, output methods
	
	//5. Business methods
	@Override
	public void tinhLuong() {
		float soGioTask = tinhSoGioTask();
		if (soGioTask > 10) {
			this.luong = LUONG_NGAY * this.soNgayLam + 300 + 1000;
		} else {
			this.luong = LUONG_NGAY * this.soNgayLam + 300;
		}
	}

}
