package cl.liberty.exception;

/**
 *
 * @author jgarrido
 *
 */
public class BadRequestException extends ApplicationCommonException {

    private static final long serialVersionUID = 1L;
    
    private static final int CODE = 400;

    public BadRequestException(String message) {
        super(CODE, message);
    }

    public BadRequestException(Throwable t) {
        super(CODE, t.getMessage());
    }

}