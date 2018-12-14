package es.cqrs.view.components.tables.renderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import es.cqrs.core.model.StatusAccount;
import es.cqrs.view.components.label.LabelBuilder;
import es.cqrs.view.components.tables.model.UserModel;

public class TableUserRenderer implements TableCellRenderer {

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		final UserModel userModel = (UserModel)value;
		final StatusAccount status = userModel.getUserData().getStatus();
		final JLabel label = new LabelBuilder.Builder().withText(userModel.getValue()).withFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14))
				.withBackground(definedBackgroundColor(status, isSelected)).withForeground(definedForegraound(status, isSelected))
				.withHorizontalAlignment(definedHorizontalAlignment(column)).withOpaque(definedOpaque(isSelected, status)).build().buildLabel();
		
		return label;
	}

	private Boolean definedOpaque(final boolean isSelected, final StatusAccount status) {
		if(isSelected || StatusAccount.LOCK_ACCOUNT.getId() == status.getId()) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	private int definedHorizontalAlignment(final int column) {
		if(column == 3) {
			return JLabel.CENTER;
		}
		return JLabel.LEFT;
	}

	private Color definedForegraound(final StatusAccount status, final boolean isSelected) {
		if(isSelected || StatusAccount.LOCK_ACCOUNT.getId() == status.getId()) {
			return new Color(255,255,255);
		}
		return new Color(0,0,0);
	}

	private Color definedBackgroundColor(final StatusAccount status, final boolean isSelected) {
		if(isSelected) {
			return new Color(0, 153, 204);
		}else if(StatusAccount.LOCK_ACCOUNT.getId() == status.getId()) {
			return new Color(128, 128, 0);
		}
		return new Color(255, 255, 255);
	}

}
