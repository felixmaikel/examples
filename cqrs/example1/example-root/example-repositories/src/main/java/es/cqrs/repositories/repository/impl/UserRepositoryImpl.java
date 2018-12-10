package es.cqrs.repositories.repository.impl;

import java.util.List;

import es.cqrs.core.model.UserData;
import es.cqrs.repositories.dao.UserQuery;
import es.cqrs.repositories.dao.impl.UserQueryImpl;
import es.cqrs.repositories.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {

	private UserQuery userQuery;
	
	public UserRepositoryImpl() {
		userQuery = new UserQueryImpl();
	}
	
	public List<UserData> findAll() {
		return userQuery.findAll();
	}

	public void addUser(final UserData userData) {
		
	}

	public void updateUser(final UserData userData) {
		
	}

}
