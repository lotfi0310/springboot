package tn.esprit.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.persistance.Universite;
import tn.esprit.persistance.repositories.UniversityRepository;
import tn.esprit.services.Interfaces.UniversiteService;
@Service
public class UniversityServiceImplementation implements UniversiteService {
@Autowired
UniversityRepository univrep;

@Override
public List<Universite> retrieveAllUniversites() {
	return univrep.findAll();

}

@Override
public Universite addUniversite(Universite u) {
u=univrep.save(u);
return u;
}

@Override
public Universite updateUniversite(Universite u) {
	  u =univrep.findById(u.getIdUniv()).get();
      univrep.save(u);

     return u;
}

@Override
public Universite retrieveUniversite(Integer idUniversite) {
	return univrep.findById(idUniversite).get();
}

}
