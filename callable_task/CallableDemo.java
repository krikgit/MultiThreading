package self.learning.callable_task;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyMath{
	public static int sum(int c, int d) {
		return c+d;
	}
}

class MyTask implements Callable<Integer>{ // required when we want something to be returned and cath in main
	
	private int x,y;
	
	public MyTask(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return MyMath.sum(y, x);
	}
	
}

public class CallableDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		
		int x = 9;
		int y = 7;
		
		ExecutorService service = Executors.newFixedThreadPool(1);
		Future<Integer> future = service.submit(new MyTask(x, y));
		//MyTask can be replaced by below thing
		Future<Integer> future2 = service.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				return MyMath.sum(x, y);
			}
		});
		
		
		System.out.println(future2.get());

	}

}
