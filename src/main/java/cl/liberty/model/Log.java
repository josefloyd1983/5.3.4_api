/**
 * 
 */
package cl.liberty.model;

import java.io.Serializable;

/**
 * @author jgarrido
 *
 */
public class Log implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer logId;
	private Integer userId;
	private Integer eventId;
	private String valueNew;
	private String valueOld;
	private String modificatioDate;
	
	@Override
	public String toString() {
		return "Log [logId=" + logId + ", userId=" + userId + ", eventId=" + eventId + ", valueNew=" + valueNew
				+ ", valueOld=" + valueOld + ", modificatioDate=" + modificatioDate + "]";
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

	public String getModificatioDate() {
		return modificatioDate;
	}

	public void setModificatioDate(String modificatioDate) {
		this.modificatioDate = modificatioDate;
	}
	


}
