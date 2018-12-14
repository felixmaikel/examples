package es.cqrs.kafka.consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;

import es.cqrs.core.actor.KafkaActor;
import es.cqrs.core.exception.ApplicationException;
import es.cqrs.kafka.producer.NotifyProducer;

public abstract class BaseConsumer<K, T> extends KafkaActor implements Runnable {

	protected final AtomicBoolean closed = new AtomicBoolean(false);
	protected KafkaConsumer<K, T> consumer;
	protected String topic;
	protected String name;
	
	protected BaseConsumer(final String topic, final String name) {
		super();
		this.topic = topic;
		this.name = name;
		consumer = new KafkaConsumer<K, T>(properties);
	}

	public void run() {
		try {
			consumer.subscribe(Arrays.asList(topic));
			while(!closed.get()) {
				final ConsumerRecords<K, T> records = consumer.poll(Duration.ofMillis(10000));
				if(!records.isEmpty()) {
					executeConsumer(records);
					notifyModelChange();
				}
			}
			
		}catch(WakeupException ex) {
			if( !closed.get() ) 
				throw new ApplicationException("Error to consumer user data.", ex);
		}
	}
	
	public void shutdown() {
		closed.set(true);
		consumer.wakeup();
	}
	
	protected abstract void executeConsumer(final ConsumerRecords<K, T> records) throws WakeupException;

	public String getName() {
		return name;
	}
	
	private void notifyModelChange() {
		final NotifyProducer producer = new NotifyProducer();
		producer.send();
	}
}
