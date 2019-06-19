package br.udipet.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.udipet.entity.Marcacao;

public interface MarcacaoRepository extends CrudRepository<Marcacao, Integer> {
	
	List<Marcacao> findByStatusExec(String statusExec);
}
