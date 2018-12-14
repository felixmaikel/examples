package es.cqrs.repositories.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import es.cqrs.core.exception.ApplicationException;
import es.cqrs.core.model.StatusAccount;
import es.cqrs.core.model.UserData;

public class UserRowMapper implements RowMapper<UserData> {

	private static String ID = "ID";
	private static String USERNAME = "USERNAME";
	private static String NAME = "NAME";
	private static String LASTNAME = "LASTNAME";
	private static String EMAIL = "EMAIL";
	private static String STATUS = "STATUS";
	
	public UserData toMapper(final ResultSet resultSet) {
		try {
			final int status = resultSet.getInt(STATUS);
			return new UserData(resultSet.getInt(ID), resultSet.getString(USERNAME), resultSet.getString(NAME), 
					resultSet.getString(LASTNAME), resultSet.getString(EMAIL), definedStatus(status));
		}catch(SQLException ex) {
			throw new ApplicationException("Error to the execute query.", ex);
		}
	}

	private StatusAccount definedStatus(final int status) {
		final StatusAccount statusAccount = StatusAccount.value(status);
		return statusAccount;
	}
}
