/**
 * 
 */
package cl.liberty.response;

import java.io.Serializable;

/**
 * @author joseg
 *
 */
public class OperationResponse implements Serializable {

	private static final long serialVersionUID = 5499721093093154777L;

	private int result;
	private String message;
	private Long id;
	private Exception exception;
	
	@Override
	public String toString() {
		return "OperationResponse [result=" + result + ", message=" + message + ", id=" + id + ", exception="
				+ exception + "]";
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	

}
