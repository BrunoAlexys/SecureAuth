package br.com.autenticacaousuario.model.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(
        @NotBlank(message = "O email não pode ser vazio")
        String email,
        @NotBlank(message = "A senha não pode ser vazia")
        String senha
) {
}
