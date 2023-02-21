package fourachievers.lf.reports;

import com.aventstack.extentreports.MediaEntityBuilder;

import fourachievers.lf.enums.ConfigProp;
import fourachievers.lf.util.PropertyUtils;
import fourachievers.lf.util.ScreenshotUtils;

public class ExtentLogger {

	private ExtentLogger() {
	}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}

	public static void pass(String message, boolean isScreenshotNeeded) {
		if (PropertyUtils.get(ConfigProp.PASSEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotNeeded)
			ExtentManager.getExtentTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		else
			pass(message);
	}
	
	public static void fail(String message, boolean isScreenshotNeeded) {
		if (PropertyUtils.get(ConfigProp.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotNeeded)
			ExtentManager.getExtentTest().fail(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		else
			fail(message);
	}
	
	public static void skip(String message, boolean isScreenshotNeeded) {
		if (PropertyUtils.get(ConfigProp.SKIPPEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotNeeded)
			ExtentManager.getExtentTest().skip(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		else
			skip(message);
	}
}
