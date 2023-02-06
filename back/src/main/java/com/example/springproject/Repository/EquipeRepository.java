package com.example.springproject.Repository;

import com.example.springproject.Entity.Equipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeRepository extends CrudRepository<Equipe,Integer> {
}
