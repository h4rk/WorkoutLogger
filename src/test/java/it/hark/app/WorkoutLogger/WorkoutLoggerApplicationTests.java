package it.hark.app.WorkoutLogger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.hark.app.WorkoutLogger.utils.Div;
import it.hark.app.WorkoutLogger.utils.Utils;

@SpringBootTest
class WorkoutLoggerApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void generateNavTest() {
		List<Div> indexNav = Utils.generateNav("index");
		List<Div> schedeNav = Utils.generateNav("schede");
		List<Div> workoutsNav = Utils.generateNav("workouts");
		
		//Test elementi not null
		assertNotNull(indexNav.get(0));
		assertNotNull(indexNav.get(1));
		assertNotNull(schedeNav.get(0));
		assertNotNull(schedeNav.get(1));
		assertNotNull(workoutsNav.get(0));
		assertNotNull(workoutsNav.get(1));
		
		//Test cardinalita
		assertEquals(indexNav.size(), 2);
		assertEquals(schedeNav.size(), 2);
		assertEquals(workoutsNav.size(), 2);
		
		//Test valori
		assertEquals(indexNav.get(0).getId(), "workouts-btn");
		assertEquals(indexNav.get(0).getTarget(), "workouts");
		assertEquals(indexNav.get(1).getId(), "schede-btn");
		assertEquals(indexNav.get(1).getTarget(), "schede");
		
		assertEquals(schedeNav.get(0).getId(), "home-btn");
		assertEquals(schedeNav.get(0).getTarget(), "");
		assertEquals(schedeNav.get(1).getId(), "workouts-btn");
		assertEquals(schedeNav.get(1).getTarget(), "workouts");
		
		assertEquals(workoutsNav.get(0).getId(), "home-btn");
		assertEquals(workoutsNav.get(0).getTarget(), "");
		assertEquals(workoutsNav.get(1).getId(), "schede-btn");
		assertEquals(workoutsNav.get(1).getTarget(), "schede");
		
		
	}
}
