package es.cqrs.view.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sql.DataSource;

import es.cqrs.core.datasource.UserDataSource;
import es.cqrs.core.model.UserData;

public class RemoveActionListener implements ActionListener {

	private UserDataSource userDataSource;
	private UserData userData;
	
	public RemoveActionListener(final UserData userData) {
		this.userData = userData;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(userData != null) {
			userDataSource.removeUserData(userData);
		}
	}

}
