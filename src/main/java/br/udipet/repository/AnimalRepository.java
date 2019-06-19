package br.udipet.repository;

import org.springframework.data.repository.CrudRepository;

import br.udipet.entity.Animal;

public interface AnimalRepository extends CrudRepository<Animal,Integer>{
}
