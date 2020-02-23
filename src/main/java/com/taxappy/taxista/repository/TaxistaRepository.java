package com.taxappy.taxista.repository;

import org.springframework.data.repository.CrudRepository;

import com.taxappy.taxista.model.Taxista;


public interface TaxistaRepository extends CrudRepository<Taxista, Integer> {
	Iterable<Taxista> findTaxistaByNombre(String nombre);
	Taxista findTaxistaByIdTaxista(int idTaxista);
}
