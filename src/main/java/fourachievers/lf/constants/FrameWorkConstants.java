package fourachievers.lf.constants;

import fourachievers.lf.enums.ConfigProp;
import fourachievers.lf.util.PropertyUtils;

public final class FrameWorkConstants {
	
	private FrameWorkConstants() {}

	public static String getConfigPath() {
		return CONFIG_PATH;
	}

	public static int getExplicitwaitTime() {
		return EXPLICITWAIT_TIME;
	}

	public static String getConfigjsonPath() {
		return CONFIGJSON_PATH;
	}

	public static String getExtentReportFilePath() {
		if(extentReportFilePath.isEmpty())
			extentReportFilePath = createReportPath();
		return extentReportFilePath;
	}
	
	private static String createReportPath() {
		if(PropertyUtils.get(ConfigProp.OVERRIDEREPORTS).equalsIgnoreCase("no"))
			return EXTENTREPORT_FOLDERPATH+System.currentTimeMillis()+"/index.html";
		else
			return EXTENTREPORT_FOLDERPATH+"/index.html";
	}

	public static String getExcelPath() {
		return EXCEL_PATH;
	}

	public static String getRunmanagerSheetname() {
		return RUNMANAGER_SHEETNAME;
	}

	public static String getIterationData() {
		return ITERATION_DATA;
	}

	private static final String RESOURCES_PATH = System.getProperty("user.dir")+"/src/test/resources/"; 
	private static final String CHROMEDRIVERPATH = RESOURCES_PATH;
	private static final String CONFIG_PATH = RESOURCES_PATH+"/config/config.properties";
	private static final String CONFIGJSON_PATH = RESOURCES_PATH+"/config/config.json";
	private static final int EXPLICITWAIT_TIME = 10;
	private static final String EXTENTREPORT_FOLDERPATH = System.getProperty("user.dir")+"extent-test-output";
	private static String extentReportFilePath="";
	private static final String EXCEL_PATH = RESOURCES_PATH+"/excel/";
	private static final String RUNMANAGER_SHEETNAME = "RUNMANAGER";
	private static final String ITERATION_DATA = "testDatasheetname";
	
}
