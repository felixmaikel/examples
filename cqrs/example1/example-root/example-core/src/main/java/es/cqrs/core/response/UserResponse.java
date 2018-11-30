package es.cqrs.core.response;

import java.util.List;

import es.cqrs.core.model.UserData;

public class UserResponse {

	private Integer count;
	private List<UserData> users;
	
	public UserResponse(List<UserData> users, Integer count) {
		this.users = users;
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public List<UserData> getUsers() {
		return users;
	}

}
