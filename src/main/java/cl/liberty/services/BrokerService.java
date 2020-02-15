/**
 * 
 */
package cl.liberty.services;

import java.util.List;

import cl.liberty.model.Broker;
import cl.liberty.request.BrokerRequest;
import cl.liberty.response.OperationResponse;

/**
 * @author jgarrido
 *
 */
public interface BrokerService {

	public List<Broker> getBrokers();

	public Broker getBroker(Integer brokerCode);

	public Broker getBrokerByCode(Integer code);

	public OperationResponse addBroker(BrokerRequest brokerRequest);

	public OperationResponse editBroker(BrokerRequest brokerRequest);

	public OperationResponse deleteBroker(Integer brokerCode);

	public boolean validateBrokerExist(Integer brokerCode);
}
