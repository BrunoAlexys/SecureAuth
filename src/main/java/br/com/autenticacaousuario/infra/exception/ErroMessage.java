package br.com.autenticacaousuario.infra.exception;

import org.springframework.http.HttpStatus;

public record ErroMessage(
        HttpStatus status,
        String message
) {
    public ErroMessage(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
