package es.cqrs.kafka.main;

import es.cqrs.kafka.manager.ConsumerManager;
import es.cqrs.kafka.manager.impl.ConsumerManagerImpl;

public class EntryPoint {

	public static void main(String [] args) {
	
		final Console console = new Console();
		final ConsumerManager consumerManager = new ConsumerManagerImpl(console);
		consumerManager.startConsumers();
	}
	
}
