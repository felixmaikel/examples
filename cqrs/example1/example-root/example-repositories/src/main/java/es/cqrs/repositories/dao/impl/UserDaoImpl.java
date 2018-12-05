package es.cqrs.repositories.dao.impl;

import java.util.List;

import es.cqrs.core.model.UserData;
import es.cqrs.repositories.dao.UserDao;
import es.cqrs.repositories.dao.mapper.UserRowMapper;

public class UserDaoImpl extends BaseDao implements UserDao {

	public List<UserData> findAll() {
		final String query = "SELECT * FROM USERS";
		return list(query, new UserRowMapper());
	}

}
