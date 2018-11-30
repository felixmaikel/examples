package es.cqrs.view.components.forms;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import es.cqrs.view.components.combobox.StatusComboBox;
import es.cqrs.view.components.forms.constraints.ConstraintsFactory;
import es.cqrs.view.components.label.LabelBuilder;
import es.cqrs.view.translate.Translate;
import es.cqrs.view.translate.TranslateKey;

public class EditUserForm extends JPanel {

	private JTextField txtUsername;
	private JTextField txtName;
	private JTextField txtLastname;
	private JTextField txtemail;
	private StatusComboBox cbStatus;
	private JButton btnNewUser;
	private JButton btnUpdateUser;
	private JButton btnRemoveUser;
	private JPanel btnPanel;
	
	public EditUserForm() {
		super();
		initialize();
	}
	
	private void initialize() {
		this.setLayout(new GridBagLayout());
		addLabels();
		addTextEdits();
		addButtons();
	}
	
	private void addLabels() {
		final JLabel lbusername = createLabel(Translate.getString(TranslateKey.USERNAME_FIELD_TEXT));
		final JLabel lbname = createLabel(Translate.getString(TranslateKey.NAME_FIELD_TEXT));
		final JLabel lblastname = createLabel(Translate.getString(TranslateKey.LASTNAME_FIELD_TEXT));
		final JLabel lbemail = createLabel(Translate.getString(TranslateKey.EMAIL_FIELD_TEXT));
		final JLabel lbstatus = createLabel(Translate.getString(TranslateKey.STATUS_FIELD_TEXT));
		
		final GridBagConstraints userConstraints = new ConstraintsFactory.Builder().withGridX(0).withGridY(0).withWeightX(0.0).withWeightY(0.0)
				.withGridWidth(1).withGridHeight(1).withInsets(new Insets(10, 10, 0, 10)).withAnchor(GridBagConstraints.WEST).withFill(GridBagConstraints.NONE)
				.build().buildConstraints();
		final GridBagConstraints nameConstraints = new ConstraintsFactory.Builder().withGridX(0).withGridY(1).withGridWidth(1).withGridHeight(1)
				.withWeightX(0.0).withWeightY(0.0).withInsets(new Insets(10, 10, 0, 10)).withAnchor(GridBagConstraints.WEST).withFill(GridBagConstraints.NONE)
				.build().buildConstraints();
		final GridBagConstraints lastnameConstraints = new ConstraintsFactory.Builder().withGridX(0).withGridY(2).withGridWidth(1).withGridHeight(1)
				.withWeightX(0.0).withWeightY(0.0).withInsets(new Insets(10, 10, 0, 10)).withAnchor(GridBagConstraints.WEST).withFill(GridBagConstraints.NONE)
				.build().buildConstraints();
		final GridBagConstraints emailConstraints = new ConstraintsFactory.Builder().withGridX(0).withGridY(3).withGridWidth(1).withGridHeight(1)
				.withWeightX(0.0).withWeightY(0.0).withInsets(new Insets(10, 10, 0, 10)).withAnchor(GridBagConstraints.WEST).withFill(GridBagConstraints.NONE)
				.build().buildConstraints();
		final GridBagConstraints statusConstraints = new ConstraintsFactory.Builder().withGridX(0).withGridY(4).withGridWidth(1).withGridHeight(1)
				.withWeightX(0.0).withWeightY(0.0).withInsets(new Insets(10, 10, 0, 10)).withAnchor(GridBagConstraints.WEST).withFill(GridBagConstraints.NONE)
				.build().buildConstraints();
		
		this.add(lbusername, userConstraints);
		this.add(lbname, nameConstraints);
		this.add(lblastname, lastnameConstraints);
		this.add(lbemail, emailConstraints);
		this.add(lbstatus, statusConstraints);
	}
	
