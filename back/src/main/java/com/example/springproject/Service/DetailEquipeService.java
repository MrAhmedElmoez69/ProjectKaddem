package com.example.springproject.Service;

import com.example.springproject.Entity.DetailEquipe;
import com.example.springproject.Repository.DetailEquipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DetailEquipeService implements IDetailEquipeService {
  @Autowired
  private DetailEquipRepository DetailEquipeRepository;


  @Override
  public int ajouterDetailEquipe(DetailEquipe C) {
    DetailEquipeRepository.save(C);
    return 1;
  }

  @Override
  public Boolean deleteDetailEquipe(DetailEquipe C) {
    DetailEquipeRepository.delete(C);
    return true;
  }


  @Override
  public Boolean updateDetailEquipe(DetailEquipe C) {
    DetailEquipeRepository.save(C);
    return DetailEquipeRepository.findById((Integer) C.getSalle()).equals(C);
  }

  @Override
  public List<DetailEquipe> findAll() {
    return (List<DetailEquipe>) DetailEquipeRepository.findAll();
  }

  @Override
  public DetailEquipe findById(Integer U) {
    return DetailEquipeRepository.findById(U).get();
  }
}