/**
 * 
 */
package cl.liberty.services;

import java.util.List;

import cl.liberty.model.ValidityStart;
import cl.liberty.model.Wallet;
import cl.liberty.model.WalletHistory;
import cl.liberty.request.WalletRequest;
import cl.liberty.response.OperationResponse;
import cl.liberty.response.WalletByPolicyResponse;

/**
 * @author jgarrido
 *
 */
public interface WalletService {
	
	public Wallet getWallet(Integer policyNumber, Integer contractorCode, Integer brokerCode, String validInYears);

	public WalletByPolicyResponse wallet(Integer policyNumber, Integer contractorCode, Integer brokerCode,
			String validInYears, Integer idPadre);

	public List<WalletHistory> getWalletHistorys(Integer policyNumber, Integer idUser);

	public List<Wallet> wallets(Integer policyNumber, Integer contractorCode, Integer brokerCode, String validInYears,
			Integer idPadre);

	public OperationResponse addWallet(WalletRequest walletRequest);

	public OperationResponse editWallet(WalletRequest walletRequest);

	public OperationResponse deleteWallet(Integer walletId);

	public boolean validateWalletExist(Integer walletId);

	public List<ValidityStart> getValidityStarts();

}
