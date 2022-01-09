import java.util.ArrayList;
import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		ListPerson objList = new ListPerson();
		objList.dummyData();
		
		xuLyMenu(scan, objList);

	}

	private static void inMenu() {
		System.out.println("==================================================");
		System.out.println("||               Nhập lựa chọn                  ||");
		System.out.println("|| Nhập 1. Xuất danh sách học viện              ||");
		System.out.println("|| Nhập 2. Thêm người vào danh sách             ||");
		System.out.println("|| Nhập 3. Xoá một người theo mã                ||");
		System.out.println("|| Nhập 4. Sắp xếp danh sách theo thứ tự họ tên ||");
		System.out.println("|| Nhập 0. Thoát chương trình                   ||");
		System.out.println("==================================================");
	}

	public static void xuLyMenu(Scanner scan, ListPerson objList) {
		boolean flag = true;
		do {
			inMenu();
			int luaChon = Integer.parseInt(scan.nextLine());
			switch (luaChon) {
			case 1:
				ArrayList<Person> listPerson = new ArrayList<Person>();
				listPerson = objList.getList();
				objList.xuat(listPerson);
				break;
			case 2:
				objList.nhap(scan);
				break;
			case 3:
				objList.xoaNhanVienTheoMa(scan);
				break;
			case 4:
				objList.sortName();
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
