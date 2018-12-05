package es.cqrs.view.events;

import es.cqrs.core.exception.ApplicationException;
import es.cqrs.core.exception.ValidateException;
import es.cqrs.core.model.StatusAccount;
import es.cqrs.core.model.UserData;
import es.cqrs.service.service.UserService;
import es.cqrs.service.service.impl.UserServiceImpl;
import es.cqrs.view.components.forms.View;
import es.cqrs.view.translate.Translate;
import es.cqrs.view.translate.TranslateKey;

public class UpdateUserActionListener extends BaseActionListener {

	private UserService userService;
	private UpdateViewListener updateViewListener;
	
	public UpdateUserActionListener(final View view, final UpdateViewListener updateViewListener) {
		super(view);
		this.updateViewListener = updateViewListener;
		userService = new UserServiceImpl();
	}

	@Override
	protected void execute(Object object) {
		final UserData userData = (UserData)object;
		userService.addOrUpdateInfo(userData);
	}

	@Override
	protected void validate(final Object object) {
		if(!(object instanceof UserData)) {
			throw new ApplicationException(Translate.getString(TranslateKey.DIFFERENT_ARGUMENT_KEY), new IllegalArgumentException());
		}
		
		final UserData userData = (UserData)object;
		if(isEmpty(userData.getUsername()) || isEmpty(userData.getName()) || isEmpty(userData.getLastname()) || isEmpty(userData.getEmail())
				|| userData.getStatus() == StatusAccount.NONE) {
			throw new ValidateException(Translate.getString(TranslateKey.INVALID_FIELD_TEXT));
		}
	}
	
	private boolean isEmpty(final String text) {
		return text == null || text.isEmpty();
	}

}
