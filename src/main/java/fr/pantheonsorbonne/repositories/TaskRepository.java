package fr.pantheonsorbonne.repositories;

import org.springframework.data.repository.CrudRepository;
import fr.pantheonsorbonne.entities.Task;

public interface TaskRepository extends CrudRepository<Task, Long>{
	
	
}