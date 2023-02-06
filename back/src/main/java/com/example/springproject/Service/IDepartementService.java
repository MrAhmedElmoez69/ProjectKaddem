package com.example.springproject.Service;

import com.example.springproject.Entity.Contrat;
import com.example.springproject.Entity.Departement;

import java.util.List;

public interface IDepartementService {

    int ajouterDepartement(Departement D);

    Boolean DeleteDepartement(Departement D);

    Boolean UpdateDepartement(Departement D);

    List<Departement> findAll();

    Departement findById(Integer D);


}
