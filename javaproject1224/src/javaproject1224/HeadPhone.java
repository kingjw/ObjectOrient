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
		System.out.println("친구 연락처 관리");
		
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
				System.out.printf("잘못 입력했습니다. 다시 선택하세요.");
				
			}//switch
		}//while
		sc.close();
	}
	static void print_menu() {
		System.out.printf("1. 연락처 출력\n");
		System.out.printf("2. 연락처  등록\n");
		System.out.printf("3. 연락처 삭제\n");
		System.out.printf("4. 끝내기\n");
	}
	static void view_juso() {
		System.out.println("1");
	}
	static void add_juso() {
		
	}
	static void delete_juso() {
		
	}

}
