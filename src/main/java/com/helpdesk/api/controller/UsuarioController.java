package com.helpdesk.api.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.helpdesk.api.model.Login;
import com.helpdesk.api.model.Usuario;
import com.helpdesk.api.service.UsuarioService;

@Controller
@RequestMapping("/v1/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/")
    public ResponseEntity<Usuario> login(@RequestBody Login login) {
        System.out.println(login.username);
        System.out.println(login.senha);
        Optional<Usuario> usuarioOp = usuarioService.login(login.username, login.senha);

        if (usuarioOp.isPresent()) {
            return ResponseEntity.ok().body(usuarioOp.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
