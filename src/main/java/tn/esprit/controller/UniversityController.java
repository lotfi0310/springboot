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
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.persistance.Departement;
import tn.esprit.persistance.Universite;
import tn.esprit.services.Interfaces.UniversiteService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("UniversityController")
public class UniversityController {

	@Autowired
	UniversiteService univserv; 
	 

@GetMapping("displayUniversities")
public List<Universite> retrieveAllUniversites() {
	return univserv.retrieveAllUniversites();

}

@PostMapping("addUniversity")
public Universite addUniversite(@RequestBody Universite u) {
u=univserv.addUniversite(u);
return u;
}
//
@PutMapping("updateUniversity")
public Universite updateUniversity(@RequestBody Universite u) {
	 return univserv.updateUniversite(u);
}

@GetMapping("displayUniversityBYId/{idUniversity}")
public Universite retrieveUniversite(@PathVariable("idUniversity") Integer idUniversite) {
	return univserv.retrieveUniversite(idUniversite);
}

@PutMapping("assignuniversityToDepartment/{iduniv}/{iddep}")
public void assignUniversiteToDepartement(@PathVariable("iduniv") Integer idUniversite, @PathVariable("iddep") Integer idDepartement) {
	univserv.assignUniversiteToDepartement(idUniversite, idDepartement);
}

@GetMapping("DetDepatmentByUniversity/{iduniv}")
public List<Departement> retrieveDepartementsByUniversite(@PathVariable("iduniv") Integer idUniversite){
	return univserv.retrieveDepartementsByUniversite( idUniversite);
}


@DeleteMapping("/deleteUniv/{idUniv}")
public String deleteStudentById(@PathVariable("idUniv") int id){
	univserv.removeUniv(id);
 return ""+retrieveUniversite(id).getNomUniv()+"deleted successfully"; 
 }

}
