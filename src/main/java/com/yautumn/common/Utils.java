package com.yautumn.common;

import java.util.UUID;

public class Utils {
	public static String getUUID() {
		String uuid = null;
		uuid = UUID.randomUUID().toString();
		return uuid;
	}
}
