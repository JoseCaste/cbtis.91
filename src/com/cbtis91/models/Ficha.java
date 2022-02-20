package com.cbtis91.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ficha {

	private Integer idFicha;
	private String nombreAlumno;
	private String apellidoPaterno;
	private String curp;
	private String numeroTelefono;
	private String correoElectronico;
	private Integer opEspecialidadOne;
	private Integer opEspecialidadTwo;
	private Integer fkIdEspecialidad;
	private Integer fkIdDiscapacidad;
	private Integer fkIdLengua;
	
	public Ficha(String nombreAlumno, String apellidoPaterno, String curp, String numeroTelefono,
			String correoElectronico, Integer opEspecialidadOne, Integer opEspecialidadTwo, Integer fkIdEspecidad,
			Integer fkIdDiscapacidad, Integer fkIdLengua) {
		this.nombreAlumno = nombreAlumno;
		this.apellidoPaterno = apellidoPaterno;
		this.curp = curp;
		this.numeroTelefono = numeroTelefono;
		this.correoElectronico = correoElectronico;
		this.opEspecialidadOne = opEspecialidadOne;
		this.opEspecialidadTwo = opEspecialidadTwo;
		this.fkIdDiscapacidad = fkIdEspecidad;
		this.fkIdDiscapacidad = fkIdDiscapacidad;
		this.fkIdLengua = fkIdLengua;
	}
	
	public Ficha(String nombreAlumno, String apellidoPaterno, String curp, String numeroTelefono,
			Integer opEspecialidadOne, Integer opEspecialidadTwo, Integer fkIdEspecidad, Integer fkIdDiscapacidad,
			Integer fkIdLengua) {
		this.nombreAlumno = nombreAlumno;
		this.apellidoPaterno = apellidoPaterno;
		this.curp = curp;
		this.numeroTelefono = numeroTelefono;
		this.opEspecialidadOne = opEspecialidadOne;
		this.opEspecialidadTwo = opEspecialidadTwo;
		this.fkIdDiscapacidad = fkIdEspecidad;
		this.fkIdDiscapacidad = fkIdDiscapacidad;
		this.fkIdLengua = fkIdLengua;
	}
	
	
	
	
	
	
}
