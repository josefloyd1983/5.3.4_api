/**
 * 
 */
package cl.liberty.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.liberty.constantes.Errores;
import cl.liberty.messaging.ErrorNotification;
import cl.liberty.request.LogRequest;
import cl.liberty.response.OperationResponse;
import cl.liberty.response.ResponseBuilder;
import cl.liberty.response.ResponseContainer;
import cl.liberty.services.LogService;

/**
 * @author jgarrido
 *
 */

@RestController
@RequestMapping("/logs")
public class LogController {

	private static final Logger logger = LoggerFactory.getLogger(LogController.class);

	@Autowired
	LogService logService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<OperationResponse> addLog(@RequestBody LogRequest logRequest) {
		logger.info("[addLog]");
		OperationResponse logResponse = new OperationResponse();
		try {
			logResponse = logService.addLog(logRequest);
			return new ResponseBuilder<OperationResponse>().setData(logResponse).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<OperationResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}
}
