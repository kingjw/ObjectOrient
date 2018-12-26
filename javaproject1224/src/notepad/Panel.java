package notepad;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Panel extends JPanel{
	protected TextArea ta;
	
	public Panel() {
		ta = new TextArea();
		this.setLayout(new GridLayout());
		
		this.add(ta);
	}
}
