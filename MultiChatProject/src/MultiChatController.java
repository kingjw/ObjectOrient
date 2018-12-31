import java.io.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

import com.google.gson.*;

public class MultiChatController implements Runnable{
	
	private Message m;
	private final MultiChatUI v;
	private final MultiChatData chatData;
	private String ip = "127.0.0.1";
	private Socket socket;
	private PrintWriter outMsg;
	private boolean status = true;
	private Gson gson = new Gson();
	private BufferedReader inMsg;
	private Logger logger;
	private Thread thread;
	public MultiChatController(MultiChatData chatData, MultiChatUI v) {
		// TODO Auto-generated constructor stub
		logger = Logger.getLogger(this.getClass().getName());
		this.v = v;
		this.chatData = chatData;
	}
	
	public void appMain() {
		chatData.addObj(v.msgOut);
		
		v.addButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				
				if(obj == v.exitButton) {
					System.exit(0);
				}
				else if(obj == v.loginButton) {
					v.id = v.idInput.getText();
					v.outLabel.setText(" 대화명 : " + v.id);
					v.cardLayout.show(v.tab, "logout");
					connectServer();
				}
				else if(obj == v.logoutButton) {
					outMsg.println(gson.toJson(new Message(v.id, "", "", "logout")));
					
					v.msgOut.setText("");
					v.cardLayout.show(v.tab, "login");
					outMsg.close();
					
					try{
						inMsg.close();
						socket.close();
					}
					catch(IOException ex) {
						ex.printStackTrace();
					}
					
					status = false;
				}
				else if(obj == v.msgInput) {
					outMsg.println(gson.toJson(new Message(v.id, "", v.msgInput.getText(), "msg")));
					v.msgInput.setText("");
					chatData.refreshData(v.msgInput.getText());
				}
			}
		});
	}
	
	public void connectServer() {
		try {
			socket = new Socket(ip,8888);
			System.out.println("connectServer success");
			
			inMsg = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			outMsg = new PrintWriter(socket.getOutputStream(),true);
			
			m = new Message(v.id,"","","login");
			outMsg.println(gson.toJson(m));
			
			thread = new Thread(this);
			thread.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void run() {
		String msg;
		status = true;
		
		while(status) {
			try {
				msg = inMsg.readLine();
				m = gson.fromJson(msg,Message.class);
				
				chatData.refreshData(m.getId() + ">" + m.getMsg() + "\n");
				
				v.msgOut.setCaretPosition(v.msgOut.getDocument().getLength());
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(thread.getName() + "메세지 수신 쓰레드 종료");
	}
	public static void main(String[] args) {
		MultiChatController app = new MultiChatController(new MultiChatData(),new MultiChatUI());
		
		app.appMain();
	}
}
