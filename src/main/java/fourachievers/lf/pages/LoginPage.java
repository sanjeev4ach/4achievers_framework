package fourachievers.lf.pages;

import org.openqa.selenium.By;

import fourachievers.lf.enums.WaitStrategy;

public class LoginPage extends BasePage {

	private final By userName_TextBox = By.xpath("");
	private final By password_TextBox = By.xpath("");
	private final By submit_btn = By.xpath("");

	public LoginPage enterUserName(String userName) {
		sendKeys(userName_TextBox, userName);
		return this;
	}

	public LoginPage enterPassword(String password) {
		sendKeys(password_TextBox, password);
		return this;
	}

	public HomePage doLogin() {
		click(submit_btn,WaitStrategy.CLICKABLE,"login button");
		return new HomePage();
	}

	public String getTitle() {
		return getPageTitle();
	}

}
