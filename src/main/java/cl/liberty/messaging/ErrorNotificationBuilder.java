package cl.liberty.messaging;
import java.util.ArrayList;
import java.util.List;

import cl.liberty.messaging.ErrorNotification.StatusFamily;

public class ErrorNotificationBuilder {

	private String identifier;
	private StatusFamily family;
	private String context;
	private String problem;
	private String solution;
	private List<String> details;
	
	public ErrorNotificationBuilder() {
		 this.details = new ArrayList<>();
	}
	
	public ErrorNotification build() {
		ErrorNotification error = new ErrorNotification();
		error.setFamily(family);
		error.setContext(context);
		error.setProblem(problem);
		error.setSolution(solution);
		error.setIdentifier(identifier);
		error.setDetails(details);
		return error;
	}
	
	public ErrorNotificationBuilder setIdentifier(String identifier) {
		this.identifier = identifier;
		return this;
	}

	public ErrorNotificationBuilder setContext(Throwable t) {
		this.context = t.getClass().getSimpleName();
		return this;
	}

	public ErrorNotificationBuilder setFamily(StatusFamily family) {
		this.family = family;
		return this;
	}
	
	public ErrorNotificationBuilder setDetails(List<String> details) {
		this.details = details;
		return this;
	}
	
	public ErrorNotificationBuilder addDetail(String message) {
		details.add(message);
		return this;
	}
	
}
