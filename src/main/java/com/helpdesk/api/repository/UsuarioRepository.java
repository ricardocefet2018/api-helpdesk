package com.helpdesk.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.helpdesk.api.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findAllByUsername(String username);

    Optional<Usuario> findByUsernameAndSenha(String username, String senha);

}
