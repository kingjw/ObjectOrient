package javaproject1224;
import java.io.*;
import java.util.*;
public class HeadPhone {
	static String fname="tempjuso.txt";
	static class address{
		String name;
		String age;
		String phone;
		
		address(String s1, String s2, String s3){
			this.name = s1;
			this.age = s2;
			this.phone = s3;
		}
	}
	public static void main(String[] args) {		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String select = "";
		System.out.println("ģ�� ����ó ����");
		
		while(select != "4") {
			print_menu();
			select = sc.next();
			
			switch(select) {
			case "1":
				view_juso();
				break;
			case"2":
				add_juso();
				break;
			case"3":
				delete_juso();
				break;
			case"4":
				return;
				
			default:
				System.out.printf("�߸� �Է��߽��ϴ�. �ٽ� �����ϼ���.");
				
			}//switch
		}//while
		sc.close();
	}
	static void print_menu() {
		System.out.printf("1. ����ó ���\n");
		System.out.printf("2. ����ó  ���\n");
		System.out.printf("3. ����ó ����\n");
		System.out.printf("4. ������\n");
	}
	static void view_juso() {
		System.out.println("1");
	}
	static void add_juso() {
		
	}
	static void delete_juso() {
		
	}

}
