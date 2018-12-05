package es.cqrs.repositories.dao.mapper;

import java.sql.ResultSet;

public interface RowMapper<T> {

	T toMapper(final ResultSet resultSet);
	
}
