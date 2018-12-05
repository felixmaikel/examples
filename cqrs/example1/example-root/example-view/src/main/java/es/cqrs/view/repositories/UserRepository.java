package es.cqrs.view.repositories;

import java.util.List;

import es.cqrs.core.model.UserData;

public interface UserRepository {

	List<UserData> findAll();

	void addOrUpdateInfo(final UserData userData);

}
