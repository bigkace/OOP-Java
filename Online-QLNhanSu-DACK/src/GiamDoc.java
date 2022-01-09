import java.util.Scanner;

/*
 * Mục đích: Xử lý các nghiệp vụ liên quan đến Giám Đốc
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 27/12/2021
 * Version: 1.0
 * */

public class GiamDoc extends NhanSu {

	// Constants
	final static int LUONG_NGAY = 300;

	// 1. Attributes
	private float coPhan;

	// 2. Get, set methods
	public float getCoPhan() {
		return coPhan;
	}

	public void setCoPhan(float coPhan) {
		this.coPhan = coPhan;
	}

	// 3. Constructor methods
	public GiamDoc() {
		// TODO Auto-generated constructor stub
	}

	public GiamDoc(String maSo, String hoTen, String soDienThoai, int soNgayLamViec, float coPhan) {
		super(maSo, hoTen, soDienThoai, soNgayLamViec);
		this.coPhan = coPhan;
	}

	// 4. Input, output methods
	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);

		System.out.print("Nhập cổ phần: ");
		this.coPhan = Float.parseFloat(scan.nextLine());
	}

	@Override
	public void xuat() {
		super.xuat();
		System.out.println("\tCổ phần: " + this.coPhan + "\tLương: " + this.luong);
	}

	// 5. Business methods
	@Override
	public void tinhLuong() {
		this.luong = LUONG_NGAY * this.soNgayLamViec;
	}

}
