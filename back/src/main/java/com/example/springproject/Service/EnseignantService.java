package com.example.springproject.Service;

import com.example.springproject.Entity.Enseignant;
import com.example.springproject.Repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EnseignantService implements IEnseignantService{
    @Autowired
    private EnseignantRepository enseignantRepository;

    @Override
    public int ajouterEnseignant(Enseignant enseignant) {
        enseignantRepository.save(enseignant);
        return 1;
    }

    @Override
    public Boolean deleteEnseignant(Enseignant enseignant) {
        enseignantRepository.delete(enseignant);
        return true;
    }


    @Override
    public Boolean updateEnseignant(Enseignant enseignant) {
        enseignantRepository.save(enseignant);
        return  enseignantRepository.findById((Integer) enseignant.getIdEnseignant()).equals(enseignant);
    }

    @Override
    public List<Enseignant> findAll() {
        return (List<Enseignant>) enseignantRepository.findAll();
    }

    @Override
    public Enseignant findById(Integer enseignant) {
        return enseignantRepository.findById(enseignant).get();
    }
}
