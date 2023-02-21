package fourachievers.lf.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import fourachievers.lf.enums.ConfigProp;
import fourachievers.lf.util.PropertyUtils;

public class RetryFailedTests implements IRetryAnalyzer {

	private int count = 0;
	private int retries = 1;

	@Override
	public boolean retry(ITestResult result) {
		boolean value = false;
		if (PropertyUtils.get(ConfigProp.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
			value = count < retries;
			count++;
		}
		return value;
	}

}
