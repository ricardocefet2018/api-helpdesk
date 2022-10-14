package com.helpdesk.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpdesk.api.model.Usuario;
import com.helpdesk.api.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> login(String username, String senha) {
        return usuarioRepository.findByUsernameAndSenha(username, senha);
    }

    public Usuario cadastro(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
