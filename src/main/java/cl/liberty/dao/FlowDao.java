/**
 * 
 */
package cl.liberty.dao;

import java.util.List;

import cl.liberty.model.Flow;
import cl.liberty.request.FlowRequest;

/**
 * @author jgarrido
 *
 */
public interface FlowDao {

	public List<Flow> getFlows();

	public Flow getFlow(Integer flowId);

	public void addFlow(FlowRequest flowRequest);

	public void editFlow(FlowRequest flowRequest);

	public void deleteFlow(Integer flowId);

	public boolean validateFlowExist(Integer flowId);

}
