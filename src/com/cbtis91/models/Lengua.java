package com.cbtis91.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Lengua {

	private Integer idLengua;
	private String nombreLengua;
	
	public Lengua(String nombre_lengua) {
		this.nombreLengua = nombre_lengua;
	}
	
}
