package es.cqrs.service.service.impl;

import java.util.List;

import es.cqrs.core.model.UserData;
import es.cqrs.repositories.repository.UserRepository;
import es.cqrs.service.service.UserService;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	public List<UserData> findAll() {
		return userRepository.findAll();
	}

	public void addOrUpdateInfo(UserData userData) {
		if(userData.getId() == -1) {
			userRepository.addUser(userData);
		}else {
			userRepository.updateUser(userData);
		}
	}

}
