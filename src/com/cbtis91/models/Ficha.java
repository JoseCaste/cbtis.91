package com.cbtis91.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ficha {

	private Integer numeroFicha;
	private String names;
	private String lastName;
	private String secondLastName;
	private Integer age;
	private String curp;
	private String actualResidencia;
	private String address;
	private String birthPlace;
	private String op1Especilty;
	private String op2Especilty;
	private String email;
	private String contact;
	private String detailLanguaje;
	private String detailDisability;
	private String kindSchool;
	
	public Ficha(String names, String lastName, String secondLastName, Integer age, String curp,
			String actualResidencia, String address, String birthPlace, String op1Especilty, String op2Especilty,
			String email, String contact, String detailLanguaje, String detailDisability, String kindSchool) {
		
		this.names = names;
		this.lastName = lastName;
		this.secondLastName = secondLastName;
		this.age = age;
		this.curp = curp;
		this.actualResidencia = actualResidencia;
		this.address = address;
		this.birthPlace = birthPlace;
		this.op1Especilty = op1Especilty;
		this.op2Especilty = op2Especilty;
		this.email = email;
		this.contact = contact;
		this.detailLanguaje = detailLanguaje;
		this.detailDisability = detailDisability;
		this.kindSchool = kindSchool;
	}
	
	
	
	
	
	
	
	
	
}
