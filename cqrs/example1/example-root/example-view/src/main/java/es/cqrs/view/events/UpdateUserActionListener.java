package es.cqrs.view.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.cqrs.core.datasource.UserDataSource;
import es.cqrs.core.model.UserData;

public class UpdateUserActionListener implements ActionListener {

	private UserDataSource userDataSource;
	private UserData userData;
	
	public UpdateUserActionListener(final UserData userData) {
		this.userData = userData;
	}
	
	public void actionPerformed(ActionEvent event) {
		if(userData != null) {
			userDataSource.addOrUpdateInfo(userData);
		}
	}

}
