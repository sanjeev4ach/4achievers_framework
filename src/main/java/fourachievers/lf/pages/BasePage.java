package fourachievers.lf.pages;

import org.openqa.selenium.By;

import fourachievers.lf.driver.DriverManager;
import fourachievers.lf.enums.WaitStrategy;
import fourachievers.lf.factories.ExplicitWaitFactory;
import fourachievers.lf.reports.ExtentLogger;

public class BasePage {

	protected void click(By by, WaitStrategy waitStrategy,String elementName) {
		ExplicitWaitFactory.performExplicitWaitStrategy(waitStrategy, by).click();
		DriverManager.getDriver().findElement(by).click();
		ExtentLogger.pass(elementName +"is Clicked");
	}

	protected void sendKeys(By by, String value) {
		DriverManager.getDriver().findElement(by).sendKeys(value);
	}

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

}
