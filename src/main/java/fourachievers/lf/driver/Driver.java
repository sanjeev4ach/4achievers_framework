package fourachievers.lf.driver;

import java.io.IOException;
import java.util.Objects;

import org.openqa.selenium.WebDriver;

import fourachievers.lf.enums.ConfigProp;
import fourachievers.lf.util.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public final class Driver {
	private Driver() {
	}

	public static void initDriver(String browserName) throws IOException {
		if (Objects.isNull(DriverManager.getDriver())) {
			if(browserName.equalsIgnoreCase("chrome"))
				DriverManager.setDriver(WebDriverManager.chromedriver().create());
			else if(browserName.equalsIgnoreCase("firefox"))
				DriverManager.setDriver(WebDriverManager.firefoxdriver().create());
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProp.URL));
		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
