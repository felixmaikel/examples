package es.cqrs.repositories.db;

import java.sql.Connection;

public interface ConnectionManager {

	Connection getConnection();
	boolean existsDataBase();
}
