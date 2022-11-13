package tn.esprit.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.Contrat;
import tn.esprit.persistance.repositories.ContratRepository;
import tn.esprit.services.Interfaces.ContratService;
 @Service
public class ContratServiceImplementation implements ContratService {
@Autowired
ContratRepository contratrep; 
	@Override
	public List<Contrat> retrieveAllContrats() {
		return contratrep.findAll();
	}

	@Override
	public Contrat updateContrat(Contrat ce) {
		ce=contratrep.findById(ce.getIdContrat()).get();
		contratrep.save(ce);
		return ce;
	}

	@Override
	public Contrat addContrat(Contrat ce) {
		contratrep.save(ce);
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
