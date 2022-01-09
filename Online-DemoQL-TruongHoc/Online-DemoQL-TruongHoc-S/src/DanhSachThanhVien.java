import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Mục đích: Xử lý các nghiệp vụ liên quan đến danh sách thành viên
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 2/1/2022
 * Version: 1.0
 * */

public class DanhSachThanhVien implements NhapXuat {

	// 1. Attributes
	private ArrayList<ThanhVien> dsThanhVien;

	// 2. Get, set methods
	public ArrayList<ThanhVien> getDsThanhVien() {
		return dsThanhVien;
	}

	public void setDsThanhVien(ArrayList<ThanhVien> dsThanhVien) {
		this.dsThanhVien = dsThanhVien;
	}

	// 3. Constructor methods
	public DanhSachThanhVien() {
		this.dsThanhVien = new ArrayList<ThanhVien>();
	}

	// 4. Input, output methods
	@Override
	public void nhap() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		ThanhVien thanhVien;
		do {
			System.out.println("=======================");
			System.out.println("|| Nhập 1. Giáo Viên ||");
			System.out.println("|| Nhập 2. Học Sinh  ||");
			System.out.println("|| Nhập 0. Thoát     ||");
			System.out.println("=======================");
			System.out.print("Lựa chọn >> ");
			int luaChon = Integer.parseInt(scan.nextLine());
			switch (luaChon) {
			case 1:
				thanhVien = new GiaoVien();
				thanhVien.nhap();
				this.dsThanhVien.add(thanhVien);
				break;
			case 2:
				thanhVien = new HocSinh();
				thanhVien.nhap();
				this.dsThanhVien.add(thanhVien);
				break;
			case 0:
				flag = false;
				break;
			}
		} while (flag);
	}

	@Override
	public void xuat() {
		for (ThanhVien tv : this.dsThanhVien) {
			tv.xuat();
		}
	}

	// 5. Business methods
	
	/*
	 * Đọc và tạo dữ liệu Giáo Viên và Học Sinh
	 * */
	private void taoDuLieu(String tenFile) {
		try {
			FileReader reader = new FileReader("src/" + tenFile + ".txt");
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line;

			while ((line = bufferedReader.readLine()) != null) {
				// System.out.println(line);
				String[] listInfo = line.split(" # ");
				ThanhVien tv;
				if (tenFile.equalsIgnoreCase("GiaoVien")) {
					tv = new GiaoVien(listInfo[0], listInfo[1], listInfo[2], listInfo[3], listInfo[4],
							Integer.parseInt(listInfo[5]), listInfo[6]);
				} else {
					tv = new HocSinh(listInfo[0], listInfo[1], listInfo[2], listInfo[3], listInfo[4], Float.parseFloat(listInfo[5]),
							Float.parseFloat(listInfo[6]), Float.parseFloat(listInfo[7]));
				}
				this.dsThanhVien.add(tv);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void taoDuLieuGiaoVien() {
		taoDuLieu("GiaoVien");
	}
	
	public void taoDuLieuHocSinh() {
		taoDuLieu("HocSinh");
	}
	
	/*
	 * Xuất danh sách theo format
	 * */
	private void xuatLine(int number) {
		String text = String.format("%" + number + "s", " ").replace(" ", "=");
		System.out.println(text);
	}
	
	private String formatCell(String paddLeft, String title, String paddRight) {
		return String.format(paddLeft, " ") + title + String.format(paddRight, " ");
	}
	
	private void xuatCellThuTu(int i) {
		String paddLeft = "%3s";
		String paddRight = "%-6s";
		String text = "||" + String.format(paddLeft, " ") + String.format(paddRight, "" + i) + "|";
		System.out.print(text);
	}
	
	private void xuatRowHeader(String paddString3, String paddString4, String paddString5) {
		String text;
		text = "||" + formatCell(paddString3, "STT", paddString3);
		text += "|" + formatCell(paddString5, "Họ tên", paddString5);
		text += "|" + formatCell(paddString4, "Năm sinh", paddString4);
		text += "|" + formatCell(paddString4, "Nơi sinh", paddString4);
		text += "|" + formatCell(paddString4, "Địa chỉ", paddString4);
		System.out.print(text);
	}
	
	/*
	 * Xuất danh sách Học Sinh theo format
	 * */
	private void xuatLineHS() {
		xuatLine(187);
	}
	
	
	private void xuatRowHeaderHS() {
		String paddString3 = "%3s";
		String paddString4 = "%5s";
		String paddString5 = "%9s";
		
		xuatLineHS();
		
		xuatRowHeader(paddString3, paddString4, paddString5);
		String text;
		text = "|" + formatCell(paddString3, "Điểm toán", paddString3);
		text += "|" + formatCell(paddString3, "Điểm văn", paddString3);
		text += "|" + formatCell(paddString3, "Điểm ngoại ngữ", paddString3);
		text += "|" + formatCell(paddString3, "Điểm trung bình", paddString3);
		text += "|" + formatCell(paddString4, "Xếp loại", paddString4) + "||";
		System.out.println(text);
		
		xuatLineHS();
	}
	
	
	public void xuatTheoFormatHS(ArrayList<HocSinh> ds) {
		 xuatRowHeaderHS();
		 int i = 1;
		 for (HocSinh sv : ds) {
			  xuatCellThuTu(i);
			  sv.xuatRowFormatHocSinh();
			  i++;
		 }
		 xuatLineHS();
	}
	
	/*
	 * Xuất danh sách Giáo Viên theo format
	 * */
	private void xuatLineGV() {
		xuatLine(147);
	}
	
	private void xuatRowHeaderGV() {
		String paddString1 = "%1s";
		String paddString2 = "%2s";
		String paddString3 = "%3s";
		String paddString4 = "%5s";
		String paddString5 = "%9s";
		
		xuatLineGV();
		
		xuatRowHeader(paddString3, paddString4, paddString5);
		String text;
		text = "|" + formatCell(paddString1, "Năm bắt đầu dạy", paddString1);
		text += "|" + formatCell(paddString2, "Chuyên môn", paddString2);
		text += "|" + formatCell(paddString4, "Thâm niên", paddString4) + "||";
		System.out.println(text);
		
		xuatLineGV();
	}
	
	
	public void xuatTheoFormatGV(ArrayList<GiaoVien> ds) {
		 xuatRowHeaderGV();
		 int i = 1;
		 for (GiaoVien gv : ds) {
			  xuatCellThuTu(i);
			  gv.xuatRowFormatGiaoVien();
			  i++;
		 }
		 xuatLineGV();
	}
	
}
