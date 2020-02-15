/**
 * 
 */
package cl.liberty.response;

import cl.liberty.configuration.SemverResolver;
import cl.liberty.messaging.ErrorNotification;

import java.util.Calendar;
import java.util.Collections;
import java.util.UUID;

/**
 * @author jgarrido
 * @param <T>
 *
 */
public class ResponseBuilder<T> {

	private static final Integer RESPONSE_NO_CODE = -1;
	private static final String RESPONSE_EMPTY_MESSAGE = "";
	private static final String APP_IMPLEMENTATION_VERSION = SemverResolver.getVersion();

	private Integer code;
	private String message;
	private T data;
	private ErrorNotification errors;

	public ResponseContainer<T> build() {
		ResponseContainer<T> response = new ResponseContainer<>();
		response.setCode(code != null ? code : RESPONSE_NO_CODE);
		response.setMessage(message != null ? message : RESPONSE_EMPTY_MESSAGE);
		response.setDate(Calendar.getInstance().getTime());
		response.setData(data);
		response.setErrors(errors);
		response.setVersion(APP_IMPLEMENTATION_VERSION);
		return response;
	}

	// Setter methods

	public ResponseBuilder<T> setCode(Integer code) {
		this.code = code;
		return this;
	}

	public ResponseBuilder<T> setMessage(String message) {
		this.message = message;
		return this;
	}

	public ResponseBuilder<T> setData(T data) {
		this.data = data;
		return this;
	}

	public ResponseBuilder<T> withErrors(ErrorNotification errorNotification) {
		this.errors = errorNotification;
		return this;
	}

	// Builder methods

	/**
	 * Set code and message for ResponseContainer object that represent a succes
	 * request.
	 * 
	 * @return
	 */
	public ResponseBuilder<T> withSucess() {
		this.code = 200;
		this.message = "success";
		return this;
	}

	/**
	 * If a unknown exception is raised we can build a ErrorNotification object
	 * based on any String message given by the creator.
	 * 
	 * @param message
	 * @return
	 */
	public ResponseBuilder<T> withUnknownException(String message) {
		ErrorNotification error = new ErrorNotification();
		error.setIdentifier(UUID.randomUUID().toString());
		error.setDetails(Collections.singletonList(message));
		this.errors = error;

		return this;
	}

}
