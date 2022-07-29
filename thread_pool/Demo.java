package self.learning.thread_pool;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import self.learning.example.Util;

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

	public static void main(String[] args) throws IOException {
		String source_  = "a.txt";
		String _source = "b.txt";
		
		
		String destination_  = "c.txt";
		String _destination = "d.txt";
		
		
		//here for 100 files we should not create 100 threads
		//instead we can create thread pool using executor service
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		service.execute(new CopyTask(_source, _destination));
		service.execute(new CopyTask(source_, destination_));
		
		service.shutdown();
		
	}

}
