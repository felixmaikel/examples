package es.cqrs.kafka.manager.impl;

import java.util.ArrayList;
import java.util.List;

import es.cqrs.core.model.UserData;
import es.cqrs.kafka.consumer.BaseConsumer;
import es.cqrs.kafka.consumer.UserAddConsumer;
import es.cqrs.kafka.consumer.UserUpdateConsumer;
import es.cqrs.kafka.manager.ConsumerManager;

public class ConsumerManagerImpl implements ConsumerManager {

	private static final String THREAD_GROUP_NAME = "consumerThreadGroup";
	private List<BaseConsumer<String, UserData>> consumers;
	private ThreadGroup consumerThreadGroup;
	
	public ConsumerManagerImpl() {
		consumers = new ArrayList<BaseConsumer<String, UserData>>();
		consumerThreadGroup = new ThreadGroup(THREAD_GROUP_NAME);
		loadConsumers();
	}
	
	public void startConsumers() {
		for(BaseConsumer<String, UserData> consumer : consumers) {
			final Thread thread = new Thread(consumerThreadGroup, consumer, consumer.getName());
			thread.start();
		}
	}

	private void loadConsumers() {
		consumers.add(new UserAddConsumer());
		consumers.add(new UserUpdateConsumer());
	}
}
