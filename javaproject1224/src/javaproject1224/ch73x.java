package javaproject1224;

import java.io.*;
public class ch73x {

	public static void main(String[] args) {
		String path = "tmpfile.txt";
		File file = new File(path);
		
		try {
			FileWriter fw = new FileWriter(file);	
			for(int i ='A';i<'Z';i++) {
				fw.write(i);
				}
			fw.close();
			System.out.println("Done..");
			}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
