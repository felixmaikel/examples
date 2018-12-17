package es.cqrs.kafka.dao;

import es.cqrs.core.model.UserData;

public interface UserDataDao {

	void update(final UserData userData);

	void add(final UserData userData);

	void remove(final UserData userData);

}
