import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		CongTy objCTy = new CongTy();
		objCTy.taoDuLieu();
		
		xuLyMenu(objCTy, scan);
		
	}
	
	private static void inMenu() {
		System.out.println("Nhập 1. Phân bổ Nhân Viên Thường về Phòng Ban");
		System.out.println("Nhập 2. Chỉ định Trưởng Phòng cho Phòng Ban");
		System.out.println("Nhập 3. Phân bổ Task");
		System.out.println("Nhập 4. Xuất List Nhân Sự");
		System.out.println("Nhập 5. Xuất List Phòng Ban");
		System.out.println("Nhập 6. Xuất List Task");
		System.out.println("Nhập 0. Thoát chương trình");
	}
	
	public static void xuLyMenu(CongTy objCTy, Scanner scan) {
		boolean flag = true;
		do {
			inMenu();
			int luaChon = Integer.parseInt(scan.nextLine());
			switch (luaChon) {
			case 1:
				objCTy.phanBoNhanVienThuong();
				break;
			case 2: 
				objCTy.chiDinhTPChoPhongBan();
				break;
			case 3: 
				objCTy.phanBoTask();
				break;
			case 4: 
				objCTy.xuatListNhanSu();
				break;
			case 5: 
				objCTy.xuatListPhongBan();
				break;
			case 6: 
				objCTy.xuatListTask();
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
