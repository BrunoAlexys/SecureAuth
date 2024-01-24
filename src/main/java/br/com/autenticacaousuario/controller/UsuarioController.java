package br.com.autenticacaousuario.controller;

import br.com.autenticacaousuario.model.dto.AtualizarUsuarioDTO;
import br.com.autenticacaousuario.model.dto.CadastroUsuarioDTO;
import br.com.autenticacaousuario.model.dto.ListaUsuarioDTO;
import br.com.autenticacaousuario.model.entities.Usuario;
import br.com.autenticacaousuario.model.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroUsuarioDTO dados) {
        var usuario = new Usuario(dados);
        usuarioService.salvar(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ListaUsuarioDTO>> listar() {
        List<ListaUsuarioDTO> usuarios = usuarioService.listar()
                .stream()
                .map(ListaUsuarioDTO::new)
                .toList();
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Usuario> atualizar(@RequestBody @Valid AtualizarUsuarioDTO dados) {
        var usuario = usuarioService.atualizarUsuario(dados);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") UUID id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.ok().build();
    }
}
