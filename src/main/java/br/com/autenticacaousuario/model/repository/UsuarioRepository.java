package br.com.autenticacaousuario.model.repository;

import br.com.autenticacaousuario.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    boolean existsByCpf(String cpf);

    boolean existsByEmail(String email);

    UserDetails findByEmail(String email);

    Optional<Usuario> findByEmailAndAtivoTrue(String email);

    Optional<Usuario> findByIdAndAtivoTrue(UUID id);

    @Query("select u from Usuario u where u.ativo = true")
    List<Usuario> findAllAndAtivoTrue();
}