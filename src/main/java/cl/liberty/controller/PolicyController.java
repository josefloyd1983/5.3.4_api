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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.liberty.constantes.Constantes;
import cl.liberty.constantes.Errores;
import cl.liberty.messaging.ErrorNotification;
import cl.liberty.model.Policy;
import cl.liberty.model.Property;
import cl.liberty.response.OperationResponse;
import cl.liberty.response.PolicyResponse;
import cl.liberty.response.ResponseBuilder;
import cl.liberty.response.ResponseContainer;
import cl.liberty.services.PolicyService;
import cl.liberty.services.PropertyService;
import cl.liberty.utils.UtilAMS;

/**
 * @author jgarrido
 *
 */

@RestController
@RequestMapping("/policys")
public class PolicyController {

	private static final Logger logger = LoggerFactory.getLogger(PolicyController.class);

	@Autowired
	PolicyService policyService;

	@Autowired
	PropertyService propertyService;

	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<PolicyResponse> policys(@RequestParam Integer policyNumber,
			@RequestParam Integer branchNumber) {
		logger.info("[policys]");
		PolicyResponse policyResponse = new PolicyResponse();
		List<Policy> policys = new ArrayList<>();
		try {
			Property property = propertyService.getProperty(Constantes.PROPERTY_NAME_COVERAGE);
			policys = policyService.policys(policyNumber, branchNumber, property.getPropertyId());
			policyResponse.setPolicys(policys);
			return new ResponseBuilder<PolicyResponse>().setData(policyResponse).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<PolicyResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}

	@GetMapping(path = "/nonmortgage", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<PolicyResponse> policyNonMortgages(@RequestParam Integer policyNumber) {
		logger.info("[policyNonMortgages]");
		PolicyResponse policyResponse = new PolicyResponse();
		List<Policy> policys = new ArrayList<>();
		try {
			Property property = propertyService.getProperty(Constantes.PROPERTY_NAME_COVERAGE);
			policys = policyService.policyNonMortgages(policyNumber, property.getPropertyId());
			policyResponse.setPolicys(policys);
			return new ResponseBuilder<PolicyResponse>().setData(policyResponse).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<PolicyResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}

	@GetMapping(path = "/diffdaystart", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<OperationResponse> diffDayStart(@RequestParam Integer policyNumber,
			@RequestParam String validityStartDate) {
		logger.info("[diffDayStart]");
		OperationResponse walletResponse = new OperationResponse();
		try {

			Policy policy = policyService.getPolicy(policyNumber, 20);

			Boolean effectiveDateStart = UtilAMS.isDiffOneDay(validityStartDate, policy.getValidityStartDate());
			
			if (effectiveDateStart) {
				walletResponse.setResult(0);
				walletResponse.setMessage("La Vigencia de Inicio indicada no corresponde a la fecha entregada por AXIS");
			} else {
				walletResponse.setResult(1);
				walletResponse.setMessage("La Vigencia de Inicio indicada no corresponde a la fecha entregada por AXIS");
			}
			return new ResponseBuilder<OperationResponse>().setData(walletResponse).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<OperationResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}
	
	
	@GetMapping(path = "/diffdayend", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<OperationResponse> diffDayEnd(@RequestParam Integer policyNumber,
			@RequestParam String validityEndDate) {
		logger.info("[diffDayEnd]");
		OperationResponse walletResponse = new OperationResponse();
		try {

			Policy policy = policyService.getPolicy(policyNumber, 20);

			Boolean effectiveDateStart = UtilAMS.isDiffOneDay(validityEndDate, policy.getValidityEndDate());
			
			if (effectiveDateStart) {
				walletResponse.setResult(0);
				walletResponse.setMessage("La Vigencia de Fin indicada no corresponde a la fecha entregada por AXIS");
			} else {
				walletResponse.setResult(1);
				walletResponse.setMessage("La Vigencia de Inicio indicada corresponde a la fecha entregada por AXIS");
			}
			return new ResponseBuilder<OperationResponse>().setData(walletResponse).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<OperationResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}
}
