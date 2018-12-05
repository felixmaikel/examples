package es.cqrs.view.components.tables;

import javax.swing.JTable;

import es.cqrs.service.service.impl.UserServiceImpl;
import es.cqrs.view.components.tables.model.TableUserModel;
import es.cqrs.view.components.tables.renderer.TableUserRenderer;

public class TableUser extends JTable {

	private TableUserModel model;
	private TableUserRenderer renderer;
	
	public TableUser() {
		super();
		model = new TableUserModel(new UserServiceImpl());
		renderer = new TableUserRenderer();
		this.setModel(model);
		this.setDefaultRenderer(String.class, renderer);
		
	}
}
