package self.learning.parallel_copy;

import java.io.IOException;

import self.learning.example.Util;

class CopyTask implements Runnable {

	String source;
	String destination;

	CopyTask(String source, String destination) {
		this.source = source;
		this.destination = destination;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Util.copyFile(source, destination);
			System.out.println("Content copied from " + source + " to " + destination);
		} catch (Exception e) {
			// TODO: handle exception
			e.fillInStackTrace();
		}
	}

}

public class Demo {

	public static void main(String[] args) throws IOException {
		String source_ = "a.txt";
		String _source = "b.txt";

		String destination_ = "c.txt";
		String _destination = "d.txt";

		// this is parallel copy
		// making copy a parallel execution
		  Thread thread_ = new Thread(new CopyTask(source_,destination_));
		  thread_.start();
		  
		  Thread _thread = new Thread(new CopyTask(_source,_destination));
		  _thread.start();
		 

	}

}
