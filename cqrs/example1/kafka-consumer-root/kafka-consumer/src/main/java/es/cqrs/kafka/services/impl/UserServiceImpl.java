package es.cqrs.kafka.services.impl;

import es.cqrs.core.model.StatusAccount;
import es.cqrs.core.model.UserData;
import es.cqrs.kafka.dao.UserDataDao;
import es.cqrs.kafka.dao.impl.UserDataDaoImpl;
import es.cqrs.kafka.producer.EmailProducer;
import es.cqrs.kafka.services.UserService;

public class UserServiceImpl implements UserService {

	private UserDataDao userDataDao;
	private EmailProducer emailProducer;
	
	public UserServiceImpl() {
		userDataDao = new UserDataDaoImpl();
		emailProducer = new EmailProducer();
	}
	
	@Override
	public void addUser(final UserData userData) {
		userDataDao.add(userData);
		if(StatusAccount.ENABLE_ACCOUNT.getId() == userData.getStatus().getId()) {
			emailProducer.send(userData);
		}
	}

}
