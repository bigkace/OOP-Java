import java.util.ArrayList;
import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		TruongHoc objTruongHoc = new TruongHoc();
		objTruongHoc.taoDuLieu();
		
		xuLyMenu(objTruongHoc, scan);
		
	}
	
	private static void inMenu() {
		System.out.println("=========================== Menu Lựa Chọn ==========================");
		System.out.println("|| Nhập 1. Nhập thêm thành viên                                   ||");
		System.out.println("|| Nhập 2. Xuất danh sách thông tin giáo viên trường học          ||");
		System.out.println("|| Nhập 3. Xuất danh sách thông tin học sinh trường học           ||");
		System.out.println("|| Nhập 4. Tính số năm giảng dạy(thâm niên) của Giáo Viên         ||");
		System.out.println("|| Nhập 5. Tìm Giáo Viên có thâm niên cao nhất                    ||");
		System.out.println("|| Nhập 6. Tìm Giáo Viên thâm niên > 5 và thuộc khối Tự nhiên     ||");
		System.out.println("|| Nhập 7. Tính điểm trung bình học sinh                          ||");
		System.out.println("|| Nhập 8. Tìm điểm trung bình cao nhất                           ||");
		System.out.println("|| Nhập 9. Tìm Học Sinh có điêm trung bình cao nhất               ||");
		System.out.println("|| Nhập 10. Xếp loại học sinh                                     ||");
		System.out.println("|| Nhập 11. Sắp xêp học sinh theo thứ tự giảm dần Điểm Trung Bình ||");
		System.out.println("|| Nhập 12. Sắp xêp học sinh theo ABC                             ||");
		System.out.println("|| Nhập 0. Thoát                                                  ||");
		System.out.println("====================================================================");
	}
	
	public static void xuLyMenu(TruongHoc objTruongHoc, Scanner scan) {
		boolean flag = true;
		do {
			inMenu();
			System.out.print("Lựa chọn >> ");
			int luaChon = Integer.parseInt(scan.nextLine());
			switch (luaChon) {
			case 1:
				objTruongHoc.nhap();
				break;
			case 2:
				System.out.println("DANH SÁCH GIÁO VIÊN TOÀN TRƯỜNG");
				ArrayList<GiaoVien> dsGiaovien = objTruongHoc.layDSGiaoVien();
				objTruongHoc.xuatTheoFormatGiaoVien(dsGiaovien);
				break;
			case 3:
				System.out.println("DANH SÁCH HỌC SINH TOÀN TRƯỜNG");
				ArrayList<HocSinh> dsHocSinh = objTruongHoc.layDSHocSinh();
				objTruongHoc.xuatTheoFormatHocSinh(dsHocSinh);
				break;
			case 4:
				objTruongHoc.tinhThamNien();
				break;
			case 5:
				System.out.println("DANH SÁCH GIÁO VIÊN THÂM NIÊN CAO NHẤT");
				ArrayList<GiaoVien> dsGVThamNienCaoNhat = objTruongHoc.timGVThamNienCaoNhat();
				objTruongHoc.xuatTheoFormatGiaoVien(dsGVThamNienCaoNhat);
				break;
			case 6:
				System.out.println("DANH SÁCH GIÁO VIÊN THÂM NIÊN LỚN HƠN 5 VÀ KHỐI TỰ NHIÊN");
				ArrayList<GiaoVien> dsGVThamNienLonHon5VaKhoiTN = objTruongHoc.timGVThamNienLonHon5VaKhoiTN();
				objTruongHoc.xuatTheoFormatGiaoVien(dsGVThamNienLonHon5VaKhoiTN);
				break;
			case 7:
				objTruongHoc.tinhDiemTB();
				break;
			case 8:
				objTruongHoc.timDiemTBCaoNhat();
				break;
			case 9:
				System.out.println("DANH SÁCH HỌC SINH ĐIỂM TRUNG BÌNH CAO NHẤT");
				objTruongHoc.timHSDiemTBCaoNhat();
				break;
			case 10:
				objTruongHoc.xepLoai();
				break;
			case 11:
				System.out.println("DANH SÁCH HỌC SINH THEO ĐIỂM TRUNG BÌNH GIẢM DẦN");
				objTruongHoc.sapXepHSDiemTBGiam();
				break;
			case 12:
				System.out.println("DANH SÁCH HỌC SINH THEO TÊN ABC");
				objTruongHoc.sortName();
				break;
			case 0: 
				flag = false;
				break;
			default:
				System.out.println("Lựa chọn không hợp lệ!");
				break;
			}
		} while (flag);
	}

}
