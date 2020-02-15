/**
 * 
 */
package cl.liberty.model;

import java.io.Serializable;

/**
 * @author jgarrido
 *
 */
public class ValidityStart implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String validityStartDate;

	@Override
	public String toString() {
		return "ValidityStart [validityStartDate=" + validityStartDate + "]";
	}

	public String getValidityStartDate() {
		return validityStartDate;
	}

	public void setValidityStartDate(String validityStartDate) {
		this.validityStartDate = validityStartDate;
	}

	
	
	
	

}
