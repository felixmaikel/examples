package es.cqrs.repositories.repository.impl;

import java.util.List;

import es.cqrs.core.model.UserData;
import es.cqrs.repositories.command.UserCommand;
import es.cqrs.repositories.dao.UserQuery;
import es.cqrs.repositories.dao.impl.UserQueryImpl;
import es.cqrs.repositories.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {

	private static final String UPDATE_USER = "update";
	private static final String UPDATE_KEY = "update.user";
	private static final String CREATE_USER = "create";
	private static final String CREATE_KEY = "create.user";
	private UserQuery userQuery;
	
	public UserRepositoryImpl() {
		userQuery = new UserQueryImpl();
	}
	
	public List<UserData> findAll() {
		return userQuery.findAll();
	}

	public void addUser(final UserData userData) {
		final UserCommand userCommand = new UserCommand.Builder().withTopic(CREATE_USER).withKey(CREATE_KEY).withDto(userData).build();
		userCommand.send();
	}

	public void updateUser(final UserData userData) {
		final UserCommand userCommand = new UserCommand.Builder().withTopic(UPDATE_USER).withKey(UPDATE_KEY).withDto(userData).build();
		userCommand.send();
	}

}
