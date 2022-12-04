package tn.esprit.controller;

import java.io.ByteArrayInputStream;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.DTO.ArchivePercentType;
import tn.esprit.persistance.Contrat;
import tn.esprit.persistance.Etudiant;
import tn.esprit.persistance.Specialite;
import tn.esprit.services.Interfaces.ContratService;
import tn.esprit.services.classes.ExportContratService;

@RestController
@RequestMapping("ContartController")
@Slf4j
public class ContratController {

	@Autowired
	ContratService contserv;
	@Autowired
	ExportContratService exportService;

	@GetMapping("displayallcontrats")
	public List<Contrat> retrieveAllContrats() {
		return contserv.retrieveAllContrats();
	}

//

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("updateContrat")
	public Contrat updateContrat(@RequestBody Contrat ce) {
		return contserv.updateContrat(ce);
	}

	@CrossOrigin(origins = "http://localhost:4200")
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
	@CrossOrigin(origins = "http://localhost:4200")

	@DeleteMapping("deleteContrat/{id}")
	public void removeContrat(@PathVariable("id") int  idContrat) {
       contserv.removeContrat(idContrat);		
	}
	

	
	@DeleteMapping("dropcontratdaujourdhui")
	public void dropcontratdaujourdhui() {
		 contserv.dropAllContratsEveryYear();
	}
	
	@DeleteMapping("deletecontratdujour")
	 public int DeleteLesContratDunjour() {
		 log.info("deleting ... ");
		 return contserv.dropcontratdunjour();
	 }
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("assignContratToEtudiantByID/{idcontrat}/{idetudiant}")
	public Etudiant assigncontratToEtudiant(@PathVariable("idcontrat") int idcontrat,@PathVariable("idetudiant") int idEtudiant) {
		return contserv.assigncontratToEtudiant(idcontrat, idEtudiant);
	}

	@GetMapping("export/pdf")
	@ResponseBody
	public ResponseEntity<InputStreamResource> exportTermsPdf() {
		List<Contrat> contrats = contserv.retrieveAllContrats();
		System.out.println("test1");
		System.out.println(contrats.get(0).getMontantContrat());
		ByteArrayInputStream bais = exportService.contratsPDFReport(contrats);
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-Disposition","inline;filename=contrats.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bais));
	}

	@GetMapping("/vData/percentArchiveStatus")
	public List<ArchivePercentType> getPercentageGroupByArchiveStatus(){
		return contserv.getContratPercentByArchiveStatus();
	}

	@GetMapping("searchContratByAnyCriteria/")
	List<Contrat> findByAnyParam(
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin,
			@RequestParam(required = false) Specialite specialite,
			@RequestParam(required = false) boolean archive,
			@RequestParam(required = false) int montant
	){
		return contserv.findAllByDateDebutContratOrDateFinContratOrSpecialiteOrArchiveOrMontantContrat(dateDebut, dateFin, specialite, archive, montant);
	}




}
