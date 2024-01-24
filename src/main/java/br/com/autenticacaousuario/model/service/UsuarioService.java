package br.com.autenticacaousuario.model.service;

import br.com.autenticacaousuario.model.dto.AtualizarUsuarioDTO;
import br.com.autenticacaousuario.model.entities.Usuario;
import br.com.autenticacaousuario.model.repository.UsuarioRepository;
import br.com.autenticacaousuario.model.validation.IValidarUsuario;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private List<IValidarUsuario> validacao;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void salvar(Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        validacao.forEach(v -> v.validar(usuario));
        usuarioRepository.save(usuario);
    }

    public List<Usuario> listar() {
        try {
            return usuarioRepository.findAll();
        } catch (EntityNotFoundException exception) {
            throw new EntityNotFoundException("Não foi possível listar os usuários");
        }
    }

    @Transactional
    public Usuario atualizarUsuario(AtualizarUsuarioDTO dados) {
        var usuario = usuarioRepository.findById(dados.id())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        if (dados.nome() != null) {
            usuario.setNome(dados.nome());
        }

        if (dados.senha() != null) {
            usuario.setSenha(passwordEncoder.encode(dados.senha()));
        }

        return usuario;
    }
}
