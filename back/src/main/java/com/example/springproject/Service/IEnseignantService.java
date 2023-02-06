package com.example.springproject.Service;

import com.example.springproject.Entity.Enseignant;

import java.util.List;

public interface IEnseignantService {
    int ajouterEnseignant(Enseignant C);

    Boolean deleteEnseignant(Enseignant C);

    Boolean updateEnseignant(Enseignant C);

    List<Enseignant> findAll();

    Enseignant findById(Integer C);
}
