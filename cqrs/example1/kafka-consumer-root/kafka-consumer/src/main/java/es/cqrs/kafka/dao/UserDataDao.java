package es.cqrs.kafka.dao;

import es.cqrs.core.model.UserData;

public interface UserDataDao {

	void update(UserData userData);

	void add(UserData userData);

}
