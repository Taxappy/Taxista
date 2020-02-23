package com.taxappy.taxista.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taxappy.taxista.model.UsoTaxi;

@Repository
public interface UsoTaxiRepository extends CrudRepository<UsoTaxi, Integer> {
	UsoTaxi findUsoTaxiByIdTaxistaAndPlaca(int idTaxista, String placa);

	UsoTaxi findUsoTaxiByIdTaxistaAndFechaUso(int idTaxista, String fechaUso);

}
