package com.example.springproject.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "Etudiant")
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_etudaint")
    private Integer idEtudaint;
    private Option  option;
    private String  prenomE;
    private String  nomE;

    @ManyToOne()
    Departement departement;

    @ManyToOne()
    Equipe equipe;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "etudiant",fetch = FetchType.EAGER)
    private Set<Contrat> contratList;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Equipe> equipes;

}
