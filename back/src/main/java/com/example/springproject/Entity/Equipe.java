package com.example.springproject.Entity;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_equipe")
    private Integer idEquipe;
    private String nomEquipe;
    private Niveau niveau;

    @OneToMany
    @JoinColumn(name = "etudiant_set_id_etudaint")
    Set<Etudiant> etudiantSet;
    @OneToOne
    private DetailEquipe detailEquipe;
}
