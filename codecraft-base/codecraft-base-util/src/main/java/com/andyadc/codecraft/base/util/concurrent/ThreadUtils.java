package com.andyadc.codecraft.base.util.concurrent;

import java.util.concurrent.TimeUnit;

public final class ThreadUtils {

	private ThreadUtils() {
	}

	public static void sleep(long durationMillis) {
		try {
			Thread.sleep(durationMillis);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public static void sleep(long duration, TimeUnit unit) {
		try {
			Thread.sleep(unit.toMillis(duration));
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public static void handleInterruptedException() {
		Thread.currentThread().interrupt();
	}

}
