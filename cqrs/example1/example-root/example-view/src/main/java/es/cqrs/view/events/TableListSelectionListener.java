package es.cqrs.view.events;

import java.util.Optional;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import es.cqrs.core.model.UserData;
import es.cqrs.view.components.DataSetObject;
import es.cqrs.view.components.NotifyChange;

public class TableListSelectionListener implements ListSelectionListener {

	private DataSetObject dataSetObject;
	private NotifyChange notifyChange;
	
	public TableListSelectionListener(final DataSetObject dataSetObject) {
		this.dataSetObject = dataSetObject;
		notifyChange = NotifyChange.getInstance();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		final Optional<Object> object = dataSetObject.getObject();
		if(object.isPresent()) {
			final UserData userData = (UserData)object.get();
			notifyChange.notifyChange(userData);
		}
	}

}
