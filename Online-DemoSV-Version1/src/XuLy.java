import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		SinhVien sv = new SinhVien();
		
		Scanner scan = new Scanner(System.in);
		sv.nhap(scan);
		sv.tinhDiemTB();
		sv.xepLoai();
		sv.xuat();

	}

}
