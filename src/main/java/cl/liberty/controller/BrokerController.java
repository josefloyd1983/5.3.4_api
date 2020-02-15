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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.liberty.constantes.Errores;
import cl.liberty.messaging.ErrorNotification;
import cl.liberty.model.Broker;
import cl.liberty.request.BrokerRequest;
import cl.liberty.response.BrokerResponse;
import cl.liberty.response.OperationResponse;
import cl.liberty.response.ResponseBuilder;
import cl.liberty.response.ResponseContainer;
import cl.liberty.services.BrokerService;

/**
 * @author jgarrido
 *
 */

@RestController
@RequestMapping("/brokers")
public class BrokerController {

	private static final Logger logger = LoggerFactory.getLogger(BrokerController.class);

	@Autowired
	BrokerService brokerService;

	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<BrokerResponse> brokers() {
		logger.info("[brokers]");
		BrokerResponse brokerResponse = new BrokerResponse();
		List<Broker> brokers = new ArrayList<>();
		try {
			brokers = brokerService.getBrokers();
			brokerResponse.setBrokers(brokers);
			return new ResponseBuilder<BrokerResponse>().setData(brokerResponse).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<BrokerResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<OperationResponse> addBroker(@RequestBody BrokerRequest brokerRequest) {
		logger.info("[addBroker]");
		OperationResponse brokerResponse = new OperationResponse();
		try {
			brokerResponse = brokerService.addBroker(brokerRequest);
			return new ResponseBuilder<OperationResponse>().setData(brokerResponse).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<OperationResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<OperationResponse> editBroker(@RequestBody BrokerRequest brokerRequest) {
		logger.info("[editBroker]");
		OperationResponse brokerResponse = new OperationResponse();
		try {
			brokerResponse = brokerService.editBroker(brokerRequest);
			return new ResponseBuilder<OperationResponse>().setData(brokerResponse).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<OperationResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}

	@DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<OperationResponse> deleteBroker(@RequestParam Integer brokerCode) {
		logger.info("[deleteBroker]");
		OperationResponse brokerResponse = new OperationResponse();
		try {
			brokerResponse = brokerService.deleteBroker(brokerCode);
			return new ResponseBuilder<OperationResponse>().setData(brokerResponse).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<OperationResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}
}
