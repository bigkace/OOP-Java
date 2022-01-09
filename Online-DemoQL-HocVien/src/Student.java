import java.util.Scanner;

/*
 * Mục đích: Xử lý nghiệp vụ liên quan đến lớp Student
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 26/12/2021
 * Version: 1.0
 * */

public class Student extends Person{
	
	//1. Attributes
	private float diemToan;
	private float diemLy;
	private float diemHoa;
	
	//2. Get, set methods
	public float getDiemToan() {
		return diemToan;
	}
	
	public void setDiemToan(float diemToan) {
		this.diemToan = diemToan;
	}
	
	public float getDiemLy() {
		return diemLy;
	}
	
	public void setDiemLy(float diemLy) {
		this.diemLy = diemLy;
	}
	
	public float getDiemHoa() {
		return diemHoa;
	}
	
	public void setDiemHoa(float diemHoa) {
		this.diemHoa = diemHoa;
	}
	
	//3. Constructor methods
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String hoTen, String diaChi, String ma, String email, float diemToan, float diemLy, float diemHoa) {
		super(hoTen, diaChi, ma, email);
		this.diemToan = diemToan;
		this.diemLy = diemLy;
		this.diemHoa = diemHoa;
	}
		
	//4. Input, output methods
	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);
		
		System.out.print("Nhập điểm toán: ");
		this.diemToan = Float.parseFloat(scan.nextLine());
		
		System.out.print("Nhập điểm lý: ");
		this.diemLy = Float.parseFloat(scan.nextLine());
		
		System.out.print("Nhập điểm hoá: ");
		this.diemHoa = Float.parseFloat(scan.nextLine());
	}
	
	@Override
	public void xuat() {
		super.xuat();
		System.out.println("\tĐiểm toán: " + this.diemToan
				+ "\tĐiểm lý: " + this.diemLy
				+ "\tĐiểm hoá: " + this.diemHoa);
	}
	
	//5. Business methods



}
