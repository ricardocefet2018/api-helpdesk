package com.helpdesk.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "categoria")
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(length = 100)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    @NonNull
    private Usuario usuario;

    // @OneToMany(mappedBy = "categoria")
    // private List<Atividade> atividades;

    // TO-DO
    // private Professor professor;

    // TO-DO
    // private String local;

    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

}
