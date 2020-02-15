/**
 * 
 */
package cl.liberty.request;

import java.io.Serializable;

/**
 * @author joseg
 *
 */
public class LogRequest implements Serializable {

	private static final long serialVersionUID = 4155055822525802475L;

	private Integer logId;
	private Integer userId;
	private Integer walletId;
	private Integer policyNumber;
	private Integer eventId;
	private String valueNew;
	private String valueOld;

	@Override
	public String toString() {
		return "LogRequest [logId=" + logId + ", userId=" + userId + ", walletId=" + walletId + ", policyNumber="
				+ policyNumber + ", eventId=" + eventId + ", valueNew=" + valueNew + ", valueOld=" + valueOld + "]";
	}

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getWalletId() {
		return walletId;
	}

	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getValueNew() {
		return valueNew;
	}

	public void setValueNew(String valueNew) {
		this.valueNew = valueNew;
	}

	public String getValueOld() {
		return valueOld;
	}

	public void setValueOld(String valueOld) {
		this.valueOld = valueOld;
	}

	public Integer getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(Integer policyNumber) {
		this.policyNumber = policyNumber;
	}

	

}
