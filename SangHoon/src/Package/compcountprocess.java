package Package;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class compcountprocess {
	
	
	public static void saveuser(String id, int count) {
		try {
			FileWriter writer = new FileWriter(new File("datacomp/" + id));

			writer.write(count + "");

			writer.flush();

			writer.close();
		} catch (IOException e) {  //파일을 처리하다보면 파일이 없거나 파일을 접근할 수 없을때 예외처리
			e.printStackTrace();
		}
	}
	

	public static Integer count(String id) {
		try {
			FileReader writer = new FileReader(new File("datacomp/" + id));

			Scanner scanner = new Scanner(writer);
			return Integer.valueOf(scanner.nextLine()); //파일로 저장하면 문자로 바뀌니까 다시 읽어와서 반환할때 숫자로 바꿔주는부분
		} catch (IOException e) { //파일을 처리하다보면 파일이 없거나 파일을 접근할 수 없을때 예외처리
			e.printStackTrace(); 
		}
		return 0;
	}
}
