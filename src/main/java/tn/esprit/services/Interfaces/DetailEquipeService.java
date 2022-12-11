package tn.esprit.services.Interfaces;

import java.util.List;

import tn.esprit.persistance.DetailEquipe;

public interface DetailEquipeService {
 List<DetailEquipe> getDetailEquipes();
 DetailEquipe saveDetailEquipe(DetailEquipe detailEquipe);
 String deleteDetailEquipe(Integer idDetailEquipe);
 DetailEquipe upadateDetailEquipe(DetailEquipe detailEquipe);
List<DetailEquipe> findByThematiqueLike(String thematique);
}
