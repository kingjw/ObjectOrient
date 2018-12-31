import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Logger;
import com.google.gson.Gson;

public class MultiChatServer {
	private ServerSocket ss = null;
	private Socket s = null;
	
	ArrayList<ChatThread> chatThreads = new ArrayList<ChatThread>();
	
	Logger logger;
	
	public MultiChatServer() {
		start();
	}
	public void start() {
		logger = Logger.getLogger(this.getClass().getName());
		
		try {
			ss = new ServerSocket(8888);
			logger.info("MultiChatServer start");
			
			while(true) {
				s = ss.accept();
				ChatThread chat = new ChatThread();
				chatThreads.add(chat);
				chat.start();
			}
		}
		catch(Exception e) {
				logger.info("[MulitChatServer]start() Exception 발생");
				e.printStackTrace();
		}
		
	}
	
	public void msgSendAll(String msg) {
		for(ChatThread ct : chatThreads) {
			ct.outMsg.println(msg);
		}
	}
	class ChatThread extends Thread {
		String msg;
		Message m;
		Gson gson = new Gson();
		
		private BufferedReader inMsg = null;
		private PrintWriter outMsg = null;
		
		public void run() {
			boolean status = true;
			
			try {
				inMsg = new BufferedReader(new InputStreamReader(s.getInputStream()));
				outMsg = new PrintWriter(s.getOutputStream(),true);
				
				while(true) {
					msg = inMsg.readLine();
					m = gson.fromJson(msg, Message.class);
					
					if(m.getType().equals("logout")) {
						chatThreads.remove(this);
						msgSendAll(gson.toJson(new Message(m.getId(), "", "님이 종료했습니다.", "server")));
						
						status = false;
						this.interrupt();
						logger.info(this.getName() + " 종료됨");
					}
					
					else if(m.getType().equals("login")) {
						msgSendAll(gson.toJson(new Message(m.getId(), "", "님이 로그인했습니다.", "server")));
					}
					
					else {
						msgSendAll(msg);
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		MultiChatServer server = new MultiChatServer();
	}
}
