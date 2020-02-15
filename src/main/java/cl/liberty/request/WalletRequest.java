/**
 * 
 */
package cl.liberty.request;

import java.io.Serializable;

/**
 * @author joseg
 *
 */
public class WalletRequest implements Serializable {

	private static final long serialVersionUID = 4155055822525802475L;

	private Integer walletId;
	private String walletName;
	private Integer policyNumber;
	private String validityStartDate;
	private String validityEndDate;
	private Integer contractorCode;
	private String contractorDescription;
	private Integer flowId;
	private Integer usingId;
	private Integer brokerCode;
	private String brokerDescription;
	private Integer status;
	
	@Override
	public String toString() {
		return "WalletRequest [walletId=" + walletId + ", walletName=" + walletName + ", policyNumber=" + policyNumber
				+ ", validityStartDate=" + validityStartDate + ", validityEndDate=" + validityEndDate
				+ ", contractorCode=" + contractorCode + ", contractorDescription=" + contractorDescription
				+ ", flowId=" + flowId + ", usingId=" + usingId + ", brokerCode=" + brokerCode + ", brokerDescription="
				+ brokerDescription + ", status=" + status + "]";
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

	public Integer getUsingId() {
		return usingId;
	}

	public void setUsingId(Integer usingId) {
		this.usingId = usingId;
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



}
