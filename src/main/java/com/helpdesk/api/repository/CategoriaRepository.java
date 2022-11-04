package com.helpdesk.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.helpdesk.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query("SELECT new com.helpdesk.api.model.Categoria(c.id, c.nome) FROM categoria c WHERE c.usuario.id = :id")
    public Optional<List<Categoria>> findAtividadesByUsuarioId(@Param("id") Long id);

    @Query("SELECT new com.helpdesk.api.model.Categoria(c.id, c.nome) FROM categoria c WHERE c.id = :id")
    public Optional<Categoria> findById(@Param("id") Long id);

    @Query("SELECT new com.helpdesk.api.model.Categoria(c.id, c.nome) FROM categoria c WHERE c.id = :id AND c.usuario.id = :idUsuario")
    public Optional<Categoria> findByIdAndUsuarioId(@Param("id") Long id, @Param("idUsuario") Long idUsuario);

}
