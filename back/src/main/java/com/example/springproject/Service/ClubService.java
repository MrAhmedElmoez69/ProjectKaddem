package com.example.springproject.Service;

import com.example.springproject.Entity.Club;
import com.example.springproject.Repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService implements IClubService {
    @Autowired
    private ClubRepository ClubRepository;

    @Override
    public int ajouterClub(Club C) {
        ClubRepository.save(C);
        return 1;
    }

    @Override
    public Boolean deleteClub(Club C) {
        ClubRepository.delete(C);
        return true;
    }

    @Override
    public Boolean updateClub(Club C) {
        ClubRepository.save(C);
        return ClubRepository.findById((Integer) C.getIdClub()).equals(C);
    }

    @Override
    public List<Club> findAll() {
        return (List<Club>) ClubRepository.findAll();
    }

    public Club findById(Integer C) {
        return ClubRepository.findById(C).get();
    }


}
