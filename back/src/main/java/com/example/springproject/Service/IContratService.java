package com.example.springproject.Service;

import com.example.springproject.Entity.Contrat;

import java.util.Date;
import java.util.List;

public interface IContratService {

    int ajouterContrat(Contrat C);

    Boolean deleteContrat(Contrat C);

    Boolean updateContrat(Contrat C);

    List<Contrat> findAll();

    Contrat findById(Integer C);

    float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);



    List<Contrat> contratBetween2dates(Date startDate, Date endDate);
    Integer nbContratsValides(Date endDate, Date startDate);


    List<Contrat> contratExp();
    List<Contrat> contratDepasseAn();

    Contrat affectContratToEtudiant(int ce,String nomE,String prenomE);

}


