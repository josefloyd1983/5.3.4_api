/**
 * 
 */
package cl.liberty.exception;

/**
 * @author jgarrido
 *
 */
public class NoDataFoundException extends ApplicationCommonException {

	private static final long serialVersionUID = 1L;
	// HTTP Status Code 202 ACCEPTED
	private static final int CODE = 202;

	private static final String DEFAULT_MESSAGE = "No se han encontrado registros para los datos suministrados.";

	public NoDataFoundException() {
		super(CODE, DEFAULT_MESSAGE);
	}

	public NoDataFoundException(String message, Object... args) {
		super(CODE, message, args);
	}

}
