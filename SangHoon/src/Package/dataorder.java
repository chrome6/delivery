
package Package;
/////////////////////////////////////////////////���Ͽ� �ֹ�����(����� ��������)�� �Է��մϴ�//////////////////////////////////
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class dataorder {
	public static void saveorder(String customerid, String addr, String phone, String method, String price) {
		try {
			FileWriter writer = new FileWriter(new File("dataorder/" + (new Random()).nextInt(210000000)));
			//�����̸���  �������  ��ġ���ʰ�

			writer.write(customerid + "\n" + addr + "\n" + phone + "\n" + method + "\n" + price + "\n����" + "\n�����");
/////////////////ó���� ������ ���̵� �Է��ϰ� �Ѵ�//////////////////////
			/////�׷��� ��� ���Կ��� ���״��� ������ �����ϴ�////
			writer.flush();

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String customerid(String id) {
		try {
			FileReader writer = new FileReader(new File("dataorder/" + id));

			Scanner scanner = new Scanner(writer);
			return scanner.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String addr(String id) {
		try {
			FileReader writer = new FileReader(new File("dataorder/" + id));

			Scanner scanner = new Scanner(writer);
			scanner.nextLine();
			return scanner.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String status(String id) {
		try {
			FileReader writer = new FileReader(new File("dataorder/" + id));

			Scanner scanner = new Scanner(writer);
			scanner.nextLine();  //���Ͽ��� ���� �о���� �ҽ��ڵ�
			scanner.nextLine();
			scanner.nextLine();
			scanner.nextLine();
			scanner.nextLine();
			scanner.nextLine();
			return scanner.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String phone(String id) {
		try {
			FileReader writer = new FileReader(new File("dataorder/" + id));

			Scanner scanner = new Scanner(writer);
			scanner.nextLine();
			scanner.nextLine();
			return scanner.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String method(String id) {
		try {
			FileReader writer = new FileReader(new File("dataorder/" + id));

			Scanner scanner = new Scanner(writer);
			scanner.nextLine();
			scanner.nextLine();
			scanner.nextLine();
			return scanner.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String price(String id) {
		try {
			FileReader writer = new FileReader(new File("dataorder/" + id));

			Scanner scanner = new Scanner(writer);
			scanner.nextLine();
			scanner.nextLine();
			scanner.nextLine();
			scanner.nextLine();
			return scanner.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String carrier(String id) {
		try {
			FileReader writer = new FileReader(new File("dataorder/" + id));

			Scanner scanner = new Scanner(writer);
			scanner.nextLine();
			scanner.nextLine();
			scanner.nextLine();
			scanner.nextLine();
			scanner.nextLine();
			return scanner.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void setstatus(String id, String status) {
		try {
			String customerid = customerid(id);
			String addr = addr(id);
			String phone = phone(id);
			String method = method(id);
			String price = price(id);
			String carrierId = carrier(id);

			FileWriter writer = new FileWriter(new File("dataorder/" + id));

			writer.write(customerid + "\n" + addr + "\n" + phone + "\n" + method + "\n" + price + "\n" + carrierId + "\n" + status);

			writer.flush();

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void setcarrier(String id, String carrierId) {
		try {
			String customerid = customerid(id);
			String addr = addr(id);
			String phone = phone(id);
			String method = method(id);
			String price = price(id);
			String status = status(id);

			FileWriter writer = new FileWriter(new File("dataorder/" + id));

			writer.write(customerid + "\n" + addr + "\n" + phone + "\n" + method + "\n" + price + "\n" + carrierId +  "\n" + status);

			writer.flush();

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<String> ordercustomer(String customerid) {
		File file = new File("dataorder/");

		List<String> list = new ArrayList<String>();

		for (File f : file.listFiles()) {
			FileReader writer;
			try {
				writer = new FileReader(f);

				Scanner scanner = new Scanner(writer);

				String nextLine = scanner.nextLine();
				if (nextLine.equals(customerid)) {
					list.add(f.getName());
				}

				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	public static List<String> notordercarriers() {
		File file = new File("dataorder/");

		List<String> list = new ArrayList<String>();

		for (File f : file.listFiles()) {
			FileReader writer;
			try {
				writer = new FileReader(f);

				Scanner scanner = new Scanner(writer);
				scanner.nextLine();
				scanner.nextLine();
				scanner.nextLine();
				scanner.nextLine();
				scanner.nextLine();

				String nextLine = scanner.nextLine();
				if (nextLine.equals("����")) {
					list.add(f.getName());
				}

				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		return list;
	}


	public static List<String> ordercarriers() {
		File file = new File("dataorder/");

		List<String> list = new ArrayList<String>();

		for (File f : file.listFiles()) {
			FileReader writer;
			try {
				writer = new FileReader(f);

				Scanner scanner = new Scanner(writer);
				scanner.nextLine();
				scanner.nextLine();
				scanner.nextLine();
				scanner.nextLine();
				scanner.nextLine();

				String nextLine = scanner.nextLine();
				if (!nextLine.equals("����")) {
					list.add(f.getName());
				}

				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		return list;
	}
	public static List<String> carriers() {
		File file = new File("dataorder/");

		List<String> list = new ArrayList<String>();

		for (File f : file.listFiles()) {
				list.add(f.getName());
		}

		return list;
	}

	public static void main(String[] args) {

	}
}
