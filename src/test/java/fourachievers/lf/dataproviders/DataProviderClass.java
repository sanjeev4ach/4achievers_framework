package fourachievers.lf.dataproviders;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class DataProviderClass {
	
	@DataProvider
	public Object[] getData() throws StreamReadException, DatabindException, IOException {
		Map<String,Object> map1 = new ObjectMapper().
				readValue(new File(System.getProperty("user.dir")+"/src/test/resources/config/config.json"), new 
						TypeReference<HashMap<String,Object>>(){});
		
		return new Object[] {map1};
	}

}
