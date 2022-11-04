package com.helpdesk.api.model;

import java.time.Instant;

public class AtividadeDTO {
    private Long id;
    private String titulo;
    private Instant dtInicio;
    private Instant dtFinal;
    private int prioridade; // ENUM
    private int dificuldade; // ENUM
    private CategoriaDTO categoria;

    public AtividadeDTO(Long id, String titulo, Instant dtInicio, Instant dtFinal, int prioridade, int dificuldade,
            Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.dtInicio = dtInicio;
        this.dtFinal = dtFinal;
        this.prioridade = prioridade;
        this.dificuldade = dificuldade;
        this.categoria = new CategoriaDTO(categoria.getId(), categoria.getNome());
    }

}
