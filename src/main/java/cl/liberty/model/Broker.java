/**
 * 
 */
package cl.liberty.model;

import java.io.Serializable;

/**
 * @author jgarrido
 *
 */
public class Broker implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer brokerCode;
	private String brokerDescription;
	
	@Override
	public String toString() {
		return "Broker [brokerCode=" + brokerCode + ", brokerDescription=" + brokerDescription + "]";
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
