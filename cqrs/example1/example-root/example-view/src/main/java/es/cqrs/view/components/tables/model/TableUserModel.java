package es.cqrs.view.components.tables.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import es.cqrs.core.exception.ApplicationException;
import es.cqrs.core.model.UserData;
import es.cqrs.service.service.UserService;
import es.cqrs.view.events.UpdateViewListener;
import es.cqrs.view.translate.Translate;
import es.cqrs.view.translate.TranslateKey;

public class TableUserModel implements TableModel, UpdateViewListener {

	private UserService userService;
	private List<TableModelListener> modelListener;
	private String [] columns = new String[]{Translate.getString(TranslateKey.USERNAME_COLUMN), Translate.getString(TranslateKey.NAME_COLUMN),
			Translate.getString(TranslateKey.LASTNAME_COLUMN), Translate.getString(TranslateKey.STATUS_COLUMN)};
	private List<UserData> response;
	
	public TableUserModel(final UserService userService) {
		this.userService = userService;
		modelListener = new ArrayList<TableModelListener>();
		refresh();
	}
	
	public void addTableModelListener(TableModelListener l) {
		modelListener.add(l);
	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public int getColumnCount() {
		return columns.length;
	}

	public String getColumnName(int columnIndex) {
		if(columnIndex < 0 || columnIndex >= columns.length) {
			throw new ApplicationException(Translate.getString(TranslateKey.MESSAGE_INDEX_BOUND), new IndexOutOfBoundsException());
		}
		return columns[columnIndex];
	}

	public int getRowCount() {
		return response.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		
		if(rowIndex < 0 || rowIndex >= response.size() || columnIndex < 0 || columnIndex >= columns.length) {
			throw new ApplicationException(Translate.getString(TranslateKey.MESSAGE_INDEX_BOUND), new IndexOutOfBoundsException());
		}
		return obtainsValue(response.get(rowIndex), columnIndex);
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public void removeTableModelListener(TableModelListener l) {
		modelListener.remove(l);
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		if(rowIndex < 0 || columnIndex >= response.size() || columnIndex < 0 || columnIndex >= columns.length) {
			throw new ApplicationException(Translate.getString(TranslateKey.MESSAGE_INDEX_BOUND), new IndexOutOfBoundsException());
		}
		
	}

	private void refresh() {
		response = new ArrayList<UserData>();
		
		if(userService != null) {
			response = userService.findAll();
		}
	}
	
	private Object obtainsValue(final UserData userData, final int columnIndex) {
		switch(columnIndex) {
			case 0:
				return userData.getUsername();
			case 1:
				return userData.getName();
			case 2:
				return userData.getLastname();
			case 3:
				return userData.getStatus();
			default:
				return "";
		}
	}

	@Override
	public void refresh(UserData userData) {
		response = userService.findAll();
	}
}
