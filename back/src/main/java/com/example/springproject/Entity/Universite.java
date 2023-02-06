package com.example.springproject.Entity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id_univ")
    private Integer idUniv;
    private String nomUniv;


    @OneToMany(fetch = FetchType.EAGER)
    private List<Departement> departementSet;

}
