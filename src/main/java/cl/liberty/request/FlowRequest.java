/**
 * 
 */
package cl.liberty.request;

import java.io.Serializable;

/**
 * @author joseg
 *
 */
public class FlowRequest implements Serializable {

	private static final long serialVersionUID = 4155055822525802475L;

	private Long flowId;
	private String flowDescription;

	@Override
	public String toString() {
		return "FlowRequest [flowId=" + flowId + ", flowDescription=" + flowDescription + "]";
	}

	public Long getFlowId() {
		return flowId;
	}

	public void setFlowId(Long flowId) {
		this.flowId = flowId;
	}

	public String getFlowDescription() {
		return flowDescription;
	}

	public void setFlowDescription(String flowDescription) {
		this.flowDescription = flowDescription;
	}

}
