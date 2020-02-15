/**
 * 
 */
package cl.liberty.model;

import java.io.Serializable;

/**
 * @author jgarrido
 *
 */
public class Flow implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer flowId;
	private String flowDescription;
	
	@Override
	public String toString() {
		return "Flow [flowId=" + flowId + ", flowDescription=" + flowDescription + "]";
	}

	public Integer getFlowId() {
		return flowId;
	}

	public void setFlowId(Integer flowId) {
		this.flowId = flowId;
	}

	public String getFlowDescription() {
		return flowDescription;
	}

	public void setFlowDescription(String flowDescription) {
		this.flowDescription = flowDescription;
	}
	
	
	
	
}
