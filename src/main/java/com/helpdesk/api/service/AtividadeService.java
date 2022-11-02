package com.helpdesk.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.helpdesk.api.model.Atividade;
import com.helpdesk.api.repository.AtividadeRepository;

@Service
public class AtividadeService {

    @Autowired
    AtividadeRepository atividadeRepository;

    // @Query("SELECT a.id, a.titulo, a.dtInicio, a.dtFinal, a.prioridade,
    // a.dificuldade, a.categoria FROM atividade a WHERE a.usuario.id = ?1")
    public Optional<List<Atividade>> findAtividadeByUsuarioId(Long idUsuario) {

        return atividadeRepository.findAtividadesByUsuarioId(idUsuario);
    }

}
