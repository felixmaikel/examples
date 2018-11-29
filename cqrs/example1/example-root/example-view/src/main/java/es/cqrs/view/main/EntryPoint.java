package es.cqrs.view.main;

import es.cqrs.view.MainWindow;
import es.cqrs.view.translate.Translate;

public class EntryPoint {

	public static void main(String[] args) {
		Translate.loadTranslateText();
		final MainWindow mainWindow = new MainWindow();
		mainWindow.setVisible(true);
	}

}
