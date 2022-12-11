package tn.esprit.services.Interfaces;

import java.util.List;

import tn.esprit.persistance.Departement;
import tn.esprit.persistance.Enseignant;
import tn.esprit.persistance.Etudiant;

public interface DepartmentService {
	List<Departement> retrieveAllDepartements();

	Departement addDepartement (Departement d);

	Departement updateDepartement (Integer idDepart,String name);

	Departement retrieveDepartement (Integer idDepart);
	List<Etudiant> getEtudiantsByDepartement (Integer idDepartement);
	public void deleteDepartment(Integer idDepartement);
	public List<Enseignant> getEnseignantsByDepartement(Integer idDepartement);

//
}
