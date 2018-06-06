package com.web.apps.HelperClasses;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePDF{
   public static void main(String[] args){
	   createPDF();
   }
   
   public static void createPDF(){
	   Document document = new Document();
	      try{
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D://BARCODES//HelloWorld.pdf"));
	         document.open();
	         document.add(new Paragraph("A Hello World PDF document."));
	         document.close();
	         writer.close();
	      }catch(DocumentException e){
	         e.printStackTrace();
	      }catch(FileNotFoundException e){
	         e.printStackTrace();
	      }
   }
}