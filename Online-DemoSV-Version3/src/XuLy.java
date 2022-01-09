import java.util.ArrayList;
import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// DanhSachSinhVien listSV = new DanhSachSinhVien();

		TruongHoc truong = new TruongHoc();
		truong.nhap();

		xuLyLuaChon(scan, truong);

	}

	private static void inMenu() {
		System.out.println("Chọn chức năng: ");
		System.out.println("1. Thêm sinh viên.");
		System.out.println("2. Xuất danh sách sinh viên.");
		System.out.println("3. Liệt kê DSSV có ĐTB cao nhất.");
		System.out.println("4. Liệt kê DSSV Yếu");
		System.out.println("5. Tìm sinh viên theo tên");
		System.out.println("6. Tìm sinh viên theo mã");
		System.out.println("7. Xoá sinh viên theo mã");
		System.out.println("0. Thoát");
	}

	private static void xuLyLuaChon(Scanner scan, TruongHoc truong) {
		boolean flag = true;

		do {
			inMenu();
			System.out.println("Mời chọn: ");
			int luaChon = Integer.parseInt(scan.nextLine());
			switch (luaChon) {
			case 1:
				SinhVien sv = new SinhVien();
				sv.nhap(scan);
				truong.themSinhVien(sv);
				break;
			case 2:
				truong.tinhDiemTB();
				truong.xepLoai();
//				truong.xuat();
				truong.xuatTheoFormat(truong.getDsSVToanTruong().getListSV());
				break;
			case 3:
				ArrayList<SinhVien> list = truong.timDSSVCoDTBCaoNhat();
//				truong.xuatHelper(list);
				truong.xuatTheoFormat(list);
//				for (SinhVien svList : list) {
//					svList.xuat();
//				}
				break;
			case 4:
				ArrayList<SinhVien> listYeu = truong.timDSSVYeu();
//				truong.xuatHelper(listYeu);
				truong.xuatTheoFormat(listYeu);
//				for (SinhVien svListYeu : listYeu) {
//					svListYeu.xuat();
//				}
				break;
			case 5:
				System.out.println("Nhập tên sinh viên cần tìm: ");
				String tenSV = scan.nextLine();
				ArrayList<SinhVien> listTenSV = truong.timSVTheoTen(tenSV);
//				truong.xuatHelper(listTenSV);
				truong.xuatTheoFormat(listTenSV);
				break;
			case 6:
				System.out.println("Nhập mã sinh viên: ");
				int maSV = Integer.parseInt(scan.nextLine());
				SinhVien svFound = truong.timSVTheoMa(maSV);
				if (svFound == null) {
					System.out.println("Mã số sinh viên nhập không tồn tại");
				} else {
					svFound.xuat();
				}
				break;
			case 7: 
				System.out.println("Nhập mã sinh viên cần xoá: ");
				int maXoa = Integer.parseInt(scan.nextLine());
				boolean xoa = truong.xoaSVTheoMa(maXoa);
				if(xoa) {
					System.out.println("Xoá thành công");
				} else {
					System.out.println("Mã sinh viên không tồn tại");
				}
				break;
			case 0:
				flag = false;
				break;
			}
		} while (flag);
	}

}
