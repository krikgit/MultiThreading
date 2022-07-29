package self.learning.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Sample {

	private int x;
	
	ReadWriteLock rw_lock = new ReentrantReadWriteLock();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void incr() {
		Lock lock = rw_lock.writeLock();
		lock.lock();
		try {
			int y = getX();
			y++;
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				// TODO: handle exception
				e.getStackTrace();
			}
			setX(y);
		} finally {
			// TODO: handle finally clause
			lock.unlock();
		}
		
		
	}
}

class MyThread extends Thread {
	Sample obj;

	public MyThread(Sample obj) {
		// TODO Auto-generated constructor stub
		this.obj = obj;
	}

	public void run() {
		obj.incr();
	}
}

public class LockWithConcurrentLock {

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
