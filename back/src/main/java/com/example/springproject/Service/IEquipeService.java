package com.example.springproject.Service;

import com.example.springproject.Entity.Equipe;

import java.util.List;

public interface IEquipeService {
    int ajouterEquipe(Equipe C);

    Boolean deleteEquipe(Equipe C);

    Boolean updateEquipe(Equipe C);

    List<Equipe> findAll();

    Equipe findById(Integer C);

}
