package com.m2m.onousc.business.utils;



import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



/**
 * A utility class for sending e-mail with attachment.
 * @author www.codejava.net
 *
 */
public class EmailUtility {
	
	public static void sendEmail(String host, String port,
			final String userName, final String password, 
			String recipient []	, String subject, String message, File attachFile)
					throws AddressException, MessagingException, GeneralSecurityException {
		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.user", userName);
		properties.put("mail.password", password);
		properties.put("mail.smtp.ssl.trust", "*");
	//	 MailSSLSocketFactory sf = new MailSSLSocketFactory();
//		  sf.setTrustAllHosts(true);
//		  properties.put("mail.smtp.ssl.socketFactory", sf);
		// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};
		Session session = Session.getInstance(properties, auth);

		// creates a new e-mail message
		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(userName));
		
		
		
		       
		 
		InternetAddress[] toAddresses = new InternetAddress[recipient.length];
		for (int i = 0; i < recipient.length; i++)
			toAddresses[i] = new InternetAddress(recipient[i]);
		
	//	InternetAddress[] toAddresses = { new InternetAddress(recipient) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject);
		msg.setSentDate(new Date());

		// creates message part
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(message, "text/html");

		// creates multi-part
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// adds attachments
		if (attachFile != null) {
			MimeBodyPart attachPart = new MimeBodyPart();

			try {
				attachPart.attachFile(attachFile);
			} catch (IOException ex) {
				ex.printStackTrace();
			}

			multipart.addBodyPart(attachPart);
		}

		// sets the multi-part as e-mail's content
		msg.setContent(multipart);

		// sends the e-mail
		Transport.send(msg);

	}
}