package com.web.apps.HelperClasses;

import java.io.IOException;  
import java.util.Properties;  

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Folder;  
import javax.mail.Message;  
import javax.mail.MessagingException;  
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;  
import javax.mail.PasswordAuthentication;
import javax.mail.Session;  
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.pop3.POP3Store;  
import com.web.apps.utils.CLogger;

public class JavaMailAPI{
	public static void main(String[] args) throws AddressException, MessagingException {
		
		/*
		String host 		 =  "pop.gmail.com";//change accordingly  
		String mailStoreType =  "pop3";  
		String port			 =  "995";
		String username		 =  "havewordswithpraveen@gmail.com";  
		String password		 =  "shanu@11";//change accordingly  
		receiveEmail(host, mailStoreType, port, username, password);  */
	} 
	
	

	public static int sendEmail(String TO,String subject,String msgbody){
		final String username = "havewordswithpraveen@gmail.com";
		final String password = "Shanu@11";
		String CC  = "";
		String BCC = "";;
		String salutation  ="Dear User";
		String footer = "<tr><td><b>--</b></td></tr>"
				+ "<tr><td><b>Thanks&Regards</b></td></tr>"
				+ "<tr><td>Praveen Kumar</td></tr>"
				+ "<tr><td>Bcits Pvt Ltd Bangalore</td></tr>"
				+ "<tr><td>Mobile: +91-9738716976</td></tr>";

		try{
			System.err.println("------------------------sending Email to "+TO+"-----------------------");
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			Session session = Session.getInstance(props,new javax.mail.Authenticator() {
				@Override
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username,password);
				}
			});
			Message message = new MimeMessage(session);	        
			message.setFrom(new InternetAddress(username));	       
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(TO));	 
			message.setRecipients(Message.RecipientType.CC,InternetAddress.parse(CC));
			message.setRecipients(Message.RecipientType.BCC,InternetAddress.parse(BCC));	
			message.setSubject(subject);	       
			String msg = "<html><head></head><body><table><tr>" + "<td>"+ salutation
					+"</td></tr><tr><td>&nbsp;</td></tr><tr><td>&nbsp;</td></tr>"
					+ "<tr><td>"+ msgbody + "</td></tr>"
					+ "<tr><td>&nbsp;</td><tr><td>&nbsp;</td>"
					+ "</tr>"+ footer
					+ "</table></body></html>";
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(msg, "text/html");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			Transport.send(message);
			System.out.println("Email sent to "+TO+" successfully....");
			CLogger.writeToFile("Email sent to "+TO+" successfully....");
			return 0;
		}catch(Exception e){
			CLogger.writeToFile("Exception---->"+e.toString());
			e.printStackTrace();
			return 1;
		}
	}
	
	public static void sendEmailWithAttachment() throws AddressException, MessagingException
	{
		final String username = "havewordswithpraveen@gmail.com";
		final String password = "Shanu@11";

		String header ="<tr><td>------------------------- Send Through Java Application-------------------------</td></tr><tr><td>&nbsp;</td></tr>";
		String TO  = "praveen.kumar@bcits.in";
		String CC  = "praveen.shanukumar@gmail.com";
		String BCC = "";//"sachin.hs@bcits.in";
		String subject     ="HoliCelebrations-Bcits";
		String salutation  ="Dear All";
		String messagebody ="Our warmest greetings to you and your family this Holi. May this Holi  be the start of your successful and fulfilling life at Skyon! Join us on Friday, March 2nd 2018 from 10:00am at Skyon, as we celebrate the Festival of Holi with your loved ones and enjoy the festivities and spend moments of happiness with your family and friends- Come,Celebrate the festival of colors, Get drenched with different hues,Share the love and fun this festival of Holi at Ireo Skyon!";
		String UploadFileLocation = "C:\\Users\\User\\Desktop\\HOLI_celebration.png";
		String footer = "--"
						+ "<tr><td><b>Thanks&Regards</b></td></tr>"
						+ "<tr><td>Praveen Kumar</td></tr>"
						+ "<tr><td>Bcits Pvt Ltd Bangalore</td></tr>"
						+ "<tr><td>Mobile: +91-9738716976</td></tr>";


		System.err.println("------------------------sending Email to "+TO+"-----------------------");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getInstance(props,new javax.mail.Authenticator() {
			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});

		Message message = new MimeMessage(session);	        
		message.setFrom(new InternetAddress(username));	       
		message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(TO));	 
		message.setRecipients(Message.RecipientType.CC,InternetAddress.parse(CC));
		message.setRecipients(Message.RecipientType.BCC,InternetAddress.parse(BCC));	
		message.setSubject(subject);	       

		String msg = "<html><head></head><body><table>"
					+ header
					+ "<tr>"
					+ "<td>"
					+ salutation
					+"</td></tr><tr><td>&nbsp;</td></tr><tr><td>&nbsp;</td></tr>"
					+ "<tr><td>"
					+ messagebody
					+ "</td></tr>"
					+ "<tr><td>&nbsp;</td></tr>"
					+ "<tr><td><img src=\"cid:image\" style='width: 100%;'></td></tr>"
					+ footer
					+ "</table></body></html>";

		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(msg, "text/html");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		String filename = UploadFileLocation; 
		DataSource source = new FileDataSource(filename);
		messageBodyPart = new MimeBodyPart();
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setHeader("Content-ID", "<image>");
		messageBodyPart.setFileName(filename);
		multipart.addBodyPart(messageBodyPart);

		message.setContent(multipart);
		Transport.send(message);
		System.out.println("Email sent to "+TO+" successfully....");
	}
	
	
	public static void receiveEmail(String Host, String storeType, String port, String user, String password){
		try {  
			//1) get the session object  
			Properties properties = new Properties();  
			properties.put("mail.pop3.host", Host);  
			properties.put("mail.pop3.port", port);
			//properties.put("mail.pop3.starttls.enable", "true");
            properties.put("mail.pop3.ssl.enable", "true");
            properties.put("mail.pop3.auth", "true");

			Session emailSession = Session.getDefaultInstance(properties);  

			//2) create the POP3 store object and connect with the pop server  
			POP3Store emailStore = (POP3Store) emailSession.getStore(storeType);  
			emailStore.connect(Host, user, password);

			//3) create the folder object and open it  
			Folder emailFolder = emailStore.getFolder("INBOX");  
			emailFolder.open(Folder.READ_ONLY);  

			//4) retrieve the messages from the folder in an array and print it  
			Message[] messages = emailFolder.getMessages();  
			for (int i = 0; i < messages.length; i++) {
				Message message = messages[i];  
				System.out.println("---------------------------------");  
				System.out.println("Email Number " + (i + 1));  
				System.out.println("Subject: " + message.getSubject());  
				System.out.println("From: " + message.getFrom()[0]);  
				System.out.println("Text: " + message.getContent().toString());  
			}  

			//5) close the store and folder objects  
			emailFolder.close(false);  
			emailStore.close();  

		}
		catch (NoSuchProviderException e) {e.printStackTrace();}   
		catch (MessagingException e) {e.printStackTrace();}  
		catch (IOException e) {e.printStackTrace();}  
	}  
} 