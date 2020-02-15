/**
 * 
 */
package cl.liberty.model;

import java.io.Serializable;

/**
 * @author jgarrido
 *
 */
public class PolicyCoverage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer policyCoverageCode;
	private String policyCoverageName;
	private String policyCoverageUsing;
	
	@Override
	public String toString() {
		return "PolicyCoverage [policyCoverageCode=" + policyCoverageCode + ", policyCoverageName=" + policyCoverageName
				+ ", policyCoverageUsing=" + policyCoverageUsing + "]";
	}

	public Integer getPolicyCoverageCode() {
		return policyCoverageCode;
	}

	public void setPolicyCoverageCode(Integer policyCoverageCode) {
		this.policyCoverageCode = policyCoverageCode;
	}

	public String getPolicyCoverageName() {
		return policyCoverageName;
	}

	public void setPolicyCoverageName(String policyCoverageName) {
		this.policyCoverageName = policyCoverageName;
	}

	public String getPolicyCoverageUsing() {
		return policyCoverageUsing;
	}

	public void setPolicyCoverageUsing(String policyCoverageUsing) {
		this.policyCoverageUsing = policyCoverageUsing;
	}
	

}
