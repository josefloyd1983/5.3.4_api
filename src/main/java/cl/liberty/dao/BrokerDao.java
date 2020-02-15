/**
 * 
 */
package cl.liberty.dao;

import java.util.List;

import cl.liberty.model.Broker;
import cl.liberty.request.BrokerRequest;

/**
 * @author jgarrido
 *
 */
public interface BrokerDao {

	public List<Broker> getBrokers();

	public Broker getBroker(Integer brokerCode);

	public Broker getBrokerByCode(Integer code);

	public void addBroker(BrokerRequest brokerRequest);

	public void editBroker(BrokerRequest brokerRequest);

	public void deleteBroker(Integer brokerCode);

	public boolean validateBrokerExist(Integer brokerCode);

}
