package tn.esprit.services.classes;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.DetailEquipe;
import tn.esprit.persistance.Equipe;
import tn.esprit.persistance.Etudiant;
import tn.esprit.persistance.repositories.DetailEquipeRepository;
import tn.esprit.persistance.repositories.EquipeRepository;
import tn.esprit.persistance.repositories.EtudiantRepository;
import tn.esprit.persistance.repositories.EquipeRepository.NameOnly;
import tn.esprit.services.Interfaces.EquipeService;
@Service
public class EquipeServiceImplementation implements EquipeService {
@Autowired
EquipeRepository equiperep;
@Autowired
DetailEquipeRepository detailequiperep;
@Autowired
EtudiantRepository etudrep;

public List<Equipe> retrieveAllEquipes() {
	return (List<Equipe>) equiperep.findAll();
}

public Equipe addEquipe(Equipe e) {
	e.setFav(0);
	e=equiperep.save(e);
	return e;
}

public Equipe updateEquipe(Equipe e) {
	return equiperep.save(e);
}

public Equipe retrieveEquipe(Integer idEquipe) {
	return  equiperep.findById(idEquipe).get();

}
//
public void DeleteEquipe(Integer idEquipe) {
	equiperep.deleteById(idEquipe);
	
}

public Equipe affecterDetailsToEquipe(int IdEquipe,int IdDetailEquipe) {
	Equipe e= equiperep.findById(IdEquipe).get();
	DetailEquipe de=detailequiperep.findById(IdDetailEquipe).get();
	e.setDetail_equipe(de);
	return equiperep.save(e);
}

public Etudiant assignEquipeToEtudiant(int idEquipe, int idEtudiant) {
     Etudiant e=etudrep.findById(idEtudiant).get();
     Equipe eq=equiperep.findById(idEquipe).get();
     eq.getEtudiants().add(e);
     equiperep.save(eq);
	return e;
}

<<<<<<< HEAD
=======
@Override
>>>>>>> a990b5996a1b9342f617c2a19853a5b029d8638e
public List<Etudiant> getAllEtudiantsfromEquipe(int id) {
	return equiperep.getAllEtudiantsfromEquipe(id);

}

<<<<<<< HEAD
=======
@Override
>>>>>>> a990b5996a1b9342f617c2a19853a5b029d8638e
public Collection<NameOnly> countetudiantbyequipes() {
	return equiperep.countetudiantbyequipes();
}

<<<<<<< HEAD
=======
@Override
>>>>>>> a990b5996a1b9342f617c2a19853a5b029d8638e
public void favorite(int id) {
	
	  equiperep.favorite(id);
}

<<<<<<< HEAD
=======
@Override
>>>>>>> a990b5996a1b9342f617c2a19853a5b029d8638e
public void unfavorite(int id) {
	  equiperep.unfavorite(id);
	
}

<<<<<<< HEAD
=======
@Override
>>>>>>> a990b5996a1b9342f617c2a19853a5b029d8638e
public List<Equipe> myFavorites() {
	return equiperep.myFavorites();
}





}
