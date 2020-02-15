/**
 * 
 */
package cl.liberty.response;

import java.util.List;

import cl.liberty.model.Wallet;

/**
 * @author jgarrido
 *
 */
public class WalletResponse {

	List<Wallet> wallets;

	@Override
	public String toString() {
		return "WalletListResponse [wallets=" + wallets + "]";
	}

	public List<Wallet> getWallets() {
		return wallets;
	}

	public void setWallets(List<Wallet> wallets) {
		this.wallets = wallets;
	}

}
