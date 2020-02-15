package cl.liberty.exception;

/**
 * @author jgarrido
 *
 */
public class DuplicateEntityException extends ApplicationCommonException {

    private static final long serialVersionUID = 1L;
   
    private static final int CODE = 409;
    
    private static final String MESSAGE = "Esta entidad ya ha sido registrada.";

    public DuplicateEntityException() {
        super(CODE, MESSAGE);
    }

}