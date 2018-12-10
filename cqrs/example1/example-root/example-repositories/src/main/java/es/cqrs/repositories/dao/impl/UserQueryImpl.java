package es.cqrs.repositories.dao.impl;

import java.util.List;

import es.cqrs.core.model.UserData;
import es.cqrs.repositories.dao.UserQuery;
import es.cqrs.repositories.dao.mapper.UserRowMapper;

public class UserQueryImpl extends BaseQuery implements UserQuery {

	public List<UserData> findAll() {
		final String query = "SELECT * FROM USER_TB";
		return list(query, new UserRowMapper());
	}

}
