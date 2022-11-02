package com.helpdesk.api.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "usuario")
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 12, nullable = true)
    private String telefone;

    @Column(length = 45, nullable = false, unique = true)
    private String email;

    @Column(nullable = true)
    private Instant dtNasc;

    @Column(nullable = true)
    private String escolaridade; // Enum

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = true)
    private String sexo; // Enum

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String petHumor; // Enum

    // @OneToMany(mappedBy = "usuario")
    // @Column(nullable = false)
    // private List<Atividade> atividades;

    public Usuario(
            String nome,
            String email,
            String username,
            String senha) {
        this.nome = nome;
        this.email = email;
        this.username = username;
        this.senha = senha;
        this.petHumor = "neutro";
    }
}
