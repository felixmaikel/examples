package es.cqrs.view.events;

import es.cqrs.view.components.NotifyChange;
import es.cqrs.view.components.forms.View;

public class RestoreActionListener extends BaseActionListener {

	private NotifyChange notifyChange;
	
	public RestoreActionListener(final View view) {
		super(view);
		notifyChange = NotifyChange.getInstance();
	}

	@Override
	protected void execute(Object object) {
		view.restored();
		notifyChange.notifySelection(false);
	}

}
