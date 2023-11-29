package it.hark.app.WorkoutLogger.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.hark.app.WorkoutLogger.model.entities.EserciziScheda;

@Repository
public interface EserciziSchedaRepository extends JpaRepository<EserciziScheda, Integer>{

}
