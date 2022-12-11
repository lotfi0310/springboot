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

import tn.esprit.persistance.Equipe;
import tn.esprit.persistance.Stade;
import tn.esprit.services.Interfaces.StadeService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/StadeController")
public class StadeController {
	@Autowired
	StadeService stadeService;
	 
	 @CrossOrigin(origins = "http://localhost:4200")
	 @GetMapping("/displayStades")
	 public List<Stade> getEquipes(){
		 return stadeService.retrieveAllStades();
	 }

@CrossOrigin(origins = "http://localhost:4200")
@PostMapping("/addStade")
@ResponseBody
public Stade addStade(@RequestBody Stade s) {
	stadeService.addStade(s);
	 return s; 
}

@CrossOrigin(origins = "http://localhost:4200")
@PutMapping("/updateStade")
public Stade updateEquipe(@RequestBody Stade eq ) {
	 return  stadeService.updateStade(eq); 
}
@CrossOrigin(origins = "http://localhost:4200")
@DeleteMapping("/deleteStade/{id}")
public void DeleteEquipe(@PathVariable("id")int id ) {
	stadeService.DeleteStade(id);
}

}
