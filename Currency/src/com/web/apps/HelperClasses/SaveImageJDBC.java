package com.web.apps.HelperClasses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;

public class SaveImageJDBC {
	public static void main(String[] args) {
		saveImage();
		//getImage();
	}
	public static void saveImage() {
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.96:1521:ORCL","SPG","bcits");  
			PreparedStatement ps=con.prepareStatement("insert into IMAGE_STORE values(?,?)");  
			ps.setString(1,"praveen");  
			FileInputStream fin=new FileInputStream("D:\\BARCODES\\BARCODE_123456789.gif");  
			ps.setInt(1,1);
			ps.setBinaryStream(2,fin,fin.available());  
			int i=ps.executeUpdate();  
			System.out.println(i+" image saved in database");  

			con.close();  
		}catch (Exception e) {e.printStackTrace();}
	}

	public static void getImage() {
		try{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.96:1521:ORCL","SPG","bcits");  
			PreparedStatement ps=con.prepareStatement("select * from IMAGE_STORE where id='1'");  
			ResultSet rs=ps.executeQuery();  
			if(rs.next()){  
				Blob b=rs.getBlob(2);  
				byte barr[]=b.getBytes(1,(int)b.length());  
				FileOutputStream fout=new FileOutputStream("D:\\BARCODES\\ImageOfBarcode.gif");  
				fout.write(barr);  
				fout.close();  
			}  
			System.out.println("image saved in folder");  
			con.close();  
		}catch (Exception e) {e.printStackTrace();}  
	} 


}
