package Package;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class logincarrierprocess {
	public static void saveuser(String id, String password, String name, String phone) {
		try {
			FileWriter writer = new FileWriter(new File("datacarrier/" + id));

			writer.write(id + "\n" + password + "\n" + name + "\n" + phone);

			writer.flush();

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean userex(String id) { //로그인이 되어버리는걸 방지하기위해서 id가 비어있다면 아무값이나 채워주는겁니다.
		if(id.equals("")) id ="A";  
		File file = new File("datacarrier/" + id);
		return file.exists();
	}

	public static String password(String id) {
		try {
			FileReader writer = new FileReader(new File("datacarrier/" + id));

			Scanner scanner = new Scanner(writer);
			scanner.nextLine();
			return scanner.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	

	public static String name(String id) {
		try {
			FileReader writer = new FileReader(new File("datacarrier/" + id));

			Scanner scanner = new Scanner(writer);
			scanner.nextLine();
			scanner.nextLine();
			return scanner.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}


	public static List<String> carriers() {
		File file = new File("datacarrier/");

		List<String> list = new ArrayList<String>();

		for (File f : file.listFiles()) {
			list.add(f.getName());
		}

		return list;
	}
	public static String phone(String id) {
		try {
			FileReader writer = new FileReader(new File("datacarrier/" + id));

			Scanner scanner = new Scanner(writer);
			scanner.nextLine();
			scanner.nextLine();
			scanner.nextLine();
			return scanner.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static String phoneTwo(String id) {
		try {
			FileReader writer = new FileReader(new File("datacarrier/" + id));

			Scanner scanner = new Scanner(writer);
			return scanner.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
