package es.cqrs.view.components.label;

import java.awt.Color;
import java.awt.Font;
import java.util.Optional;

import javax.swing.JLabel;

public class LabelBuilder {

	private static final Color DEFAULT_BACKGROUND_COLOR = new Color(255,255,255);
	private static final Color DEFAULT_FOREGROUND_COLOR = new Color(0,0,0);
	private static final Integer DEFAULT_HORIZONTAL_ALIGNMENT = JLabel.LEFT;
	private static final Font DEFAULT_FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
	
	private final String text;
	private final Font font;
	private final Color background;
	private final Color foreground;
	private final Integer alignment;
	private final Boolean opaque;
	
	private LabelBuilder(final Builder builder) {
		text = builder.text;
		font = builder.font;
		background = builder.background;
		foreground = builder.foreground;
		alignment = builder.alignment;
		opaque = builder.opaque;
	}
	
	public String getText() {
		return text;
	}
	
	public Font getFont() {
		return Optional.ofNullable(font).orElse(DEFAULT_FONT);
	}
	
	public Color getBackground() {
		return Optional.ofNullable(background).orElse(DEFAULT_BACKGROUND_COLOR);
	}
	
	public Color getForeground() {
		return Optional.ofNullable(foreground).orElse(DEFAULT_FOREGROUND_COLOR);
	}
	
	public Integer getAlignment() {
		return Optional.ofNullable(alignment).orElse(DEFAULT_HORIZONTAL_ALIGNMENT);
	}
	
	public Boolean getOpaque() {
		return Optional.ofNullable(opaque).orElse(Boolean.FALSE);
	}
	
	public JLabel buildLabel() {
		final JLabel label = new JLabel(text);
		label.setFont(font);
		label.setBackground(getBackground());
		label.setForeground(getForeground());
		label.setHorizontalAlignment(getAlignment());
		label.setOpaque(getOpaque());
		return label;
	}
	
	public static class Builder {

		private String text;
		private Font font;
		private Color background;
		private Color foreground;
		private Integer alignment;
		private Boolean opaque;
		
		public Builder withText(final String text) {
			this.text = text;
			return this;
		}
	
		public Builder withFont(final Font font) {
			this.font = font;
			return this;
		}
	
		public Builder withBackground(final Color background) {
			this.background = background;
			return this;
		}
		
		public Builder withForeground(final Color foreground) {
			this.foreground = foreground;
			return this;
		}
		
		public Builder withHorizontalAlignment(final Integer alignment) {
			this.alignment = alignment;
			return this;
		}
		
		public Builder withOpaque(final Boolean opaque) {
			this.opaque = opaque;
			return this;
		}
		
		public LabelBuilder build() {
			return new LabelBuilder(this);
		}

	}
}
