package notepad;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*;

public class FileMenu extends JMenu{
	TextArea text;
	JMenuItem newFile = new JMenuItem("새로만들기");
	JMenuItem open = new JMenuItem("열기");
	JMenuItem save = new JMenuItem("저장");
	JMenuItem newName = new JMenuItem("다른 이름으로 저장");
	JMenuItem exit = new JMenuItem("끝내기");
	String path = null;
	public FileMenu(TextArea ta){
		this.setText("파일");
		
		this.text = ta;
		FileListener filedir = new FileListener();
		this.add(newFile);
		this.add(open);
		this.add(save);
		this.add(newName);
		this.add(exit);
		
		
		save.addActionListener(filedir);
		newFile.addActionListener(filedir);
		open.addActionListener(filedir);
		newName.addActionListener(filedir);
		
	}
	private class FileListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(save)) {//처음저장
				if(path == null) {
					JFileChooser choosed = new JFileChooser();
				    FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT files", "txt");
				    choosed.setFileFilter(filter);
				    int returnVal = choosed.showOpenDialog(text);

				    if(returnVal == JFileChooser.APPROVE_OPTION) {
				    	try {
				    		File file = choosed.getSelectedFile();
				    		
					    	FileWriter fw = new FileWriter(file);
					    	String temp=text.getText().trim();
					    	
					    	fw.write(temp);
					    	fw.close();
					    	File selectedFile = choosed.getSelectedFile();
					    	path = selectedFile.getPath();
					    }
					    
					    catch(Exception ex) {
					    	ex.printStackTrace();
					    }
				    }
				}
				else {
					System.out.print("두번째 저장누른거");
					BufferedWriter bw;
					try {
						bw = new BufferedWriter(new FileWriter(path));
						for (String s : text.getText().split("\\n")){
				    		bw.write(s+"\r\n");
				    	}
			    		
			    		bw.close();

					}
					catch(Exception ex){
						System.out.println("error");
					}
				}
				
			}
			
			
			
			else if(e.getSource().equals(newFile)) {//다시쓰기
				text.setText("");
			}
			
			
			
			
			else if(e.getSource().equals(open)) {//열기(기존의파일)
				JFileChooser fc = new JFileChooser();
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("txt files", "txt");
				fc.setFileFilter(filter);
				int fileOpen = fc.showOpenDialog(text);
				
				if(fileOpen == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fc.getSelectedFile();
					String strPath = selectedFile.getPath();
					BufferedReader br = null;
					try {
						br = new BufferedReader(new FileReader(strPath));
						String str;
						
						text.setText("");
						while((str = br.readLine()) != null) {
							text.setText(text.getText() + str + "\n");
						}
						
						br.close();
						
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}

			}
			
			
			
			
			else if(e.getSource().equals(newName)) {//새로운이름으로저장
				JFileChooser choosed = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT files", "txt");
			    choosed.setFileFilter(filter);
			    int returnVal = choosed.showOpenDialog(text);

			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	try {
			    		File file = choosed.getSelectedFile();
			    		
				    	FileWriter fw = new FileWriter(file);
				    	String temp=text.getText().trim();
				    	
//				    	for (String s : text.getText().split("\\n")){
//				    		fw.write(s+"\r\n");
//				    	}
				    	fw.write(temp);
				    	fw.close();
				    }
				    
				    catch(Exception ex) {
				    	ex.printStackTrace();
				    }
			    }

			}
		}
	}
}
