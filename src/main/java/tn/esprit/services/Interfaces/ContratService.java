package tn.esprit.services.Interfaces;

import java.util.List;

import tn.esprit.persistance.Contrat;

public interface ContratService {
	List<Contrat> retrieveAllContrats();

	Contrat updateContrat (Contrat ce);

	Contrat addContrat (Contrat ce);

	Contrat retrieveContrat (Integer idContrat);

	void removeContrat(Integer idContrat);
}
