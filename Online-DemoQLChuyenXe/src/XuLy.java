import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		DanhSachChuyenXe objDSCX = new DanhSachChuyenXe();
		Scanner scan = new Scanner(System.in);
//		objDSCX.nhap(scan);
		objDSCX.dummyData();
		objDSCX.xuat();
		
		objDSCX.tinhTongDoanhThu();
		System.out.println("Tổng doanh thu: " + objDSCX.getTongDoanhThu());
		
		objDSCX.tinhDoanhThuNoi();
		System.out.println("Tổng doanh thu nội thành: " + objDSCX.getDoanhThuNoi());
		
		objDSCX.tinhDoanhThuNgoai();
		System.out.println("Tổng doanh thu ngoại thành: " + objDSCX.getDoanhThuNgoai());
		
		float doanhThu = objDSCX.tinhDTCXBinhThuan();
		System.out.println("Tổng doanh thu xe đi Bình Thuận: " + doanhThu);

	}

}
