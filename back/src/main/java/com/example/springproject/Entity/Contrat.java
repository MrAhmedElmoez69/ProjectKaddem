package com.example.springproject.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Contrat")

public class Contrat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContrat;

    private Date dateFinContrat;
    private Date dateDebutContrat;
    private boolean archive;

    private int  montantContrat;

    @Enumerated(EnumType.ORDINAL)
    private Specialite specialite;


    @JsonIgnore
    @ManyToOne
    Etudiant etudiant;

}