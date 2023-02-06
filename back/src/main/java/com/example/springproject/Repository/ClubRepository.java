package com.example.springproject.Repository;

import com.example.springproject.Entity.Club;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends CrudRepository<Club, Integer> {
}
