import java.util.*;
import java.net.*;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class MailToTest {

    public static void main(String[] args){

	String mailTo = "reitsma.mischa@gmail.com";
	String mailFrom = "teqn0x@gmail.com";
	
	String host = "localhost";
	
	Properties properties = System.getProperties();
	
	properties.setProperty("mail.smtp.host",host);
	
	Session session = Session.getDefaultInstance(properties);
	
	try{
	    MimeMessage message = new MimeMessage(session);
	    message.setFrom(new InternetAddress(mailFrom));
	    message.addRecipient(Message.RecipientType.TO,new InternetAddress(mailTo));
	    message.setSubject("Just a test to mail from a Java App");
	    message.setText("So, this is just a test to mail from a java app. If this works I can always adjust it to take in a text using an BufferedReader and write the input to a string.");
	    Transport.send(message);
	    System.out.println("Message sent successfully...");
	}
	catch (MessagingException mex){
	    mex.printStackTrace();
	}
	
    }

}
