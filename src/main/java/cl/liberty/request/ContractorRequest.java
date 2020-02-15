/**
 * 
 */
package cl.liberty.request;

import java.io.Serializable;

/**
 * @author joseg
 *
 */
public class ContractorRequest implements Serializable {

	private static final long serialVersionUID = 4155055822525802475L;

	private Integer contractorCode;
	private String contractorDescription;

	@Override
	public String toString() {
		return "ContractorRequest [contractorCode=" + contractorCode + ", contractorDescription="
				+ contractorDescription + "]";
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
