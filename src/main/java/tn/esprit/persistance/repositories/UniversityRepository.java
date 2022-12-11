package tn.esprit.persistance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.persistance.Departement;
import tn.esprit.persistance.Universite;
@Repository
public interface UniversityRepository extends JpaRepository<Universite, Integer> {
    @Query("select u.departments from Universite u  where u.idUniv= ?1")
	public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
}
//