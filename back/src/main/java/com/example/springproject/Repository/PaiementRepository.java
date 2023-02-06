package com.example.springproject.Repository;

import com.example.springproject.Entity.Paiement;
import org.springframework.data.repository.CrudRepository;

public interface PaiementRepository extends CrudRepository<Paiement,Integer> {
    Paiement findTopByOrderByIdPaiementDesc();
}
