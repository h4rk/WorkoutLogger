package it.hark.app.WorkoutLogger.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Workout")
public class Workout {
	
	public Workout() {}
	
	public Workout(Integer idWorkout, Integer idScheda, Date data, Integer durata, Integer kcal, short feelScore,
			String note) {
		super();
		this.idWorkout = idWorkout;
		this.idScheda = idScheda;
		this.data = data;
		this.durata = durata;
		this.kcal = kcal;
		this.feelScore = feelScore;
		this.note = note;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Getter
	@Setter
	private Integer idWorkout;
	
	@Getter
	@Setter
	private Integer idScheda;
	
	@Setter
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data;
	
	@Getter
	@Setter
	private Integer durata;
	
	@Getter
	@Setter
	private Integer kcal;
	
	@Getter
	@Setter
	private short feelScore;
	
	@Getter
	@Setter
	private String note;
	
	@Override
	public String toString() {
		return "Workout [idWorkout=" + idWorkout + ", idScheda=" + idScheda + ", data=" + data + ", durata=" + durata
				+ ", kcal=" + kcal + ", feelScore=" + feelScore + ", note=" + note + "]";
	}
	
	public String getData() {
		return new SimpleDateFormat("MM-dd-yyyy").format(this.data);
	}
}
