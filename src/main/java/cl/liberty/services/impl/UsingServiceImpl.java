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

import cl.liberty.constantes.Errores;
import cl.liberty.dao.UsingDao;
import cl.liberty.model.Using;
import cl.liberty.services.UsingService;

/**
 * @author jgarrido
 *
 */

@Repository
public class UsingServiceImpl implements UsingService {

	private static final Logger logger = LoggerFactory.getLogger(UsingServiceImpl.class);

	@Autowired
	private UsingDao usingDao;

	@Override
	@Transactional
	public List<Using> getUsings() {
		List<Using> result = new ArrayList<>();
		try {
			result = usingDao.getUsings();
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	@Transactional
	public Using getUsingByDescription(String description) {
		Using result = null;
		try {
			result = usingDao.getUsingByDescription(description);
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return result;
	}

}
