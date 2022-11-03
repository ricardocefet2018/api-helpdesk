package com.helpdesk.api.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.helpdesk.api.model.Login;
import com.helpdesk.api.model.Usuario;
import com.helpdesk.api.repository.UsuarioRepository;
import com.helpdesk.api.service.UsuarioService;

@Controller
@RequestMapping("/v1/usuario")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/login/")
    public ResponseEntity<Usuario> login(@RequestBody Login login) {
        System.out.println(login.username);
        System.out.println(login.senha);
        Optional<Usuario> usuarioOp = usuarioRepository.findByUsernameAndSenha(login.username, login.senha);

        if (usuarioOp.isPresent()) {
            return ResponseEntity.ok().body(usuarioOp.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/cadastro/")
    public ResponseEntity<Usuario> cadastro(@RequestBody Usuario usuario) {
        System.out.println(usuario);
        try {
            Optional<Usuario> u1 = usuarioRepository.findAllByUsername(usuario.getUsername());
            if (u1.isPresent()) {
                return ResponseEntity.status(403).build();
            } else {
                Usuario u = this.usuarioRepository.save(usuario);
                return ResponseEntity.ok().body(u);
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/alterarSenha/")
    public ResponseEntity<Usuario> alterarSenha(@RequestBody Login login) {
        System.out.println(login.username);
        System.out.println(login.senha);
        Optional<Usuario> usuarioOp = usuarioRepository.findByUsernameAndSenha(login.username, login.senha);

        if (usuarioOp.isPresent()) {
            Usuario u = usuarioOp.get();
            if (u.getSenha() == login.senha) {
                u.setSenha(login.novaSenha);
                u = usuarioRepository.save(u);
                return ResponseEntity.ok().body(u);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
