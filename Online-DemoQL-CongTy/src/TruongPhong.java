/*
 * Mục đích: Xử lý các nghiệp vụ liên quan đến Trưởng Phòng
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 2/1/2021
 * Version: 1.0
 * */

public class TruongPhong extends NhanSu {
	
	final int LUONG_NGAY = 300;
	final int PHU_CAP = 200;
	
	//1. Attributes
	//2. Get, set methods
	//3. Constructor methods
	public TruongPhong() {
		
	}
	
	public TruongPhong(String maNS, String tenNS, String namSinh, String email, String soDienThoai, int soNgayLam) {
		super(maNS, tenNS, namSinh, email, soDienThoai, soNgayLam);
	}
	
	//4. Input, output methods

	//5. Business methods
	@Override
	public void tinhLuong() {
		this.luong = this.soNgayLam * LUONG_NGAY + 200;
	}
	
	public void tinhSoNVQuanLy() {
	}

}
