package com.example.springproject.Entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Paiement")


public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_paiement")
    private Integer idPaiement;
    private Integer montant;

    @ManyToOne()
    Etudiant etudiant;

    @ManyToOne()
    Contrat contrat;



}
