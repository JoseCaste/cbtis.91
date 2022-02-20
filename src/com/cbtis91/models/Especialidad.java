package com.cbtis91.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Especialidad {
	private Integer id_especialidad;
	private String name_especialidad;
	
	public Especialidad(String name_especialidad) {
		this.name_especialidad = name_especialidad;
	}
	
	

}
