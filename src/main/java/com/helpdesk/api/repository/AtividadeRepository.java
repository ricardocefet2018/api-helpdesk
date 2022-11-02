package com.helpdesk.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.helpdesk.api.model.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

    // SELECT a.id as id_atividade, a.titulo, a.dt_inicio, a.dt_final,
    // a.dificuldade, a.prioridade, a.id_categoria, c.nome, a.id_usuario, u.email,
    // u.nome, u.username FROM atividade a, categoria c, usuario u WHERE
    // a.id_usuario = 1 AND a.id_usuario = u.id AND a.id_categoria = c.id;

    // public Optional<List<Atividade>> findAtividadesByUsuarioId(Long id);

    // @Query("SELECT a.id, a.titulo, a.dtInicio, a.dtFinal, a.prioridade,
    // a.dificuldade, a.categoria FROM atividade a WHERE a.usuario.id = :id")

    @Query("SELECT new com.helpdesk.api.model.Atividade(a.id, a.titulo, a.dtInicio, a.dtFinal, a.prioridade, a.dificuldade, a.categoria) FROM atividade a WHERE a.usuario.id = :id")
    public Optional<List<Atividade>> findAtividadesByUsuarioId(@Param("id") Long id);
}
