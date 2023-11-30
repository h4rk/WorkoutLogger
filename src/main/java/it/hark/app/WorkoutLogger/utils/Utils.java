package it.hark.app.WorkoutLogger.utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {

	public static void sleep(int millis) {
		try {
			  Thread.sleep(millis);
		} catch (InterruptedException e) {
			  Thread.currentThread().interrupt();
		}
	}
	
	public static List<Div> generateNav(String location) {
		List<Div> nav = new ArrayList<>();
		switch (location) {
			case "index":
				nav.add(new Div("workouts-btn", "workouts", "Workouts"));
				nav.add(new Div("schede-btn", "schede", "Schede"));
				break;
			case "workouts":
				nav.add(new Div("home-btn", "", "Home"));
				nav.add(new Div("schede-btn", "schede", "Schede"));
				break;
			case "schede":
				nav.add(new Div("home-btn", "", "Home"));
				nav.add(new Div("workouts-btn", "workouts", "Workouts"));
				break;
		}
		return nav;
	}
}
