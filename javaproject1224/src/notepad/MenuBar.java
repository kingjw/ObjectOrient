package notepad;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MenuBar extends JMenuBar {
	MenuBar(TextArea ta){
		FileMenu fm = new FileMenu(ta);
		ViewMenu vm = new ViewMenu(ta);
		HelpMenu hp = new HelpMenu(ta);
		
		this.add(fm);
		this.add(vm);
		this.add(hp);
	}
}
