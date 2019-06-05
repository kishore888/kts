/** EmailBOImpl.java  Dec 31,17
*/

package com.hospitality.boimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.bo.EmailBO;
import com.hospitality.core.Email;
import com.hospitality.dao.EmailDAO;
import com.sun.mail.pop3.POP3Store;

/**
* @author  Kishore
*/

@Service("EmailBO")
@Scope(value="prototype")
public class EmailBOImpl implements EmailBO{

	@Autowired
	private EmailDAO EmailDAO;
	
	@Override
	public void create(Email Email) {
		try{
			if(StringUtils.isNotBlank(Email.getEmailId())){
				EmailDAO.update(Email);
			}else{
				EmailDAO.create(Email);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<Email> retrieveList() {
		List<Email> EmailList = null;
		try{
			EmailList = EmailDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return EmailList;
	}

	@Override
	public List<Email> retrieveEmailListByEmailId(String emailId) throws Exception {
		List<Email> emailList = new ArrayList<>();
		try{
//			String host = "smtp.gmail.com";
//			String mailStoreType = "pop3";  
//			String username= "dkishoremail@gmail.com";  
//			String password= "kismissavitrikis$123";
//			receiveEmail(host, mailStoreType, username, password); 
			
			emailList = EmailDAO.retrieveEmailListByEmailId(emailId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return emailList;
	}
	
	public static void receiveEmail(String pop3Host, String storeType, String user, String password) {  
		try {  
			   //1) get the session object  
			   Properties properties = new Properties();  
			   properties.put("mail.pop3.host", pop3Host);  
			   Session emailSession = Session.getDefaultInstance(properties);  
			     
			   //2) create the POP3 store object and connect with the pop server  
			   POP3Store emailStore = (POP3Store) emailSession.getStore(storeType);  
			   emailStore.connect(user, password);  
			  
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
		  
		} catch (NoSuchProviderException e) {e.printStackTrace();}   
		catch (MessagingException e) {e.printStackTrace();}  
		catch (IOException e) {e.printStackTrace();}  
	}

	@Override
	public void sendEmail(Email email) throws Exception {
		try{
			String from = email.getFrom();
			String to = email.getTo();
			String subject = email.getSubject();
			String text = email.getMessage();
			
			email.setStatus("UNDER PROCESS");
			if(StringUtils.isNotBlank(email.getEmailId())){
				EmailDAO.update(email);
			}else{
				EmailDAO.create(email);
			}
			
			
			final String username = "balakishor420@gmail.com";
			final String password = "kismissavitrikis$123";

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
				message.setSubject(subject);
				message.setText(text);

				Transport.send(message);

				System.out.println("Done");
				
				email.setFrom(from);
				email.setStatus("SENT");
				if(StringUtils.isNotBlank(email.getEmailId())){
					EmailDAO.update(email);
				}else{
					EmailDAO.create(email);
				}

			} catch (MessagingException e) {
				email.setStatus("FAILED");
				if(StringUtils.isNotBlank(email.getEmailId())){
					EmailDAO.update(email);
				}else{
					EmailDAO.create(email);
				}
				throw new RuntimeException(e);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	} 

}
