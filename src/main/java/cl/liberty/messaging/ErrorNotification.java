/**
 * 
 */
package cl.liberty.messaging;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jgarrido
 *
 */
public class ErrorNotification {
	
	private String identifier;
	private StatusFamily family;
	private String context;
	private String problem;
	private String solution;
	private List<String> details;

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public ErrorNotification() {
		this.details = new ArrayList<>();
	}
	
	public ErrorNotification(String identifier) {
		this.identifier = identifier;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public StatusFamily getFamily() {
		return family;
	}

	public void setFamily(StatusFamily family) {
		this.family = family;
	}
	
	public void setFamily(final int statusCode) {
		this.family = StatusFamily.familyOf(statusCode);
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}
	
	public enum StatusFamily {

		/**
		 * {@code 1xx} HTTP status codes.
		 */
		INFORMATIONAL, 
		
		/**
		 * {@code 2xx} HTTP status codes.
		 */
		SUCCESSFUL, 
		
		/**
		 * {@code 4xx} HTTP status codes.
		 */
		CLIENT_ERROR, 
		
		/**
		 * {@code 5xx} HTTP status codes.
		 */
		SERVER_ERROR, 
		
		/**
		 * Other, unrecognized HTTP status codes.
		 */
		OTHER;
		
		/**
		 * Get the response status family for the status code.
		 *
		 * @param statusCode
		 *            response status code to get the family for.
		 * @return family of the response status code.
		 */
		public static StatusFamily familyOf(final int statusCode) {
			switch (statusCode / 100) {
			case 1:
				return StatusFamily.INFORMATIONAL;
			case 2:
				return StatusFamily.SUCCESSFUL;
			case 4:
				return StatusFamily.CLIENT_ERROR;
			case 5:
				return StatusFamily.SERVER_ERROR;
			default:
				return StatusFamily.OTHER;
			}
		}
	}

}
