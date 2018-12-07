package es.cqrs.service.service.impl;

import es.cqrs.repositories.db.DataBaseManager;
import es.cqrs.repositories.db.impl.DataBaseManagerImpl;
import es.cqrs.service.service.DataService;

public class DataServiceManager implements DataService {

	private static DataService dataService;
	private DataBaseManager dataBaseManager;
	
	private DataServiceManager() {
		dataBaseManager = new DataBaseManagerImpl();
	}
	
	public static DataService getInstancia() {
		if(dataService == null) {
			dataService = new DataServiceManager();
		}
		return dataService;
	}

	public void createDataBase() {
		dataBaseManager.preparedUserDataBase();
	}

}
