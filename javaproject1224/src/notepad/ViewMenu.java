package notepad;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ViewMenu extends JMenu{
	TextArea text;
	JMenuItem small = new JMenuItem("작게");
	JMenuItem medium = new JMenuItem("보통");
	JMenuItem big = new JMenuItem("크게");
	
	public ViewMenu(TextArea ta) {
		this.setText("보기");
		this.text = ta;
		FontListener font = new FontListener();
		this.add(small);
		this.add(medium);
		this.add(big);
		
		small.addActionListener(font);
		medium.addActionListener(font);
		big.addActionListener(font);
		
	}
	private class FontListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(small)) {
				Font f = new Font("Serif",Font.PLAIN, 5);
				text.setFont(f);
			}
			else if(e.getSource().equals(medium)) {
				Font f = new Font("serif", Font.PLAIN, 15);
	            text.setFont(f);
			}
			else {
				Font f = new Font("serif", Font.PLAIN, 50);
	            text.setFont(f);
			}
		}
	}
}
