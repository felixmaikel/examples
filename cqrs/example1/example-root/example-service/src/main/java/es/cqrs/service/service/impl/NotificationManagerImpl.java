package es.cqrs.service.service.impl;

import java.util.ArrayList;
import java.util.List;

import es.cqrs.service.consumer.ConsumerThread;
import es.cqrs.service.service.NotificationManager;
import es.cqrs.service.service.NotificationObserver;

public class NotificationManagerImpl implements NotificationManager {

	private static final String RESPONSE_OK = "OK";
	private List<NotificationObserver> observers;
	private static NotificationManager instance;
	private ConsumerThread consumer;
	
	private NotificationManagerImpl() {
		observers = new ArrayList<NotificationObserver>();
		consumer = new ConsumerThread(this);
	}
	
	public void add(final NotificationObserver notificationObserver) {
		observers.add(notificationObserver);
	}

	public void remove(final NotificationObserver notificationObserver) {
		observers.remove(notificationObserver);
	}
	
	public static NotificationManager getInstance() {
		if(instance == null) {
			instance = new NotificationManagerImpl();
		}
		return instance;
	}

	public void startConsumer() {
		consumer.start();
	}

	public void stopConsumer() {
		consumer.interrupt();
	}

	public void notifyChange(final String response) {
		if(RESPONSE_OK.equals(response)) {
			observers.stream().forEach(observer -> observer.notifyModelChange());
		}
	}

}
