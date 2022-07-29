package self.learning.thread_priority;

/*
 *Thread priorities are between 1 to 10
 *Normal = 5
 *Max = 10
 *Min = 1
*/

class CopyTask implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.print("==copy==");
		}
		
	}
	
}

class ProgressTask implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.print("==progress==");
		}
		
	}
}

public class ThreadPriority {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyTask copyTask = new CopyTask();
		Thread copyThread = new Thread(copyTask);
		copyThread.setPriority(Thread.NORM_PRIORITY + 4); //priority 9
		copyThread.start();
		
		ProgressTask progressTask = new ProgressTask();
		Thread progressThread = new Thread(progressTask); //priority 5
		progressThread.start();
		
	}

}
