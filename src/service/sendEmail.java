package service;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

import DAO.usersDAO;//8
import DAO.productsDAO;//2

public class sendEmail {
	public static void send(String PD_ID,String User_ID) {
		// Get properties object

		String from = "kencs16358@gmail.com";
		String password = "ken12345678";
		String PD_Name=productsDAO.getPD_Infor(PD_ID,"PD_Name");
		String email=usersDAO.getUser_Infor_With_UserID(User_ID,"User_Email");
		String to = email;
		String sub = "來新貨了";
		String msg = String.format("您訂閱的商品"+PD_Name+"已有新貨");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		// get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});
		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setText(msg);
			// send message
			Transport.send(message);
			System.out.println("message sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}

