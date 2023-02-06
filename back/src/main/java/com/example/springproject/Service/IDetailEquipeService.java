package com.example.springproject.Service;

import com.example.springproject.Entity.DetailEquipe;

import java.util.List;

public interface IDetailEquipeService {
    int ajouterDetailEquipe(DetailEquipe C);

    Boolean deleteDetailEquipe(DetailEquipe C);

    Boolean updateDetailEquipe(DetailEquipe C);

    List<DetailEquipe> findAll();

    DetailEquipe findById(Integer C);
}
