package self.learning.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Util {
	public static void copy(InputStream src, OutputStream out) throws IOException {
		System.out.println("=Copying Start=");
		int value;
		while((value = src.read())!=-1) {
			out.write(value);
		}
		System.out.println("=Copying End=");
	}
	
	public static void copyFile(String src,String dest) throws IOException {
		FileInputStream fin = new FileInputStream(src);
		FileOutputStream fout = new FileOutputStream(dest);
		
		Util.copy(fin, fout);
		
		fin.close();
		fout.close();
		System.out.println("Done!!");
	}

}
