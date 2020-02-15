/**
 * 
 */
package cl.liberty.model;

import java.io.Serializable;

/**
 * @author jgarrido
 *
 */
public class WalletHistory implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer logId;
	private String oldValue;
	private String newValue;
	private String modificationDate;
	private Integer eventId;
	private String eventName;
	private Integer userId;
	private String userName;
	private Integer policyNumber;
	private Integer brokerCode;
	private String brokerName;
	private Integer contractorCode;
	private String contractorDescription;
	
	@Override
	public String toString() {
		return "WalletHistory [logId=" + logId + ", oldValue=" + oldValue + ", newValue=" + newValue
				+ ", modificationDate=" + modificationDate + ", eventId=" + eventId + ", eventName=" + eventName
				+ ", userId=" + userId + ", userName=" + userName + ", policyNumber=" + policyNumber + ", brokerCode="
				+ brokerCode + ", brokerName=" + brokerName + ", contractorCode=" + contractorCode
				+ ", contractorDescription=" + contractorDescription + "]";
	}

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public String getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(Integer policyNumber) {
		this.policyNumber = policyNumber;
	}

	public Integer getBrokerCode() {
		return brokerCode;
	}

	public void setBrokerCode(Integer brokerCode) {
		this.brokerCode = brokerCode;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
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
