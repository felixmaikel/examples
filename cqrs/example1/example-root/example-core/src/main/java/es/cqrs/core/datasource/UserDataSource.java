package es.cqrs.core.datasource;

import java.util.List;

import es.cqrs.core.model.UserData;
import es.cqrs.core.response.UserResponse;

public interface UserDataSource {

	int count();

	List<UserData> findAll();

	UserData getUser(final int id);
	
	void addOrUpdateInfo(final UserData userData);

	void removeUserData(UserData userData);

}
