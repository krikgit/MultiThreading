package self.learning.example;

import java.io.IOException;

class CopyTask implements Runnable{
	
	String source;
	String destination;
	
	CopyTask(String source, String destination){
		this.source = source;
		this.destination = destination;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Util.copyFile(source,destination);
			System.out.println("Content copied from "+source+" to "+destination);
		}catch (Exception e) {
			// TODO: handle exception
			e.fillInStackTrace();
		}
	}
	
}

public class Demo {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		String source_  = "a.txt";
		String _source = "b.txt";
		
		
		String destination_  = "c.txt";
		String _destination = "d.txt";
		
		//this is parallel copy
		/*
		  Util.copyFile(source_, destination_); 
		  Util.copyFile(_source, _destination);
		 */
		//making copy a parallel execution
		/*
		Thread thread_ = new Thread(new CopyTask(source_,destination_));
		thread_.start();
		
		Thread _thread = new Thread(new CopyTask(_source,_destination));
		_thread.start();
		*/
		
		//here for 100 files we should not create 100 threads
		//instead we can create thread pool using executor service
		/*
		ExecutorService service = Executors.newFixedThreadPool(5);
		service.execute(new CopyTask(_source, _destination));
		service.execute(new CopyTask(source_, destination_));
		*/
	}

}
