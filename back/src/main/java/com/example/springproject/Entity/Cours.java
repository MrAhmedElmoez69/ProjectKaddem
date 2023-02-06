package com.example.springproject.Entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cours")
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cours")
    private Integer IdCours;

    private String Nom;
    private String description;
    private Integer credit;
    private Integer nbHeure;
    private Integer anneeUniv;

}
