package es.cqrs.service.consumer;

import es.cqrs.service.service.NotificationManager;

public class ConsumerThread extends Thread {

	private static final String THREAD_NAME = "notify-thread";
	
	public ConsumerThread(final NotificationManager notificationManager) {
		super(new NotifyRunnable(notificationManager), THREAD_NAME);
	}

}
