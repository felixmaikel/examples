package es.cqrs.kafka.main;

public class Console implements NotificationListener {

	public Console() {
		
	}
	
	@Override
	public void writeNotification(final String notification) {
		System.out.println(notification);
	}

}
