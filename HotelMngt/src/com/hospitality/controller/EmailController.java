/** EmailController.java  Dec 8,17
*/


package com.hospitality.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.bo.EmailBO;
import com.hospitality.core.Email;

/**
* @author  Kishore
*/

@Controller
@RequestMapping("/email/")
public class EmailController extends commonController {
	
	@Autowired
	private EmailBO emailBO;
	
	@RequestMapping(value="showInbox",method = RequestMethod.GET)
	public ModelAndView showInbox(String emailId){
		List<Email> emailList = new ArrayList<>();
		try{
			emailList = emailBO.retrieveEmailListByEmailId(emailId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("EmailInbox", "emailList", emailList);
	}
	
	@RequestMapping(value="showComposeEmail",method = RequestMethod.GET)
	public ModelAndView showComposeEmail(){
		try{
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("ComposeEmail");
	}
	
//	@RequestMapping(value="showCreateEmail",method = RequestMethod.GET)
//	public ModelAndView showCreateEmail(){
//		try{
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return new ModelAndView("CreateEmail");
//	}
			
//	@RequestMapping(value="create",method = RequestMethod.POST)
//	public ModelAndView create(Email Email){
//		try{
//			EmailBO.create(Email);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return new ModelAndView("CreateEmail").addObject("Email", Email);
//	}
//	
//	@RequestMapping(value="retrieveEmailList",method = RequestMethod.GET)
//	public ModelAndView retrieveList(Email Email){
//		List<Email> EmailList = null;
//		try{
//			EmailList = EmailBO.retrieveList();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return new ModelAndView("EmailList").addObject("EmailList", EmailList);
//	}
	
	@RequestMapping(value="send",method = RequestMethod.POST)
	public ModelAndView sendEmail(Email email){
		try{
			emailBO.sendEmail(email);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("ComposeEmail");
	}
	
	
//	practiuce
	@RequestMapping(value="sendEmail",method = RequestMethod.GET)
	public ModelAndView create(){
		try{
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
				message.setFrom(new InternetAddress("balakishor420@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("dkishoremail@gmail.com"));
				message.setSubject("Testing Subject");
				message.setText("Dear Mail Crawler,"
					+ "\n\n No spam to my email, please!");

				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("ComposeEmail");
	}
	
}
