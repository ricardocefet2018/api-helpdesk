package com.helpdesk.api.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.helpdesk.api.model.Atividade;
import com.helpdesk.api.repository.AtividadeRepository;

@Controller
@RequestMapping("/v1/atividade")
public class AtividadeController {

    AtividadeRepository atividadeRepository;

    public AtividadeController(AtividadeRepository atividadeRepository) {
        this.atividadeRepository = atividadeRepository;
    }

    @GetMapping("/usuario/{idUsuario}/")
    public ResponseEntity<List<Atividade>> list(@PathVariable Long idUsuario) {
        System.out.println("////////////////////////////////////////////////////////////////");
        System.out.println(idUsuario);
        System.out.println("////////////////////////////////////////////////////////////////");
        Optional<List<Atividade>> atividadesOp = this.atividadeRepository.findAtividadesByUsuarioId(idUsuario);
        if (atividadesOp.isPresent()) {
            List<Atividade> atividades = atividadesOp.get();
            return ResponseEntity.ok().body(atividades);
        } else {
            return ResponseEntity.ok().body(new ArrayList<Atividade>());
        }
    }

    @PostMapping
    public ResponseEntity<Atividade> create(@RequestBody Atividade atividade) {
        if (atividade.getId() != null) {
            return ResponseEntity.badRequest().build();
        } else {
            atividade = this.atividadeRepository.save(atividade);
            return ResponseEntity.status(202).body(atividade);
        }
    }
}
