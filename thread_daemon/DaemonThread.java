package self.learning.thread_daemon;

class MyTask implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(;;) {
			System.out.println("**");
		}
	}
}

public class DaemonThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Thread thr = new Thread(new MyTask());
		thr.setDaemon(true); // its actually background task 
		thr.start();
		
		for(int i=0; i<200;i++) {
			System.out.println("##");
		}*/
		//==================
		Thread [] threads = new Thread[10];
		Thread th = Thread.currentThread();
		ThreadGroup grp = th.getThreadGroup();
		while(grp.getParent() != null) {
			grp = grp.getParent();
		}
		int p = grp.enumerate(threads);
		for(int i=0;i<p;i++) {
			System.out.println("Thread Name:"+threads[i].getName()+"  isDeamon:"+threads[i].isDaemon());
		}
	}

}
