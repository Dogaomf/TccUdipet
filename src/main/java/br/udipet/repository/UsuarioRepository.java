package br.udipet.repository;

import org.springframework.data.repository.CrudRepository;

import br.udipet.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario,Integer>{
	Usuario findByNomeUsuario(String nomeUsuario);
}
