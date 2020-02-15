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
import cl.liberty.model.Profile;
import cl.liberty.response.ProfileResponse;
import cl.liberty.response.ResponseBuilder;
import cl.liberty.response.ResponseContainer;
import cl.liberty.services.ProfileService;

/**
 * @author jgarrido
 *
 */

@RestController
@RequestMapping("/profiles")
public class ProfileController {

	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

	@Autowired
	ProfileService profileService;

	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<ProfileResponse> profiles() {
		logger.info("[profiles]");
		ProfileResponse profileResponse = new ProfileResponse();
		List<Profile> profiles = new ArrayList<>();
		try {
			profiles = profileService.getProfiles();
			profileResponse.setProfiles(profiles);
			return new ResponseBuilder<ProfileResponse>().setData(profileResponse).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<ProfileResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}
}
