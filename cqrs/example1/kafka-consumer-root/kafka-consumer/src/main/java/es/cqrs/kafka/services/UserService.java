package es.cqrs.kafka.services;

import es.cqrs.core.model.UserData;

public interface UserService {

	void addUser(final UserData userData);

}
