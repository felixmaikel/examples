package es.cqrs.service.service;

import java.util.List;

import es.cqrs.core.model.UserData;

public interface UserService {

	List<UserData> findAll();

	void addOrUpdateInfo(UserData userData);

}
