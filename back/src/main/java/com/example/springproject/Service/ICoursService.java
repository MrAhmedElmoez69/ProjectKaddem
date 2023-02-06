package com.example.springproject.Service;

import com.example.springproject.Entity.Cours;

import java.util.List;

public interface ICoursService {
    int ajouterCours(Cours C);

    Boolean deleteCours(Cours C);

    Boolean updateCours(Cours C);

    List<Cours> findAll();

    Cours findById(Integer C);
}
