package es.cqrs.view.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import es.cqrs.core.exception.ApplicationException;
import es.cqrs.core.exception.ValidateException;
import es.cqrs.view.components.forms.View;
import es.cqrs.view.components.messagebox.BoxMessageApplication;
import es.cqrs.view.translate.Translate;
import es.cqrs.view.translate.TranslateKey;

public abstract class BaseActionListener implements ActionListener{

	protected View view;
	
	protected BaseActionListener(final View view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			final Object object = view.getObject();
			validate(object);
			execute(object);
			view.restored();
		}catch(ApplicationException ex) {
			showApplicationException(ex);
		}catch(ValidateException ex) {
			showValidateException(ex);
		}
	}

	protected abstract void execute(final Object object);
	
	protected void validate(final Object object) {
		
	}
	
	private void showApplicationException(final ApplicationException ex) {
		final BoxMessageApplication messageError = new BoxMessageApplication.Builder().withMessage(ex.getMessage())
				.withTitle(Translate.getString(TranslateKey.MESSAGE_ERROR_TITLE)).withMessageType(JOptionPane.ERROR_MESSAGE).build();
		messageError.showMessage();
	}
	
	private void showValidateException(final ValidateException ex) {
		final BoxMessageApplication boxMessage = new BoxMessageApplication.Builder().withMessage(ex.getMessage())
				.withTitle(Translate.getString(TranslateKey.MESSAGE_VALIDATE_TITLE)).withMessageType(JOptionPane.INFORMATION_MESSAGE).build();
		boxMessage.showMessage();
	}
}
