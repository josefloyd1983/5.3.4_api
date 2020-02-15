/**
 * 
 */
package cl.liberty.response;

import java.util.List;

import cl.liberty.model.Contractor;

/**
 * @author jgarrido
 *
 */
public class ContractorResponse {

	List<Contractor> contractors;

	@Override
	public String toString() {
		return "ContractorResponse [contractors=" + contractors + "]";
	}

	public List<Contractor> getContractors() {
		return contractors;
	}

	public void setContractors(List<Contractor> contractors) {
		this.contractors = contractors;
	}

}
