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

import cl.liberty.constantes.Errores;
import cl.liberty.messaging.ErrorNotification;
import cl.liberty.model.Using;
import cl.liberty.response.ResponseBuilder;
import cl.liberty.response.ResponseContainer;
import cl.liberty.response.UsingResponse;
import cl.liberty.services.UsingService;

/**
 * @author jgarrido
 *
 */

@RestController
@RequestMapping("/usings")
public class UsingController {

	private static final Logger logger = LoggerFactory.getLogger(UsingController.class);

	@Autowired
	UsingService usingService;

	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<UsingResponse> usings() {
		logger.info("[usings]");
		UsingResponse usingResponse = new UsingResponse();
		List<Using> usings = new ArrayList<>();
		try {
			usings = usingService.getUsings();
			usingResponse.setUsings(usings);
			return new ResponseBuilder<UsingResponse>().setData(usingResponse).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<UsingResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}
}
