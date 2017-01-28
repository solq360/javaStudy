package org.solq.lesson13;

import java.util.Properties;

public class ConfigModel {

	private String name;
	private String password;

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public static ConfigModel of(Properties pro) {
		ConfigModel ret = new ConfigModel();
		ret.name = pro.getProperty("name");
		ret.password = pro.getProperty("password");
		return ret;
	}

}
