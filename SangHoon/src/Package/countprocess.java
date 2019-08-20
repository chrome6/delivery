package Package;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//////////////////∞Ì∞¥¿« ¥Î«‡¿‹ø© »Ωºˆ//////////////
public class countprocess {
	public static void saveuser(String id, int count) {
		try {
			FileWriter writer = new FileWriter(new File("datacount/" + id));

			writer.write(count + "");

			writer.flush();

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Integer count(String id) {
		try {
			FileReader writer = new FileReader(new File("datacount/" + id));

			Scanner scanner = new Scanner(writer);
			return Integer.valueOf(scanner.nextLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
