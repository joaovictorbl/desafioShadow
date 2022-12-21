package com.api.usuario.services;

import com.api.usuario.entitys.Usuario;
import com.api.usuario.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository repository;


    public Usuario criar(Usuario novoUsuario) {
        return repository.save(novoUsuario);
    }

    public List<Usuario> listaUsuario() {
        List<Usuario> novaLista = repository.findAll();
        return novaLista;
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Usuario atualizar(Usuario usuario, Long id) {
        Usuario usuarioAtualizado = repository.findById(id).get();
        usuarioAtualizado.setNome(usuario.getNome());
        usuarioAtualizado.setCpf(usuario.getCpf());
        usuarioAtualizado.setEmail(usuario.getEmail());
        usuarioAtualizado.setSenha(usuario.getSenha());
        return usuarioAtualizado;
    }

    public Usuario obterPorId(Long id) {
        Usuario usuario = repository.findById(id).get();

        if (usuario == null) {
            throw new RuntimeException("Id usuario não existe! ");
        }
        return usuario;
    }

}
