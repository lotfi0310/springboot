package tn.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.persistance.Contrat;
import tn.esprit.services.Interfaces.ContratService;
@RestController
@RequestMapping("ContartController")
public class ContratController {

	@Autowired
	ContratService contserv; 
	
	@GetMapping("displayallcontrats")
	public List<Contrat> retrieveAllContrats() {
		return contserv.retrieveAllContrats();
	}

	@PutMapping("updateContrat")
	public Contrat updateContrat(@RequestBody Contrat ce) {
		return contserv.updateContrat(ce);
	}

	@PostMapping("newContrat")
	public Contrat newContrat( @RequestBody Contrat ce) {
		ce=contserv.addContrat(ce);
		return ce ;
	}

	@GetMapping("displayContratById/{id}")
	@ResponseBody
	public Contrat retrieveContrat(@PathVariable("id") int idContrat) {
		
		return contserv.retrieveContrat(idContrat);
	}

	@DeleteMapping("deleteContrat/{id}")
	public void removeContrat(@PathVariable("id") int  idContrat) {
       contserv.removeContrat(idContrat);		
	}
}
