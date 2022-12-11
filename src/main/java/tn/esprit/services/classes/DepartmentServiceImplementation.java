package tn.esprit.services.classes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.Departement;
import tn.esprit.persistance.Enseignant;
import tn.esprit.persistance.Etudiant;
import tn.esprit.persistance.repositories.DepartmentRepository;
import tn.esprit.services.Interfaces.DepartmentService;
@Service
public class DepartmentServiceImplementation implements DepartmentService{
	@Autowired 
	DepartmentRepository deprep; 

	public List<Departement> retrieveAllDepartements() {
		return deprep.findAll();
	}

	public Departement addDepartement(Departement d) {
		 deprep.save(d);
		return d;
	}

	public Departement updateDepartement(Integer id,String name) {
		Optional<Departement> department = deprep.findById(id);
		if(department.isPresent()) {
			Departement dep = department.get();
			dep.setNomDepart(name);
			deprep.save(dep);
			return dep;
		}
		return null;
	}
//
	public Departement retrieveDepartement(Integer idDepart) {
		return deprep.findById(idDepart).get();
	}

	public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
		return deprep.getEtudiantsByDepartement(idDepartement);
	}
	
	public List<Enseignant> getEnseignantsByDepartement(Integer idDepartement) {
		return deprep.getEnseignantsByDepartement(idDepartement);
	}


	public void deleteDepartment(Integer idDepartement) {
		 deprep.deleteById(idDepartement);
		
	}
	
	

}
