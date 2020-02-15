package cl.liberty.exception;

/**
 *
 * @author jgarrido
 */
public class CacheStateException extends ApplicationCommonException {

    private static final long serialVersionUID = 1L;
    
    private static final int CODE = 500;

    public CacheStateException(String message, Object... args) {
        super(CODE, message, args);
    }
}