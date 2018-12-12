package es.cqrs.repositories.command;

import es.cqrs.core.command.BaseCommand;
import es.cqrs.core.model.UserData;

public class UserCommand extends BaseCommand<String, UserData> {
	
	private final String topic;
	private final String key;
	private final UserData dto;
	
	private UserCommand(final Builder builder) {
		super();
		this.topic = builder.topic;
		this.key = builder.key;
		this.dto = builder.dto;
	}

	public void send() {
		send(topic, key, dto);
	}
	
	public static class Builder {
		
		private String topic;
		private String key;
		private UserData dto;
		
		public Builder() {
			
		}

		public Builder withTopic(final String topic) {
			this.topic = topic;
			return this;
		}

		public Builder withDto(final UserData dto) {
			this.dto = dto;
			return this;
		}

		public UserCommand build() {
			return new UserCommand(this);
		}

		public Builder withKey(final String key) {
			this.key = key;
			return this;
		}
	}

}
