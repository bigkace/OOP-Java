import java.util.ArrayList;
import java.util.Scanner;

/*
 * Mục đích: Xử lý các nghiệp vụ liên quan đến Công Ty
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 2/1/2022
 * Version: 1.0
 * */

public class CongTy {

	// 1. Attributes
	private String tenCongTy;
	private String maSoThue;
	private float tongLuong;
	private DanhSachNhanSu objListNhanSu;
	private DanhSachPhongBan objListPhongBan;
	private DanhSachTask objListTask;
	private ArrayList<TruongPhong> listTruongPhong;

	// 2. Get, set methods
	public String getTenCongTy() {
		return tenCongTy;
	}

	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;
	}

	public String getMaSoThue() {
		return maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public DanhSachNhanSu getObjListNhanSu() {
		return objListNhanSu;
	}

	public void setObjListNhanSu(DanhSachNhanSu objListNhanSu) {
		this.objListNhanSu = objListNhanSu;
	}

	public DanhSachPhongBan getObjListPhongBan() {
		return objListPhongBan;
	}

	public void setObjListPhongBan(DanhSachPhongBan objListPhongBan) {
		this.objListPhongBan = objListPhongBan;
	}

	public DanhSachTask getObjListTask() {
		return objListTask;
	}

	public void setObjListTask(DanhSachTask objListTask) {
		this.objListTask = objListTask;
	}

	public float getTongLuong() {
		return tongLuong;
	}

	public ArrayList<TruongPhong> getListTruongPhong() {
		return listTruongPhong;
	}

	public void setListTruongPhong(ArrayList<TruongPhong> listTruongPhong) {
		this.listTruongPhong = listTruongPhong;
	}

	// 3. Constructor methods
	public CongTy() {
		this.listTruongPhong = new ArrayList<TruongPhong>();
	}

	// 4. Input, output methods
	public void xuatListNhanSu() {
		this.objListNhanSu.xuat();
	}

	public void xuatListPhongBan() {
		this.objListPhongBan.xuat();
	}

	public void xuatListTask() {
		this.objListTask.xuat();
	}

	// 5. Business methods
	public void taoDuLieu() {
		this.objListNhanSu = new DanhSachNhanSu();
		this.objListNhanSu.taoDuLieu();

		this.objListPhongBan = new DanhSachPhongBan();
		this.objListPhongBan.taoDuLieu();

		this.objListTask = new DanhSachTask();
		this.objListTask.taoDuLieu();

		layDSTruongPhong();
	}

	/*
	 * Phân bổ nhân viên về Phòng Ban
	 */
	/*
	 * Duyệt danh sách chọn nhân viên thường Hỏi phân bổ Hiển thị phòng ban Tìm kiếm
	 * phòng ban theo mã Add vào list nhân viên trong phòng ban set mã phòng ban cho
	 * nhân viên
	 */
	public PhongBan timPhongBanTheoMa(Scanner scan) {
		PhongBan phongBan = null;
		do {
			System.out.print("Lựa chọn >> ");
			String ma = scan.nextLine();
			for (PhongBan pb : this.objListPhongBan.getListPhongBan()) {
				if (pb.getMaPhongBan().equalsIgnoreCase(ma)) {
					phongBan = pb;
					break;
				}
			}
		} while (phongBan == null);
		return phongBan;
	}

	private void xuatDSTenVaMaPB() {
		this.objListPhongBan.xuatDSTenVaMa();
	}

	public void phanBoNhanVienThuong() {
		Scanner scan = new Scanner(System.in);
		for (NhanSu ns : this.objListNhanSu.getListNhanSu()) {
			if (ns instanceof NhanVienThuong) {
				boolean flag = true;
				do {
					System.out.print("Nhân viên >> ");
					ns.xuatMaVaTen();
					System.out.println("===========================================================");
					System.out.println("|| Có phân bổ nhân viên hiện tại về phòng ban hay không? ||");
					System.out.println("|| Nhập 1. Phân bổ                                       ||");
					System.out.println("|| Nhập 0. Không phân bổ                                 ||");
					System.out.println("===========================================================");
					System.out.print("Lựa chọn >> ");
					int luaChon = Integer.parseInt(scan.nextLine());
					switch (luaChon) {
					case 1:
						xuatDSTenVaMaPB();
						PhongBan pb = timPhongBanTheoMa(scan);
						pb.getListNhanVien().add((NhanVienThuong) ns);
						ns.setMaPhongBan(pb.getMaPhongBan());
						flag = false;
						break;
					case 0:
						flag = false;
						break;
					default:
						System.out.println("Chỉ nhập 1 hoặc 0 !");
						break;
					}
				} while (flag);
			}
		}
	}

	/*
	 * Chỉ định trưởng phòng quản lí phòng ban
	 */
	/*
	 * Duyệt danh sách trưởng phòng Hỏi có muốn chỉ định không Cho nhập mã phòng ban
	 * muốn chỉ định Tìm phòng ban theo mã Gán trưởng phòng cho trưởng phòng của
	 * phòng ban đó set mã phòng ban cho trưởng phòng
	 */
	public void layDSTruongPhong() {
		for (NhanSu ns : this.objListNhanSu.getListNhanSu()) {
			if (ns instanceof TruongPhong) {
				this.listTruongPhong.add((TruongPhong) ns);
			}
		}
	}

	public void chiDinhTPChoPhongBan() {
		Scanner scan = new Scanner(System.in);
		for (TruongPhong tp : this.listTruongPhong) {
			boolean flag = true;
			do {
				System.out.print("Trưởng phòng >> ");
				tp.xuatMaVaTen();
				System.out.println("============================================================");
				System.out.println("|| Có chỉ định Trưởng Phòng hiện tại cho phòng ban không? ||");
				System.out.println("|| Nhập 1. Chỉ định                                       ||");
				System.out.println("|| Nhập 0. Không chỉ định                                 ||");
				System.out.println("============================================================");
				System.out.print("Lựa chọn >> ");
				int luaChon = Integer.parseInt(scan.nextLine());
				switch (luaChon) {
				case 1:
					xuatListPhongBan();
					PhongBan pb = null;
					boolean flag_child = true;
					do {
						pb = timPhongBanTheoMa(scan);
						if (pb.getTruongPhong() == null) {
							flag_child = false;
						}
					} while (flag_child);
					pb.setTruongPhong(tp);
					tp.setMaPhongBan(pb.getMaPhongBan());
					flag = false;
					break;
				case 0:
					flag = false;
					break;
				default:
					System.out.println("Chỉ nhập 1 hoặc 0 !");
					break;
				}
			} while (flag);
		}
	}
	
	/*
	 * Phân bổ Task về cho phòng ban
	 * */
	/*
	 * Duyệt danh sách task
	 * Hiển thị danh sách phòng ban
	 * Cho chọn phòng ban
	 * Thêm task vào list task trong phòng ban
	 * */
	public void phanBoTask() {
		Scanner scan = new Scanner(System.in);
		for (Task task : this.objListTask.getListTask()) {
			boolean flag = true;
			do {
				System.out.print("Task >> ");
				task.xuat();
				xuatDSTenVaMaPB();
				PhongBan pb = timPhongBanTheoMa(scan);
				pb.getListTask().add(task);
				task.setMaPhongBan(pb.getMaPhongBan());
				for (NhanSu ns : this.objListNhanSu.getListNhanSu()) {
					if (ns.getMaPhongBan().equalsIgnoreCase(pb.getMaPhongBan())) {
						ns.themTaskVaoList(task);
					}
				}
				flag = false;
			} while (flag);
		}
	}

}
