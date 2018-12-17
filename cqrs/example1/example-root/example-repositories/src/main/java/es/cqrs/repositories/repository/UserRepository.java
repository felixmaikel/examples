package es.cqrs.repositories.repository;

import java.util.List;

import es.cqrs.core.model.UserData;

public interface UserRepository {

	List<UserData> findAll();

	void addUser(final UserData userData);

	void updateUser(final UserData userData);

	void remove(final UserData userData);

}
