package es.cqrs.view.components.tables.renderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import es.cqrs.view.components.label.LabelBuilder;

public class TableUserRenderer implements TableCellRenderer {

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		final JLabel label = new LabelBuilder.Builder().withText(String.valueOf(value)).withFont(new Font(Font.SANS_SERIF, Font.PLAIN, 11))
				.build().buildLabel();
		
		if(isSelected) {
			label.setBackground(Color.blue);
		}
		
		return label;
	}

}
