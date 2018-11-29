package es.cqrs.view.components.label;

import java.awt.Font;

import javax.swing.JLabel;

public class LabelBuilder {

	private final String text;
	private final Font font;
	
	private LabelBuilder(final Builder builder) {
		text = builder.text;
		font = builder.font;
	}
	
	public String getText() {
		return text;
	}
	
	public Font getFont() {
		return font;
	}
	
	public JLabel buildLabel() {
		final JLabel label = new JLabel(text);
		label.setFont(font);
		return label;
	}
	
	public static class Builder {

		private String text;
		private Font font;
		
		public Builder withText(String text) {
			this.text = text;
			return this;
		}
	
		public Builder withFont(Font font) {
			this.font = font;
			return this;
		}
	
		public LabelBuilder build() {
			return new LabelBuilder(this);
		}

	}
}
