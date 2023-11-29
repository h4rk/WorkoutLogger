package it.hark.app.workoutlogger.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.hark.app.workoutlogger.model.entities.Workout;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Integer>{

}
