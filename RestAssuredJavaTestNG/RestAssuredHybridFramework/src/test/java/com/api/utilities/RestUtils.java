package com.api.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

	
	public static String empName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("John"+generatedString);
	}

	public static String empJob() {
		String generatedString2 = RandomStringUtils.randomAlphabetic(5);
		return ("Leader"+generatedString2);
	}
	
	
	
}
