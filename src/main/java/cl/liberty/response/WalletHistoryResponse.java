/**
 * 
 */
package cl.liberty.response;

import java.util.List;

import cl.liberty.model.WalletHistory;

/**
 * @author jgarrido
 *
 */
public class WalletHistoryResponse {

	List<WalletHistory> walletHistorys;

	@Override
	public String toString() {
		return "WalletHistoryResponse [walletHistorys=" + walletHistorys + "]";
	}

	public List<WalletHistory> getWalletHistorys() {
		return walletHistorys;
	}

	public void setWalletHistorys(List<WalletHistory> walletHistorys) {
		this.walletHistorys = walletHistorys;
	}

}
