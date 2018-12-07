package es.cqrs.repositories.db.impl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import es.cqrs.core.exception.ApplicationException;
import es.cqrs.repositories.db.ConnectionManager;
import es.cqrs.repositories.db.DataBaseManager;

public class DataBaseManagerImpl implements DataBaseManager{
	
	private static final String SCHEMA_PATH = "/schema/user-schema.sql";
	private ConnectionManager connectionManager;
	
	public DataBaseManagerImpl() {
		connectionManager = ConnectionManagerImpl.getInstance();
	}
	
	public void preparedUserDataBase() {
		if(!connectionManager.existsDataBase()) {
			createDbFile();
			executeScript();
		}
	}

	private void createDbFile() {
		try {
			final String query = loadScript();
			final Connection connection = connectionManager.getConnection();
			final PreparedStatement statement = connection.prepareStatement(query);
			statement.execute();
		}catch(SQLException ex) {
			throw new ApplicationException("Error to execute table sql file.", ex);
		}
	}
	
	private String loadScript() {
		try {
			final Path path = Paths.get(getClass().getResource(SCHEMA_PATH).toURI());
			final List<String> lines = Files.readAllLines(path);
			StringBuilder stringBuilder = new StringBuilder();
			
			for (String string : lines) {
				stringBuilder.append(string);
			}
			
			return stringBuilder.toString();
		}catch(URISyntaxException ex) {
			throw new ApplicationException("Error to load data base script.", ex);
		}catch(IOException ex) {
			throw new ApplicationException("Error to loas data base script.", ex);
		}
	}
	
	private void executeScript() {
		
	}
}
