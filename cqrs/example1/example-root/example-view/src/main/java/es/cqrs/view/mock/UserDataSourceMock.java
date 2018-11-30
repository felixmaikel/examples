package es.cqrs.view.mock;

import java.util.ArrayList;
import java.util.List;

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
		if(existsUser(userData)) {
			updateUser(userData);
		}else {
			addUser(userData);
		}
	}

	public void removeUserData(UserData userData) {
		if(existsUser(userData)) {
			final int position = position(userData);
			repository.remove(position);
		}
	}
	
	private boolean existsUser(final UserData userData) {
		return false;
	}

	private void updateUser(final UserData userData) {
		
	}
	
	private void addUser(final UserData userData) {
		
	}
	
	private int position(final UserData userData) {
		return 0;
	}
}
