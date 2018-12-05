package es.cqrs.core.datasource;

import es.cqrs.core.model.UserData;
import es.cqrs.core.response.UserResponse;

public interface UserDataSource {

	int count();

	UserResponse findAll();

	UserData getUser(final int id);
	
	void addOrUpdateInfo(final UserData userData);

	void removeUserData(UserData userData);

}