	private void addTextEdits() {
		txtUsername = createTextField();
		txtName = createTextField();
		txtLastname = createTextField();
		txtemail = createTextField();
		cbStatus = new StatusComboBox();
		
		final GridBagConstraints txtUserConstraints = new ConstraintsFactory.Builder().withGridX(1).withGridY(0).withWeightX(1.0).withWeightY(0.0)
				.withGridWidth(1).withGridHeight(1).withInsets(new Insets(10, 10, 0, 10)).withFill(GridBagConstraints.HORIZONTAL).build().buildConstraints();
		final GridBagConstraints txtNameConstraints = new ConstraintsFactory.Builder().withGridX(1).withGridY(1).withGridWidth(1).withGridHeight(1)
				.withWeightX(1.0).withWeightY(0.0).withInsets(new Insets(10, 10, 0, 10)).withFill(GridBagConstraints.HORIZONTAL).build().buildConstraints();
		final GridBagConstraints txtLastnameConstraints = new ConstraintsFactory.Builder().withGridX(1).withGridY(2).withGridWidth(1).withGridHeight(1)
				.withWeightX(1.0).withWeightY(0.0).withInsets(new Insets(10, 10, 0, 10)).withFill(GridBagConstraints.HORIZONTAL).build().buildConstraints();
		final GridBagConstraints txtEmailConstraints = new ConstraintsFactory.Builder().withGridX(1).withGridY(3).withGridWidth(1).withGridHeight(1)
				.withWeightX(1.0).withWeightY(0.0).withInsets(new Insets(10, 10, 0, 10)).withFill(GridBagConstraints.HORIZONTAL).build().buildConstraints();
		final GridBagConstraints txtStatusConstraints = new ConstraintsFactory.Builder().withGridX(1).withGridY(4).withGridWidth(1).withGridHeight(1)
				.withWeightX(1.0).withWeightY(0.0).withInsets(new Insets(10, 10, 0, 10)).withFill(GridBagConstraints.HORIZONTAL).build().buildConstraints();
		
		this.add(txtUsername, txtUserConstraints);
		this.add(txtName, txtNameConstraints);
		this.add(txtLastname, txtLastnameConstraints);
		this.add(txtemail, txtEmailConstraints);
		this.add(cbStatus, txtStatusConstraints);
	}
	
	private void addButtons() {
		btnNewUser = createButton(Translate.getString(TranslateKey.BTN_NEW_USER_TEXT));
		btnUpdateUser = createButton(Translate.getString(TranslateKey.BTN_UPDATE_USER_TEXT));
		btnRemoveUser = createButton(Translate.getString(TranslateKey.BTN_REMOVE_USER_TEXT));
		btnPanel = new JPanel();
		btnPanel.setLayout(new GridBagLayout());
		
		final GridBagConstraints btnNewConstraints = new ConstraintsFactory.Builder().withGridX(0).withGridY(0).withGridWidth(1).withGridHeight(1)
				.withWeightX(1.0).withWeightY(0.0).withInsets(new Insets(10, 10, 10, 10)).withAnchor(GridBagConstraints.EAST)
				.withFill(GridBagConstraints.NONE).build().buildConstraints();
		final GridBagConstraints btnUpdateConstraints = new ConstraintsFactory.Builder().withGridX(1).withGridY(0).withGridWidth(1).withGridHeight(1)
				.withWeightX(1.0).withWeightY(0.0).withInsets(new Insets(10, 0, 10, 10)).withAnchor(GridBagConstraints.EAST)
				.withFill(GridBagConstraints.NONE).build().buildConstraints();
		final GridBagConstraints btnRemoveConstraints = new ConstraintsFactory.Builder().withGridX(2).withGridY(0).withGridWidth(1).withGridHeight(1)
				.withWeightX(1.0).withWeightY(0.0).withInsets(new Insets(10, 0, 10, 10)).withAnchor(GridBagConstraints.EAST)
				.withFill(GridBagConstraints.NONE).build().buildConstraints();
		final GridBagConstraints panelConstraints = new ConstraintsFactory.Builder().withGridX(1).withGridY(5).withGridWidth(1).withGridHeight(1)
				.withWeightX(0.0).withWeightY(0.0).withInsets(new Insets(0, 0, 0, 0)).withFill(GridBagConstraints.NONE)
				.withAnchor(GridBagConstraints.EAST).build().buildConstraints();
		
		btnPanel.add(btnNewUser, btnNewConstraints);
		btnPanel.add(btnUpdateUser, btnUpdateConstraints);
		btnPanel.add(btnRemoveUser, btnRemoveConstraints);
		
		this.add(btnPanel, panelConstraints);
	}
	
	private JTextField createTextField() {
		final Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
		final JTextField textField = new JTextField();
		textField.setFont(font);
		
		return textField;
	}
	
	private JButton createButton(final String text) {
		final Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 11);
		final JButton btn = new JButton(text);
		btn.setFont(font);
		
		return btn;
	}
	
	private JLabel createLabel(final String text) {
		final Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 11);
		
		final JLabel label = new LabelBuilder.Builder().withText(text).withFont(font).build().buildLabel();
		
		return label;
	}
}
