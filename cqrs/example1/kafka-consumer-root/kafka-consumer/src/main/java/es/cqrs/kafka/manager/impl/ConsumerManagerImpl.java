package es.cqrs.kafka.manager.impl;

import java.util.ArrayList;
import java.util.List;

import es.cqrs.core.model.UserData;
import es.cqrs.kafka.consumer.BaseConsumer;
import es.cqrs.kafka.consumer.UserAddConsumer;
import es.cqrs.kafka.consumer.UserRemoveConsumer;
import es.cqrs.kafka.consumer.UserUpdateConsumer;
import es.cqrs.kafka.main.NotificationListener;
import es.cqrs.kafka.manager.ConsumerManager;

public class ConsumerManagerImpl implements ConsumerManager {

	private static final String THREAD_GROUP_NAME = "consumerThreadGroup";
	private List<BaseConsumer<String, UserData>> consumers;
	private ThreadGroup consumerThreadGroup;
	
	public ConsumerManagerImpl(final NotificationListener notification) {
		consumers = new ArrayList<BaseConsumer<String, UserData>>();
		consumerThreadGroup = new ThreadGroup(THREAD_GROUP_NAME);
		loadConsumers(notification);
	}
	
	public void startConsumers() {
		for(BaseConsumer<String, UserData> consumer : consumers) {
			final Thread thread = new Thread(consumerThreadGroup, consumer, consumer.getName());
			thread.start();
		}
	}

	private void loadConsumers(final NotificationListener notification) {
		notification.writeNotification("Load consumers user data.");
		consumers.add(new UserAddConsumer(notification));
		notification.writeNotification("Load UserAddConsumer >>>> OK");
		consumers.add(new UserUpdateConsumer(notification));
		notification.writeNotification("Load UserUpdateConsumer >>>> OK");
		consumers.add(new UserRemoveConsumer(notification));
		notification.writeNotification("Load UserRemoveConsumer >>>> OK");
	}
}
