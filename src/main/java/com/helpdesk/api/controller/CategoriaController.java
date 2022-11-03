package com.helpdesk.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.helpdesk.api.model.Categoria;
import com.helpdesk.api.repository.CategoriaRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<Categoria>> list(@PathVariable Long idUsuario) {
        Optional<List<Categoria>> categoriasOp = this.categoriaRepository.findAtividadesByUsuarioId(idUsuario);
        if (categoriasOp.isPresent()) {
            List<Categoria> categorias = categoriasOp.get();
            return ResponseEntity.ok().body(categorias);
        } else {
            return ResponseEntity.ok().body(new ArrayList<Categoria>());
        }
    }

    @PostMapping
    public ResponseEntity<Categoria> create(Categoria categoria) {
        if (categoria.getId() != null) {
            return ResponseEntity.badRequest().build();
        } else {
            categoria = this.categoriaRepository.save(categoria);
            return ResponseEntity.status(202).body(categoria);
        }
    }

    @DeleteMapping("")
    public ResponseEntity<Categoria> delete(Long id) {
        this.categoriaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
