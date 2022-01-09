import java.util.ArrayList;
import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		DanhSachGiaoDich objDSGD = new DanhSachGiaoDich();
//		objDSGD.nhap(scan);
		objDSGD.dummyData();
		
		xuLyMenu(scan, objDSGD);
	}
	
	public static void inMenu() {
		System.out.println("======================================================");
		System.out.println("||                 Lựa chọn chức năng               ||");
		System.out.println("|| 1. Xuất danh sách toàn bộ giao dịch              ||");
		System.out.println("|| 2. Xuất danh sách giao dịch đất                  ||");
		System.out.println("|| 3. Xuất danh sách giao dịch nhà                  ||");
		System.out.println("|| 4. Nhập(Thêm) giao dịch                          ||");
		System.out.println("|| 5. Hiển thị số lượng giao dịch từng loại         ||");
		System.out.println("|| 6. Hiển thị trung bình thành tiền giao dịch đất. ||\n||"
				            + "    Xuất ra danh sách giao dịch tháng 9 năm 2013  ||");
		System.out.println("|| 0. Thoát chương trình                            ||");
		System.out.println("======================================================");
	}
	
	public static void xuLyMenu(Scanner scan, DanhSachGiaoDich objDSGGD) {
		boolean flag = true;
		do {
			inMenu();
			byte luaChon = Byte.parseByte(scan.nextLine());
			switch (luaChon) {
			case 1:
				ArrayList<GiaoDich> listGD = new ArrayList<GiaoDich>();
				listGD = objDSGGD.getListGiaoDich();
				objDSGGD.xuat(listGD);
				break;
			case 2:
				ArrayList<GiaoDich> listGDD = new ArrayList<GiaoDich>();
				listGDD = objDSGGD.listGDDat();
				objDSGGD.xuat(listGDD);
				break;
			case 3: 
				ArrayList<GiaoDich> listGDN = new ArrayList<GiaoDich>();
				listGDN = objDSGGD.listGDNha();
				objDSGGD.xuat(listGDN);
				break;
			case 4: 
				objDSGGD.nhap(scan);
				break;
			case 5: 
				objDSGGD.tinhTongSLTungLoai();
				break;
			case 6:
				double tbThanhTienGDD = objDSGGD.tinhTBThanhTienGDD();
				System.out.println("Trung bình thành tiền giao dịch đất: " + tbThanhTienGDD);
				ArrayList<GiaoDich> listGDT9N2013 = new ArrayList<GiaoDich>();
				listGDT9N2013 = objDSGGD.listGDT9N2013();
				objDSGGD.xuat(listGDT9N2013);
				break;
			case 0: 
				flag = false;
				break;
			default:
				System.out.println("Lựa chọn bạn nhập không hợp lệ! Hãy nhập lại!");
				break;
			}
		} while (flag);
	}

}
