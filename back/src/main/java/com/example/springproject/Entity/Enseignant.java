package com.example.springproject.Entity;

import lombok.*;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Enseignant")
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_enseignant")
    private Integer idEnseignant;
    private String nomEns;
    private String prenomEns;
    private Date datNaissance;
    private Sexe sexe;
    private Date dateContrat;
    private Integer salaire;



}
