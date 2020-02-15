/**
 * 
 */
package cl.liberty.exception;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author jgarrido
 *
 */
public class ApplicationCommonException  extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	private final int code;
	private final String identifier;
	private final List<String> messages;
	
	
	/**
	 * Private constructor using a exception identifier that has been computed before the super() call.
	 *
	 * @param identifier
	 * @param code
	 * @param messages
	 */
	private ApplicationCommonException(final String identifier, final int code, final List<String> messages) {
		// to print the exception message while printing the stacktrace
		super(identifier + " " + messages.stream()
				.map(s -> s.substring(0, s.length() - 1).concat("; "))
				.collect(Collectors.joining()));

		this.identifier = identifier;
		this.code = code;
		this.messages = messages;
	}

	/**
	 * Constructor using a List of messages.
	 *
	 * @param code
	 * @param messages
	 */
	ApplicationCommonException(final int code, final List<String> messages) {
		this(UUID.randomUUID().toString(), code, messages);
	}

	/**
	 * Constructor using single message.
	 *
	 * @param code
	 * @param message
	 */
	ApplicationCommonException(final int code, final String message) {
		this(UUID.randomUUID().toString(), code, Collections.singletonList(message));
	}

	/**
	 * Constructor using a Exception instance.
	 *
	 * @param code
	 * @param exception
	 */
	ApplicationCommonException(final int code, final Exception exception) {
		this(UUID.randomUUID().toString(), code, Collections.singletonList(exception.getMessage()));
	}

	/**
	 * Constructor using a Throwable instance.
	 *
	 * @param code
	 * @param throwable
	 */
	ApplicationCommonException(final int code, final Throwable throwable) {
		this(UUID.randomUUID().toString(), code, Collections.singletonList(throwable.getMessage()));
	}

	/**
	 * Constructor using single message and a String formatter for n arguments in the message creation.
	 *
	 * @param code
	 * @param message
	 * @param args
	 */
	ApplicationCommonException(final int code, final String message, Object... args) {
		// using a String formatter
		this(UUID.randomUUID().toString(), code, Collections.singletonList(String.format(message, args)));
	}

	public int getCode() {
		return code;
	}

	public List<String> getMessages() {
		return messages;
	}

	public String getIdentifier() {
		return identifier;
	}


}
