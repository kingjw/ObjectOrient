package notepad;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HelpMenu extends JMenu{
	HelpMenu(TextArea ta){
		this.setText("도움말");
		JMenuItem proInfo = new JMenuItem("프로그램 정보");
		this.add(proInfo);
		
		
	}
}
