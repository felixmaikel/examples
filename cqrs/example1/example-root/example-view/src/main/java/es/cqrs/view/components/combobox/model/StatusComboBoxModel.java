package es.cqrs.view.components.combobox.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import es.cqrs.core.exception.ApplicationException;
import es.cqrs.core.model.StatusAccount;

public class StatusComboBoxModel implements ComboBoxModel<StatusAccount>{

	private List<ListDataListener> listeners;
	private List<StatusAccount> status;
	private StatusAccount selectItem;
	
	public StatusComboBoxModel() {
		listeners = new ArrayList<ListDataListener>();
		status = new ArrayList<StatusAccount>();
		status.add(StatusAccount.NONE);
		status.add(StatusAccount.ENABLE_ACCOUNT);
		status.add(StatusAccount.LOCK_ACCOUNT);
		selectItem = status.get(0);
	}
	
	public void addListDataListener(ListDataListener l) {
		listeners.add(l);
	}

	public StatusAccount getElementAt(int index) {
		return status.get(index);
	}

	public int getSize() {
		return status.size();
	}

	public void removeListDataListener(ListDataListener l) {
		listeners.remove(l);
	}

	public Object getSelectedItem() {
		return selectItem;
	}

	public void setSelectedItem(Object anItem) {
		if(!(anItem instanceof StatusAccount)) {
			throw new ApplicationException("The status value is incorrect.", new ClassCastException());
		}
		this.selectItem = status.get(((StatusAccount)anItem).getId());
	}

}
