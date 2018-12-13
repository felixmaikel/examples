package es.cqrs.core.command;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import es.cqrs.core.actor.KafkaActor;

public class BaseCommand<K,T> extends KafkaActor {

	protected static final String topic = "test";
	
	public BaseCommand() {
		super();
	}
	
	
	protected void send(final String topic, K key, T object) {
		final Producer<K, T> producer = new KafkaProducer<>(properties);
		final ProducerRecord<K, T> record = new ProducerRecord<K, T>(topic, key, object);
		producer.send(record);
		producer.close();
	}
}
