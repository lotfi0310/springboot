package tn.esprit.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

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

import tn.esprit.persistance.Equipe;
import tn.esprit.persistance.Etudiant;
import tn.esprit.persistance.repositories.EquipeRepository;
import tn.esprit.persistance.repositories.EquipeRepository.NameOnly;
import tn.esprit.services.Interfaces.EquipeService;
//
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/EquipeController")
public class EquipeController {
	
	 @Autowired 
	 EquipeService equipeserv; 
	 EquipeRepository equiprep;
	 
	 @CrossOrigin(origins = "http://localhost:4200")
	 @GetMapping("/displayEquipes")
	 public List<Equipe> getEquipes(){
		 return equipeserv.retrieveAllEquipes();
	 }
	 
	 @CrossOrigin(origins = "http://localhost:4200")
 @GetMapping("/displayEquipeById/{id}")
	public Equipe displayEquipe(@PathVariable int id) {
		return equipeserv.retrieveEquipe(id);
	}
 

 @CrossOrigin(origins = "http://localhost:4200")
 @PostMapping("/addEquipe")
 @ResponseBody
 public Equipe addEquipe(@RequestBody Equipe eq) {
	 equipeserv.addEquipe(eq);
	 return eq; 
 }
 
 @CrossOrigin(origins = "http://localhost:4200")
 @PutMapping("/updateEquipe")
 public Equipe updateEquipe(@RequestBody Equipe eq ) {
	 return  equipeserv.updateEquipe(eq); 
 }
 @CrossOrigin(origins = "http://localhost:4200")
 @DeleteMapping("/deleteEquipe/{id}")
 public void DeleteEquipe(@PathVariable("id")int id ) {
	 equipeserv.DeleteEquipe(id);
 }
 
 
 @PutMapping("affecterDetailsToEquipe/{idEquipe}/{Iddetails}")
 public Equipe affecterDetailsToEquipe(@PathVariable("idEquipe") int IdEquipe,@PathVariable("Iddetails") int IdDetailEquipe) {
	 return equipeserv.affecterDetailsToEquipe(IdEquipe, IdDetailEquipe);
 }
 
 @PutMapping("assignEquipeEtudiant/{idequipe}/{idetudiant}")
 public Etudiant assignEquipeToEtudiant(@PathVariable("idequipe") int idEquipe,@PathVariable("idetudiant") int idEtudiant) {
	 return equipeserv.assignEquipeToEtudiant(idEquipe, idEtudiant);
	 
 }
 @GetMapping("getAllEtudiantsfrom1Equipe/{id}")
 public List<Etudiant> getAllEtudiantsfrom1Equipe(@PathVariable("id") int id) {
 	return equipeserv.getAllEtudiantsfromEquipe(id);

 }
 @CrossOrigin(origins = "http://localhost:4200")
 @GetMapping("countequipeparetudiant")
 public Collection<NameOnly> countetudiantbyequipes()
 {
 	return equipeserv.countetudiantbyequipes();
 }
 @CrossOrigin(origins = "http://localhost:4200")
 @PutMapping("favorite/{id}")
 public void favorite(@PathVariable("id") int id) {
 	  equipeserv.favorite(id);
 }
 @CrossOrigin(origins = "http://localhost:4200")
 @PutMapping("unfavorite/{id}")
 public void unfavorite(@PathVariable("id") int id) {
 	  equipeserv.unfavorite(id);
 }
 
 @CrossOrigin(origins = "http://localhost:4200")
 @GetMapping("myfavorites/")
 public List<Equipe> myFavorites() {
 	return equipeserv.myFavorites();
 }
}
