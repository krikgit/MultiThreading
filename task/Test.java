package self.learning.task;


class MyTask extends Thread{
	int i=99;
	public void run() {
		i++;
		System.out.println(i);
	}
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyTask().start();
		
	}

}
