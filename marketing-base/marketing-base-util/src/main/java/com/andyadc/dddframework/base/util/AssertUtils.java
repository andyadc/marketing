package com.andyadc.dddframework.base.util;

import java.util.Collection;

/**
 * Util class for checking arguments.
 */
public class AssertUtils {

	private AssertUtils() {
	}

	public static void notNull(Object object, String message) {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void assertTrue(boolean value, String message) {
		if (!value) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void notEmpty(String string, String message) {
		if (StringUtils.isEmpty(string)) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void notEmpty(Collection<?> collection, String message) {
		if (collection == null || collection.isEmpty()) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void notBlank(String string, String message) {
		if (StringUtils.isBlank(string)) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void isTrue(boolean value, String message) {
		if (!value) {
			throw new IllegalArgumentException(message);
		}
	}

	public static void assertState(boolean condition, String message) {
		if (!condition) {
			throw new IllegalStateException(message);
		}
	}
}
