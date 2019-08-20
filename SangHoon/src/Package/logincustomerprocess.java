package Package;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class logincustomerprocess {
	public static void saveuser(String id, String password, String name, String phone, String money) {
		try {
			FileWriter writer = new FileWriter(new File("datacustomer/" + id));

			writer.write(id + "\n" + password + "\n" + name + "\n" + phone + "\n" + money);

			writer.flush();

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean userex(String id) {
		if(id.equals("")) id ="A";
		File file = new File("datacustomer/" + id);
		return file.exists();
	}

	public static String password(String id) {
		try {
			FileReader writer = new FileReader(new File("datacustomer/" + id));

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
			FileReader writer = new FileReader(new File("datacustomer/" + id));

			Scanner scanner = new Scanner(writer);
			scanner.nextLine();
			scanner.nextLine();
			return scanner.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static String money(String id) {
		try {
			FileReader writer = new FileReader(new File("datacustomer/" + id));

			Scanner scanner = new Scanner(writer);
			scanner.nextLine();
			scanner.nextLine();
			scanner.nextLine();
			scanner.nextLine();
			return scanner.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static List<String> customers() { //제네릭 사용
		File file = new File("datacustomer/");  //datacustomer라는 가게목록이 담긴 폴더를 가져옴

		List<String> list = new ArrayList<String>();  //가게목록을 반환하기 위해서 리스트를 생성

		for (File f : file.listFiles()) { //가게폴더에 있는 파일 목록을 가져옵니다.
			list.add(f.getName()); //리스트에 파일 이름(아이디) 를 넣습니다.
		}

		return list;
	}
	public static String phone(String id) {
		try {
			FileReader writer = new FileReader(new File("datacustomer/" + id));

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
}
