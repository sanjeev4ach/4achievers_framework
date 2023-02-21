package fourachievers.lf.pages;

import org.openqa.selenium.By;

import fourachievers.lf.enums.WaitStrategy;
import fourachievers.lf.reports.ExtentLogger;
import fourachievers.lf.reports.ExtentManager;

public class HomePage extends BasePage {

	private static By link_welcome = By.linkText("");
	private static By logout_btn = By.xpath("");

	public HomePage clickWelcome() {
		click(link_welcome,WaitStrategy.PRESENCE,"Welcome link");
		ExtentLogger.pass("Test Passed");
		return this;
	}

	public LoginPage clickLogOut() {
		click(logout_btn,WaitStrategy.PRESENCE,"logout button");
		ExtentLogger.pass("Logout is Successfull");
		return new LoginPage();
	}

}
