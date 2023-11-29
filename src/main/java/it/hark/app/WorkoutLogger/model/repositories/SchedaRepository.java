package it.hark.app.workoutlogger.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.hark.app.workoutlogger.model.entities.Scheda;

@Repository
public interface SchedaRepository extends JpaRepository<Scheda, Integer>{

}
