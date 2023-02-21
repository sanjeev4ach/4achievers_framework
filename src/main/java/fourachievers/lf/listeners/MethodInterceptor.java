package fourachievers.lf.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import fourachievers.lf.constants.FrameWorkConstants;
import fourachievers.lf.util.ExcelUtils;

public class MethodInterceptor implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

		List<Map<String, String>> data = ExcelUtils.readExcelDataInMap(FrameWorkConstants.getRunmanagerSheetname());
		List<IMethodInstance> result = new ArrayList<>();

		for (int i = 0; i < methods.size(); i++) {
			for (int j = 0; j < data.size(); j++) {
				if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(data.get(j).get("name"))
						&& data.get(j).get("execute").equalsIgnoreCase("yes")) {

					methods.get(i).getMethod().setDescription(data.get(j).get("testdescription"));
					methods.get(i).getMethod().setInvocationCount(Integer.parseInt(data.get(j).get("count")));
					methods.get(i).getMethod().setPriority(Integer.parseInt(data.get(j).get("priority")));
					result.add(methods.get(i));

				}
			}
		}
		return result;
	}

}
