package fr.pantheonsorbonne.repositories;

import org.springframework.data.repository.CrudRepository;
import fr.pantheonsorbonne.entities.Report;


public interface ReportRepository extends CrudRepository<Report, Long>{
	
	
}