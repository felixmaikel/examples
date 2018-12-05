package es.cqrs.view.events;

import es.cqrs.core.model.UserData;

public interface UpdateViewListener {

	void refresh(final UserData userData);
}
