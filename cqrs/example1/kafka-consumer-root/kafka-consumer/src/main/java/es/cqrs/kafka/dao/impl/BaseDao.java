package es.cqrs.kafka.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.cqrs.core.db.ConnectionManager;
import es.cqrs.core.db.impl.ConnectionManagerImpl;
import es.cqrs.core.exception.ApplicationException;

public class BaseDao {

	private ConnectionManager connectionManager;
	
	public BaseDao() {
		connectionManager = ConnectionManagerImpl.getInstance();
	}
	
	protected void execute(final String query, final Object [] parameters) {
		try {
			final Connection connection = connectionManager.getConnection();
			final PreparedStatement statement = connection.prepareStatement(query);
			for(int i=0; i < parameters.length; i++) {
				statement.setObject(i + 1, parameters[i]);
			}
			statement.executeUpdate();
		}catch(SQLException ex) {
			throw new ApplicationException("Error to update user data.", ex);
		}
	}
}
