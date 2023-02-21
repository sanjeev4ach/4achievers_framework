package fourachievers.lf.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class ExceptionDemo {
	
	public static void main(String [] args) throws FileNotFoundException, SQLException{
		a();
	}
	
	public static void a() throws FileNotFoundException, SQLException  {
		b();
		c();
	}
	
	public static void b() throws FileNotFoundException  {
		FileInputStream fis = new FileInputStream("");
	}
	public static void c() throws SQLException {
		throw new SQLException();
	}
	
	//when we throw any RuntimeException it won't ask you to handle it as Java compiler knows that program needs to be terminated here

}
