package com.example.springproject.Repository;


import com.example.springproject.Entity.Cours;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursRepository extends CrudRepository<Cours,Integer> {
}
