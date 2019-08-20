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
		} catch (IOException e) {  //������ ó���ϴٺ��� ������ ���ų� ������ ������ �� ������ ����ó��
			e.printStackTrace();
		}
	}
	

	public static Integer count(String id) {
		try {
			FileReader writer = new FileReader(new File("datacomp/" + id));

			Scanner scanner = new Scanner(writer);
			return Integer.valueOf(scanner.nextLine()); //���Ϸ� �����ϸ� ���ڷ� �ٲ�ϱ� �ٽ� �о�ͼ� ��ȯ�Ҷ� ���ڷ� �ٲ��ִºκ�
		} catch (IOException e) { //������ ó���ϴٺ��� ������ ���ų� ������ ������ �� ������ ����ó��
			e.printStackTrace(); 
		}
		return 0;
	}
}
