package es.cqrs.kafka.services;

import es.cqrs.core.model.UserData;

public interface EmailSenderService {

	void sendEmail(UserData userData);

}
