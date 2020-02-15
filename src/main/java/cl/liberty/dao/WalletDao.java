/**
 * 
 */
package cl.liberty.dao;

import java.util.List;

import cl.liberty.model.ValidityStart;
import cl.liberty.model.Wallet;
import cl.liberty.model.WalletCoverage;
import cl.liberty.model.WalletHistory;
import cl.liberty.request.WalletRequest;

/**
 * @author jgarrido
 *
 */
public interface WalletDao {

	public Wallet getWallet(Integer policyNumber, Integer contractorCode, Integer brokerCode, String validInYears);

	public List<Wallet> getWallets(Integer policyNumber, Integer contractorCode, Integer brokerCode,
			String validInYears, Integer idPadre);

	public List<WalletCoverage> getWalletCoverages(Integer policyNumber, Integer branchNumber, Integer idPadre);

	public List<WalletHistory> getWalletHistorys(Integer policyNumber, Integer userId);

	public void addWallet(WalletRequest walletRequest);

	public void editWallet(WalletRequest walletRequest);

	public void deleteWallet(Integer walletId);

	public boolean validateWalletExist(Integer walletId);

	public List<ValidityStart> getValidityStarts();

}
