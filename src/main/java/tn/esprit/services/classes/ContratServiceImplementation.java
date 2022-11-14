package tn.esprit.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.persistance.Contrat;
import tn.esprit.persistance.Etudiant;
import tn.esprit.persistance.repositories.ContratRepository;
import tn.esprit.services.Interfaces.ContratService;
 @Service
 @Slf4j
public class ContratServiceImplementation implements ContratService {
@Autowired
ContratRepository contratrep; 
	@Override
	public List<Contrat> retrieveAllContrats() {
		log.info(" getting contrats ...");
		return contratrep.findAll();
	}

	@Override
	public Contrat updateContrat(Contrat ce) {
		Contrat ce1=retrieveContrat(ce.getIdContrat());
		log.info(""+ce.getIdContrat()+"Data before saving:");
	      log.info("saving new contrat values  ...");
	     if(ce.hashCode()!=ce1.hashCode()) {
	    	  log.info("new Value saved "+ce);
	     }else {
	    	  log.info("not saved "+ce);

	     }
	      return contratrep.saveAndFlush(ce);
		
	}

	@Override
	public Contrat addContrat(Contrat ce) {
		try {
			log.info(" adding contart ... ");
			contratrep.save(ce);
		    log.info("contrat added successfuly");
			}catch(Exception exp) {
	         log.info("test1"+exp.getStackTrace());			
			}
		return ce ;
	}

	@Override
	public Contrat retrieveContrat(Integer idContrat) {
		
		return contratrep.findById(idContrat).get();
	}

	@Override
	public void removeContrat(Integer idContrat) {
       contratrep.deleteById(idContrat);		
	}

}
