package fourachievers.lf.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import fourachievers.lf.constants.FrameWorkConstants;
import fourachievers.lf.enums.CategoryType;

public class ExtentReport {

	private ExtentReport() {
	}

	private static ExtentReports extent;

	public static void initReports() {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("4achievers Automation Learning");
			spark.config().setReportName("Framework Learning");
		}
	}

	public static void flushReports() {
		if (Objects.nonNull(extent))
			extent.flush();
		ExtentManager.unload();
		try {
			Desktop.getDesktop().browse(new File(FrameWorkConstants.getExtentReportFilePath()).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createTest(String testcaseName) {
		ExtentTest test = extent.createTest(testcaseName);
		ExtentManager.setExtentTest(test);
	}

	public static void addAuthors(String[] authors) {
		for (String temp : authors)
			ExtentManager.getExtentTest().assignAuthor(temp);
	}

	public static void addCategories(CategoryType[] categories) {
		for (CategoryType temp : categories)
			ExtentManager.getExtentTest().assignCategory(temp.toString());
	}

}
