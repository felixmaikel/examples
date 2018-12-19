package es.cqrs.kafka.consumer;

import java.util.Iterator;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.errors.WakeupException;

import es.cqrs.core.model.UserData;
import es.cqrs.kafka.main.NotificationListener;
import es.cqrs.kafka.services.EmailSenderService;
import es.cqrs.kafka.services.impl.EmailSenderServiceImpl;

public class EmailConsumer extends BaseConsumer<String, UserData> {

	private static final String TOPIC = "email";
	private static final String NAME = "email-name";
	private EmailSenderService emailSenderEmail;
	
	public EmailConsumer(final NotificationListener notification) {
		super(TOPIC, NAME, notification);
		emailSenderEmail = new EmailSenderServiceImpl();
	}

	@Override
	protected void executeConsumer(final ConsumerRecords<String, UserData> records) throws WakeupException {
		for(Iterator<ConsumerRecord<String, UserData>> it = records.iterator(); it.hasNext();) {
			final ConsumerRecord<String, UserData> record = it.next();
			final UserData userData = record.value();
			sendEmail(userData);
		}
	}
	
	private void sendEmail(final UserData userData) {
		emailSenderEmail.sendEmail(userData);
	}

}
