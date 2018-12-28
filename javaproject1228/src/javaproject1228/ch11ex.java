package javaproject1228;

public class ch11ex extends Thread{
	public int total;
	private SellMananger sm;
	
	public ch11ex() {
		sm = new SellMananger();
		total = 100;
	}

	public class SellMananger {
		synchronized int sell() {
			total--;
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			return total;
		}
	}
	
	public void run() {
		String tname = Thread.currentThread().getName();
		for(int i = 0; i < 3 ; i++) {
			System.out.println(tname + "-판매 : " + sm.sell());
		}
		System.out.println(tname + "종료.");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("티켓 예매 프로그램");
		
		ch11ex app = new ch11ex();
		for(int i = 0 ; i < 10 ; i++) {
			Thread mt = new Thread(app);
			mt.start();
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("main 종료()");
	}

}
