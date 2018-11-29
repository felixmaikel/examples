package es.cqrs.core.datasource;

import es.cqrs.core.response.UserResponse;

public interface UserDataSource {

	int count();

	UserResponse findAll();

}
