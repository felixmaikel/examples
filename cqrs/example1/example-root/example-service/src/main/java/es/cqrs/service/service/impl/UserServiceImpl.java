package es.cqrs.service.service.impl;

import java.util.List;
import java.util.Random;

import es.cqrs.core.model.UserData;
import es.cqrs.repositories.repository.UserRepository;
import es.cqrs.repositories.repository.impl.UserRepositoryImpl;
import es.cqrs.service.service.UserService;

public class UserServiceImpl implements UserService {

	private static final String [] LOWERCASE = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z"};
	private static final String [] UPPERCASE = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	private static final String [] NUMBER = new String[]{"1","2","3","4","5","6","7","8","9","0"};
	private UserRepository userRepository;
	
	public UserServiceImpl() {
		userRepository = new UserRepositoryImpl();
	}
	
	public List<UserData> findAll() {
		return userRepository.findAll();
	}

	public void addOrUpdateInfo(final UserData userData) {
		if(userData.getId() == -1) {
			final String password = generatePassword();
			userData.setPassword(password);
			userRepository.addUser(userData);
		}else {
			userRepository.updateUser(userData);
		}
	}

	@Override
	public void remove(final UserData userData) {
		userRepository.remove(userData);
	}

	private String generatePassword() {
		final StringBuilder stringBuilder = new StringBuilder();
		for(int i=0; i<6; i++) {
			stringBuilder.append(getCharacter());
		}
		return stringBuilder.toString();
	}
	
	private String getCharacter() {
		final Random random = new Random();
		final Random randomCharacter = new Random();
		final int characterCase = random.nextInt(3);
		
		switch(characterCase) {
			case 0: {
				final int index = randomCharacter.nextInt(LOWERCASE.length);
				return LOWERCASE[index];
			}
			case 1: {
				final int index = randomCharacter.nextInt(UPPERCASE.length);
				return UPPERCASE[index];
			}
			default : {
				final int index = randomCharacter.nextInt(NUMBER.length);
				return NUMBER[index];
			}
		}
	}
}
