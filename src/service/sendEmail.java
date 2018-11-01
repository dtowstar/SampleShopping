package service;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
public class sendEmail {
	public static void send() {
		// Get properties object
		System.out.println("恭喜有呼叫到email但我不想測試");
		/*String from = "kencs16358@gmail.com";
		String password = "ken12345678";
		String to = "接收者Email";
		String sub = "輸入標題";
		String msg = "輸入內文";
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
		}*/
	}
}

