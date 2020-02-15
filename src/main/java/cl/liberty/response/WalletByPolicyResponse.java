/**
 * 
 */
package cl.liberty.response;

import cl.liberty.model.Wallet;

/**
 * @author jgarrido
 *
 */
public class WalletByPolicyResponse {

	Wallet wallet;

	@Override
	public String toString() {
		return "WalletPolicyResponse [wallet=" + wallet + "]";
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

}
