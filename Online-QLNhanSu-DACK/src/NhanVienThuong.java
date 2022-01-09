/*
 * Mục đích: Xử lý các nghiệp vụ liên quan đến Nhân Viên Thường
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 27/12/2021
 * Version: 1.0
 * */

public class NhanVienThuong extends NhanSu {

	// Constants
	final static int LUONG_NGAY = 100;

	// 1. Attributes
	private TruongPhong truongPhong;

	// 2. Get, set methods
	public TruongPhong getTruongPhong() {
		return truongPhong;
	}

	public void setTruongPhong(TruongPhong truongPhong) {
		this.truongPhong = truongPhong;
	}

	// 3. Constructor methods
	public NhanVienThuong() {
		this.truongPhong = null; // Chưa được phân bổ
	}

	public NhanVienThuong(String maSo, String hoTen, String soDienThoai, int soNgayLamViec) {
		super(maSo, hoTen, soDienThoai, soNgayLamViec);
	}

	// 4. Input, output methods
	@Override
	public void xuat() {
		if (this.truongPhong != null) {
			super.xuat();
			System.out.println("\tLương: " + this.luong + "\tMã Trưởng Phòng QL: " + this.truongPhong.getMaSo()
					+ "\tTên Trưởng Phòng QL: " + this.truongPhong.getHoTen());
		} else {
			super.xuat();
			System.out.println("\tLương: " + this.luong + "\tChưa phân bổ");
		}
	}

	// 5. Business methods
	@Override
	public void tinhLuong() {
		this.luong = LUONG_NGAY * this.soNgayLamViec;
	}

}
