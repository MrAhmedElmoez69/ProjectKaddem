package com.example.springproject.Repository;

import com.example.springproject.Entity.Enseignant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnseignantRepository extends CrudRepository<Enseignant,Integer> {
}
