package es.cqrs.core.db.impl;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import es.cqrs.core.db.ConnectionManager;
import es.cqrs.core.exception.ApplicationException;

public class ConnectionManagerImpl implements ConnectionManager {

	private static final String FILE_NAME = "userdb.sqlite";
	private static final String PATH_DRIVER = "org.sqlite.JDBC";
	private static final String URL = "jdbc:sqlite:${path}\\userdb.sqlite";
	private Connection connection;
	private static ConnectionManager instance;
	
	private ConnectionManagerImpl() {
		
	}
	
	public static ConnectionManager getInstance() {
		if(instance == null) {
			instance = new ConnectionManagerImpl();
		}
		return instance;
	}
	
	public Connection getConnection() {
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
	
	public boolean existsDataBase() {
		final String temp = System.getProperty("java.io.tmpdir");
		return Files.exists(Paths.get(temp, FILE_NAME));
	}

}
