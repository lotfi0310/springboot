package tn.esprit.services.classes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import tn.esprit.input.EnseignantInput;
import tn.esprit.persistance.Departement;
import tn.esprit.persistance.Enseignant;
import tn.esprit.persistance.Etudiant;
import tn.esprit.persistance.repositories.DepartmentRepository;
import tn.esprit.persistance.repositories.EnseignantRepository;
import tn.esprit.services.Interfaces.DepartmentService;
import tn.esprit.services.Interfaces.EnseignantService;
@Service
public class EnseignantServiceImplementation implements EnseignantService{
	@Autowired 
	EnseignantRepository enseignantRepository;
	@Autowired 
	DepartmentRepository departmentRepository;
	@Override
	public List<Enseignant> retrieveAllEnseignannt() {
		return enseignantRepository.findAll();
	}

	@Override
	public Enseignant addEnseignant(EnseignantInput ens) {
		Enseignant e = new  Enseignant();
		e.setCin(ens.getCin());
		e.setNomEnseignant(ens.getNomEnseignant());
		e.setPrenomEnseignant(ens.getPrenomEnseignant());
		Departement dep = departmentRepository.findByNomDepart(ens.getDepartement().getNomDepart());
		if(dep != null ) {
			e.setDepartement(dep);
		}
		enseignantRepository.save(e);
		return e;
	}

	@Override
	public Enseignant updateEnseignant(Integer idEns, EnseignantInput ens) {
		Enseignant e = enseignantRepository.findById(idEns).get();
		e.setCin(ens.getCin());
		e.setNomEnseignant(ens.getNomEnseignant());
		e.setPrenomEnseignant(ens.getPrenomEnseignant());
		Departement dep = departmentRepository.findByNomDepart(ens.getDepartement().getNomDepart());
		if(dep != null ) {
			e.setDepartement(dep);
		}
		enseignantRepository.save(e);
		return e;
	}

	@Override
	public Enseignant retrieveEnseignant(Integer idEns) {
		// TODO Auto-generated method stub
		return enseignantRepository.findById(idEns).get();
	}

	@Override
	public void deleteEnseignat(Integer idEns) {
		enseignantRepository.delete(enseignantRepository.findById(idEns).get());
		
	}

	

	
	

}
