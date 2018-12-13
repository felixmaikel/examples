package es.cqrs.kafka.consumer.deserializer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import es.cqrs.core.exception.ApplicationException;
import es.cqrs.core.model.UserData;

public class UserDeserializer implements Deserializer<UserData> {

	public void configure(Map<String, ?> configs, boolean isKey) {
		
	}

	public UserData deserialize(String topic, byte[] data) {
		try {
			final InputStream inputStream = new ByteArrayInputStream(data);
			final ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			final UserData userData = (UserData)objectInputStream.readObject();
			objectInputStream.close();
			return userData;
		}catch(IOException | ClassNotFoundException ex) {
			throw new ApplicationException("Error to deserializer user data object.", ex);
		}
	}

	public void close() {
		
	}

}
