package it.hark.app.workoutlogger.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "EserciziScheda")
public class EserciziScheda {
	
	public EserciziScheda() {}

	public EserciziScheda(Integer idEsercizioScheda, Integer idScheda, String esercizio, Integer serie,
			Integer ripetizioni, Integer peso) {
		super();
		this.idEsercizioScheda = idEsercizioScheda;
		this.idScheda = idScheda;
		this.esercizio = esercizio;
		this.serie = serie;
		this.ripetizioni = ripetizioni;
		this.peso = peso;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Getter
	@Setter
	private Integer idEsercizioScheda;
	@Getter
	@Setter
	private Integer idScheda;
	@Getter
	@Setter
	private String esercizio;
	@Getter
	@Setter
	private Integer serie;
	@Getter
	@Setter
	private Integer ripetizioni;
	@Getter
	@Setter
	private Integer peso;
	@Override
	public String toString() {
		return "EserciziScheda [idEsercizioScheda=" + idEsercizioScheda + ", idScheda=" + idScheda + ", esercizio="
				+ esercizio + ", serie=" + serie + ", ripetizioni=" + ripetizioni + ", peso=" + peso + "]";
	}	
}
