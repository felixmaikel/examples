package es.cqrs.core.command;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import es.cqrs.core.exception.ApplicationException;

public class BaseCommand<K,T> {

	protected static final String topic = "test";
	private static final String PROPERTIES_FILE = "/kafka/config.properties";
	private Properties properties;
	
	public BaseCommand() {
		loadProperties();
	}
	
	private void loadProperties() {
		try {
			final Path path = Paths.get(getClass().getResource(PROPERTIES_FILE).toURI());
			properties = new Properties();
			properties.load(Files.newInputStream(path));
		}catch(URISyntaxException | IOException ex) {
			throw new ApplicationException("Error to load properties kafka connection.", ex);
		}
	}
	
	protected void send(final String topic, K key, T object) {
		final Producer<K, T> producer = new KafkaProducer<>(properties);
		final ProducerRecord<K, T> record = new ProducerRecord<K, T>(topic, key, object);
		producer.send(record);
		producer.close();
	}
}
