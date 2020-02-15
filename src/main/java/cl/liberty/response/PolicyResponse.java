/**
 * 
 */
package cl.liberty.response;

import java.util.List;

import cl.liberty.model.Policy;

/**
 * @author jgarrido
 *
 */
public class PolicyResponse {

	List<Policy> policys;

	@Override
	public String toString() {
		return "PolicyResponse [policys=" + policys + "]";
	}

	public List<Policy> getPolicys() {
		return policys;
	}

	public void setPolicys(List<Policy> policys) {
		this.policys = policys;
	}

}
