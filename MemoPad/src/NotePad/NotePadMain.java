package NotePad;

import javax.swing.*;

public class NotePadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		NotePadPanel panel = new NotePadPanel();
		NotePadMenuBar menuBar = new NotePadMenuBar(panel.ta);
		
		
		frame.setTitle("메모장");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(menuBar);
		frame.add(panel);
		frame.setSize(700, 500);
		frame.setVisible(true);
		
	}

}
