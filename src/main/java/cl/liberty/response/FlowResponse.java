/**
 * 
 */
package cl.liberty.response;

import java.util.List;

import cl.liberty.model.Flow;

/**
 * @author jgarrido
 *
 */
public class FlowResponse {

	List<Flow> flows;

	@Override
	public String toString() {
		return "FlowResponse [flows=" + flows + "]";
	}

	public List<Flow> getFlows() {
		return flows;
	}

	public void setFlows(List<Flow> flows) {
		this.flows = flows;
	}

}
