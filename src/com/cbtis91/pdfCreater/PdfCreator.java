package com.cbtis91.pdfCreater;

import java.io.File;
import java.io.IOException;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;

import lombok.Data;

@Data
public class PdfCreator {

	private String names;
	private String lastName;
	private String secondLastName;
	private Integer age;
	private String curp;
	private String address;
	private String birthPlace;
	private String op1Especilty;
	private String op2Especilty;
	private String email;
	private String contact;
	private String languaje;
	private String detailLanguaje;
	private String disability;
	private String detailDisability;
	private String kindSchool;
	private String optionalNote;
	
	public PdfCreator(String names, String lastName, String secondLastName, Integer age, String curp, String address,
			String birthPlace, String op1Especilty, String op2Especilty, String contact, String languaje,
			String disability, String kindSchool) {
		this.names = names;
		this.lastName = lastName;
		this.secondLastName = secondLastName;
		this.age = age;
		this.curp = curp;
		this.address = address;
		this.birthPlace = birthPlace;
		this.op1Especilty = op1Especilty;
		this.op2Especilty = op2Especilty;
		this.contact = contact;
		this.languaje = languaje;
		this.disability = disability;
		this.kindSchool = kindSchool;
	}
	public boolean createFicha() {
		try {
			//PdfWriter writer= new PdfWriter("//home//jose//Documents//PDFs//test.pdf");
			File file = new File(String.format("/home/jose/Documents/PDFs/%s.pdf", this.curp));
	        file.getParentFile().mkdirs();
	        
	        PdfWriter writer = new PdfWriter(String.format("/home/jose/Documents/PDFs/%s.pdf", this.curp));
	        
	        PdfDocument pdf = new PdfDocument(writer);
	        
	        Document document = new Document(pdf);
	        
	      
	        PdfFont font= PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
	        document.add(new Paragraph("SECRETARIA DE EDUCACIÓN PÚBLICA").setTextAlignment(TextAlignment.CENTER).setFont(font).setFontSize(9).setFixedLeading(1));
	        document.add(new Paragraph("SUBSECRETARÍA DE EDUCACIÓN MEDIA SUPERIOR").setTextAlignment(TextAlignment.CENTER).setFont(font).setFontSize(9));
	        document.add(new Paragraph("DIRECCIÓN GENERAL DE EDUCACIÓN TECNOLÓGICA industrial y de servicios").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(9).setFixedLeading(1));
	        document.add(new Paragraph("CENTRO DE BACHILLERATO TECNOLÓGICO industrial y de servicios No. 91").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(9));
	        
	        document.add(new Paragraph(" "));
	        
	        document.add(new Paragraph("FICHA DE SOLICITUD DE EXAMEN DE INGRESO").setFont(font).setTextAlignment(TextAlignment.CENTER).setFontSize(9).setUnderline());

	        document.add(new Paragraph(" "));
	        
	        document.add(new Paragraph("No. de FICHA: "+"5").setTextAlignment(TextAlignment.RIGHT).setFont(font).setFontSize(9));
	        document.add(new Paragraph(" "));
	        document.add(new Paragraph(" "));
	        document.add(new Paragraph(" "));
	        document.add(new Paragraph(" "));
	        document.add(new Paragraph(String.format("NOMBRE DEL ALUMNO: %s %s %s", this.lastName,this.secondLastName,this.names)).setTextAlignment(TextAlignment.JUSTIFIED).setFontSize(9).setPaddingLeft(48));
	        document.add(new Paragraph(String.format("CURP: %s", this.names)).setTextAlignment(TextAlignment.JUSTIFIED).setFontSize(9).setPaddingLeft(48));
	        document.add(new Paragraph(String.format("TELEFONO: %s", this.contact)).setTextAlignment(TextAlignment.JUSTIFIED).setFontSize(9).setPaddingLeft(48));
	        document.add(new Paragraph(String.format("CORREO ELECTRÓNICO: %s", this.email)).setTextAlignment(TextAlignment.JUSTIFIED).setFontSize(9).setPaddingLeft(48));
	        document.add(new Paragraph(String.format("LUGAR DE NACIEMIENTO: %s", this.birthPlace)).setTextAlignment(TextAlignment.JUSTIFIED).setFontSize(9).setPaddingLeft(48));
	        document.add(new Paragraph(String.format("OPCION 1 DE ESPECIALIDAD : %s", this.op1Especilty)).setTextAlignment(TextAlignment.JUSTIFIED).setFontSize(9).setPaddingLeft(48));
	        document.add(new Paragraph(String.format("OPCION 2 DE ESPECIALIDAD : %s", this.op2Especilty)).setTextAlignment(TextAlignment.JUSTIFIED).setFontSize(9).setPaddingLeft(48));
	        
	        document.add(new Paragraph(" "));
	        
	        document.add(new Paragraph(String.format("NOTA: %s", this.optionalNote)).setTextAlignment(TextAlignment.JUSTIFIED).setFontSize(9).setPaddingLeft(48));
	        
	        document.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}		
	}

	
	
}
