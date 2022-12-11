package tn.esprit.services.Interfaces;

import java.util.List;

import tn.esprit.persistance.Departement;
import tn.esprit.persistance.Etudiant;
import tn.esprit.persistance.Universite;

public interface UniversiteService {
	List<Universite> retrieveAllUniversites();
	Universite addUniversite (Universite u);
	Universite updateUniversite (Universite u);
	Universite retrieveUniversite (Integer idUniversite);

	public void assignUniversiteToDepartement(Integer idUniversite, Integer
			idDepartement);
	
	public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
	void removeUniv(int id);

}
//