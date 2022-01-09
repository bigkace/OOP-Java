import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Mục đích: Xử lý các nghiệp vụ liên quan đến danh sách Phòng Ban
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 2/1/2022
 * Version: 1.0
 * */

public class DanhSachPhongBan implements NhapXuat{
	
	//1. Attributes
	private ArrayList<PhongBan> listPhongBan;
	
	//2. Get, set methods
	public ArrayList<PhongBan> getListPhongBan() {
		return listPhongBan;
	}

	public void setListPhongBan(ArrayList<PhongBan> listPhongBan) {
		this.listPhongBan = listPhongBan;
	}

	//3. Constructor methods
	public DanhSachPhongBan() {
		this.listPhongBan = new ArrayList<PhongBan>();
	}
	
	//4. Input, output methods
	@Override
	public void xuat() {
		for (PhongBan pb : this.listPhongBan) {
			pb.xuat();
		}		
	}
	
	public void xuatDSTenVaMa() {
		for (PhongBan pb : this.listPhongBan) {
			pb.xuatTenVaMa();
		}
	}
	
	//5. Business methods
	public void taoDuLieu() {
		try {
			FileReader reader = new FileReader("src/PhongBan.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			
			String line;
			
			while ((line = bufferedReader.readLine()) != null) {
				//System.out.println(line);
				String[] listInfo = line.split(" # ");
				PhongBan pb = new PhongBan(listInfo[0], listInfo[1]);
				
				//Thêm nhân sự vào list
				this.listPhongBan.add(pb);
			} 
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
