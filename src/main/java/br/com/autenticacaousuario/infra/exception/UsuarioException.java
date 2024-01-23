package br.com.autenticacaousuario.infra.exception;

public class UsuarioException extends RuntimeException {
    public UsuarioException(String message) {
        super(message);
    }
}
