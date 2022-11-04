package com.helpdesk.api.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<Atividade>> list(@PathVariable Long idUsuario) {
        Optional<List<Atividade>> atividadesOp = this.atividadeRepository.findAtividadesByUsuarioId(idUsuario);
        if (atividadesOp.isPresent()) {
            List<Atividade> atividades = atividadesOp.get();
            return ResponseEntity.ok().body(atividades);
        } else {
            return ResponseEntity.ok().body(new ArrayList<Atividade>());
        }
    }

    @GetMapping("/{id}/usuario/{idUsuario}")
    public ResponseEntity<Atividade> getAtividade(@PathVariable Long id, @PathVariable Long idUsuario) {
        Optional<Atividade> atividadeOp = this.atividadeRepository.findByIdAndUsuarioId(id, idUsuario);
        if (atividadeOp.isPresent()) {
            Atividade atividade = atividadeOp.get();
            return ResponseEntity.ok().body(atividade);
        } else {
            return ResponseEntity.noContent().build();
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

    @PutMapping
    public ResponseEntity<Atividade> edit(@RequestBody Atividade atividade) {
        if (atividade.getId() == null) {
            return ResponseEntity.badRequest().build();
        } else {
            atividade = this.atividadeRepository.save(atividade);
            atividade = this.atividadeRepository.findById(atividade.getId()).get();
            return ResponseEntity.ok().body(atividade);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Atividade> delete(@PathVariable Long id) {
        this.atividadeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
