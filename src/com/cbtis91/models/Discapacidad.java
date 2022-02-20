package com.cbtis91.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Discapacidad {

	private Integer idDiscapacidad;
	private String nombreDiscapacidad;
	
	public Discapacidad(String nombre_discapacidad) {
		this.nombreDiscapacidad = nombre_discapacidad;
	}
	
}
