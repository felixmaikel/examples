package es.cqrs.view.components.combobox;

import java.awt.Font;

import javax.swing.JComboBox;

import es.cqrs.core.model.StatusAccount;
import es.cqrs.view.components.combobox.model.StatusComboBoxModel;

public class StatusComboBox extends JComboBox<StatusAccount> {

	private StatusComboBoxModel statusComboBoxModel;
	
	public StatusComboBox() {
		super();
		statusComboBoxModel = new StatusComboBoxModel();
		this.setModel(statusComboBoxModel);
		this.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
	}
}
