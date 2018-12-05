package es.cqrs.view.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.cqrs.core.datasource.UserDataSource;
import es.cqrs.core.model.UserData;
import es.cqrs.core.response.UserResponse;

public class UserDataSourceMock implements UserDataSource{

	private List<UserData> repository;
	
	public UserDataSourceMock() {
		repository = new ArrayList<UserData>();
	}
	
	public int count() {
		return repository.size();
	}

	public UserResponse findAll() {
		return new UserResponse(repository, repository.size());
	}

	public void addOrUpdateInfo(UserData userData) {
		final Optional<UserData> user = existsUser(userData);
		if(user.isPresent()) {
			updateUser(user.get(), userData);
		}else {
			addUser(userData);
		}
	}

	public void removeUserData(UserData userData) {
		final Optional<UserData> user = existsUser(userData);
		if(user.isPresent()) {
			repository.remove(user.get());
		}
	}
	
	public UserData getUser(final int id) {
		return null;
	}
	
	private Optional<UserData> existsUser(final UserData userData) {
		final Optional<UserData> obj = repository.stream().findFirst().filter(user -> user.getId() == userData.getId());
		return obj;
	}

	private void updateUser(final UserData currentUser, final UserData newUser) {
		repository.remove(currentUser);
		addUser(newUser);
	}
	
	private void addUser(final UserData userData) {
		repository.add(userData);
	}
	
}
