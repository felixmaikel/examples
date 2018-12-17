package es.cqrs.view.events;

import es.cqrs.core.model.UserData;
import es.cqrs.service.service.UserService;
import es.cqrs.service.service.impl.UserServiceImpl;
import es.cqrs.view.components.forms.View;

public class RemoveActionListener extends BaseActionListener {

	private UserService userService;
	
	public RemoveActionListener(final View view) {
		super(view);
		userService = new UserServiceImpl();
	}

	@Override
	protected void execute(Object object) {
		final UserData userData = (UserData)object;
		userService.remove(userData);
	}

}
