package NotePad;

import javax.swing.*;
import java.awt.*;

public class NotePadMenuBar extends JMenuBar{
	NotePadMenuBar(NotePadTextArea ta){
		NotePadFileMenu fm = new NotePadFileMenu(ta);
		NotePadViewMenu vm = new NotePadViewMenu(ta);
		//NotePadHelpMenu hm = new NotePadHelpMenu(ta);
		
		this.add(fm);
		this.add(vm);
		//this.add(hm);
	}
}
