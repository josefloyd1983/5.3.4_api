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
import cl.liberty.dao.PropertyDao;
import cl.liberty.model.Property;
import cl.liberty.services.PropertyService;

/**
 * @author jgarrido
 *
 */

@Repository
public class PropertyServiceImpl implements PropertyService {

	private static final Logger logger = LoggerFactory.getLogger(PropertyServiceImpl.class);

	@Autowired
	private PropertyDao propertyDao;

	@Override
	@Transactional
	public Property getProperty(String name) {
		Property result = null;
		try {
			result = propertyDao.getProperty(name);
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	@Transactional
	public List<Property> getPropertys(Integer idPadre) {
		List<Property> result = new ArrayList<>();
		try {
			result = propertyDao.getPropertys(idPadre);
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return result;
	}

}
