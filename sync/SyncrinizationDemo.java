package self.learning.sync;

class Sample{
	
	private int x;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public synchronized void incr() {
		int y = getX();
		y++;
		try {
			Thread.sleep(1);
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		setX(y);
	}
}

class MyThread extends Thread{
	Sample obj;
	
	public MyThread(Sample obj) {
		// TODO Auto-generated constructor stub
		this.obj = obj;
	}
	
	public void run() {
		obj.incr();
	}
}

public class SyncrinizationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sample obj = new Sample();
		obj.setX(10);
		
		MyThread th = new MyThread(obj);
		MyThread thr = new MyThread(obj);
		
		th.start();
		thr.start();
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		
		System.out.println(obj.getX());
		

	}

}
