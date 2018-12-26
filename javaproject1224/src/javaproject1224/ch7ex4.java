package javaproject1224;
import java.io.*;
public class ch7ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File rfile=new File("tmpfile.txt");
		File wfile=new File("tmpfile_new.txt");
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(rfile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(wfile));
			
			String s;
			while((s = reader.readLine()) != null) {
				writer.write(s + "-라인종료");
			}
			reader.close();
			writer.close();
			rfile.delete();
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done");
	}

}
