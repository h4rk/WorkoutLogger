package it.hark.app.WorkoutLogger.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.hark.app.WorkoutLogger.model.entities.Scheda;

@Repository
public interface SchedaRepository extends JpaRepository<Scheda, Integer>{

}
