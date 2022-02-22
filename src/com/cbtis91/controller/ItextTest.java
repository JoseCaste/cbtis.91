package com.cbtis91.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.VerticalAlignment;

public class ItextTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			//PdfWriter writer= new PdfWriter("//home//jose//Documents//PDFs//test.pdf");
			File file = new File("/home//jose/Documents/PDFs/test.pdf");
	        file.getParentFile().mkdirs();
	        
	        PdfWriter writer = new PdfWriter("/home/jose/Documents/PDFs/test.pdf");
	        
	        PdfDocument pdf = new PdfDocument(writer);
	        
	        Document document = new Document(pdf);
	        ImageData image_izq= ImageDataFactory.create("/home/jose/Pictures/logo_cbtis_izq.jpg");
	        Image image= new Image(image_izq);
	        image.scale(0.2f, 0.2f);
	        image.setFixedPosition(10, 760);
	        document.add(image);
	        /*Table table = new Table(UnitValue.createPercentArray(new float[]{1, 2}));
	        table.addCell(createImageCell("/home/jose/Pictures/logo_cbtis_izq.jpg"));
	        table.addCell(createImageCell2("/home/jose/Pictures/logo_cbtis_der.jpg"));
	        document.add(table);*/
	      
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
	        document.add(new Paragraph("NOMBRE DEL ALUMNO: Castellanos Guzmán Juan José").setTextAlignment(TextAlignment.JUSTIFIED).setFontSize(9).setPaddingLeft(48));
	        document.add(new Paragraph("CURP: 1123CURP").setTextAlignment(TextAlignment.JUSTIFIED).setFontSize(9).setPaddingLeft(48));
	        document.add(new Paragraph("TELEFONO: 9712212212").setTextAlignment(TextAlignment.JUSTIFIED).setFontSize(9).setPaddingLeft(48));
	        document.add(new Paragraph("CORREO ELECTRÓNICO: ABC@gmail.com").setTextAlignment(TextAlignment.JUSTIFIED).setFontSize(9).setPaddingLeft(48));
	        document.add(new Paragraph("LUGAR DE NACIEMIENTO: Aquí").setTextAlignment(TextAlignment.JUSTIFIED).setFontSize(9).setPaddingLeft(48));
	        document.add(new Paragraph("OPCION 1 DE ESPECIALIDAD : 1").setTextAlignment(TextAlignment.JUSTIFIED).setFontSize(9).setPaddingLeft(48));
	        document.add(new Paragraph("OPCION 2 DE ESPECIALIDAD : 2").setTextAlignment(TextAlignment.JUSTIFIED).setFontSize(9).setPaddingLeft(48));
	        
	        document.add(new Paragraph(" "));
	        
	        document.add(new Paragraph("NOTA: Nota de prueba ").setTextAlignment(TextAlignment.JUSTIFIED).setFontSize(9).setPaddingLeft(48));
	        
	        document.close();
			System.out.println("PDF creado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Cell createImageCell(String path) throws MalformedURLException {
	    Image img = new Image(ImageDataFactory.create(path));
	    img.setFixedPosition(2f, 1f);
	    img.setWidth(UnitValue.createPercentValue(20));
	    Cell cell = new Cell().add(img);
	    cell.setBorder(null);
	    return cell;
	}

	public static Cell createImageCell2(String path) throws MalformedURLException {
		Image img = new Image(ImageDataFactory.create(path));
	    img.setWidth(UnitValue.createPercentValue(20));
	    Cell cell = new Cell().add(img).setTextAlignment(TextAlignment.RIGHT);
	    cell.setBorder(null);
	    return cell;
	}

}
