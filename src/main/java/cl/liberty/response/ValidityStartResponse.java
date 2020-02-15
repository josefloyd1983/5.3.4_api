/**
 * 
 */
package cl.liberty.response;

import java.util.List;

import cl.liberty.model.ValidityStart;

/**
 * @author jgarrido
 *
 */
public class ValidityStartResponse {

	List<ValidityStart> validityStarts;

	@Override
	public String toString() {
		return "ValidityStartResponse [validityStarts=" + validityStarts + "]";
	}

	public List<ValidityStart> getValidityStarts() {
		return validityStarts;
	}

	public void setValidityStarts(List<ValidityStart> validityStarts) {
		this.validityStarts = validityStarts;
	}

}
