package it.hark.app.WorkoutLogger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.hark.app.WorkoutLogger.model.entities.Workout;
import it.hark.app.WorkoutLogger.model.repositories.WorkoutRepository;
import it.hark.app.WorkoutLogger.utils.Utils;
import jakarta.validation.Valid;

@Controller
public class WorkoutLoggerController {

	private final Logger logger = LoggerFactory.getLogger(WorkoutLoggerController.class);
	private WorkoutRepository workoutRepository;
	
	public WorkoutLoggerController(WorkoutRepository workoutRepository) {
		super();
		this.workoutRepository = workoutRepository;
	}

	@GetMapping("/")
	public String getIndex(Model model) {
		logger.info("Received request for getIndex()");
		model.addAttribute("navElements", Utils.generateNav("index"));
		model.addAttribute("swapNav", true);
		return "index";
	}
	
	@GetMapping("/home")
	public String getHome(Model model) {
		logger.info("Received request for getHome()");
		model.addAttribute("navElements", Utils.generateNav("index"));
		model.addAttribute("swapNav", true);
		return "fragments/main";
	}
	
	@GetMapping("/workouts")
	public String getWorkouts(Model model) {
		logger.info("Received request for getWorkouts()");
		model.addAttribute("swapNav", true);
		model.addAttribute("navElements", Utils.generateNav("workouts"));
		return "workouts";
	}
	
	@GetMapping("/schede")
	public String getSchede(Model model) {
		logger.info("Received request for getSchede()");
		model.addAttribute("swapNav", true);
		model.addAttribute("navElements", Utils.generateNav("schede"));
		return "schede";
	}
	
	@GetMapping("/loadTable")
	public String loadTable(Model model) {
		logger.info("Received request for loadTable()");
		model.addAttribute("workouts", workoutRepository.findAll());
		Utils.sleep(2000);
		return "table";
	}
	
	@DeleteMapping("/deleteWorkout/{idWorkout}")
	public String deleteWorkout(@PathVariable Integer idWorkout) {
		logger.info("Received request for deleteWorkout() with id:" + idWorkout);
		workoutRepository.deleteById(idWorkout);
		return "reload-table";
	}
	
	@PostMapping("/postWorkout")
	public String postWorkout(@Valid Workout workout, BindingResult bindingResult) {
		logger.info("Received request for postWorkout()");
		logger.info("Persisting the following workout: " + workout.toString());
		workoutRepository.save(workout);
		return "reload-table";
	}
}
