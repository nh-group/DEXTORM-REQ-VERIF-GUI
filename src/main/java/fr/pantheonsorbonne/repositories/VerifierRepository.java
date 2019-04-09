package fr.pantheonsorbonne.repositories;

import fr.pantheonsorbonne.entities.Verifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface VerifierRepository extends CrudRepository<Verifier, Long>{

	
}
