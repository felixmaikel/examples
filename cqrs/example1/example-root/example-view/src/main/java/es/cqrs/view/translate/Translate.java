package es.cqrs.view.translate;

import java.util.ResourceBundle;

import es.cqrs.core.exception.ApplicationException;

public class Translate {

	private static final String BASE_NAME = "es.cqrs.language.language";
	private static ResourceBundle bundle;
	
	private Translate() {
		
	}
	
	public static String getString(final String messageKey) {
		if(!bundle.containsKey(messageKey)) {
			final String message = String.format(bundle.getString(TranslateKey.MESSAGE_KEY_NOT_FOUND), messageKey);
			throw new ApplicationException(message);
		}
		
		return bundle.getString(messageKey);
	}

	public static void loadTranslateText() {
		bundle = ResourceBundle.getBundle(BASE_NAME);
	}
}
