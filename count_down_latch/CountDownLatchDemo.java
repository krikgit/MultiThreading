package self.learning.count_down_latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Migration implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int recordCount = 220;
		int batchSize = 100;
		int pages = (int) Math.ceil((double)recordCount/batchSize);
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		CountDownLatch latch = new CountDownLatch(pages);
		
		for (int i = 1; i <= pages; i++) {
			final int pageNo = i;
			service.submit(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println("Migrated page:"+pageNo);
					latch.countDown(); // it will decrease the count 
				}
			});
		}
		service.shutdown(); // so that executor is cloed for new thread submission
		boolean state = false;
		try {
			state =latch.await(2, TimeUnit.SECONDS); // if not completed within 2 seconds then timed out
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		if (state) {
			System.out.println("Migration completed!!");
		}else {
			System.out.println("Timed out!!");
		}
		
		
	}
	
}

public class CountDownLatchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new Thread(new Migration()).start();
	}

}
