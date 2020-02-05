package com.taxapy.taxistaservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.taxapy.taxistaservice.model.Taxista;

public interface TaxistaRepository extends CrudRepository<Taxista, Integer> {
	Iterable<Taxista> findTaxistaByNombre(String nombre);
	Taxista findTaxistaByIdTaxista(int idTaxista);
}
