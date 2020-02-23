package com.taxappy.taxista.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name="usotaxi")
public class UsoTaxi {
	@Id
	private int codigo;
	
	private int idTaxista;
	
	private String placa;
	
	private String fechaUso;

}
