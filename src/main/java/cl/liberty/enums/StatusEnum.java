/**
 * 
 */
package cl.liberty.enums;

/**
 * @author jgarrido
 *
 */
public enum StatusEnum {
	
	UNBLOCKED_USER(1), 
	BLOCKED_USER(0);
	
	private final int code;

	StatusEnum(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

}
