package cl.liberty.exception;

/**
 * @author jgarrido
 *
 */
public class IntegrityViolationException extends ApplicationCommonException {

    private static final long serialVersionUID = 1L;
    
    private static final int CODE = 400;
    
    private static final String MESSAGE = "Ha ocurrido una violacion de entidad referencial. "
            + "Por favor validar que la entidad sobre la cual se esta operando no sea una dependencia de otras entidades.";

    public IntegrityViolationException() {
        super(CODE, MESSAGE);
    }

    public IntegrityViolationException(String message) {
        super(CODE, message);
    }

    public IntegrityViolationException(Throwable t) {
        super(CODE, t);
    }
}