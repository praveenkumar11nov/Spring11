package com.web.apps.HelperClasses;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CreateImageFromText {
	public static void main(String arg[]) throws Exception {
		createImage1("स्थाई शुल्क");
		//createImage1("प्रवीण कुमार");
		//createImage("Praveen Kumar");
		//createImage1("Praveen Kumar");
	}
	public static void createImage(String text) throws Exception {
		BufferedImage bufferedImage = new BufferedImage(170, 50, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = bufferedImage.getGraphics();
		graphics.setColor(Color.LIGHT_GRAY);
		graphics.fillRect(0, 0, 250, 60);
		graphics.setColor(Color.BLUE);
		graphics.setFont(new Font("Arial Black", Font.PLAIN, 11));
		graphics.drawString(text, 10, 25);
		ImageIO.write(bufferedImage, "jpg", new File("D://BARCODES//"+text+".jpg"));
		System.out.println("Image Created for " + text);
	}
	public static void createImage1(String text) throws Exception {
		BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB); 
		 Graphics graphics = image.getGraphics(); 
		 graphics.drawString(text,10,20);
		 graphics.setColor(Color.BLUE);
		 try {  
		   ImageIO.write(image, "jpg", new File("D://BARCODES//"+text+".jpg")); 
		 }catch(IOException e){  
		  e.printStackTrace(); 
		 }
		System.out.println("Image Created for " + text);
	}
}