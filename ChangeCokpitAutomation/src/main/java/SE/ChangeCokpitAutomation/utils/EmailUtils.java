package SE.ChangeCokpitAutomation.utils;

import java.util.Properties;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailUtils {

	public static void sendFailureMail(String testName, String reason) {

		final String username = "your-email@outlook.com";

		final String password = "app-password";

		Properties props = new Properties();

		props.put("mail.smtp.auth", "true");

		props.put("mail.smtp.starttls.enable", "true");

		props.put("mail.smtp.host", "smtp.office365.com");

		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(username));

			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("swapnil.kedar.ext@siemens-energy.com"));

			message.setSubject("Automation Failure Alert");

			message.setText("Test Failed : " + testName + "\n\nReason : " + reason);

			Transport.send(message);

			System.out.println("Failure Email Sent");

		} catch (MessagingException e) {

			e.printStackTrace();
		}
	}
}