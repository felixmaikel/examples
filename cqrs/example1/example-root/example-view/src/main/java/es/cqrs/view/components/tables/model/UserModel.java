package es.cqrs.view.components.tables.model;

import es.cqrs.core.model.UserData;

public class UserModel {

	private String value;
	private UserData userData;
	
	public UserModel(final String value, final UserData userData) {
		this.value = value;
		this.userData = userData;
	}

	public String getValue() {
		return value;
	}

	public UserData getUserData() {
		return userData;
	}
	
}
