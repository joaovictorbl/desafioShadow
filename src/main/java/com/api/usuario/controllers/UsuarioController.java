package com.api.usuario.controllers;

import com.api.usuario.entitys.Usuario;
import com.api.usuario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {


    @Autowired
    private UsuarioService service;


    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        Usuario usuario1 = service.criar(usuario);
        return usuario1;
    }

    @GetMapping
    public List<Usuario> listar() {
        List<Usuario> listaUsuario = service.listaUsuario();
        return listaUsuario;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @PatchMapping("/{id}")
    public Usuario atualizar(@RequestBody Usuario usuario, @PathVariable Long id) {
        Usuario usuarioAtualizado = service.atualizar(usuario, id);
        return usuarioAtualizado;
    }

    @GetMapping("/{id}")
    public Usuario obterPorId(@PathVariable Long id) {
        Usuario usuario = service.obterPorId(id);
        return usuario;
    }
}
