package com.cbtis91.metadata;

import com.cbtis91.models.Especialidad;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExcelMetaData {
	
	private int numeroFicha;
	
	private String names;
	
	private String lastNames;
	
	private String curp;
	
	private String contact;
	
	private String email;
	
	private String languaje;
	
	private String disability;
	
	private String kindSchool;
	
	private int age;
	
	private String birthPlace;
	
	private String address;
	
	private Especialidad op1;
	
	private Especialidad op2;
	
	private String locality;
}
