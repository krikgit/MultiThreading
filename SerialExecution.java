package self.learning;

public class SerialExecution {

	public static void main(String[] args) {
		//task - 1
		Test t = new Test();
		t.task();
		
		System.out.println("----------------");
		//task - 2
		for(int i=0;i<10;i++) {
			System.out.println("Task - Main");
		}

	}

}

class Test{
	
	public void task() {
		for(int i=0;i<10;i++) {
			System.out.println("Task - Test");
		}
	}
	
}