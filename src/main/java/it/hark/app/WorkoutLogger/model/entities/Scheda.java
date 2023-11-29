package it.hark.app.WorkoutLogger.model.entities;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Scheda")
public class Scheda {
	
	
	public Scheda() {}
	
	public Scheda(long idScheda, String nomeScheda, Date dataCreazione, String descrizione) {
		super();
		this.idScheda = idScheda;
		this.nomeScheda = nomeScheda;
		this.dataCreazione = dataCreazione;
		this.descrizione = descrizione;
	}
	
	@Id
	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long idScheda;
	@Getter
	@Setter
	private String nomeScheda;
	@Getter
	@Setter
	private Date dataCreazione;
	@Getter
	@Setter
	private String descrizione;
	@Override
	public String toString() {
		return "Scheda [idScheda=" + idScheda + ", nomeScheda=" + nomeScheda + ", dataCreazione=" + dataCreazione
				+ ", descrizione=" + descrizione + "]";
	}
	
	
}
