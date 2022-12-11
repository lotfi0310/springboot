package tn.esprit.persistance.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.DTO.ArchivePercentType;
import tn.esprit.persistance.Contrat;
import tn.esprit.persistance.Etudiant;
import tn.esprit.persistance.Specialite;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Integer>{
   /* @Modifying
	@Query("update  Contrat c set c.etudiant.idEtudiant= :idetudiant where c.idContrat= :idcontrat")
	int affecterContratToEtudiant(@Param("idetudiant") int i, @Param("idcontrat") int j ); 
  */
    @Modifying
    @Query("delete  from Contrat c where c.dateFinContrat - c.dateDebutContrat =0  ")
	int dropcontratdunjour();


    @Query(value = "select new tn.esprit.DTO.ArchivePercentType" +
            "(count(*)/(Select COUNT(*) from Contrat) * 100, archive) from Contrat GROUP BY archive")
    public List <ArchivePercentType> getPercentageGroupByArchiveStatus();

    @Query("select c from Contrat c where c.etudiant = ?1")
    List<Contrat> findContratByEtudiant(Etudiant etudiant);

    List<Contrat> findAllByDateDebutContratOrDateFinContratOrSpecialiteOrArchiveOrMontantContrat(Date dateDebut, Date dateFin, Specialite specialite,
                                                                                                 boolean archive, int montantContrat);



	
   /*  @Query("select sum(montantContrat) Beetween startDate= ?1 and endDate =?2 from Contrat c where c.archive =false")
	public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);*/
}
//
