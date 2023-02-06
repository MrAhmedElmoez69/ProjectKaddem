package com.example.springproject.Service;

import com.example.springproject.Entity.Departement;
import com.example.springproject.Entity.Universite;
import com.example.springproject.Repository.DepartementRepository;
import com.example.springproject.Repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service

public class UniversiteService implements IUniversiteService {
    @Autowired
    private UniversiteRepository UniversiteRepository;

  @Autowired
  private DepartementRepository departmentRepository;

  public UniversiteService(com.example.springproject.Repository.UniversiteRepository universiteRepository) {
    UniversiteRepository = universiteRepository;
  }

  @Transactional
  @Override
    public void update_uni_dep(Integer uniId, Integer depId) {
      Universite u= UniversiteRepository.findById(uniId).orElseThrow(() -> new IllegalStateException("uni doesnt exist"));
      Departement d= departmentRepository.findById(depId).orElseThrow(() -> new IllegalStateException("dep doesnt exist"));

      List <Departement> L = u.getDepartementSet();
      L.add(d);
      u.setDepartementSet(L);

    }

    @Override
  public int ajouterUniversite(Universite C) {
    UniversiteRepository.save(C);
    return 1;
  }

  @Override
  public Boolean deleteUniversite(Universite C) {
    UniversiteRepository.delete(C);
    return true;
  }


  @Override
  public Boolean updateUniversite(Universite C) {
    UniversiteRepository.save(C);
    return  UniversiteRepository.findById((Integer) C.getIdUniv()).equals(C);
  }

  @Override
  public List<Universite> findAll() {
    return (List<Universite>) UniversiteRepository.findAll();
  }

  @Override
  public Universite findById(Integer U) {
    return UniversiteRepository.findById(U).get();
  }
}
