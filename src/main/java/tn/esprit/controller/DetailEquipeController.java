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
import tn.esprit.persistance.DetailEquipe;
import tn.esprit.services.Interfaces.DetailEquipeService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/DetailEquipeController")
public class DetailEquipeController {
	
	  @Autowired
	    DetailEquipeService detailEquipeService;

	    @GetMapping("/detailEquipes")
	    private List<DetailEquipe> getAlldetailEquipes() {
	        return detailEquipeService.getDetailEquipes();
	    }

	    @PostMapping("/AddDetailEquipe")
	    public DetailEquipe addDetailEquipe (@RequestBody DetailEquipe detailEquipe){
	        return detailEquipeService.saveDetailEquipe(detailEquipe);
	    }
	    
	    @PutMapping("/UpdateDetailEquipe")
	    public DetailEquipe updateDetailEquipe (@RequestBody DetailEquipe detailEquipe){
	        return detailEquipeService.upadateDetailEquipe(detailEquipe);
	    }

	    @DeleteMapping("/DeleteDetailEquipe/{idDetailEquipe}")
	    public String deleteDetailEquipe (@PathVariable int idDetailEquipe){
	        return detailEquipeService.deleteDetailEquipe(idDetailEquipe);
	    }

	    @GetMapping("/findByThematique/{thematique}")
	    public List<DetailEquipe> findByThematique(@PathVariable("thematique") String thematique){
	        return detailEquipeService.findByThematiqueLike(thematique);
	    }

}