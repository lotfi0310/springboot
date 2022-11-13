package tn.esprit.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.persistance.Contrat;
@Repository
public interface ContratRepository extends JpaRepository<Contrat, Integer>{

	
}
