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
import cl.liberty.model.Contractor;
import cl.liberty.response.ContractorResponse;
import cl.liberty.response.ResponseBuilder;
import cl.liberty.response.ResponseContainer;
import cl.liberty.services.ContractorService;

/**
 * @author jgarrido
 *
 */

@RestController
@RequestMapping("/contractors")
public class ContractorController {

	private static final Logger logger = LoggerFactory.getLogger(ContractorController.class);

	@Autowired
	ContractorService contractorService;

	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<ContractorResponse> contractors() {
		logger.info("[contractors]");
		ContractorResponse contractorResponse = new ContractorResponse();
		List<Contractor> contractors = new ArrayList<>();
		try {
			contractors = contractorService.getContractors();
			contractorResponse.setContractors(contractors);
			return new ResponseBuilder<ContractorResponse>().setData(contractorResponse).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<ContractorResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}
}
