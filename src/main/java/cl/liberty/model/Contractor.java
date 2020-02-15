/**
 * 
 */
package cl.liberty.model;

import java.io.Serializable;

/**
 * @author jgarrido
 *
 */
public class Contractor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer contractorCode;
	private String contractorDescription;
	
	@Override
	public String toString() {
		return "Contractor [contractorCode=" + contractorCode + ", contractorDescription=" + contractorDescription
				+ "]";
	}

	public Integer getContractorCode() {
		return contractorCode;
	}

	public void setContractorCode(Integer contractorCode) {
		this.contractorCode = contractorCode;
	}

	public String getContractorDescription() {
		return contractorDescription;
	}

	public void setContractorDescription(String contractorDescription) {
		this.contractorDescription = contractorDescription;
	}
	
	

}
