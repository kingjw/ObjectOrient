import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiChatUI extends JFrame {
	private JPanel logoutPanel;
	protected JTextField idInput;
	protected JButton logoutButton;
	private JPanel msgPanel, loginPanel;
	JTextField msgInput;
	JButton exitButton,loginButton;
	JLabel inLabel, outLabel;
	protected Container tab;
	protected CardLayout cardLayout;
	protected JTextArea msgOut;
	protected String id;
	public MultiChatUI() {
		super("::멀티챗::");
		this.setLayout(new BorderLayout());
		this.setSize(900, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loginPanel = new JPanel();
		loginPanel.setLayout(new BorderLayout());
		
		idInput = new JTextField(15);
		loginButton = new JButton("로그인");
		
		inLabel = new JLabel("대화명 : ");
		loginPanel.add(inLabel, BorderLayout.WEST);
		loginPanel.add(idInput, BorderLayout.CENTER);
		loginPanel.add(loginButton, BorderLayout.EAST);
		
		logoutPanel = new JPanel();
		logoutPanel.setLayout(new BorderLayout());
		
		outLabel = new JLabel();
		logoutButton = new JButton("로그아웃");
		
		logoutPanel.add(outLabel, BorderLayout.CENTER);
		logoutPanel.add(logoutButton, BorderLayout.EAST);
		msgPanel = new JPanel();
		msgPanel.setLayout(new BorderLayout());

		msgInput = new JTextField(15);
		exitButton = new JButton("종료");
		msgPanel.add(msgInput, BorderLayout.CENTER);
		msgPanel.add(exitButton, BorderLayout.EAST);
		
		msgOut = new JTextArea("", 10, 30);
		msgOut.setEditable(false);
		
		
		msgOut = new JTextArea("",10,30);
		msgOut.setEditable(false);
		
		JScrollPane jsp = new JScrollPane(msgOut, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		tab = new JPanel();
		cardLayout = new CardLayout();
		tab.setLayout(cardLayout);
		tab.add(loginPanel, "login");
		tab.add(logoutPanel, "logout");
		cardLayout.show(tab, "login");
		
		this.add(tab, BorderLayout.NORTH);
		this.add(msgOut, BorderLayout.CENTER);
		this.add(msgPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	
	public void addButtonActionListener(ActionListener listener) {
		loginButton.addActionListener(listener);
		logoutButton.addActionListener(listener);
		exitButton.addActionListener(listener);
		msgInput.addActionListener(listener);
	}

}
