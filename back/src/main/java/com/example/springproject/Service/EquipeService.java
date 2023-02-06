package com.example.springproject.Service;
import com.example.springproject.Entity.Contrat;
import com.example.springproject.Entity.Equipe;
import com.example.springproject.Entity.Etudiant;
import com.example.springproject.Entity.Niveau;
import com.example.springproject.Repository.ContratRepository;
import com.example.springproject.Repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service

public class EquipeService implements IEquipeService {
  @Autowired
  private EquipeRepository myRepository;
  private ContratRepository contratRepository;
  @Autowired
  private com.example.springproject.Repository.EquipeRepository EquipeRepository;

  @Override
  public int ajouterEquipe(Equipe C) {
    EquipeRepository.save(C);
    return 1;
  }

  @Override
  public Boolean deleteEquipe(Equipe C) {
    EquipeRepository.delete(C);
    return true;
  }


  @Override
  public Boolean updateEquipe(Equipe C) {
    EquipeRepository.save(C);
    return EquipeRepository.findById((Integer) C.getIdEquipe()).equals(C);
  }

  @Override
  public List<Equipe> findAll() {
    return (List<Equipe>) EquipeRepository.findAll();
  }

  @Override
  public Equipe findById(Integer U) {
    return EquipeRepository.findById(U).get();
  }


  @Scheduled(cron = "* * * 30 * *")
  public void faireEvoluerEquipes() {
    int cptEtudiant = 0;
    List<Equipe> equipes = (List<Equipe>) EquipeRepository.findAll();
    List<Contrat> contratDepasseAn = contratRepository.contratDepasseAn(); // afficher la liste des contrats depasse 1 an
    for (Equipe e : equipes) {
      cptEtudiant = 0;
      Set<Etudiant> etudiants = e.getEtudiantSet();
      if (etudiants.size() >= 3) {
        for (Etudiant etudiant : etudiants) {
          int cptContrat = 0;
          Set<Contrat> contrats = etudiant.getContratList();
          for (Contrat c : contrats) {

            if (contratDepasseAn.contains(c)) {
              cptContrat = cptContrat + 1;
            }
          }
          if (cptContrat >= 1) {
            cptEtudiant++;
          }
          // if pour les 3 conditions
        }
      } else {
        System.out.println("nbre des etudiants < 3");
      }
      if (cptEtudiant >= 3 && e.getNiveau() == Niveau.JUNIOR) {
        e.setNiveau(Niveau.SENIOR);
        EquipeRepository.save(e);
      } else if (cptEtudiant >= 3 && (e.getNiveau() == Niveau.SENIOR)) {
        e.setNiveau(Niveau.EXPERT);
        EquipeRepository.save(e);
      }
    }

  }


}
