package fourachievers.lf.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fourachievers.lf.driver.DriverManager;
import fourachievers.lf.pages.LoginPage;
import fourachievers.lf.util.DataProviderUtils;

public final class LoginPageTest extends BaseTest{
	
	private LoginPageTest() {}
	
	@Test
	public void testgetTitle() {
		System.out.println(DriverManager.getDriver().getTitle());
		
		String title = new LoginPage().enterUserName("").enterPassword("").doLogin()
		.clickWelcome().clickLogOut().getTitle();
		
		Assertions.assertThat(title).isEqualTo("amazon");
		
	}
	
	@Test(dataProvider = "dataProvider")
	public void testDataProvider(String userName,String password) {
		String title = new LoginPage().enterUserName(userName).enterPassword(password).doLogin()
		.clickWelcome().clickLogOut().getTitle();
		
		Assertions.assertThat(title).isEqualTo("amazon");
	}
	
	@DataProvider(name="dataProvider", parallel = true)
	public Object[][] getData(){
		return new Object[][] {
			{"Admin","Admin123"}
		};
	}
	
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
	public void testDataProviderFromCommonClass(Map<String,String> data) {
		String title = new LoginPage().enterUserName(data.get("username")).enterPassword(data.get("password")).doLogin()
		.clickWelcome().clickLogOut().getTitle();
		
		Assertions.assertThat(title).isEqualTo("amazon");
	}

}
