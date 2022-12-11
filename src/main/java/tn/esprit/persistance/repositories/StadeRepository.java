package tn.esprit.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.persistance.Stade;
@Repository

public interface StadeRepository extends JpaRepository<Stade, Integer> {

}
