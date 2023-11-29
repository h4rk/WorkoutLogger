package it.hark.app.WorkoutLogger.utils;

public class Utils {

	public static void sleep(int millis) {
		try {
			  Thread.sleep(millis);
		} catch (InterruptedException e) {
			  Thread.currentThread().interrupt();
		}
	}
}
