package es.cqrs.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import es.cqrs.view.components.forms.EditUserForm;
import es.cqrs.view.components.tables.TableUser;
import es.cqrs.view.events.ClosedApplicationListener;
import es.cqrs.view.events.UpdateViewListener;
import es.cqrs.view.translate.Translate;
import es.cqrs.view.translate.TranslateKey;

public class MainWindow extends JFrame {

	private TableUser tableUser;
	private EditUserForm editUserForm;
	
	public MainWindow() {
		super();
		initialize();
	}
	
	private void initialize() {
		this.setTitle(Translate.getString(TranslateKey.MAIN_WINDOW_TITLE_KEY));
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLayout(new GridBagLayout());
		this.addWindowListener(new ClosedApplicationListener());
		
		initializeTable();
		initializeEditForm();
	}
	
	private void initializeTable() {
		tableUser = new TableUser();
		final JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(tableUser);
		
		final GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(5, 5, 5, 5);
		
		this.add(scroll, constraints);
	}
	
	private void initializeEditForm() {
		editUserForm = new EditUserForm((UpdateViewListener)tableUser.getModel());
		
		final GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 1.0;
		constraints.weighty = 0.0;
		constraints.anchor = GridBagConstraints.NORTH;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(5, 5, 5, 5);
		
		this.add(editUserForm, constraints);
	}
}
