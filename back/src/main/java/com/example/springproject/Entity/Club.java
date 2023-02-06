package com.example.springproject.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Club")
public class Club {
    @ManyToOne
    Etudiant etudiant;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_club")
    private Integer idClub;
    private String nomClub;
    private String description;
    private Date datecreation;
}
