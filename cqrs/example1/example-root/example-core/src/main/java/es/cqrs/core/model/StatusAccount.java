package es.cqrs.core.model;

public enum StatusAccount {
	ENABLE_ACCOUNT(1, "Enable Account"), 
	LOCK_ACCOUNT(2, "Lock Account"), 
	NONE(0, "Select Status");
	
	private int id;
	private String text;
	
	private StatusAccount(final int id, final String text) {
		this.id = id;
		this.text = text;
	}
	
	public int getId() {
		return id;
	}
	
	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return getText();
	}
	
}
