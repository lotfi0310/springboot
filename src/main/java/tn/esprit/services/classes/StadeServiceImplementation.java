package tn.esprit.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.Equipe;
import tn.esprit.persistance.Stade;
import tn.esprit.persistance.repositories.StadeRepository;
import tn.esprit.services.Interfaces.StadeService;
@Service
public class StadeServiceImplementation implements StadeService {
	@Autowired
	StadeRepository stadeRepository;
<<<<<<< HEAD
=======
	@Override
>>>>>>> a990b5996a1b9342f617c2a19853a5b029d8638e
	public List<Stade> retrieveAllStades() {
		return (List<Stade>) stadeRepository.findAll();
	}

<<<<<<< HEAD
=======
	@Override
>>>>>>> a990b5996a1b9342f617c2a19853a5b029d8638e
	public Stade addStade(Stade s) {
		s=stadeRepository.save(s);
		return s;
	}

<<<<<<< HEAD
=======
	@Override
>>>>>>> a990b5996a1b9342f617c2a19853a5b029d8638e
	public Stade updateStade(Stade s) {
		return stadeRepository.save(s);
	}

<<<<<<< HEAD
=======
	@Override
>>>>>>> a990b5996a1b9342f617c2a19853a5b029d8638e
	public void DeleteStade(Integer id) {
		stadeRepository.deleteById(id);
	}

}
