package fourachievers.lf.tests;

import org.testng.annotations.Test;

import fourachievers.lf.annotations.FrameworkAnnotation;
import fourachievers.lf.driver.DriverManager;
import fourachievers.lf.enums.CategoryType;

public final class HomePageTest extends BaseTest{
	
	private HomePageTest() {}
	
	
	@FrameworkAnnotation(author={"Rohit","Sanjeev"},category= {CategoryType.SMOKE,CategoryType.REGRESSION})
	@Test
	public void testaa() {
		System.out.println(DriverManager.getDriver().getTitle());
	}
	
	@Test
	public void test1() {}
	
	@Test
	public void test2() {}

}
