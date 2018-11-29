package es.cqrs.view.events;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import es.cqrs.view.components.label.LabelBuilder;
import es.cqrs.view.translate.Translate;
import es.cqrs.view.translate.TranslateKey;

public class ClosedApplicationListener extends WindowAdapter implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		closedApplication();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		closedApplication();
	}

	private void closedApplication() {
		final JLabel label = new LabelBuilder.Builder().withText(Translate.getString(TranslateKey.CLOSED_APPLICATION_MESSAGE_KEY))
				.withFont(new Font(Font.SANS_SERIF, Font.PLAIN, 11)).build().buildLabel();
		final String title = Translate.getString(TranslateKey.CLOSED_TITLE_MENSAGE_KEY);
		final String [] options = new String[]{Translate.getString(TranslateKey.YES_OPTION_TEXT),
				Translate.getString(TranslateKey.CANCEL_OPTION_TEXT)};
		
		final int option = JOptionPane.showOptionDialog(null, label, title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
				null, options, options[0]);
		if(option == JOptionPane.OK_OPTION) {
			System.exit(0);
		}
	}
	
}
