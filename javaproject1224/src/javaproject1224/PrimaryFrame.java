package javaproject1224;
import java.awt.*;
import javax.swing.*;
public class PrimaryFrame {
	static class MyGUI extends JFrame{

		MyGUI(){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("������Ʈ");
			
			Container c = this.getContentPane();
			c.setBackground(Color.yellow);
			
			this.setLayout(new FlowLayout());
			
			JButton btn1 = new JButton("��ư1");
			btn1.setBackground(Color.black);
			btn1.setForeground(Color.green);
			this.add(btn1);
			
			JButton btn2 = new JButton("��ư2");
			btn1.setFont(new Font("�������",Font.BOLD,30));
			btn2.setCursor(new Cursor(Cursor.WAIT_CURSOR));
			btn2.setToolTipText("�� ��ư�� ũ�Ժ�����");
			
			this.add(btn2);
			
			JButton btn3 = new JButton("��ư3");
			btn3.setEnabled(false);//��ư3 ������� ���ϰ�
			this.add(btn3);
			
			setSize(300,300);
			setVisible(true);
		}
	
	}
}
