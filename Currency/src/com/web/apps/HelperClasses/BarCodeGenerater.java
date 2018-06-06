package com.web.apps.HelperClasses;

import java.text.ParseException;

import com.keepautomation.barcode.BarCode;
import com.keepautomation.barcode.IBarCode;

public class BarCodeGenerater {

	public static void main(String[] args) throws ParseException {
		barcode("9931854827");
    }
	

	public static void barcode(String text) throws java.text.ParseException {
		BarCode barcode = new BarCode();
		barcode.setCodeToEncode(text);
		barcode.setSymbology(IBarCode.CODE128);
		barcode.setX(2);
		barcode.setY(50);
		barcode.setRightMargin(0);
		barcode.setLeftMargin(0);
		barcode.setTopMargin(0);
		barcode.setBottomMargin(0);
		barcode.setChecksumEnabled(false);
		barcode.setFnc1(IBarCode.FNC1_NONE);
		try{
			barcode.draw("D://BARCODES//BARCODE_"+text+".gif");
			System.out.println("Generated Barcode for "+text+" \nCheck D:/BARCODES/BARCODE_"+text+".gif" );
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
 }
