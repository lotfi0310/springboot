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
import tn.esprit.persistance.Departement;
import tn.esprit.persistance.Enseignant;
import tn.esprit.persistance.Etudiant;
import tn.esprit.services.Interfaces.DepartmentService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("DepartmentController")
public class DepartmentController {
//
	@Autowired
	DepartmentService depserv ; 
	
	@GetMapping("displayalldepartment")
	public List<Departement> retrieveAllDepartements() {
		return depserv.retrieveAllDepartements();
	}

	@PostMapping("addDepartment" )
	public Departement addDepartement(@RequestBody DepartementInput d) {
		Departement dep = new Departement();
		dep.setNomDepart(d.getNomDepart());
		System.out.println(dep.getNomDepart());
		System.out.println(dep.getIdDepart());
		depserv.addDepartement(dep);
		return dep;
	}

	@PutMapping("updatedepartment/{id}")
	@ResponseBody
	public Departement updateDepartement(@PathVariable("id") Integer id,@RequestBody DepartementInput d) {	
		return depserv.updateDepartement(id,d.getNomDepart());
	}

	@GetMapping("displdepartmentbyid/{idDepart}")
	@ResponseBody
	public Departement retrieveDepartement( @PathVariable("idDepart") int idDepart) {
		return depserv.retrieveDepartement(idDepart);
	}

	@GetMapping("GetListOfEtudiantsByDepartment/{iddepartment}")
	List<Etudiant> getEtudiantsByDepartment(@PathVariable("iddepartment") Integer iddep){
		return depserv.getEtudiantsByDepartement(iddep);
	}
	
	@GetMapping("GetListOfEnseignantByDepartment/{iddepartment}")
	List<Enseignant> getEnseignantsByDepartment(@PathVariable("iddepartment") Integer iddep){
		return depserv.getEnseignantsByDepartement(iddep);
	}
	
	@DeleteMapping("DeleteDepartment/{iddepartment}")
	void deleteDepartement(@PathVariable("iddepartment") Integer iddep){
		 depserv.deleteDepartment(iddep);
	}

}
