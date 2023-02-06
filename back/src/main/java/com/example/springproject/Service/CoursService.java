package com.example.springproject.Service;

import com.example.springproject.Entity.Cours;
import com.example.springproject.Repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursService implements ICoursService {
    @Autowired
    private CoursRepository myRepository;

    @Override
    public int ajouterCours(Cours C) {
        myRepository.save(C);
        return 1;
    }

    @Override
    public Boolean deleteCours(Cours C) {
        myRepository.delete(C);
        return true;
    }


    @Override
    public Boolean updateCours(Cours C) {
        myRepository.save(C);
        return myRepository.findById((Integer) C.getIdCours()).equals(C);
    }

    @Override
    public List<Cours> findAll() {
        return (List<Cours>) myRepository.findAll();
    }

    @Override
    public Cours findById(Integer C) {
        return myRepository.findById(C).get();
    }


}
