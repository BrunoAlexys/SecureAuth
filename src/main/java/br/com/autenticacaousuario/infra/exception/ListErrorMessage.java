package br.com.autenticacaousuario.infra.exception;

import org.springframework.validation.FieldError;

public record ListErrorMessage(
        String field,
        String message
) {
    public ListErrorMessage(FieldError error) {
        this(error.getField(), error.getDefaultMessage());
    }
}
