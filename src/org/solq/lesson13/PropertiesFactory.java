package org.solq.lesson13;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class PropertiesFactory {

	public static <T> T loadProxy(Class<T> clz) {

		Properties pro = getProperties();
		T ret = null;
		try {
			ret = clz.newInstance();

			Field[] fields = clz.getDeclaredFields();
			for (Field f : fields) {
				f.setAccessible(true);
				//other load config 
				String fileName = f.getName();
				Object value = pro.get(fileName);
				try {
					f.set(ret, value);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return ret;
	}

	private static Properties getProperties() {
		Properties pro = new Properties();
		String file = PropertiesFactory.class.getResource("test.properties").getPath();
		try (InputStream fs  = new FileInputStream(file);){
 			pro.load(fs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pro;
	}
}
