package self.learning.atomic_variable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

class SharedService{
	static AtomicBoolean isInit = new AtomicBoolean(false);
	
	public void init() {
		if (!isInit.compareAndSet(false, true)) {
			System.out.println("Already initialized!!");
			return;
		}
		System.out.println("Initializing.....");
	}
	
	public void service() {
		init();
		System.out.println("Performed task.");
	}
}

public class AtomicVars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SharedService service = new SharedService();
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 3; i++) {
			executorService.submit(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					service.service();				
				}
			});
			
		}
		executorService.shutdown();
	}

}
