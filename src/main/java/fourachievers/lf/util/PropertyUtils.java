package fourachievers.lf.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import fourachievers.lf.constants.FrameWorkConstants;
import fourachievers.lf.enums.ConfigProp;

public final class PropertyUtils {

	private PropertyUtils() {
	}

	private static Properties prop = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();

	static {
		try {
			FileInputStream fis = new FileInputStream(new File(FrameWorkConstants.getConfigPath()));
			prop.load(fis);
			/*
			 * for (Entry<Object, Object> tempMap : prop.entrySet())
			 * CONFIGMAP.put(String.valueOf(tempMap.getKey()),
			 * String.valueOf(tempMap.getValue()).trim());
			 */
			prop.entrySet()
					.forEach(e -> CONFIGMAP.put(String.valueOf(e.getKey()), String.valueOf(e.getValue()).trim()));
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

	public static String getValue(ConfigProp key) throws IOException {
		if (Objects.isNull(key))
			throw new RuntimeException(
					"Given Key/Property Name is - '" + key + "' not found in config.properties file.");
		return prop.getProperty(key.name().toLowerCase());

	}
}
