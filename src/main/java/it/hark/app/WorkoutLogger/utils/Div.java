package it.hark.app.WorkoutLogger.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Div {
	
	private String id;
	private String target;
	private String text;
	
	public Div(String id, String target, String text) {
		super();
		this.id = id;
		this.target = target;
		this.text = text;
	}
}
