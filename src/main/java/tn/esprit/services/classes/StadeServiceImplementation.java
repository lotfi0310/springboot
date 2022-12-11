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
	public List<Stade> retrieveAllStades() {
		return (List<Stade>) stadeRepository.findAll();
	}

	public Stade addStade(Stade s) {
		s=stadeRepository.save(s);
		return s;
	}

	public Stade updateStade(Stade s) {
		return stadeRepository.save(s);
	}

	public void DeleteStade(Integer id) {
		stadeRepository.deleteById(id);
	}

}
