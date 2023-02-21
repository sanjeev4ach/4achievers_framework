package fourachievers.lf.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import fourachievers.lf.constants.FrameWorkConstants;

public final class DataProviderUtils {

	private static List<Map<String, String>> list = new ArrayList<>();

	@DataProvider
	public static Object[] getData(Method m) {
		String testName = m.getName();
		if (list.isEmpty())
			list = ExcelUtils.readExcelDataInMap(FrameWorkConstants.getIterationData());

		List<Map<String, String>> iterationlist = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).get("testname").equalsIgnoreCase(testName)
					&& list.get(i).get("execute").equalsIgnoreCase("yes")) {

				iterationlist.add(list.get(i));

			}
		}

		list.removeAll(iterationlist);
		return iterationlist.toArray();
	}
}
