package br.com.autenticacaousuario.model.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AtualizarDadosUsuarioADM(
        @NotNull(message = "O id não pode ser nulo")
        UUID id,
        String nome,
        String email,
        String cpf,
        String senha
) {
}
