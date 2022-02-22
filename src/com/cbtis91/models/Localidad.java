package com.cbtis91.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Localidad {

	private Integer idLocalidad;
	private String nombreLocalidad;
	
	public Localidad(String nombreLocalidad) {
		this.nombreLocalidad = nombreLocalidad;
	}
	
	
}
