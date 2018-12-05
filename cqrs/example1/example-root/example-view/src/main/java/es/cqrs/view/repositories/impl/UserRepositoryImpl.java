package es.cqrs.view.repositories.impl;

import java.util.List;

import es.cqrs.core.datasource.UserDataSource;
import es.cqrs.core.model.UserData;
import es.cqrs.view.mock.UserDataSourceMock;
import es.cqrs.view.repositories.UserRepository;

public class UserRepositoryImpl implements UserRepository {

	private UserDataSource dataSource;
	
	public UserRepositoryImpl() {
		dataSource = new UserDataSourceMock();
	}
	
	@Override
	public List<UserData> findAll() {
		return dataSource.findAll();
	}

	@Override
	public void addOrUpdateInfo(UserData userData) {
		dataSource.addOrUpdateInfo(userData);
	}

}
