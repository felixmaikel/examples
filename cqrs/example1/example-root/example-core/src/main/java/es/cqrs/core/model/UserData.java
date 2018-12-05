package es.cqrs.core.model;

public class UserData {

	private int id;
	private String username;
	private String name;
	private String lastname;
	private String email;
	private StatusAccount status;
	
	public UserData(final String username, final String name, final String lastname, final String email, final StatusAccount status) {
		this.username = username;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.status = status;
	}
	
	public UserData(final int id, final String username, final String name, final String lastname, final String email, final StatusAccount status) {
		this(username, name, lastname, email, status);
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public String getName() {
		return name;
	}

	public String getLastname() {
		return lastname;
	}

	public StatusAccount getStatus() {
		return status;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
}
