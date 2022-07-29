package self.learning.semaphore;

import java.util.concurrent.Semaphore;

class PrintThread extends Thread{
	
	int id;
	Semaphore semaphore;
	
	public PrintThread(int id, Semaphore semaphore) {
		this.id = id;
		this.semaphore = semaphore;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		//critical
		try {
			semaphore.acquire();
			System.out.println("Printing no."+id);
			Thread.sleep(2000);
			semaphore.release();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		
	}
	
}

public class SemaphoreExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Semaphore semaphore = new Semaphore(3); //number of threads allowed in critical sections
		
		new  PrintThread(1, semaphore).start();
		new  PrintThread(2, semaphore).start();
		new  PrintThread(3, semaphore).start();
		new  PrintThread(4, semaphore).start();

	}

}
