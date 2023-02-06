package com.example.springproject.Service;

import com.example.springproject.Entity.Contrat;
import com.example.springproject.Entity.Departement;
import com.example.springproject.Repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DepartementService implements IDepartementService {
    @Autowired
    private DepartementRepository myRepository;

  public int ajouterDepartement(Departement D) {
    myRepository.save(D);
  return 1;
  }

  public Boolean DeleteDepartement(Departement D) {
    myRepository.delete(D);
    return true;
  }

  public Boolean UpdateDepartement(Departement D) {
    myRepository.save(D);
    return myRepository.findById((Integer) D.getIdDepart()).equals(D);
  }

  @Override
  public List<Departement> findAll() {
    return (List<Departement>) myRepository.findAll();
  }

  @Override
  public Departement findById(Integer D) {
    return myRepository.findById(D).get();
  }


}