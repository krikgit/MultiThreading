package self.learning.serial_copy;

import java.io.IOException;

import self.learning.example.Util;



public class Demo {

	public static void main(String[] args) throws IOException {
		String source_  = "a.txt";
		String _source = "b.txt";
		
		
		String destination_  = "c.txt";
		String _destination = "d.txt";
		
		Util.copyFile(_source, _destination);
		Util.copyFile(source_, destination_);
	}

}
