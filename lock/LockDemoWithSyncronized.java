package self.learning.lock;

class Writer1 extends Thread{
	Object book;
	Object pen;
	
	public Writer1(Object book, Object pen) {
		// TODO Auto-generated constructor stub
		this.book = book;
		this.pen = pen;
	}
	
	public void run() {
		synchronized (book) {
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				// TODO: handle exception
			}
			synchronized (pen) {
				System.out.println("writer1 is writting with book and pen");
			}
		}
	}
}
class Writer2 extends Thread{
	Object book;
	Object pen;
	
	public Writer2(Object book, Object pen) {
		// TODO Auto-generated constructor stub
		this.book = book;
		this.pen = pen;
	}
	
	public void run() {
		synchronized (book) { //if pen is passed in synchronized then lock will be there
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				// TODO: handle exception
			}
			synchronized (pen) {
				System.out.println("writer2 is writting with book and pen");
			}
		}
	}
}

public class LockDemoWithSyncronized {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Object book = new Object();
		Object pen = new Object();
		
		new Writer1(book, pen).start();
		new Writer2(book, pen).start();
		
		System.out.println("Main Completed");

	}

}
