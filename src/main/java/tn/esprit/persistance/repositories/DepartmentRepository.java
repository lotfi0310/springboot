package tn.esprit.persistance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.persistance.Departement;
import tn.esprit.persistance.Enseignant;
import tn.esprit.persistance.Etudiant;
@Repository
public interface DepartmentRepository extends JpaRepository<Departement, Integer> {

	@Query("select d.etudiants from Departement d where d.idDepart =?1")
	List<Etudiant> getEtudiantsByDepartement (Integer idDepartement);

	
	@Query("select d.enseignants from Departement d where d.idDepart =?1")
	List<Enseignant> getEnseignantsByDepartement (Integer idDepartement);
	
	Departement findByNomDepart(String nomDepart);
}
//