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
@Table(name = "DetailEquipe")
public class DetailEquipe {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "salle")
    private Integer salle;
    private String thematique;


    @OneToOne
    private Equipe Equipe;

}
