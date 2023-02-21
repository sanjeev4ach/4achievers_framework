package fourachievers.lf.factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import fourachievers.lf.constants.FrameWorkConstants;
import fourachievers.lf.driver.DriverManager;
import fourachievers.lf.enums.WaitStrategy;

public class ExplicitWaitFactory {

	public static WebElement performExplicitWaitStrategy(WaitStrategy waitstrategy, By by) {
		WebElement element = null;
		if (waitstrategy == WaitStrategy.CLICKABLE)
			element = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofSeconds(FrameWorkConstants.getExplicitwaitTime()))
							.until(ExpectedConditions.elementToBeClickable(by));
		else if (waitstrategy == WaitStrategy.PRESENCE)
			element = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofSeconds(FrameWorkConstants.getExplicitwaitTime()))
							.until(ExpectedConditions.presenceOfElementLocated(by));
		else if (waitstrategy == WaitStrategy.VISIBILITY)
			element = new WebDriverWait(DriverManager.getDriver(),
					Duration.ofSeconds(FrameWorkConstants.getExplicitwaitTime()))
							.until(ExpectedConditions.presenceOfElementLocated(by));
		else if (waitstrategy == WaitStrategy.NONE)
			System.out.println("Not Doing anything");
		return element;

	}

}
