package self.learning.thread_group;

class MyTask implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

public class ThreadGroups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadGroup group = new ThreadGroup("My Group");
		group.setMaxPriority(Thread.NORM_PRIORITY + 2);
		
		
		Thread thr = new Thread(group, new MyTask(),"Task Thread");
		thr.setPriority(Thread.MIN_PRIORITY + 3);
		thr.start();
		
		System.out.println("System threads...");
		Thread thread = Thread.currentThread();
		ThreadGroup grp = thread.getThreadGroup();
		while(grp.getParent()!= null) {
			grp = grp.getParent();
		}
		grp.list();

	}

}
