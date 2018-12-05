package es.cqrs.view.components.messagebox;

import java.awt.Font;
import java.util.Optional;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import es.cqrs.view.components.label.LabelBuilder;
import es.cqrs.view.translate.Translate;
import es.cqrs.view.translate.TranslateKey;

public class BoxMessageApplication extends JOptionPane {

	private final String message;
	private final Integer messageType;
	private final String title;
	
	private BoxMessageApplication(final Builder builder) {
		this.message = builder.message;
		this.messageType = builder.messageType;
		this.title = builder.title;
	}
	
	public String getMessage() {
		return message;
	}
	
	public int getMessageType() {
		return Optional.ofNullable(messageType).orElse(JOptionPane.INFORMATION_MESSAGE);
	}
	
	public String getTitle() {
		return title;
	}
	
	public void showMessage() {
		final JLabel lbmessage = new LabelBuilder.Builder().withText(message).withFont(new Font(Font.SANS_SERIF, Font.PLAIN, 11))
				.build().buildLabel();
		final String [] options = new String[]{Translate.getString(TranslateKey.YES_OPTION_TEXT)};
		
		showOptionDialog(null, lbmessage, title, JOptionPane.OK_OPTION, getMessageType(), null,	options, options[0]);
	}
	
	public static class Builder {
		
		private String message;
		private Integer messageType;
		private String title;
		
		public Builder() {
			
		}
		
		public Builder withMessage(final String message) {
			this.message = message;
			return this;
		}
		
		public BoxMessageApplication build() {
			return new BoxMessageApplication(this);
		}

		public Builder withMessageType(final Integer messageType) {
			this.messageType = messageType;
			return this;
		}

		public Builder withTitle(String title) {
			this.title = title;
			return this;
		}
	}
}
