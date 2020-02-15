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
import cl.liberty.model.Broker;
import cl.liberty.request.BrokerRequest;
import cl.liberty.response.OperationResponse;
import cl.liberty.services.BrokerService;

/**
 * @author jgarrido
 *
 */

@Repository
public class BrokerServiceImpl implements BrokerService {

	private static final Logger logger = LoggerFactory.getLogger(BrokerServiceImpl.class);

	@Autowired
	private BrokerDao brokerDao;

	@Override
	@Transactional
	public List<Broker> getBrokers() {
		List<Broker> result = new ArrayList<>();
		try {
			result = brokerDao.getBrokers();
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);

		}
		return result;
	}

	@Override
	@Transactional
	public Broker getBroker(Integer brokerCode) {
		Broker result = null;
		try {
			result = brokerDao.getBroker(brokerCode);
		}  catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	@Transactional
	public Broker getBrokerByCode(Integer code) {
		Broker result = null;
		try {
			result = brokerDao.getBrokerByCode(code);
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	@Transactional(readOnly = false)
	public OperationResponse addBroker(BrokerRequest brokerRequest) {
		OperationResponse result = new OperationResponse();
		try {
			brokerDao.addBroker(brokerRequest);
			result.setResult(Constantes.SUCCESS);
			result.setMessage("Corredor registrado exitosamente");
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
			result.setException(e);
			result.setResult(Constantes.ERROR);
			result.setMessage("Error al registrar corredor");
		}
		return result;
	}

	@Override
	@Transactional(readOnly = false)
	public OperationResponse editBroker(BrokerRequest brokerRequest) {
		OperationResponse result = new OperationResponse();
		try {

			Broker broker = brokerDao.getBroker(brokerRequest.getBrokerCode());
			if (broker != null) {
				brokerDao.editBroker(brokerRequest);
				result.setResult(Constantes.SUCCESS);
				result.setMessage("Corredor modificado exitosamente");
			} else {
				result.setResult(Constantes.ERROR);
				result.setMessage("Error al modificar Corredor");
			}
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
			result.setException(e);
			result.setResult(Constantes.ERROR);
			result.setMessage("Error al modificar corredor");
		}
		return result;

	}

	@Override
	@Transactional(readOnly = false)
	public OperationResponse deleteBroker(Integer brokerCode) {
		OperationResponse result = new OperationResponse();
		try {
			brokerDao.deleteBroker(brokerCode);
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
	public boolean validateBrokerExist(Integer brokerCode) {
		boolean exist = false;
		try {
			exist = brokerDao.validateBrokerExist(brokerCode);
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return exist;
	}

}
