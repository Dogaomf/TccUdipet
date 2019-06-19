package br.udipet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.udipet.entity.Procedimento;

public interface ProcedimentoRepository extends JpaRepository<Procedimento, Integer> {
}
