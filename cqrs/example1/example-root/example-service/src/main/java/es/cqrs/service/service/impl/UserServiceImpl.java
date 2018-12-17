package es.cqrs.service.service.impl;

import java.util.List;

import es.cqrs.core.model.UserData;
import es.cqrs.repositories.repository.UserRepository;
import es.cqrs.repositories.repository.impl.UserRepositoryImpl;
import es.cqrs.service.service.UserService;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	public UserServiceImpl() {
		userRepository = new UserRepositoryImpl();
	}
	
	public List<UserData> findAll() {
		return userRepository.findAll();
	}

	public void addOrUpdateInfo(final UserData userData) {
		if(userData.getId() == -1) {
			userRepository.addUser(userData);
		}else {
			userRepository.updateUser(userData);
		}
	}

	@Override
	public void remove(final UserData userData) {
		userRepository.remove(userData);
	}

}
