import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Mục đích: Xử lý các nghiệp vụ liên quan đến danh sách Nhân Sự
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 2/1/2021
 * Version: 1.0
 * */

public class DanhSachNhanSu implements NhapXuat {
	
	//1. Attributes
	private ArrayList<NhanSu> listNhanSu;
	
	//2. Get, set methods
	public ArrayList<NhanSu> getListNhanSu() {
		return listNhanSu;
	}

	public void setListNhanSu(ArrayList<NhanSu> listNhanSu) {
		this.listNhanSu = listNhanSu;
	}

	//3. Constructor methods
	public DanhSachNhanSu() {
		this.listNhanSu = new ArrayList<NhanSu>();
	}
	
	//4. Input, output methods
	@Override
	public void xuat() {
		for (NhanSu ns : this.listNhanSu) {
			ns.xuat();
		}
	}
	
	//5. Business methods
	public void taoDuLieu() {
		try {
			FileReader reader = new FileReader("src/DSNS.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			
			String line;
			
			while ((line = bufferedReader.readLine()) != null) {
				//System.out.println(line);
				String[] listInfo = line.split(" # ");
				NhanSu ns;
				
				//Kiểm tra nhân sự thường hay trưởng phòng
				if (listInfo[listInfo.length - 1].equalsIgnoreCase("true")) {
					ns = new TruongPhong(listInfo[0], listInfo[1], listInfo[2], listInfo[3], listInfo[4], Integer.parseInt(listInfo[5]));
				} else {
					ns = new NhanVienThuong(listInfo[0], listInfo[1], listInfo[2], listInfo[3], listInfo[4], Integer.parseInt(listInfo[5]));
				}
				
				//Thêm nhân sự vào lsist
				this.listNhanSu.add(ns);
			} 
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
