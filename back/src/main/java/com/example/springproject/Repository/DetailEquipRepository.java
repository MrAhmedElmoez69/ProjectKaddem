package com.example.springproject.Repository;

import com.example.springproject.Entity.DetailEquipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailEquipRepository extends CrudRepository<DetailEquipe,Integer> {

}
