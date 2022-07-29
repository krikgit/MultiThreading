package self.learning.sync_static;

public class StaticSync {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sample sample = new Sample();
		Sample sample2 = new Sample();
		
		sample.start();
		sample2.start();
		
		

	}

}

class Sample extends Thread{
	static int a = 4;
	int b = 5;
	public void incr() {
		synchronized (Sample.class) {
			a++;
		}
		
		synchronized (this) {
			b++;
		}
	}
	
	public void run() {
		incr();
		System.out.println("a:"+a+"\nb:"+b);
	}
}