import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		DanhSachSinhVien listSV = new DanhSachSinhVien();
		
		xuLyLuaChon(scan, listSV);

	}

	private static void inMenu() {
		System.out.println("Chọn chức năng: ");
		System.out.println("1. Thêm sinh viên.");
		System.out.println("2. Xuất danh sách sinh viên.");
		System.out.println("0. Thoát");
	}

	private static void xuLyLuaChon(Scanner scan, DanhSachSinhVien listSV) {
		boolean flag = true;

		do {
			inMenu();
			System.out.println("Mời chọn: ");
			int luaChon = Integer.parseInt(scan.nextLine());
			switch (luaChon) {
			case 1:
				SinhVien sv = new SinhVien();
				sv.nhap(scan);
				listSV.themSinhVien(sv);
				break;
			case 2:
				listSV.tinhDiemTB();
				listSV.xepLoai();
				listSV.xuat();
				break;
			case 0:
				flag = false;
				break;
			}
		} while (flag);
	}

}
