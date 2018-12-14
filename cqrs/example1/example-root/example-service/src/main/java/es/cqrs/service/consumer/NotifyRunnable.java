package es.cqrs.service.consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.apache.kafka.common.serialization.StringDeserializer;

import es.cqrs.core.actor.KafkaActor;
import es.cqrs.core.exception.ApplicationException;
import es.cqrs.service.service.NotificationManager;

public class NotifyRunnable extends KafkaActor implements Runnable {

	private static final String TEST_TOPIC = "test";
	private AtomicBoolean atomicBoolean;
	private NotificationManager notificationManager;
	private Consumer<String, String> consumer;
	
	public NotifyRunnable(final NotificationManager notificationManager) {
		this.notificationManager = notificationManager;
		this.atomicBoolean = new AtomicBoolean(false);
		consumer = new KafkaConsumer<>(properties, new StringDeserializer(), new StringDeserializer());
	}

	@Override
	public void run() {
		try {
			consumer.subscribe(Arrays.asList(TEST_TOPIC));
			while(!atomicBoolean.get()) {
				executeConsumer();
			}
		}catch(WakeupException ex) {
			if(!atomicBoolean.get()) {
				throw new ApplicationException("Error to consumer notify data.", ex);
			}
		}
	}
	
	public void stop() {
		atomicBoolean.set(true);
		consumer.wakeup();
	}
	
	private void executeConsumer() {
		final ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(10000));
		for(Iterator<ConsumerRecord<String, String>> iterator = records.iterator(); iterator.hasNext();) {
			final String response = iterator.next().value();
			notificationManager.notifyChange(response);
		}
	}

}
