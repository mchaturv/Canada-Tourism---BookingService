package com.tourism.canada.service;


import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.tourism.canada.dao.TwoFactorDao;
import com.tourism.canada.dao.UserDao;
import com.tourism.canada.entities.Booking;
import com.tourism.canada.entities.Transaction;
import com.tourism.canada.entities.TwoFactor;
import com.tourism.canada.entities.User;
import com.twilio.Twilio;



@Service
public class TwoFactorService {
	

	
	@Value("${from.email}")
	private String fromgmail;
	
	@Value("${from.password}")
	private String fromPassword;
	
	
	
	@Autowired
	private TwoFactorDao twoFactorDao;
	
	@Autowired
	private UserDao userDao;
	
	

	
	
	public void sendBookingConfirmation(Booking booking, Transaction transaction) throws DocumentException {
		String subject = "Booking Confirmation - Your Booking is confirmed ";
		String body ="Hi "+booking.getUserDetails().getCustomerFname()+" "+booking.getUserDetails().getCustomerLname()+",\n\nYour Booking is confirmed. Below are your booking details.\n"+
				"\nBooking Date: "+booking.getBookingDate()+
				"\nJourney Date: "+booking.getJourneyDate()+
				"\nSource City: "+booking.getSourceCities().getCityName()+
				"\nDestination City: "+booking.getDestinationCities().getCityName()+
				"\nNumber Of Seats Booked: "+booking.getNoOfSeats()+
				"\nBooking Amount: "+booking.getBookingAmount();				
		sendTicket(fromgmail,fromPassword,booking.getUserDetails().getCustomerEmail(),subject,body,booking,transaction);  
				
	}
	
	
	private static void writePdf(ByteArrayOutputStream outputStream, Booking booking, Transaction transaction) throws DocumentException {
		/*Code for pdf starts*/
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, outputStream);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		document.open();

        Paragraph p = new Paragraph();
        p.add("Thanks for booking your travel with Canada Tourism");
        p.setSpacingAfter(36f);
        p.setAlignment(Element.ALIGN_CENTER);
        document.add(p);

        Paragraph p2 = new Paragraph();
        p2.setSpacingAfter(36f);
        p2.add("Source: "+booking.getSourceCities().getCityName()); //no alignment

        document.add(p2);
        
        Paragraph p3 = new Paragraph();
        p3.setSpacingAfter(36f);
        p3.add("Destination: "+booking.getDestinationCities().getCityName()); //no alignment

        document.add(p3);
        
        Paragraph p4 = new Paragraph();
        p4.setSpacingAfter(36f);
        p4.add("Journey Date: "+booking.getJourneyDate()); //no alignment

        document.add(p4);
        
        
        Paragraph p5 = new Paragraph();
        p5.add("Booking Date: "+booking.getBookingDate()); //no alignment
        p5.setSpacingAfter(36f);
        document.add(p5);
        
        
        Paragraph p6 = new Paragraph();
        p6.add("No of Seats: "+booking.getNoOfSeats()); //no alignment
        p6.setSpacingAfter(36f);
        document.add(p6);
        
        Paragraph p9 = new Paragraph();
        p9.add("Amount Paid: "+transaction.getTransactionAmount()); 
        p9.setSpacingAfter(36f);
        document.add(p9);
        
        Paragraph p7= new Paragraph();
        p7.add("Card Number: XXXX XXXX XXXX "+transaction.getCardNumber().substring(11)); //no alignment
        p7.setSpacingAfter(36f);
        document.add(p7);
        
        Paragraph p8 = new Paragraph();
        p8.add("Happy Journey"); 
        p8.setSpacingAfter(36f);
        p8.setAlignment(Element.ALIGN_CENTER);
        document.add(p8);
       

        //close
        document.close();

		/*Code for pdf ends*/

		
	}



	public static void send(String from,String password,String to,String sub,String msg){  
        //Get properties object    		
        Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class",    
                  "javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");    
        props.put("mail.smtp.starttls.enable","true");
        //get Session   
        Session session = Session.getInstance(props,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication(from,password);  
         }    
        });    
        //compose message 
       
        try {    
         MimeMessage message = new MimeMessage(session);    
         message.addRecipient(javax.mail.Message.RecipientType.TO,new InternetAddress(to));    
         message.setSubject(sub);    
         message.setText(msg);    
         //send message  
         Transport.send(message);    
         System.out.println("message sent successfully");    
        } catch (MessagingException e) {throw new RuntimeException(e);}    
           
  }  
	
	
	


	
	
}
