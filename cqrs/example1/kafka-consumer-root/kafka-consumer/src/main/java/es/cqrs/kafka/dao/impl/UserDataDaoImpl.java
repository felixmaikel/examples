package es.cqrs.kafka.dao.impl;

import es.cqrs.core.model.UserData;
import es.cqrs.kafka.dao.UserDataDao;

public class UserDataDaoImpl extends BaseDao implements UserDataDao {

	public void update(final UserData userData) {
		final Object [] parameters = new Object[]{userData.getUsername(), userData.getName(), userData.getLastname(),
				userData.getEmail(), userData.getStatus().getId(), userData.getId()};
		final String query = "UPDATE USER_TB SET USERNAME = ?, NAME = ?, LASTNAME = ?, EMAIL = ?, STATUS = ? WHERE ID = ?";
		execute(query, parameters);
	}

	public void add(UserData userData) {
		final Object [] parameters = new Object[]{userData.getUsername(), userData.getName(), userData.getLastname(),
				userData.getEmail(), userData.getStatus().getId()};
		final String query = "INSERT INTO USER_TB (USERNAME, NAME, LASTNAME, EMAIL, STATUS) VALUES (?,?,?,?,?)";
		execute(query, parameters);
	}

}
