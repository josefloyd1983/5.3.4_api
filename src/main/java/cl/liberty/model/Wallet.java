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
public class Wallet implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer walletId;
	private String walletName;
	private Integer policyNumber;
	private String validityStartDate;
	private String validityEndDate;
	private Integer contractorCode;
	private String contractorDescription;
	private Integer flowId;
	private String flowDescription;
	private Integer usingId;
	private String usingDescription;
	private Integer brokerCode;
	private String brokerDescription;
	private Integer status;
	private List<WalletCoverage> walletCoverages;
	private List<Coverage> coverages;
	
	
	@Override
	public String toString() {
		return "Wallet [walletId=" + walletId + ", walletName=" + walletName + ", policyNumber=" + policyNumber
				+ ", validityStartDate=" + validityStartDate + ", validityEndDate=" + validityEndDate
				+ ", contractorCode=" + contractorCode + ", contractorDescription=" + contractorDescription
				+ ", flowId=" + flowId + ", flowDescription=" + flowDescription + ", usingId=" + usingId
				+ ", usingDescription=" + usingDescription + ", brokerCode=" + brokerCode + ", brokerDescription="
				+ brokerDescription + ", status=" + status + ", walletCoverages=" + walletCoverages + ", coverages="
				+ coverages + "]";
	}

	public Integer getWalletId() {
		return walletId;
	}

	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}

	public String getWalletName() {
		return walletName;
	}

	public void setWalletName(String walletName) {
		this.walletName = walletName;
	}

	public Integer getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(Integer policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getValidityStartDate() {
		return validityStartDate;
	}

	public void setValidityStartDate(String validityStartDate) {
		this.validityStartDate = validityStartDate;
	}

	public String getValidityEndDate() {
		return validityEndDate;
	}

	public void setValidityEndDate(String validityEndDate) {
		this.validityEndDate = validityEndDate;
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

	public Integer getFlowId() {
		return flowId;
	}

	public void setFlowId(Integer flowId) {
		this.flowId = flowId;
	}

	public String getFlowDescription() {
		return flowDescription;
	}

	public void setFlowDescription(String flowDescription) {
		this.flowDescription = flowDescription;
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

	public Integer getBrokerCode() {
		return brokerCode;
	}

	public void setBrokerCode(Integer brokerCode) {
		this.brokerCode = brokerCode;
	}

	public String getBrokerDescription() {
		return brokerDescription;
	}

	public void setBrokerDescription(String brokerDescription) {
		this.brokerDescription = brokerDescription;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<WalletCoverage> getWalletCoverages() {
		return walletCoverages;
	}

	public void setWalletCoverages(List<WalletCoverage> walletCoverages) {
		this.walletCoverages = walletCoverages;
	}

	public List<Coverage> getCoverages() {
		return coverages;
	}

	public void setCoverages(List<Coverage> coverages) {
		this.coverages = coverages;
	}
	
	public boolean isWalletCoverageCheck(List<WalletCoverage> walletCoverages, int code) {
		boolean resultado = false;
		for (WalletCoverage walletCoverage : walletCoverages) {
			if (walletCoverage.getWalletCoverageCode() == code) {
				resultado = true;
				break;
			}
		}
		return resultado;
	}
	
	
	

}
