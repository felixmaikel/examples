package es.cqrs.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import es.cqrs.core.actor.KafkaActor;

public class NotifyProducer extends KafkaActor {

	private static final String TEST_TOPIC = "test";
	private static final String RESPONSE_KEY = "notify-change";
	private static final String RESPONSE_OK = "OK";
	
	public NotifyProducer() {
		super();
	}
	
	public void send() {
		final Producer<String, String> producer = new KafkaProducer<String, String>(properties, new StringSerializer(),
				new StringSerializer());
		final ProducerRecord<String, String> record = new ProducerRecord<String, String>(TEST_TOPIC, RESPONSE_KEY, RESPONSE_OK);
		producer.send(record);
		producer.close();
	}

}
