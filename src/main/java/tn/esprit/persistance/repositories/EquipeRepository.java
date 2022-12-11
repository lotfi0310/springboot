package tn.esprit.persistance.repositories;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.transaction.Transaction;

import org.apache.catalina.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.persistance.Equipe;
import tn.esprit.persistance.Etudiant;

@Repository
@Transactional
public  interface EquipeRepository extends JpaRepository<Equipe,Integer> {
	@Query(value="SELECT * from equipe RIGHT JOIN equipe_etudiants ON equipe.id_equipe=equipe_etudiants.equipe_id_equipe RIGHT JOIN etudiant ON equipe_etudiants.etudiants_id_etudiant=etudiant.id_etudiant"
			,nativeQuery=true)
	public List<Equipe> getAllEquipe(); 

	@Query("select e.etudiants from Equipe e where e.idEquipe = ?1")
    List<Etudiant> getAllEtudiantsfromEquipe( int id);
	//
	@Query(value="SELECT COUNT(*) as y , nom_equipe as label FROM equipe_etudiants e1 JOIN equipe e2 WHERE e1.equipe_id_equipe=e2.id_equipe GROUP BY equipe_id_equipe;"
			,nativeQuery=true)
	 Collection<NameOnly> countetudiantbyequipes(); 
	  interface NameOnly {
	     int getY();
	    // String getIdEquipe();
	     String getLabel();  
	  }
	@Modifying
	@Query("update Equipe e set e.fav = 1 where e.idEquipe = :id")
    void favorite( @Param("id") Integer id);
	@Modifying
	@Query("update Equipe e set e.fav = 0 where e.idEquipe = :id")
    void unfavorite( @Param("id") Integer id);
	
	@Query("select e from Equipe e where e.fav=1")
	List<Equipe> myFavorites();
}
