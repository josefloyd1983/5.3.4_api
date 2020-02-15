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
import cl.liberty.model.Flow;
import cl.liberty.response.FlowResponse;
import cl.liberty.response.ResponseBuilder;
import cl.liberty.response.ResponseContainer;
import cl.liberty.services.FlowService;

/**
 * @author jgarrido
 *
 */

@RestController
@RequestMapping("/flows")
public class FlowController {

	private static final Logger logger = LoggerFactory.getLogger(FlowController.class);

	@Autowired
	FlowService flowService;

	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<FlowResponse> flows() {
		logger.info("[flows]");
		FlowResponse flowResponse = new FlowResponse();
		List<Flow> flows = new ArrayList<>();
		try {
			flows = flowService.getFlows();
			flowResponse.setFlows(flows);
			return new ResponseBuilder<FlowResponse>().setData(flowResponse).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<FlowResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}
}
