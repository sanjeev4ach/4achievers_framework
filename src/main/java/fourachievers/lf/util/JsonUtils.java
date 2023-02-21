package fourachievers.lf.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import fourachievers.lf.constants.FrameWorkConstants;
import fourachievers.lf.enums.ConfigProp;

public class JsonUtils {

	private static Map<String, String> CONFIGMAP = null;

	private JsonUtils() {
	}

	static {
		try {
			CONFIGMAP = new ObjectMapper().readValue(new File(FrameWorkConstants.getConfigjsonPath()),
					new TypeReference<HashMap<String, String>>() {
					});
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String get(ConfigProp key) {
		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase())))
			throw new RuntimeException(
					"Given Key/Property Name is - '\" + key + \"' not found in config.properties file.");
		return CONFIGMAP.get(key.name().toLowerCase());
	}

}
