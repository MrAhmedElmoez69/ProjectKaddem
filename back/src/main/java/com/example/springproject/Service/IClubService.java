package com.example.springproject.Service;

import com.example.springproject.Entity.Club;

import java.util.List;

public interface IClubService {
    int ajouterClub(Club C);

    Boolean deleteClub(Club C);

    Boolean updateClub(Club C);

    List<Club> findAll();

    Club findById(Integer C);
}
