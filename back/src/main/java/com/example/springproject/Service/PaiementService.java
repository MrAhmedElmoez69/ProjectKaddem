package com.example.springproject.Service;

import com.example.springproject.Entity.Contrat;
import com.example.springproject.Entity.Etudiant;
import com.example.springproject.Entity.Paiement;
import com.example.springproject.Repository.ContratRepository;
import com.example.springproject.Repository.EtudiantRepository;
import com.example.springproject.Repository.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementService implements IPaiementService{

    @Autowired
    private PaiementRepository PaiementRepository;
    @Autowired
    private ContratRepository contratRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;



    @Override
    public Paiement ajouterPaiement(int mnt ,int  idE , int idC) {

        Etudiant etudiant = etudiantRepository.findById(idE).get();
        Contrat contrat = contratRepository.findById(idC).get();
        Paiement lastPaiement = PaiementRepository.findTopByOrderByIdPaiementDesc();
        Paiement paiement = new Paiement(lastPaiement.getIdPaiement() + 1 , mnt , etudiant , contrat);

        PaiementRepository.save(paiement);
        return paiement;
    }

    @Override
    public Boolean deletePaiement(Paiement P) {
        PaiementRepository.delete(P);
        return true;
    }

    @Override
    public Boolean updatePaiement(int idP , int mnt ,int  idE , int idC) {

        Etudiant etudiant = etudiantRepository.findById(idE).get();
        Contrat contrat = contratRepository.findById(idC).get();
        Paiement paiement = PaiementRepository.findById(idP).get();
        paiement.setEtudiant(etudiant);
        paiement.setContrat(contrat);
        paiement.setMontant(mnt);

        PaiementRepository.save(paiement);
        return  PaiementRepository.findById((Integer) paiement.getIdPaiement()).equals(paiement);
    }

    @Override
    public List<Paiement> findAll() {
        return (List<Paiement>) PaiementRepository.findAll();
    }

    @Override
    public Paiement findById(Integer P) {
        return PaiementRepository.findById(P).get();
    }


}


