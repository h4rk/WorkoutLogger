package it.hark.app.workoutlogger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.hark.app.workoutlogger.model.entities.Workout;
import it.hark.app.workoutlogger.model.repositories.WorkoutRepository;

@Controller
public class WorkoutLoggerController {

	private final Logger logger = LoggerFactory.getLogger(WorkoutLoggerController.class);
	private WorkoutRepository workoutRepository;
	
	public WorkoutLoggerController(WorkoutRepository workoutRepository) {
		super();
		this.workoutRepository = workoutRepository;
	}

	@GetMapping("/")
	public String index(Model model) {
		logger.info("Received request for index()");
		return "index";
	}
	
	@GetMapping("/loadTable")
	public String loadTable(Model model) {
		logger.info("Received request for loadTable()");
		model.addAttribute("workouts", workoutRepository.findAll());
		try {
			  Thread.sleep(2000);
		} catch (InterruptedException e) {
			  Thread.currentThread().interrupt();
		}
		return "table";
	}
	
	@DeleteMapping("/deleteWorkout/{idWorkout}")
	public String deleteWorkout(@PathVariable Integer idWorkout) {
		logger.info("Received request for deleteWorkout() with id:" + idWorkout);
		workoutRepository.deleteById(idWorkout);
		return "reload-table";
	}
	
	@PostMapping("/postWorkout")
	public String postWorkout(Workout workout) {
		logger.info("Received request for postWorkout()");
		logger.info("Persisting the following workout: " + workout.toString());
		workoutRepository.save(workout);
		return "reload-table";
	}
}
