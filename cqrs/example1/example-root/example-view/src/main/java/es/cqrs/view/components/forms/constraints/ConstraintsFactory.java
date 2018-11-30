package es.cqrs.view.components.forms.constraints;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Optional;

public class ConstraintsFactory {

	private final int gridX;
	private final int gridY;
	private final double weightX;
	private final double weightY;
	private final int gridWidth;
	private final int gridHeight;
	private final Insets insets;
	private final int fill;
	private final Integer anchor;
	
	public ConstraintsFactory(final Builder builder) {
		this.gridX = builder.gridX;
		this.gridY = builder.gridY;
		this.weightX = builder.weightX;
		this.weightY = builder.weightY;
		this.gridWidth = builder.gridWidth;
		this.gridHeight = builder.gridHeight;
		this.insets = builder.insets;
		this.fill = builder.fill;
		this.anchor = builder.anchor;
	}

	public int getGridX() {
		return gridX;
	}

	public int getGridY() {
		return gridY;
	}

	public double getWeightX() {
		return weightX;
	}

	public double getWeightY() {
		return weightY;
	}

	public int getGridWidth() {
		return gridWidth;
	}

	public int getGridHeight() {
		return gridHeight;
	}

	public Insets getInsets() {
		return Optional.ofNullable(insets).orElse(new Insets(0, 0, 0, 0));
	}

	public int getFill() {
		return fill;
	}

	public Integer getAnchor() {
		return Optional.ofNullable(anchor).orElse(GridBagConstraints.NONE);
	}

	public GridBagConstraints buildConstraints() {
		final GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = gridX;
		constraints.gridy = gridY;
		constraints.gridwidth = gridWidth;
		constraints.gridheight = gridHeight;
		constraints.weightx = weightX;
		constraints.weighty = weightY;
		constraints.fill = fill;
		constraints.insets = Optional.ofNullable(insets).orElse(new Insets(0, 0, 0, 0));
		constraints.anchor = Optional.ofNullable(anchor).orElse(GridBagConstraints.CENTER).intValue();
		return constraints;
	}
	
	public static class Builder {
		
		private int gridX;
		private int gridY;
		private double weightX;
		private double weightY;
		private int gridWidth;
		private int gridHeight;
		private Insets insets;
		private int fill;
		private Integer anchor;
		
		public Builder() {
			
		}
		
		public Builder withGridX(int gridX) {
			this.gridX = gridX;
			return this;
		}

		public Builder withGridY(int gridY) {
			this.gridY = gridY;
			return this;
		}

		public Builder withWeightX(double weightX) {
			this.weightX = weightX;
			return this;
		}

		public Builder withWeightY(double weightY) {
			this.weightY = weightY;
			return this;
		}

		public Builder withGridWidth(int gridWidth) {
			this.gridWidth = gridWidth;
			return this;
		}

		public Builder withGridHeight(int gridHeight) {
			this.gridHeight = gridHeight;
			return this;
		}

		public Builder withInsets(Insets insets) {
			this.insets = insets;
			return this;
		}

		public Builder withFill(int fill) {
			this.fill = fill;
			return this;
		}

		public ConstraintsFactory build() {
			return new ConstraintsFactory(this);
		}

		public Builder withAnchor(Integer anchor) {
			this.anchor = anchor;
			return this;
		}
	}

}
