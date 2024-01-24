package br.com.autenticacaousuario.model.dto;

import br.com.autenticacaousuario.model.entities.Usuario;
import br.com.autenticacaousuario.model.enums.UserRole;

import java.util.UUID;

public record ListaUsuarioDTO(
        UUID id,
        String nome,
        String cpf,
        String email,
        UserRole role

) {
    public ListaUsuarioDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getCpf(), usuario.getEmail(), usuario.getRole());
    }
}
