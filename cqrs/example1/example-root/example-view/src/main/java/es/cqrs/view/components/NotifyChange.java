package es.cqrs.view.components;

import java.util.ArrayList;
import java.util.List;

import es.cqrs.view.components.forms.ViewObserver;

public class NotifyChange {

	private static NotifyChange instance;
	private List<ViewObserver> observers;
	private List<SelectionObserver> selectionObserver;
	
	private NotifyChange() {
		observers = new ArrayList<ViewObserver>();
		selectionObserver = new ArrayList<SelectionObserver>();
	}
	
	public void notifyChange(final Object object) {
		observers.stream().forEach(observer -> observer.notifyChange(object));
	}

	public void addObserver(final ViewObserver viewObserver) {
		observers.add(viewObserver);
	}
	
	public void addSelectObserver(final SelectionObserver selectObserver) {
		selectionObserver.add(selectObserver);
	}
	
	public static NotifyChange getInstance() {
		if(instance == null) {
			instance = new NotifyChange();
		}
		return instance;
	}

	public void notifySelection(final boolean selection) {
		selectionObserver.stream().forEach(observer -> observer.notifySelection(selection));
	}

}
