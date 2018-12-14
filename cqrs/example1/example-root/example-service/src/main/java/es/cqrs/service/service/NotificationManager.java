package es.cqrs.service.service;

public interface NotificationManager {

	void add(final NotificationObserver notificationObserver);
	void remove(final NotificationObserver notificationObserver);
	void startConsumer();
	void stopConsumer();
	void notifyChange(final String response);
	
}
