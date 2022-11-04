package com.helpdesk.api.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "atividade")
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String titulo;

    @NonNull
    private Instant dtInicio;

    @NonNull
    private Instant dtFinal;

    @Column(nullable = true)
    private int prioridade; // ENUM

    @Column(nullable = true)
    private int dificuldade; // ENUM

    // TO-DO
    // @Column(nullable = true)
    // private Long idMateria;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    @NonNull
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    @NonNull
    private Usuario usuario;

    public Atividade(String titulo, Instant dtInicio, Instant dtFinal, Categoria categoria, Usuario usuario,
            int prioridade, int dificuldade) {
        this.titulo = titulo;
        this.dtInicio = dtInicio;
        this.dtFinal = dtFinal;
        this.categoria = categoria;
        this.usuario = usuario;
        this.prioridade = prioridade;
        this.dificuldade = dificuldade;
    }

    // long, java.lang.String, java.time.Instant, java.time.Instant, int, int,
    // com.helpdesk.api.model.Categoria
    public Atividade(Long id, String titulo, Instant dtInicio, Instant dtFinal,
            int prioridade, int dificuldade, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.dtInicio = dtInicio;
        this.dtFinal = dtFinal;
        this.prioridade = prioridade;
        this.dificuldade = dificuldade;
        this.categoria = new Categoria(categoria.getId(), categoria.getNome());
    }
}
