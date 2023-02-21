package fourachievers.lf.util;

public class TestUtils {
	
	public static void suspendSeconds(int seconds) {
		long current = System.currentTimeMillis();
		while (true) {
			if (current + 1000 * seconds < System.currentTimeMillis()) {
				break;
			}
		}
	}

}
