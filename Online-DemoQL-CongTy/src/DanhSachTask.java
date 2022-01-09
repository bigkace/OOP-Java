import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Mục đích: Xử lý các nghiệp vụ liên quan đến danh sách Task
 * Người tạo: Vũ Nam Khánh
 * Ngày tạo: 2/1/2021
 * Version: 1.0
 * */

public class DanhSachTask implements NhapXuat {
	
	//1. Attributes
	private ArrayList<Task> listTask;
	
	//2. Get, set methods
	public ArrayList<Task> getListTask() {
		return listTask;
	}

	public void setListTask(ArrayList<Task> listTask) {
		this.listTask = listTask;
	}

	//3. Constructor methods
	public DanhSachTask() {
		this.listTask = new ArrayList<Task>();
	}
	
	//4. Input, output methods
	@Override
	public void xuat() {
		for (Task task : this.listTask) {
			task.xuat();
		}
	}
	
	//5. Business methods
	public void taoDuLieu() {
		try {
			FileReader reader = new FileReader("src/Task.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			
			String line;
			
			while ((line = bufferedReader.readLine()) != null) {
				//System.out.println(line);
				String[] listInfo = line.split(" # ");
				Task task = new Task(listInfo[0], listInfo[1], Float.parseFloat(listInfo[2]));
				
				//Thêm nhân sự vào list
				this.listTask.add(task);
			} 
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
