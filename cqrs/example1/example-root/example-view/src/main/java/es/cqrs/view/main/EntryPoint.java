package es.cqrs.view.main;

import es.cqrs.core.exception.ApplicationException;
import es.cqrs.service.service.DataService;
import es.cqrs.service.service.NotificationManager;
import es.cqrs.service.service.impl.DataServiceManager;
import es.cqrs.service.service.impl.NotificationManagerImpl;
import es.cqrs.view.MainWindow;
import es.cqrs.view.translate.Translate;

public class EntryPoint {

	public static void main(String[] args) {
		try {
			Translate.loadTranslateText();
			final DataService dataService = DataServiceManager.getInstancia();
			dataService.createDataBase();
			NotificationManager notification = NotificationManagerImpl.getInstance();
			notification.startConsumer();
			final MainWindow mainWindow = new MainWindow();
			mainWindow.setVisible(true);
		}catch(ApplicationException ex) {
			ex.printStackTrace();
		}
	}

}
