package self.learning.sleep;

class MyThread extends Thread{

	public void run() {
		// TODO Auto-generated method stub
		for(;;) {
			if(isInterrupted()) {
				System.out.println("Interrupted - Stopped");
				break;
			}
			System.out.println("Running -");
		}
	}

	
}

public class Demo {

	public static void main(String[] args)  {
		System.out.println("Line - 1");
		MyThread m = new MyThread();
		m.start();
		try {
			Thread.sleep(1000); //1000 == 1 sec
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		m.interrupt();
		System.out.println("Line - 2");
		
	}

}
