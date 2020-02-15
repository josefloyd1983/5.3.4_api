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
import cl.liberty.dao.ContractorDao;
import cl.liberty.model.Contractor;
import cl.liberty.request.ContractorRequest;
import cl.liberty.response.OperationResponse;
import cl.liberty.services.ContractorService;

/**
 * @author jgarrido
 *
 */

@Repository
public class ContractorServiceImpl implements ContractorService {

	private static final Logger logger = LoggerFactory.getLogger(ContractorServiceImpl.class);

	@Autowired
	private ContractorDao contractorDao;

	@Override
	@Transactional
	public List<Contractor> getContractors() {
		List<Contractor> result = new ArrayList<>();
		try {
			result = contractorDao.getContractors();
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	@Transactional(readOnly = false)
	public OperationResponse addContractor(ContractorRequest contractorRequest) {
		OperationResponse result = new OperationResponse();
		try {
			contractorDao.addContractor(contractorRequest);
			result.setResult(Constantes.SUCCESS);
			result.setMessage("Contratante registrado exitosamente");
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
			result.setException(e);
			result.setResult(Constantes.ERROR);
			result.setMessage("Error al registrar contratante");
		}
		return result;
	}

	@Override
	@Transactional(readOnly = false)
	public OperationResponse deleteContractor(Integer contractorId) {
		OperationResponse result = new OperationResponse();
		try {
			contractorDao.deleteContractor(contractorId);
			result.setResult(Constantes.SUCCESS);
			result.setMessage("Corredor eliminado exitosamente");
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
			result.setException(e);
			result.setResult(Constantes.ERROR);
			result.setMessage("Error al eliminar corredor");
		}
		return result;
	}

	@Override
	@Transactional
	public boolean validateContractorExist(Integer contractorCode) {
		boolean exist = false;
		try {
			exist = contractorDao.validateContractorExist(contractorCode);
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return exist;
	}

}
