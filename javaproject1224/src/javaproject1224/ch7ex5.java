package javaproject1224;
import java.io.*;
import java.util.*;
public class ch7ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("������ �޸��� v1.0");
		System.out.print("������ ���ϸ� : ");
		Scanner scanner = new Scanner(System.in);
		String filename = scanner.next();
		System.out.println("������ ������ ���ο� q �Է�\n");
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter writer = new BufferedWriter(new FileWriter("" + filename));
			String s;
			while(!(s = reader.readLine()).equals("q")) {
				writer.write(s + "\r\n");
			}
			reader.close();
			writer.close();
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("���α׷��� �����մϴ�.");
		System.out.println(filename + "����Ǿ����ϴ�.");
	}

}
