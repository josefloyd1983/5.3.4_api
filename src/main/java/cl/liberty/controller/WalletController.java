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

import cl.liberty.constantes.Constantes;
import cl.liberty.constantes.Errores;
import cl.liberty.messaging.ErrorNotification;
import cl.liberty.model.Property;
import cl.liberty.model.ValidityStart;
import cl.liberty.model.Wallet;
import cl.liberty.model.WalletHistory;
import cl.liberty.request.WalletRequest;
import cl.liberty.response.OperationResponse;
import cl.liberty.response.ResponseBuilder;
import cl.liberty.response.ResponseContainer;
import cl.liberty.response.ValidityStartResponse;
import cl.liberty.response.WalletByPolicyResponse;
import cl.liberty.response.WalletHistoryResponse;
import cl.liberty.response.WalletResponse;
import cl.liberty.services.PropertyService;
import cl.liberty.services.WalletService;
import cl.liberty.utils.UtilAMS;

/**
 * @author jgarrido
 *
 */

@RestController
@RequestMapping("/wallets")
public class WalletController {

	private static final Logger logger = LoggerFactory.getLogger(WalletController.class);

	@Autowired
	WalletService walletService;

	@Autowired
	PropertyService propertyService;
	
	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<WalletResponse> wallets(@RequestParam Integer policyNumber,
			@RequestParam Integer contractorCode, @RequestParam Integer brokerCode, @RequestParam String validInYears) {
		logger.info("[wallets]");
		WalletResponse walletResponse = new WalletResponse();
		List<Wallet> wallets = new ArrayList<>();
		try {
			Property property = propertyService.getProperty(Constantes.PROPERTY_NAME_COVERAGE);
			wallets = walletService.wallets(policyNumber, contractorCode, brokerCode, validInYears,
					property.getPropertyId());
			walletResponse.setWallets(wallets);
			return new ResponseBuilder<WalletResponse>().setData(walletResponse).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<WalletResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}

	@GetMapping(path = "/policy", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<WalletByPolicyResponse> walletByPolicy(@RequestParam Integer policyNumber,
			@RequestParam Integer contractorCode, @RequestParam Integer brokerCode, @RequestParam String validInYears) {
		logger.info("[walletPolicy]");
		WalletByPolicyResponse walletPolicyResponse = new WalletByPolicyResponse();
		try {
			Property property = propertyService.getProperty(Constantes.PROPERTY_NAME_COVERAGE);
			walletPolicyResponse = walletService.wallet(policyNumber, contractorCode, brokerCode, validInYears,
					property.getPropertyId());
			if (walletPolicyResponse != null) {
				return new ResponseBuilder<WalletByPolicyResponse>().setData(walletPolicyResponse).withSucess().build();
			} else {
				return new ResponseBuilder<WalletByPolicyResponse>()
						.withErrors(new ErrorNotification(Errores.MENSAJE_DATA_NOT_FOUND)).build();
			}
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<WalletByPolicyResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}

	@GetMapping(path = "/historys", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<WalletHistoryResponse> historys(@RequestParam Integer policyNumber,
			@RequestParam Integer idUser) {
		logger.info("[historys]");
		WalletHistoryResponse walletHistoryResponse = new WalletHistoryResponse();
		List<WalletHistory> walletHistorys = new ArrayList<>();
		try {
			walletHistorys = walletService.getWalletHistorys(policyNumber, idUser);
			walletHistoryResponse.setWalletHistorys(walletHistorys);
			return new ResponseBuilder<WalletHistoryResponse>().setData(walletHistoryResponse).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<WalletHistoryResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<OperationResponse> addWallet(@RequestBody WalletRequest walletRequest) {
		logger.info("[addWallet]");
		OperationResponse walletResponse = new OperationResponse();
		try {
			walletResponse = walletService.addWallet(walletRequest);
			return new ResponseBuilder<OperationResponse>().setData(walletResponse).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<OperationResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<OperationResponse> editWallet(@RequestBody WalletRequest walletRequest) {
		logger.info("[editWallet]");
		OperationResponse walletResponse = new OperationResponse();
		try {
			walletResponse = walletService.editWallet(walletRequest);
			return new ResponseBuilder<OperationResponse>().setData(walletResponse).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<OperationResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}

	@DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<OperationResponse> deleteWallet(@RequestParam Integer walletId) {
		logger.info("[deleteWallet]");
		OperationResponse walletResponse = new OperationResponse();
		try {
			walletResponse = walletService.deleteWallet(walletId);
			return new ResponseBuilder<OperationResponse>().setData(walletResponse).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<OperationResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}

	@GetMapping(path = "/validitystarts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<ValidityStartResponse> validityStarts() {
		logger.info("[validitystarts]");
		ValidityStartResponse validityStartsResponse = new ValidityStartResponse();
		List<ValidityStart> validityStarts = new ArrayList<>();
		try {
			validityStarts = walletService.getValidityStarts();
			validityStartsResponse.setValidityStarts(validityStarts);
			return new ResponseBuilder<ValidityStartResponse>().setData(validityStartsResponse).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<ValidityStartResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}

	@GetMapping(path = "/comparedate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<OperationResponse> compareDate(@RequestParam String validityStartDate,
			@RequestParam String validityEndDate) {
		logger.info("[comparedate]");
		OperationResponse walletResponse = new OperationResponse();
		try {
			Boolean compare = UtilAMS.compareIfDateIsOlder(validityStartDate, validityEndDate);

			if (compare) {
				walletResponse.setResult(0);
			} else {
				walletResponse.setResult(1);
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
