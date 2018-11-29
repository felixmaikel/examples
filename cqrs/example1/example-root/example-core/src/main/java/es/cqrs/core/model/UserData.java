package es.cqrs.core.model;

public class UserData {

	private String username;
	private String name;
	private String lastname;
	private String status;
	
	public UserData(final String username, final String name, final String lastname, final String status) {
		this.username = username;
		this.name = name;
		this.lastname = lastname;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

}
