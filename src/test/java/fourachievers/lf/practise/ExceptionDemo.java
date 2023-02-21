package fourachievers.lf.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionDemo {
	
	public static void main(String [] args) throws FileNotFoundException{ //top level logging
		a();
	}
	
	public static void a() throws FileNotFoundException  { // mid level loggin
		b();
		c();
	}
	
	public static void b() throws FileNotFoundException  { // bottom level logging
		FileInputStream fis = new FileInputStream("");
	}
	public static void c() {
		throw new RuntimeException();
	}
	
	//when we throw any RuntimeException it won't ask you to handle it as Java compiler knows that program needs to be terminated here

}
