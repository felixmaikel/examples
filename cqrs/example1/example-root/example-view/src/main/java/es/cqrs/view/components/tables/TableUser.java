package es.cqrs.view.components.tables;

import java.util.Optional;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import es.cqrs.service.service.NotificationManager;
import es.cqrs.service.service.NotificationObserver;
import es.cqrs.service.service.impl.NotificationManagerImpl;
import es.cqrs.service.service.impl.UserServiceImpl;
import es.cqrs.view.components.DataSetObject;
import es.cqrs.view.components.SelectionObserver;
import es.cqrs.view.components.tables.model.TableUserModel;
import es.cqrs.view.components.tables.model.UserModel;
import es.cqrs.view.components.tables.renderer.TableUserRenderer;
import es.cqrs.view.events.TableListSelectionListener;

public class TableUser extends JTable implements DataSetObject, SelectionObserver, NotificationObserver{

	private TableUserModel model;
	private TableUserRenderer renderer;
	private NotificationManager notification;
	
	public TableUser() {
		super();
		model = new TableUserModel(new UserServiceImpl());
		renderer = new TableUserRenderer();
		this.setModel(model);
		this.setDefaultRenderer(UserModel.class, renderer);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getSelectionModel().addListSelectionListener(new TableListSelectionListener(this));
		notification = NotificationManagerImpl.getInstance();
		notification.add(this);
	}

	@Override
	public Optional<Object> getObject() {
		final int index = this.getSelectedRow();
		if(index >= 0) {
			return Optional.of(model.getSelectedObject(index));
		}
		return Optional.empty();
	}

	@Override
	public void notifySelection(boolean selection) {
		this.clearSelection();
	}

	@Override
	public void notifyModelChange() {
		((TableUserModel)this.getModel()).refresh();
	}
}
