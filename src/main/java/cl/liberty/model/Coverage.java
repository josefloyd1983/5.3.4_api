/**
 * 
 */
package cl.liberty.model;

import java.io.Serializable;

/**
 * @author jgarrido
 *
 */
public class Coverage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer coverageCode;
	private String coverageName;
	private String coverageUsing;
	private boolean coverageCheck;
	
	@Override
	public String toString() {
		return "Coverage [coverageCode=" + coverageCode + ", coverageName=" + coverageName + ", coverageUsing="
				+ coverageUsing + ", coverageCheck=" + coverageCheck + "]";
	}

	public Integer getCoverageCode() {
		return coverageCode;
	}

	public void setCoverageCode(Integer coverageCode) {
		this.coverageCode = coverageCode;
	}

	public String getCoverageName() {
		return coverageName;
	}

	public void setCoverageName(String coverageName) {
		this.coverageName = coverageName;
	}

	public String getCoverageUsing() {
		return coverageUsing;
	}

	public void setCoverageUsing(String coverageUsing) {
		this.coverageUsing = coverageUsing;
	}

	public boolean isCoverageCheck() {
		return coverageCheck;
	}

	public void setCoverageCheck(boolean coverageCheck) {
		this.coverageCheck = coverageCheck;
	}
}
