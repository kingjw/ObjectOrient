package javaproject1231;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

public class ch7ex6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try {
//			URL url = new URL("https://www.naver.com");
//			System.out.println("프로토콜 : " + url.getProtocol());
//			System.out.println("호스트 : " + url.getHost());
//			System.out.println("포트 : " + url.getPort());
//			System.out.println(">>html 시작");
//			InputStream is = url.openStream();
//			BufferedReader br = new BufferedReader(new InputStreamReader(is));
//			String msg;
//			while((msg = br.readLine()) != null) {
//				System.out.println(msg);
//			}
//			br.close();
//			is.close();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
		try {
			ServerSocket sc = new ServerSocket(5000);
			System.out.println("#서버실행..");
			while(true) {
				Socket s = sc.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				System.out.println("#클라이언트 연결됨(서버)");
				System.out.println("#클라이언트 메시지(서버) :" + br.readLine());
				PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
				pw.println("서버에서 전송합니다.(서버)");
				pw.close();
				br.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
