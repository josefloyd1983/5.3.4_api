/**
 * 
 */
package cl.liberty.model;

import java.io.Serializable;

/**
 * @author jgarrido
 *
 */
public class Using implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer usingId;
	private String usingDescription;
	
	@Override
	public String toString() {
		return "Using [usingId=" + usingId + ", usingDescription=" + usingDescription + "]";
	}

	public Integer getUsingId() {
		return usingId;
	}

	public void setUsingId(Integer usingId) {
		this.usingId = usingId;
	}

	public String getUsingDescription() {
		return usingDescription;
	}

	public void setUsingDescription(String usingDescription) {
		this.usingDescription = usingDescription;
	}
	
	

}
