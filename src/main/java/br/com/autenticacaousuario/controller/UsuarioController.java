package br.com.autenticacaousuario.controller;

import br.com.autenticacaousuario.model.dto.CadastroUsuarioDTO;
import br.com.autenticacaousuario.model.dto.ListaUsuarioDTO;
import br.com.autenticacaousuario.model.entities.Usuario;
import br.com.autenticacaousuario.model.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
