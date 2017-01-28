package org.solq.lesson13.demo;

import org.solq.lesson13.ConfigModel;
import org.solq.lesson13.PropertiesFactory;

public class TestProperties {

	public static void main(String[] args) {
		ConfigModel config = PropertiesFactory.loadProxy(ConfigModel.class);
		System.out.println(config.getName());
	}

}
