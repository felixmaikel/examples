package es.cqrs.kafka.main;

public interface NotificationListener {

	void writeNotification(final String notification);
}
