/**
 * 
 */
package cl.liberty.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.liberty.constantes.Constantes;
import cl.liberty.constantes.Errores;
import cl.liberty.dao.BrokerDao;
import cl.liberty.dao.ContractorDao;
import cl.liberty.dao.PropertyDao;
import cl.liberty.dao.WalletDao;
import cl.liberty.model.Coverage;
import cl.liberty.model.Property;
import cl.liberty.model.ValidityStart;
import cl.liberty.model.Wallet;
import cl.liberty.model.WalletCoverage;
import cl.liberty.model.WalletHistory;
import cl.liberty.request.BrokerRequest;
import cl.liberty.request.ContractorRequest;
import cl.liberty.request.WalletRequest;
import cl.liberty.response.OperationResponse;
import cl.liberty.response.WalletByPolicyResponse;
import cl.liberty.services.WalletService;
import cl.liberty.utils.UtilAMS;

/**
 * @author jgarrido
 *
 */

@Repository
public class WalletServiceImpl implements WalletService {

	private static final Logger logger = LoggerFactory.getLogger(WalletServiceImpl.class);

	@Autowired
	private WalletDao walletDao;

	@Autowired
	private ContractorDao contractorDao;

	@Autowired
	private BrokerDao brokerDao;

	@Autowired
	PropertyDao propertyDao;

	@Override
	@Transactional
	public WalletByPolicyResponse wallet(Integer policyNumber, Integer contractorCode, Integer brokerCode,
			String validInYears, Integer idPadre) {
		WalletByPolicyResponse result = new WalletByPolicyResponse();
		Wallet wallet;
		List<WalletCoverage> walletCoverages = new ArrayList<>();
		try {
			wallet = walletDao.getWallet(policyNumber, contractorCode, brokerCode, validInYears);
			walletCoverages = walletDao.getWalletCoverages(policyNumber, -1, Constantes.PROPERTY_ID_PADRE);
			wallet.setWalletCoverages(walletCoverages);
			if (!walletCoverages.isEmpty()) {
				result.setWallet(wallet);
			}
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	@Transactional
	public List<Wallet> wallets(Integer policyNumber, Integer contractorCode, Integer brokerCode, String validInYears,
			Integer idPadre) {
		Wallet wallet = new Wallet();
		List<Wallet> result = new ArrayList<>();
		List<WalletCoverage> walletCoverages = new ArrayList<>();
		List<Coverage> coverages = new ArrayList<>();
		try {
			result = walletDao.getWallets(policyNumber, contractorCode, brokerCode, validInYears, idPadre);
			for (int i = 0; i < result.size(); i++) {
				walletCoverages = walletDao.getWalletCoverages(result.get(i).getPolicyNumber(), -1,
						Constantes.PROPERTY_ID_PADRE);
				result.get(i).setWalletCoverages(walletCoverages);

				List<Property> propertys = propertyDao.getPropertys(Constantes.PROPERTY_ID_PADRE);
				for (int j = 0; j < propertys.size(); j++) {
					Coverage coverage = new Coverage();
					coverage.setCoverageCode(Integer.valueOf(propertys.get(j).getValue()));
					coverage.setCoverageName(propertys.get(j).getDescription());
					coverage.setCoverageUsing(UtilAMS.usingDescription(Integer.parseInt(propertys.get(j).getValue())));
					coverage.setCoverageCheck(wallet.isWalletCoverageCheck(walletCoverages,
							Integer.valueOf(propertys.get(j).getValue())));
					coverages.add(coverage);
				}
				result.get(i).setCoverages(coverages);

			}
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	@Transactional
	public List<WalletHistory> getWalletHistorys(Integer policyNumber, Integer idUser) {
		List<WalletHistory> result = new ArrayList<>();
		try {
			result = walletDao.getWalletHistorys(policyNumber, idUser);
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	@Transactional(readOnly = false)
	public OperationResponse addWallet(WalletRequest walletRequest) {
		OperationResponse result = new OperationResponse();
		try {

			if (!contractorDao.validateContractorExist(walletRequest.getContractorCode())) {
				logger.info("Se agrega contratante");
				ContractorRequest contractorAddRequest = new ContractorRequest();
				contractorAddRequest.setContractorCode(walletRequest.getContractorCode());
				contractorAddRequest.setContractorDescription(walletRequest.getContractorDescription());
				contractorDao.addContractor(contractorAddRequest);
			}

			if (!brokerDao.validateBrokerExist(walletRequest.getBrokerCode())) {
				logger.info("Se agrega corredor");
				BrokerRequest brokerRequest = new BrokerRequest();
				brokerRequest.setBrokerCode(walletRequest.getBrokerCode());
				brokerRequest.setBrokerDescription(walletRequest.getBrokerDescription());
				brokerDao.addBroker(brokerRequest);
			}

			walletDao.addWallet(walletRequest);
			Wallet wallet = getWallet(walletRequest.getPolicyNumber(), -1, -1, "-1");
			
			result.setResult(Constantes.SUCCESS);
			result.setMessage("Cartera registrado exitosamente");
			result.setId(Long.valueOf(wallet.getPolicyNumber()));
			
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
			result.setException(e);
			result.setResult(Constantes.ERROR);
			result.setMessage("Error al registrar cartera");
		}
		return result;
	}

	@Override
	@Transactional(readOnly = false)
	public OperationResponse editWallet(WalletRequest walletRequest) {
		OperationResponse result = new OperationResponse();
		try {

			Wallet wallet = walletDao.getWallet(walletRequest.getPolicyNumber(), -1, -1, "-1");
			if (wallet != null) {
				walletDao.editWallet(walletRequest);
				result.setResult(Constantes.SUCCESS);
				result.setMessage("Cartera modificado exitosamente");
				result.setId((long) walletRequest.getWalletId());
			} else {
				result.setResult(Constantes.ERROR);
				result.setMessage("Error al modificar cartera");
			}
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
			result.setException(e);
			result.setResult(Constantes.ERROR);
			result.setMessage("Error al modificar cartera");
			result.setId((long) walletRequest.getWalletId());
		}
		return result;
	}

	@Override
	@Transactional(readOnly = false)
	public OperationResponse deleteWallet(Integer walletId) {
		OperationResponse result = new OperationResponse();
		try {
			walletDao.deleteWallet(walletId);
			result.setResult(Constantes.SUCCESS);
			result.setMessage("Cartera eliminado exitosamente");
			result.setId(Long.valueOf(walletId));

		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
			result.setException(e);
			result.setResult(Constantes.ERROR);
			result.setMessage("Error al eliminar cartera");
			result.setId(Long.valueOf(walletId));
		}
		return result;
	}

	@Override
	@Transactional
	public boolean validateWalletExist(Integer walletId) {
		boolean exist = false;
		try {
			exist = walletDao.validateWalletExist(walletId);
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return exist;
	}

	@Override
	@Transactional
	public List<ValidityStart> getValidityStarts() {
		List<ValidityStart> result = new ArrayList<>();
		try {
			result = walletDao.getValidityStarts();
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	@Transactional
	public Wallet getWallet(Integer policyNumber, Integer contractorCode, Integer brokerCode, String validInYears) {
		Wallet result = null;
		try {
			result = walletDao.getWallet(policyNumber, contractorCode, brokerCode, validInYears);
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return result;
	}
}
