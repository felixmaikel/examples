package es.cqrs.kafka.consumer;

import java.util.Iterator;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.errors.WakeupException;

import es.cqrs.core.model.UserData;
import es.cqrs.kafka.dao.UserDataDao;
import es.cqrs.kafka.dao.impl.UserDataDaoImpl;
import es.cqrs.kafka.main.NotificationListener;

public class UserAddConsumer extends BaseConsumer<String, UserData> {

	private static final String CREATE_TOPIC ="create";
	private static final String CONSUMER_NAME = "create-consumer";
	private UserDataDao userDataDao;
	
	public UserAddConsumer(final NotificationListener notification) {
		super(CREATE_TOPIC, CONSUMER_NAME, notification);
		userDataDao = new UserDataDaoImpl();
	}

	@Override
	protected void executeConsumer(final ConsumerRecords<String, UserData> records) throws WakeupException {
		for (Iterator<ConsumerRecord<String, UserData>> it = records.iterator(); it.hasNext();) {
			final ConsumerRecord<String, UserData> record = (ConsumerRecord<String, UserData>) it.next();
			final UserData userData = record.value();
			userDataDao.add(userData);
			notification.writeNotification(log(userData));
		}
	}

	private String log(final Object object) {
		final String log = String.format("Insert succefull user data >>>> %s", object.toString());
		return log;
	}
}
