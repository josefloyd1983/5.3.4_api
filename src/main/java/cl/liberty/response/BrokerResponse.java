/**
 * 
 */
package cl.liberty.response;

import java.util.List;

import cl.liberty.model.Broker;

/**
 * @author jgarrido
 *
 */
public class BrokerResponse {

	List<Broker> brokers;

	@Override
	public String toString() {
		return "BrokerResponse [brokers=" + brokers + "]";
	}

	public List<Broker> getBrokers() {
		return brokers;
	}

	public void setBrokers(List<Broker> brokers) {
		this.brokers = brokers;
	}

}
