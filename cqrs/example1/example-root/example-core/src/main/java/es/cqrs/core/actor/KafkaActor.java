package es.cqrs.core.actor;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import es.cqrs.core.exception.ApplicationException;

public class KafkaActor {

	private static final String PROPERTIES_FILE = "/kafka/config.properties";
	protected Properties properties;
	
	public KafkaActor() {
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
}
