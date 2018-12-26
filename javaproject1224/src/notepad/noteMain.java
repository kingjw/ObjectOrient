package notepad;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class noteMain {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Panel Panel = new Panel();
		MenuBar MenuBar = new MenuBar(Panel.ta);
				
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("메뉴 만들기");
		frame.setJMenuBar(MenuBar);
		frame.add(Panel);
		frame.setSize(500,500);
		frame.setVisible(true);
		
		
	}

}
