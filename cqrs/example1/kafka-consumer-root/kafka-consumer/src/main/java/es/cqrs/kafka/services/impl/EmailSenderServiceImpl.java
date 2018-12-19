package es.cqrs.kafka.services.impl;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import es.cqrs.core.model.UserData;
import es.cqrs.kafka.services.EmailSenderService;

public class EmailSenderServiceImpl implements EmailSenderService {

	private static final String SMTP_HOST_PROPERTY = "mail.smtp.host";
	private static final String SMTP_STARTTLS_ENABLE_PROPERTY = "mail.smtp.starttls.enable";
	private static final String SMTP_PORT_PROPERTY = "mail.smtp.port";
	private static final String MAIL_SENDER_PROPERTY = "mail.smtp.mail.sender";
	private static final String SUBJECT_EMAIL = "Notificación de usuario creado.";
	private static final String SMTP_TRANSPORT = "smtp";
	private static final String SMTP_USER_PROPERTY = "mail.smtp.user";
	private static final String SMTP_AUTH_PROPERTY = "mail.smtp.auth";
	private static final String PASSWORD_PROPERTY = "password";
	
	private static final String SMTP_HOST_VALUE = "smtp.gmail.com";
	private static final Boolean SMTP_STARTTLS_ENABLE_VALUE = Boolean.TRUE;
	private static final String SMTP_PORT_VALUE = "587";
	private static final String MAIL_SENDER_VALUE = "felix.maikel@gmail.com";
	private static final String SMTP_USER_VALUE = "felix.maikel";
	private static final Boolean SMTP_AUTH_VALUE = Boolean.TRUE;
	private static final String PASSWORD_VALUE = "kyjozkodxycmwqzs";
	
	private static final String PRESENTATION_TEXT = "Hola %s \r\n";
	private static final String WELCOME_TEXT = "Te damos la bienvenida al sistema y te informamos que tu cuenta está activa. \r\n";
	private static final String TITLE_ACCOUNT_INFO = "Datos de la cuenta: \r\n";
	private static final String USER_NAME = "Usuario: %s \r\n";
	private static final String PASSWORD = "Contraseña: %s \r\n";
	private static final String GOODBY_TEXT = "Saludos, sistema de gestión de usuarios.";
	
	public EmailSenderServiceImpl() {
		
	}
	
	@Override
	public void sendEmail(final UserData userData) {
		try {
			final Properties properties = configurationEmail();
			final String message = compositeMessage(userData);
			final Address fromAddress = new InternetAddress(MAIL_SENDER_VALUE);
			final Address toAddress = new InternetAddress(userData.getEmail());			
			final Authenticator authenticator = new Authenticator() {

				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(MAIL_SENDER_VALUE, PASSWORD_VALUE);
				}
				
			};
						
			final Session session = Session.getInstance(properties, authenticator);
			final MimeMessage mimeMessage = new MimeMessage(session);
			mimeMessage.setFrom(fromAddress);
			mimeMessage.addRecipient(Message.RecipientType.TO, toAddress);
			mimeMessage.setSubject(SUBJECT_EMAIL);
			mimeMessage.setText(message);
			final Transport transport = session.getTransport(SMTP_TRANSPORT);
			transport.connect(properties.getProperty(SMTP_HOST_PROPERTY), properties.getProperty(MAIL_SENDER_VALUE), properties.getProperty(PASSWORD_PROPERTY));
			transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
			transport.close();
		}catch(MessagingException ex) {
			ex.printStackTrace();
		}
	}

	private Properties configurationEmail() {
		final Properties properties = new Properties();
		properties.put(SMTP_HOST_PROPERTY, SMTP_HOST_VALUE);
		properties.put(SMTP_PORT_PROPERTY, SMTP_PORT_VALUE);
		properties.put(SMTP_STARTTLS_ENABLE_PROPERTY, SMTP_STARTTLS_ENABLE_VALUE);
		properties.put(SMTP_AUTH_PROPERTY, SMTP_AUTH_VALUE);
		
		return properties;
	}
	
	private String compositeMessage(final UserData userData) {
		final StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format(PRESENTATION_TEXT, userData.getName())).append(WELCOME_TEXT)
		.append(TITLE_ACCOUNT_INFO).append(String.format(USER_NAME, userData.getUsername()))
		.append(String.format(PASSWORD, userData.getPassword())).append(GOODBY_TEXT);
		
		return stringBuilder.toString();
	}
}
