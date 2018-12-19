package es.cqrs.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import es.cqrs.core.actor.KafkaActor;
import es.cqrs.core.model.UserData;

public class EmailProducer extends KafkaActor {

	private static final String TOPIC = "email";
	private static final String EMAIL_KEY = "email_key";
	
	public EmailProducer() {
		super();
	}
	
	public void send(final UserData userData) {
		final Producer<String, UserData> producer = new KafkaProducer<>(properties);
		final ProducerRecord<String, UserData> record = new ProducerRecord<String, UserData>(TOPIC, EMAIL_KEY, userData);
		producer.send(record);
		producer.close();
	}

}
