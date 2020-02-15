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
import cl.liberty.dao.FlowDao;
import cl.liberty.model.Flow;
import cl.liberty.services.FlowService;

/**
 * @author jgarrido
 *
 */

@Repository
public class FlowServiceImpl implements FlowService {

	private static final Logger logger = LoggerFactory.getLogger(FlowServiceImpl.class);

	@Autowired
	private FlowDao flowDao;

	@Override
	@Transactional
	public List<Flow> getFlows() {
		List<Flow> result = new ArrayList<>();
		try {
			result = flowDao.getFlows();
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return result;
	}

}
