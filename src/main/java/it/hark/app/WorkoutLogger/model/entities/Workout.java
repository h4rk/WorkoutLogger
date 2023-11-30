package it.hark.app.WorkoutLogger.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Workout")
@Getter
@Setter
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
	private Integer idWorkout;
	
	@NotBlank(message="Il campo non può essere vuoto o null")
	private Integer idScheda;
	
	@NotBlank(message="Il campo non può essere vuoto o null")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data;
	
	@Positive
	@NotBlank(message="Il campo non può essere vuoto o null")
	private Integer durata;
	
	@Positive
	@NotBlank(message="Il campo non può essere vuoto o null")
	private Integer kcal;
	
	@NotBlank(message="Il campo non può essere vuoto o null")
	@Positive(message="Il campo deve essere un numero tra 1 e 5 (compresi)")
	@Max(value=5, message="Il campo deve essere un numero tra 1 e 5 (compresi)")
	private short feelScore;
	
	@Size(max=200, message="Lunghezza massima consentita: 300 caratteri")
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
