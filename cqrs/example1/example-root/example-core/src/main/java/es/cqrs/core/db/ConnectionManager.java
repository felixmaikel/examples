package es.cqrs.core.db;

import java.sql.Connection;

public interface ConnectionManager {

	Connection getConnection();
	boolean existsDataBase();
}
