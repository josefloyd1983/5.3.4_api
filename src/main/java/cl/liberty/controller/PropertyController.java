/**
 * 
 */
package cl.liberty.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.liberty.constantes.Constantes;
import cl.liberty.constantes.Errores;
import cl.liberty.messaging.ErrorNotification;
import cl.liberty.model.Property;
import cl.liberty.response.PropertyResponse;
import cl.liberty.response.ResponseBuilder;
import cl.liberty.response.ResponseContainer;
import cl.liberty.services.PropertyService;

/**
 * @author jgarrido
 *
 */

@RestController
@RequestMapping("/propertys")
public class PropertyController {

	private static final Logger logger = LoggerFactory.getLogger(PropertyController.class);

	@Autowired
	PropertyService propertyService;

	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<PropertyResponse> propertys() {
		logger.info("[propertys]");
		PropertyResponse propertyResponse = new PropertyResponse();
		List<Property> propertys = new ArrayList<>();
		try {
			propertys = propertyService.getPropertys(Constantes.PROPERTY_ID_PADRE);
			propertyResponse.setPropertys(propertys);
			return new ResponseBuilder<PropertyResponse>().setData(propertyResponse).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<PropertyResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}

}
