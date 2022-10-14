package com.helpdesk.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "categoria")
@Getter
@Setter
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(length = 100)
    private String nome;

    // @OneToMany(mappedBy = "categoria")
    // private List<Atividade> atividades;

    // TO-DO
    // private Professor professor;

    // TO-DO
    // private String local;

}
