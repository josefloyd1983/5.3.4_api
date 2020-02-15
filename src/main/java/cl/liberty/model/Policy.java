/**
 * 
 */
package cl.liberty.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author jgarrido
 *
 */
public class Policy implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer policyBranch;
	private String policyBranchName;
	private Integer policyNumber;
	private Integer contractorCode;
	private String  contractorName;
	private Integer brokerCode;
	private String brokerName;
	private String validityStartDate;
	private String validityEndDate;
	private Integer policyUsingId;
	private List<PolicyCoverage> policyCoverages;
	private List<Coverage> coverages;
	
	@Override
	public String toString() {
		return "Policy [policyBranch=" + policyBranch + ", policyBranchName=" + policyBranchName + ", policyNumber="
				+ policyNumber + ", contractorCode=" + contractorCode + ", contractorName=" + contractorName
				+ ", brokerCode=" + brokerCode + ", brokerName=" + brokerName + ", validityStartDate="
				+ validityStartDate + ", validityEndDate=" + validityEndDate + ", policyUsingId=" + policyUsingId
				+ ", policyCoverages=" + policyCoverages + ", coverages=" + coverages + "]";
	}

	public Integer getPolicyBranch() {
		return policyBranch;
	}

	public String getPolicyBranchName() {
		return policyBranchName;
	}

	public Integer getPolicyNumber() {
		return policyNumber;
	}

	public Integer getContractorCode() {
		return contractorCode;
	}

	public String getContractorName() {
		return contractorName;
	}

	public Integer getBrokerCode() {
		return brokerCode;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public String getValidityStartDate() {
		return validityStartDate;
	}

	public String getValidityEndDate() {
		return validityEndDate;
	}

	public List<PolicyCoverage> getPolicyCoverages() {
		return policyCoverages;
	}

	public void setPolicyBranch(Integer policyBranch) {
		this.policyBranch = policyBranch;
	}

	public void setPolicyBranchName(String policyBranchName) {
		this.policyBranchName = policyBranchName;
	}

	public void setPolicyNumber(Integer policyNumber) {
		this.policyNumber = policyNumber;
	}

	public void setContractorCode(Integer contractorCode) {
		this.contractorCode = contractorCode;
	}

	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}

	public void setBrokerCode(Integer brokerCode) {
		this.brokerCode = brokerCode;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}

	public void setValidityStartDate(String validityStartDate) {
		this.validityStartDate = validityStartDate;
	}

	public void setValidityEndDate(String validityEndDate) {
		this.validityEndDate = validityEndDate;
	}

	public void setPolicyCoverages(List<PolicyCoverage> policyCoverages) {
		this.policyCoverages = policyCoverages;
	}

	public List<Coverage> getCoverages() {
		return coverages;
	}

	public void setCoverages(List<Coverage> coverages) {
		this.coverages = coverages;
	}

	public Integer getPolicyUsingId() {
		return policyUsingId;
	}

	public void setPolicyUsingId(Integer policyUsingId) {
		this.policyUsingId = policyUsingId;
	}
	
	public boolean isPolicyCoverageCheck(List<PolicyCoverage> policyCoverages, int code) {
		boolean resultado = false;
		for (PolicyCoverage policyCoverage : policyCoverages) {
			if (policyCoverage.getPolicyCoverageCode() == code) {
				resultado = true;
				break;
			}
		}
		return resultado;
	}
}
