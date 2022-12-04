package tn.esprit.services.Interfaces;

import java.util.List;

import tn.esprit.input.EnseignantInput;
import tn.esprit.persistance.Departement;
import tn.esprit.persistance.Enseignant;
import tn.esprit.persistance.Etudiant;

public interface EnseignantService {
	List<Enseignant> retrieveAllEnseignannt();

	Enseignant addEnseignant (EnseignantInput d);

	Enseignant updateEnseignant(Integer idEns,EnseignantInput d);

	Enseignant retrieveEnseignant(Integer idEns);
	public void deleteEnseignat(Integer idEns);
//
}
