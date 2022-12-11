package tn.esprit.services.Interfaces;

import java.util.List;
import java.util.Set;

import tn.esprit.persistance.Contrat;
import tn.esprit.persistance.Etudiant;

public interface EtudiantService {
	List<Etudiant> retrieveAllEtudiants();

	Etudiant addEtudiant (Etudiant e);

	Etudiant updateEtudiant (Etudiant e);

	Etudiant retrieveEtudiant(Integer idEtudiant);

	void removeEtudiant(Integer idEtudiant);
	
	int searchEtudiantBynomEtprenom(String nom ,String prenom );
//
    Etudiant getEtudiantByNomE(String name);
    
    List<Etudiant> getAllEtudiantsBeginByNomE(String prefixe);
    void assignEtudiantToDepartement (Integer etudiantId, Integer departementId) ;
	Contrat affectContratToEtudiant (Contrat ce,String  nomE ,String prenomE);
 
	Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat,Integer idEquipe);
	 public List<Integer> getAllEtudiantAges(); 

}
