import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		readFile();

	}
	
	private static void readFile() {
		try {
			FileReader reader = new FileReader("src/Task.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			
			String line;
			
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				String[] listInfo = line.split(" # ");
				for (String a : listInfo)
					System.out.println(a);
			}
			reader.close(); //Đóng tập tin
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
