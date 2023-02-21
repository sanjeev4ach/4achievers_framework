package fourachievers.lf.tests;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import fourachievers.lf.driver.Driver;

public class BaseTest {
	
	protected BaseTest() {}
	
	@BeforeMethod
	protected void setUp(Object[] data) throws IOException {
		Map<String,String> map = (Map<String, String>) data[0];
		//Driver.initDriver(map.get("browser"));
		Driver.initDriver("chrome");
	}
	
	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}

}
