package tn.esprit.services.Interfaces;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;

import tn.esprit.persistance.Equipe;
import tn.esprit.persistance.Etudiant;
import tn.esprit.persistance.repositories.EquipeRepository.NameOnly;

public interface EquipeService {
	List<Equipe> retrieveAllEquipes();
	Equipe addEquipe(Equipe e); // ajouter l’équipe avec son détail
	Equipe updateEquipe (Equipe e);
	void DeleteEquipe (Integer idEquipe);
	Equipe retrieveEquipe (Integer idEquipe);
	Equipe affecterDetailsToEquipe(int IdEquipe, int IdDetailsEquipe);
    Etudiant assignEquipeToEtudiant(int idEquipe,int idEtudiant); 
    List<Etudiant> getAllEtudiantsfromEquipe( int id);
    Collection<NameOnly> countetudiantbyequipes(); 
    void favorite( int id);
    void unfavorite( int id);
	List<Equipe> myFavorites();





}
//