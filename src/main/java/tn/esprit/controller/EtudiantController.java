package tn.esprit.controller;

import java.util.List;

import javax.websocket.server.PathParam;

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

import lombok.extern.slf4j.Slf4j;
import tn.esprit.persistance.Contrat;
import tn.esprit.persistance.Etudiant;
import tn.esprit.persistance.repositories.EquipeRepository;
import tn.esprit.persistance.repositories.EtudiantRepository;
import tn.esprit.services.Interfaces.EquipeService;
import tn.esprit.services.Interfaces.EtudiantService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/controllerEtudiant")
public class EtudiantController {
	//
	
  @Autowired
  EtudiantService etudserv;
 
 
  @GetMapping("/DisplayStudents")
  public List<Etudiant> DisplayStudents() {
	  return etudserv.retrieveAllEtudiants();
  }
  

  @GetMapping("/searchEtudiantByNomEtPrenom/{nom}/{prenom}")
  public int searchEtudiantBynomEtprenom(@PathVariable("nom") String nom, @PathVariable("prenom") String prenom){
	  return etudserv.searchEtudiantBynomEtprenom(nom, prenom);
  }
  
   
  @GetMapping("/DisplayEtudiantById/{id}")
  public Etudiant displayEtudiantByID(@PathVariable("id") int id) {
	  return etudserv.retrieveEtudiant(id); 
	  }
  
  @PostMapping("/ajouterEtudiant")
  public Etudiant addEtudiant(@RequestBody Etudiant e) {
	  e=etudserv.addEtudiant(e);
	  return  e ;
  }
  
  @PutMapping("/updateStudentById")
  public Etudiant updateStudent(@RequestBody Etudiant e) {
	return  etudserv.updateEtudiant(e);
		}
  
  @DeleteMapping("/deletestudent/{id}")
  public String deleteStudentById(@PathVariable("id") int id){
   etudserv.removeEtudiant(id);
   return "deleted successfully"; 
   }
  
  @GetMapping("existenceByName/{name}")
 
  public Etudiant testExistEtudiantByname(@PathVariable("name") String name) {
	  return etudserv.getEtudiantByNomE(name); 
  }
  
  @GetMapping("filterEtudiantsBeginByName/{name}")
  public List<Etudiant> allEtudiantsNameCommencePar(@PathVariable("name") String name){
	  return etudserv.getAllEtudiantsBeginByNomE(name);
  }

  
	@PutMapping("assignetudianttodepartment/{idet}/{iddep}")
	public void assignEtudiantToDepartement( @PathVariable("idet") Integer idet, @PathVariable("iddep") Integer iddep) {
	 etudserv.assignEtudiantToDepartement(idet, iddep);
	}
	
	@PutMapping("assignContratToEtudiant/{nom}/{prenom}")
	public Contrat assignEtudiantToDepartement( @RequestBody Contrat ce , @PathVariable("nom") String nom, @PathVariable("prenom") String prenom) {
	return etudserv.affectContratToEtudiant(ce,nom, prenom);
	}
	 
	@PutMapping("assignEtudiantToContratEtEquipe/{idcontrat}/{idEquipe}")
	public Etudiant  addAndAssignEtudiantToEquipeAndContract(@ RequestBody Etudiant e ,@PathVariable("idcontrat") Integer idContrat,@PathVariable("idEquipe") Integer idEquipe) {
		return etudserv.addAndAssignEtudiantToEquipeAndContract(e, idContrat, idEquipe);
	}
  }

