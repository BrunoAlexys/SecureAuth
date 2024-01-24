package br.com.autenticacaousuario.model.validation;

import br.com.autenticacaousuario.infra.exception.UserNotFoundException;
import br.com.autenticacaousuario.model.entities.Usuario;
import br.com.autenticacaousuario.model.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ValidarUnicidadeDoUsuario implements IValidarUsuario {

    private final UsuarioRepository usuarioRepository;

    @Override
    public void validar(Usuario usuario) {
        if (usuarioRepository.existsByCpf(usuario.getCpf())) {
            throw new UserNotFoundException("Já existe um usuário cadastrado com este CPF");
        }

        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new UserNotFoundException("Já existe um usuário cadastrado com este e-mail");
        }
    }

}
