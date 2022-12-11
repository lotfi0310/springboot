package tn.esprit.services.Interfaces;

import java.util.List;

import tn.esprit.persistance.Equipe;
import tn.esprit.persistance.Stade;

public interface StadeService {
	List<Stade> retrieveAllStades();
	Stade addStade(Stade s); // ajouter l’équipe avec son détail
	Stade updateStade (Stade s);
	void DeleteStade (Integer id);

}
