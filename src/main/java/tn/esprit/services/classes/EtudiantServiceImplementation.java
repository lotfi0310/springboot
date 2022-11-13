package tn.esprit.services.classes;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.persistance.Equipe;
import tn.esprit.persistance.Etudiant;
import tn.esprit.persistance.repositories.EtudiantRepository;
import tn.esprit.services.Interfaces.EtudiantService;
@Service
@Slf4j
public class EtudiantServiceImplementation implements EtudiantService {

	  @Autowired
		EtudiantRepository etudrep ;
	    
	@Override
	public List<Etudiant> retrieveAllEtudiants() {
		 return etudrep.findAll();
		
	}

	@Override
	public Etudiant addEtudiant(Etudiant e) {
		try {
		log.info(" adding student ... ");
		etudrep.save(e);
	    log.info("student added successfuly");
		}catch(Exception exp) {
         log.info("test1"+exp.getStackTrace());			
		}
		
		return e;
	}

	@Override
	public Etudiant updateEtudiant(Etudiant e) {
		Etudiant e1=retrieveEtudiant(e.getIdEtudiant());
		log.info(""+e.getIdEtudiant()+"Data before saving:"+e1);
	      log.info("saving new values ...");
	      if(e.hashCode()!=e1.hashCode()) { 
	    	  log.info("new Value saved "+e);
	    		  }
	      else {
	    	  log.info("not saved data"+e1);
	      }
	      return etudrep.saveAndFlush(e);
	}

	@Override
	public Etudiant retrieveEtudiant(Integer idEtudiant) {
		return etudrep.findById(idEtudiant).get();
	}

	@Override
	public void removeEtudiant(Integer idEtudiant) {
		 etudrep.deleteById(idEtudiant);	
		    //etudrep.delete(etudrep.findById(id)); 
	}

	
	@Override
	public List<Etudiant> getAllEtudiantsBeginByNomE(String name) {
		log.info(""+name);
		return etudrep.getAllEtudiantsBeginByNomE(name);
	}

	@Override
	public Etudiant getEtudiantByNomE(String name) {
		log.info("resultat de recherche :"+etudrep.getEtudiantByNomE(name));
		return etudrep.getEtudiantByNomE(name);
		
	}


	
	



   
	
	
	
	}
