package es.cqrs.kafka.consumer;

import java.util.Iterator;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.errors.WakeupException;

import es.cqrs.core.model.UserData;
import es.cqrs.kafka.dao.UserDataDao;
import es.cqrs.kafka.dao.impl.UserDataDaoImpl;
import es.cqrs.kafka.main.NotificationListener;

public class UserRemoveConsumer extends BaseConsumer<String, UserData> {

	private static final String TOPIC = "delete";
	private static final String CONSUMER_NAME = "delete-consumer";
	private UserDataDao userDataDao;
	
	public UserRemoveConsumer(final NotificationListener notification) {
		super(TOPIC, CONSUMER_NAME, notification);
		userDataDao = new UserDataDaoImpl();
	}

	@Override
	protected void executeConsumer(final ConsumerRecords<String, UserData> records) throws WakeupException {
		for(Iterator<ConsumerRecord<String, UserData>> it = records.iterator(); it.hasNext(); ) {
			final ConsumerRecord<String, UserData> record = it.next();
			final UserData userData = record.value();
			userDataDao.remove(userData);
			notification.writeNotification(log(userData));
		}
	}
	
	private String log(final Object object) {
		final String log = String.format("Remove succefull user data >>>> %s", object.toString());
		return log;
	}

}
