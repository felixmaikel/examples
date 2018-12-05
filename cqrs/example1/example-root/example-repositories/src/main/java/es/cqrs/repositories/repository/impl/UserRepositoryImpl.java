package es.cqrs.repositories.repository.impl;

import java.util.List;

import es.cqrs.core.model.UserData;
import es.cqrs.repositories.dao.UserDao;
import es.cqrs.repositories.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {

	private UserDao userDao;
	
	public List<UserData> findAll() {
		return userDao.findAll();
	}

	public void addUser(final UserData userData) {
		
	}

	public void updateUser(final UserData userData) {
		
	}

}
