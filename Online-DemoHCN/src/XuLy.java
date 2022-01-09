import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		HinhChuNhat hcn = new HinhChuNhat();
		
		Scanner scan = new Scanner(System.in);
		hcn.nhap(scan);
		hcn.tinhChuVi();
		hcn.tinhDienTich();
		hcn.xuat();

	}

}
