package es.cqrs.kafka.main;

import es.cqrs.kafka.manager.ConsumerManager;
import es.cqrs.kafka.manager.impl.ConsumerManagerImpl;

public class EntryPoint {

	public static void main(String [] args) {
	
		System.out.println("Load consumers user data.");
		final ConsumerManager consumerManager = new ConsumerManagerImpl();
		consumerManager.startConsumers();
	}
	
}
