package es.cqrs.view.components.forms;

public interface ViewObserver extends View{

	void notifyChange(final Object object);

}
