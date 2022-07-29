package self.learning;

public class ParallelExecution {
	public static void main(String[] args) {

		// task - 1
		for (int i = 0; i < 100; i++) {
			System.out.print("M");
		}
		
		// task - 2
		TaskThread taskThread = new TaskThread();
		taskThread.start();
		
		// task - 3
		TestThread testThread = new TestThread();
		Thread thread = new Thread(testThread);
		thread.start();
	}

}
//Approach - 1
class TaskThread extends Thread{
	
	public void run() {
		task();
	}
	
	
	public void task() {
		for(int i=0;i<150;i++) {
			System.out.print("T");
		}
	}
}

//Approach - 2
class TestThread implements Runnable{
	
	public void task() {
		for(int i=0;i<145;i++) {
			System.out.print("R");
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		task();
	}
}