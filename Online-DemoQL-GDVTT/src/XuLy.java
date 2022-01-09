import java.util.ArrayList;
import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		DanhSachGiaoDich objDSGD = new DanhSachGiaoDich();
		objDSGD.dummyData();
		
		xuLyMenu(scan, objDSGD);

	}
	
	private static void inMenu() {
		System.out.println("========================================================");
		System.out.println("||                Hãy nhập lựa chọn                   ||");
		System.out.println("|| 1. Nhập thông tin                                  ||");
		System.out.println("|| 2. Xuất danh sách giao dịch tổng                   ||");
		System.out.println("|| 3. Xuất danh sách giao dịch vàng                   ||");
		System.out.println("|| 4. Xuất danh sách giao dịch tiền tệ                ||");
		System.out.println("|| 5. Hiển thị tổng số lượng giao dịch từng loại      ||");
		System.out.println("|| 6. Hiển thị trung bình thành tiền giao dịch tiền tệ||");
		System.out.println("|| 7. Xuất danh sách giao dịch có đơn giá > 1 tỷ      ||");
		System.out.println("|| 0. Thoát chương trình                              ||");
		System.out.println("========================================================");
	}
	
	public static void xuLyMenu(Scanner scan, DanhSachGiaoDich objDSGD) {
		boolean flag = true;
		do {
			inMenu();
			int luaChon = Integer.parseInt(scan.nextLine());
			switch (luaChon) {
			case 1: 
				objDSGD.nhap(scan);
				break;
			case 2: 
				ArrayList<GiaoDich> listGDTong = new ArrayList<GiaoDich>();
				listGDTong = objDSGD.getListGiaoDich();
				objDSGD.xuat(listGDTong);
				break;
			case 3: 
				ArrayList<GiaoDich> listGDVang = new ArrayList<GiaoDich>();
				listGDVang = objDSGD.listGDVang();
				objDSGD.xuat(listGDVang);
				break;
			case 4: 
				ArrayList<GiaoDich> listGDTienTe = new ArrayList<GiaoDich>();
				listGDTienTe = objDSGD.listGDTienTe();
				objDSGD.xuat(listGDTienTe);
				break;
			case 5:
				objDSGD.tongSLGDTungLoai();
				break;
			case 6: 				
				objDSGD.tinhTBThanhTienGDTienTe();
				break;
			case 7: 
				ArrayList<GiaoDich> listGDLonHon1Ty = new ArrayList<GiaoDich>();
				listGDLonHon1Ty = objDSGD.listGDLonHon1Ty();
				objDSGD.xuat(listGDLonHon1Ty);
				break;
			case 0: 
				flag = false;
				break;
			default:
				break;
			}
		} while (flag);
	}

}
