package es.cqrs.view.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.cqrs.core.datasource.UserDataSource;
import es.cqrs.core.model.StatusAccount;
import es.cqrs.core.model.UserData;

public class UserDataSourceMock implements UserDataSource{

	private List<UserData> repository;
	
	public UserDataSourceMock() {
		repository = new ArrayList<UserData>();
		loadUsers();
	}
	
	public int count() {
		return repository.size();
	}

	public List<UserData> findAll() {
		return repository;
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
	
	private void loadUsers() {
		final UserData user1 = new UserData(1, "User 1", "User 1", "User 1", "User1@gmail.com", StatusAccount.ENABLE_ACCOUNT);
		final UserData user2 = new UserData(2, "User 2", "User 2", "User 2", "User2@gmail.com", StatusAccount.LOCK_ACCOUNT);
		final UserData user3 = new UserData(3, "User 3", "User 3", "User 3", "User3@gmail.com", StatusAccount.ENABLE_ACCOUNT);
		
		repository.add(user1);
		repository.add(user2);
		repository.add(user3);
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
