package tn.esprit.services.classes;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.DTO.ArchivePercentType;
import tn.esprit.persistance.Contrat;
import tn.esprit.persistance.Etudiant;
import tn.esprit.persistance.Specialite;
import tn.esprit.persistance.repositories.ContratRepository;
import tn.esprit.persistance.repositories.EtudiantRepository;
import tn.esprit.services.Interfaces.ContratService;
 @Service
 @Slf4j
public class ContratServiceImplementation implements ContratService {
@Autowired
ContratRepository contratrep; 
@Autowired
EtudiantRepository etudrep; 
	public List<Contrat> retrieveAllContrats() {
		log.info(" getting contrats ...");
		return contratrep.findAll();
	}

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

	public Contrat retrieveContrat(Integer idContrat) {
		
		return contratrep.findById(idContrat).get();
	}

	public void removeContrat(Integer idContrat) {
       contratrep.deleteById(idContrat);		
	}
//
	

	@Scheduled(fixedDelay = 60000)
	public void dropAllContratsEveryYear() {
		contratrep.deleteAll();
	}

	@Scheduled(fixedRate = 6000)
	public int dropcontratdunjour() {
	 return	contratrep.dropcontratdunjour();
	}

	public Etudiant assigncontratToEtudiant(int idcontrat, int idEtudiant) {
     Etudiant e=etudrep.findById(idEtudiant).get(); 
     Contrat c =contratrep.findById(idcontrat).get(); 
     c.setEtudiant(e);
     contratrep.save(c);
	return e;
	}

<<<<<<< HEAD
=======
	 @Override
>>>>>>> a990b5996a1b9342f617c2a19853a5b029d8638e
	 public List<ArchivePercentType> getContratPercentByArchiveStatus(){
		 return contratrep.getPercentageGroupByArchiveStatus();
	 }

<<<<<<< HEAD
=======
	 @Override
>>>>>>> a990b5996a1b9342f617c2a19853a5b029d8638e
	 public List<Contrat> findAllByDateDebutContratOrDateFinContratOrSpecialiteOrArchiveOrMontantContrat(Date dateDebut, Date dateFin, Specialite specialite, boolean archive, int montantContrat) {
		 return contratrep.findAllByDateDebutContratOrDateFinContratOrSpecialiteOrArchiveOrMontantContrat(dateDebut, dateFin, specialite, archive, montantContrat);
	 }






/*
	@Override
	public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return 0;
	}
    */
	


	

}
