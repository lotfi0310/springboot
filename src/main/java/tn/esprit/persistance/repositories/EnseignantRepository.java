package tn.esprit.persistance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.persistance.Departement;
import tn.esprit.persistance.Enseignant;
import tn.esprit.persistance.Etudiant;
@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Integer> {

	

}
//