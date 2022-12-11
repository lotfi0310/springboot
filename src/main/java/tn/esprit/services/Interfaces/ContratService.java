package tn.esprit.services.Interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.esprit.DTO.ArchivePercentType;
import tn.esprit.persistance.Contrat;
import tn.esprit.persistance.Etudiant;
import tn.esprit.persistance.Specialite;

public interface ContratService {
	List<Contrat> retrieveAllContrats();

	Contrat updateContrat (Contrat ce);

	Contrat addContrat (Contrat ce);

	Contrat retrieveContrat (Integer idContrat);

	void removeContrat(Integer idContrat);
	/*
	public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);*/
	
	void dropAllContratsEveryYear();
    int dropcontratdunjour();
    //
    Etudiant assigncontratToEtudiant(int idcontrat, int idEtudiant );
	List<ArchivePercentType> getContratPercentByArchiveStatus();
	List<Contrat> findAllByDateDebutContratOrDateFinContratOrSpecialiteOrArchiveOrMontantContrat(Date dateDebut, Date dateFin, Specialite specialite,
																								 boolean archive, int montantContrat);
}
