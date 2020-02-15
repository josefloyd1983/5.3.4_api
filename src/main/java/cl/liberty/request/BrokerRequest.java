/**
 * 
 */
package cl.liberty.request;

import java.io.Serializable;

/**
 * @author joseg
 *
 */
public class BrokerRequest implements Serializable {

	private static final long serialVersionUID = 4155055822525802475L;

	private Integer brokerCode;
	private String brokerDescription;

	@Override
	public String toString() {
		return "BrokerRequest [brokerCode=" + brokerCode + ", brokerDescription=" + brokerDescription + "]";
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

}
