/**
 * 
 */
package cl.liberty.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author jgarrido
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private Integer result;
	private String message;
	private String exception;
	private int id;
	
	@Override
	public String toString() {
		return "Data [result=" + result + ", message=" + message + ", exception=" + exception + ", id=" + id + "]";
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

}
