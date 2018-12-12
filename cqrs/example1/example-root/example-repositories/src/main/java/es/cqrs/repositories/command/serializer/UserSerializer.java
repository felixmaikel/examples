package es.cqrs.repositories.command.serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import es.cqrs.core.exception.ApplicationException;
import es.cqrs.core.model.UserData;

public class UserSerializer implements Serializer<UserData> {

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		
	}

	@Override
	public byte[] serialize(String topic, UserData data) {
		try {
			if(data == null) {
				return null;
			}
			
			final ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
			final ObjectOutputStream outputStream = new ObjectOutputStream(byteOutputStream);
			outputStream.writeObject(data);
			outputStream.flush();
			final byte [] object = byteOutputStream.toByteArray();
			byteOutputStream.close();
			return object;
		}catch(IOException ex) {
			throw new ApplicationException("Error to serializer dto.", ex);
		}
	}

	@Override
	public void close() {
		
	}

}
