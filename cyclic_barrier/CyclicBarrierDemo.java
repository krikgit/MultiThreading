package self.learning.cyclic_barrier;

import java.util.concurrent.CyclicBarrier;

class A extends Thread{
	
	CyclicBarrier barrier;
	
	public A(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	public void run() {
		try {
			barrier.await();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("A started...");
	}
}
class B extends Thread{
	CyclicBarrier barrier;
	
	public B(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	public void run() {
		try {
			barrier.await();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("B started...");
	}
}

public class CyclicBarrierDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CyclicBarrier barrier = new CyclicBarrier(2);
		//A will not start until B is ready to go and vice versa as barrier is there
		new A(barrier).start();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		new B(barrier).start();

	}

}
