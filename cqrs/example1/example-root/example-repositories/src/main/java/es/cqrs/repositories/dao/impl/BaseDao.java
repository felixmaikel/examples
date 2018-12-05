package es.cqrs.repositories.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.cqrs.core.exception.ApplicationException;
import es.cqrs.repositories.dao.mapper.RowMapper;

public class BaseDao {

	private static final String PATH_DRIVER = "org.sqlite.JDBC";
	private static final String URL = "jdbc:sqlite:${path}\\userdb";
	private Connection connection;
	
	public BaseDao() {
		
	}
	
	protected Connection getConnection() {
		try {
			if(connection == null) {
				Class.forName(PATH_DRIVER);
				final String temp = System.getProperty("java.io.tmpdir");
				final String url = URL.replace("${path}", temp);
				connection = DriverManager.getConnection(url);
			}
			return connection;
		}catch(ClassNotFoundException ex) {
			throw new ApplicationException("Error to load driver class.", ex);
		}catch(SQLException ex) {
			throw new ApplicationException("Error to load data base.", ex);
		}
	}
	
	protected <T> T findOne(final String query, Object [] parameters, RowMapper<T> rowMapper) {
		try {
			final PreparedStatement statement = createStatement(query, parameters);
			final ResultSet resultSet = statement.executeQuery();
			
			return rowMapper.toMapper(resultSet);
		}catch(SQLException ex) {
			throw new ApplicationException("Error to the execute query.", ex);
		}
	}
	
	protected <T> T findOne(final String query, final RowMapper<T> rowMapper) {
		return findOne(query, new Object[]{}, rowMapper);
	}
	
	protected <T> List<T> list(final String query, Object [] parameters, RowMapper<T> rowMapper) {
		try {
			final PreparedStatement statement = createStatement(query, parameters);
			final ResultSet resultSet = statement.executeQuery();
			final List<T> list = new ArrayList<T>();
			while(resultSet.next()) {
				final T object = rowMapper.toMapper(resultSet);
				list.add(object);
			}
			return list;
		}catch(SQLException ex) {
			throw new ApplicationException("Error to the execute query.", ex);
		}
	}
	
	protected <T> List<T> list(final String query, final RowMapper<T> rowMapper) {
		return list(query, new Object[]{}, rowMapper);
	}
	
	private PreparedStatement createStatement(final String query, final Object [] parameters) {
		try {
			final PreparedStatement statement = connection.prepareStatement(query);
			for(int i=0; i<parameters.length; i++) {
				statement.setObject(i + 1, parameters[i]);
			}
			return statement;
		}catch(SQLException ex) {
			throw new ApplicationException("Error to prepared statement.", ex);
		}
	}
}
