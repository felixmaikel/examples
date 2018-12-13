package es.cqrs.kafka.consumer;

import java.util.Iterator;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.errors.WakeupException;

import es.cqrs.core.model.UserData;
import es.cqrs.kafka.dao.UserDataDao;
import es.cqrs.kafka.dao.impl.UserDataDaoImpl;

public class UserUpdateConsumer extends BaseConsumer<String, UserData> {

	private static final String UPDATE_TOPIC = "update";
	private static final String CONSUMER_NAME = "update-consumer";
	private UserDataDao userDataDao;
		
	public UserUpdateConsumer() {
		super(UPDATE_TOPIC, CONSUMER_NAME);
		this.userDataDao = new UserDataDaoImpl();
	}

	@Override
	protected void executeConsumer(final ConsumerRecords<String, UserData> records) throws WakeupException {
		for (Iterator<ConsumerRecord<String, UserData>> it = records.iterator(); it.hasNext();) {
			final ConsumerRecord<String, UserData> record = (ConsumerRecord<String, UserData>) it.next();
			final UserData userData = record.value();
			userDataDao.update(userData);
		}
	}

}
