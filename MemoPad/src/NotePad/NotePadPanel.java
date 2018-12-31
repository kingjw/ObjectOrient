package NotePad;

import java.awt.GridLayout;

import javax.swing.*;

public class NotePadPanel extends JPanel{
	protected NotePadTextArea ta;
	
	public NotePadPanel() {
		ta = new NotePadTextArea();
		this.setLayout(new GridLayout());
		
		this.add(ta);
	}
}
