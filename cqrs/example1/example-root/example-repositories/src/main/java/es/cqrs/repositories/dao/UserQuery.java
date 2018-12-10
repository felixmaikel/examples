package es.cqrs.repositories.dao;

import java.util.List;

import es.cqrs.core.model.UserData;

public interface UserQuery {

	List<UserData> findAll();

}
