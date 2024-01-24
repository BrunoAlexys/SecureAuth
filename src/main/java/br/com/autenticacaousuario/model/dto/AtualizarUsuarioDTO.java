package br.com.autenticacaousuario.model.dto;

import java.util.UUID;

public record AtualizarUsuarioDTO(
        UUID id,
        String nome,
        String senha
) { }
