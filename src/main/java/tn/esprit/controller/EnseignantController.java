package tn.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.input.DepartementInput;
import tn.esprit.input.EnseignantInput;
import tn.esprit.persistance.Departement;
import tn.esprit.persistance.Enseignant;
import tn.esprit.persistance.Etudiant;
import tn.esprit.services.Interfaces.DepartmentService;
import tn.esprit.services.Interfaces.EnseignantService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("EnseignantController")
public class EnseignantController {
//
	@Autowired
	EnseignantService enseignantService ; 
	
	@GetMapping("displayallEnseignant")
	public List<Enseignant> retrieveAllEnseignants() {
		return enseignantService.retrieveAllEnseignannt();
	}

	@PostMapping("addEnseignant" )
	public Enseignant addEnseignant(@RequestBody EnseignantInput e) {
		return enseignantService.addEnseignant(e);
	}

	@PutMapping("updateEnseignant/{id}")
	@ResponseBody
	public Enseignant updateEnseignant(@PathVariable("id") Integer id,@RequestBody EnseignantInput d) {	
		return enseignantService.updateEnseignant(id,d);
	}

	@GetMapping("displEnseignantbyid/{idEns}")
	@ResponseBody
	public Enseignant retrieveEnseignant( @PathVariable("idEns") int idEns) {
		return enseignantService.retrieveEnseignant(idEns);
	}

	/*@GetMapping("GetListOfEtudiantsByDepartment/{iddepartment}")
	List<Etudiant> getEtudiantsByDepartment(@PathVariable("iddepartment") Integer iddep){
		return depserv.getEtudiantsByDepartement(iddep);
	}
	*/
	@DeleteMapping("DeleteEnseignant/{idEnseignant}")
	void deleteEnseignant(@PathVariable("idEnseignant") Integer idEns){
		enseignantService.deleteEnseignat(idEns);
	}

}
