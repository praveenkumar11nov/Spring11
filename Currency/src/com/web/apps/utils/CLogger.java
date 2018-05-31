package com.web.apps.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CLogger {

	public static void writeToFile(String text) {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	try {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("D://Currency_Logs//CurrencyLinePrints.txt"), true));
		bw.write(sdf.format(new Date())+":::::::::::>"+text);
		bw.newLine();
		bw.newLine();
		bw.close();
	}catch (Exception e) {System.err.println(".............Exception while writing text............");
  }
 }
}
