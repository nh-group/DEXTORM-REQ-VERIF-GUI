package fr.pantheonsorbonne.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import fr.pantheonsorbonne.entities.Exigence;


public interface ExigenceRepository extends CrudRepository<Exigence, Long>{
	
	
}