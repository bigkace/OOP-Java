import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		CongTy objCTy = new CongTy();
		objCTy.dummyDataCty();
		objCTy.dummyDataNhanSu();
		
		xuLyMenu(scan, objCTy);

	}
	
	private static void inMenu() {
		System.out.println("============================ Hãy nhập lựa chọn ===========================");
		System.out.println("|| Nhập 1. Nhập thông tin công ty                                       ||");
		System.out.println("|| Nhập 2. Phân bổ nhân viên vào trưởng phòng                           ||");
		System.out.println("|| Nhập 3. Thêm nhân sự mới                                             ||");
		System.out.println("|| Nhập 4. Xoá nhân sự                                                  ||");
		System.out.println("|| Nhập 5. Xuất ra thông tin toàn bộ nhân sự trong công ty              ||");
		System.out.println("|| Nhập 6. Tính tổng lương toàn công ty                                 ||");
		System.out.println("|| Nhập 7. Tìm nhân viên thường có lương cao nhất                       ||");
		System.out.println("|| Nhập 8. Tìm trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất ||");
		System.out.println("|| Nhập 9. Sắp xếp nhân sự toàn công ty theo thứ tự abc                 ||");
		System.out.println("|| Nhập 10. Sắp xếp nhân sự toàn công ty theo thứ tự lương giảm dần     ||");
		System.out.println("|| Nhập 11. Tìm giám đốc có số lượng cổ phần nhiều nhất                 ||");
		System.out.println("|| Nhập 12. Tính và xuất thu nhập giám đốc                              ||");
		System.out.println("|| Nhập 0. Thoát chương trình                                           ||");
		System.out.println("==========================================================================");
		System.out.print("Lựa chọn >> ");
	}
	
	public static void xuLyMenu(Scanner scan, CongTy objCTy) {
		boolean flag = true;
		do {
			inMenu();
			int luaChon = Integer.parseInt(scan.nextLine());
			switch (luaChon) {
			case 1: 
				objCTy.nhap(scan);
				break;
			case 2:
				objCTy.phanBoNhanSuThuong();
				break;
			case 3:
				objCTy.themNhanSuMoi(scan);
				break;
			case 4:
				objCTy.xoaNhanSuCty(scan);
				break;
			case 5:
				objCTy.tinhLuong();
				objCTy.xuat();
				break;
			case 6:
				double tongLuong = objCTy.tinhTongLuongToanCty();
				System.out.println("Tổng lương toàn công ty: " + tongLuong);
				break;
			case 7: 
				objCTy.timNVTLuongCaoNhat();
				break;
			case 8:
				objCTy.timTPNVDuoiQuyenNN();
				break;
			case 9:
				objCTy.sortName();
				break;
			case 10:
				objCTy.sortSalary();
				break;
			case 11:
				objCTy.timGDCoPhanNN();
				break;
			case 12:
				objCTy.tinhThuNhapGD();
				break;
			case 0:
				flag = false;
				break;
			default:
				System.out.println("Lựa chọn bạn nhập không tồn tại! Hãy nhập lại!");
				break;
			}
		} while (flag);
	}

}
