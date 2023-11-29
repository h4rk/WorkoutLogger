package it.hark.app.WorkoutLogger.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import it.hark.app.WorkoutLogger.model.entities.EserciziScheda;
import it.hark.app.WorkoutLogger.model.entities.Scheda;
import it.hark.app.WorkoutLogger.model.entities.Workout;
import it.hark.app.WorkoutLogger.model.repositories.EserciziSchedaRepository;
import it.hark.app.WorkoutLogger.model.repositories.SchedaRepository;
import it.hark.app.WorkoutLogger.model.repositories.WorkoutRepository;

@RestController
public class WorkoutLoggerRestController {
	
	private SchedaRepository schedaRepository;
	private WorkoutRepository workoutRepository;
	private EserciziSchedaRepository eserciziSchedaRepository;
	private Logger logger = Logger.getLogger("it.h4rk.workoutlogger.logger");
	
	

	public WorkoutLoggerRestController(SchedaRepository schedaRepository, WorkoutRepository workoutRepository,
			EserciziSchedaRepository eserciziSchedaRepository) {
		super();
		this.schedaRepository = schedaRepository;
		this.workoutRepository = workoutRepository;
		this.eserciziSchedaRepository = eserciziSchedaRepository;
	}

	//SEZIONE SCHEDE
	
	@GetMapping("/schede")
	public List<Scheda> getSchede() {
		logger.log(Level.INFO, "Ricevuta chiamata getSchede()");
		return schedaRepository.findAll();
	}
	
	@GetMapping("/schede/{idScheda}")
	public ResponseEntity<Scheda> getScheda(@PathVariable Integer idScheda) {
		logger.log(Level.INFO, "Ricevuta chiamata getScheda()");
		try {
			return new ResponseEntity<>(schedaRepository.findById(idScheda).orElseThrow(), HttpStatus.OK);
		} catch (NoSuchElementException nsee) {
			//Sperimentare con return code
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nessuna scheda presente con l'id specificato");
		}
	}
		
	@PostMapping("/schede")
	public ResponseEntity<Scheda> postScheda(@RequestBody Scheda scheda) {
		logger.log(Level.INFO, "Ricevuta chiamata postScheda()");
		logger.log(Level.INFO, "Scheda input: " + scheda.toString());
		try {
			schedaRepository.save(scheda);
			logger.log(Level.INFO, "Scheda salvata con successo.");
			return new ResponseEntity<>(scheda, HttpStatus.OK);
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "Errore nel salvataggio della scheda.");
			re.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/schede/{idScheda}")
	public ResponseEntity<String> deleteScheda(@PathVariable Integer idScheda) {
		try {
			schedaRepository.delete(schedaRepository.findById(idScheda).orElseThrow());
			logger.log(Level.INFO, "Scheda con id="+idScheda+" rimossa correttamente.");
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException nsee) {
			//throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nessuna scheda presente con l'id specificato");
			logger.log(Level.INFO, "Nessuna scheda presente con id="+idScheda+".");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	// SEZIONE WORKOUTS
	
	@GetMapping("/workouts")
	public List<Workout> getWorkouts() {
		logger.log(Level.INFO, "Ricevuta chiamata getWorkouts()");
		return workoutRepository.findAll();
	}
	
	@GetMapping("/workouts/{idWorkout}")
	public ResponseEntity<Workout> getWorkout(@PathVariable Integer idWorkout) {
		logger.log(Level.INFO, "Ricevuta chiamata getWorkout()");
		try {
			return new ResponseEntity<>(workoutRepository.findById(idWorkout).orElseThrow(), HttpStatus.OK);
		} catch (NoSuchElementException nsee) {
			//Sperimentare con return code
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nessun workout presente con l'id specificato");
		}
	}
	
	@PostMapping("/workouts")
	public ResponseEntity<Workout> postWorkout(@RequestBody Workout workout) {
		logger.log(Level.INFO, "Ricevuta chiamata postWorkout()");
		logger.log(Level.INFO, "Workout input: " + workout.toString());
		try {
			workoutRepository.save(workout);
			logger.log(Level.INFO, "Workout salvato con successo.");
			return new ResponseEntity<>(workout, HttpStatus.OK);
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "Errore nel salvataggio del workout.");
			re.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/workouts/{id}")
	public ResponseEntity<String> deleteWorkout(@PathVariable Integer idWorkout) {
		try {
			workoutRepository.delete(workoutRepository.findById(idWorkout).orElseThrow());
			logger.log(Level.INFO, "Workout con id="+idWorkout+" rimosso correttamente.");
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException nsee) {
			logger.log(Level.INFO, "Nessun workout presente con id="+idWorkout+".");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	//SEZIONE ESERCIZI
	@PostMapping("/esercizi")
	public ResponseEntity<EserciziScheda> postEsercizio(@RequestBody EserciziScheda esercizioScheda) {
		logger.log(Level.INFO, "Ricevuta chiamata postEsercizio()");
		logger.log(Level.INFO, "Esercizio input: " + esercizioScheda.toString());
		try {
			eserciziSchedaRepository.save(esercizioScheda);
			logger.log(Level.INFO, "Esercizio salvato con successo.");
			return new ResponseEntity<>(esercizioScheda, HttpStatus.OK);
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "Errore nel salvataggio dell'esercizio.");
			re.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/esercizi/{id}")
	public ResponseEntity<String> deleteEsercizio(@PathVariable Integer idEsercizio) {
		try {
			eserciziSchedaRepository.delete(eserciziSchedaRepository.findById(idEsercizio).orElseThrow());
			logger.log(Level.INFO, "Esercizio con id="+idEsercizio+" rimosso correttamente.");
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException nsee) {
			logger.log(Level.INFO, "Nessun esercizio presente con id="+idEsercizio+".");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	
}
