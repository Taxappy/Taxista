package com.taxapy.taxistaservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "taxista")
public class Taxista {
	@Id
	private int idTaxista;

	private String nombre;
}
