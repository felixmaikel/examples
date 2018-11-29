package es.cqrs.view;

import java.awt.GridBagLayout;

import javax.swing.JFrame;

import es.cqrs.view.events.ClosedApplicationListener;
import es.cqrs.view.translate.Translate;
import es.cqrs.view.translate.TranslateKey;

public class MainWindow extends JFrame {

	public MainWindow() {
		initialize();
	}
	
	private void initialize() {
		this.setTitle(Translate.getString(TranslateKey.MAIN_WINDOW_TITLE_KEY));
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLayout(new GridBagLayout());
		this.addWindowListener(new ClosedApplicationListener());
	}
}
