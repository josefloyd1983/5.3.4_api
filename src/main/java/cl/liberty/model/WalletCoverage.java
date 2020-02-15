/**
 * 
 */
package cl.liberty.model;

import java.io.Serializable;

/**
 * @author jgarrido
 *
 */
public class WalletCoverage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer walletCoverageCode;
	private String walletCoverageName;
	private String walletCoverageUsing;
	
	@Override
	public String toString() {
		return "WalletCoverage [walletCoverageCode=" + walletCoverageCode + ", walletCoverageName=" + walletCoverageName
				+ ", walletCoverageUsing=" + walletCoverageUsing + "]";
	}

	public Integer getWalletCoverageCode() {
		return walletCoverageCode;
	}

	public void setWalletCoverageCode(Integer walletCoverageCode) {
		this.walletCoverageCode = walletCoverageCode;
	}

	public String getWalletCoverageName() {
		return walletCoverageName;
	}

	public void setWalletCoverageName(String walletCoverageName) {
		this.walletCoverageName = walletCoverageName;
	}

	public String getWalletCoverageUsing() {
		return walletCoverageUsing;
	}

	public void setWalletCoverageUsing(String walletCoverageUsing) {
		this.walletCoverageUsing = walletCoverageUsing;
	}
	
	

}
