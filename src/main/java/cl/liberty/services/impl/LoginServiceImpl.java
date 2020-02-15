/**
 * 
 */
package cl.liberty.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.liberty.constantes.Errores;
import cl.liberty.model.ProfileMenu;
import cl.liberty.model.User;
import cl.liberty.response.LoginResponse;
import cl.liberty.services.LoginService;
import cl.liberty.services.ProfileService;
import cl.liberty.services.UserService;

/**
 * @author jgarrido
 *
 */

@Repository
public class LoginServiceImpl implements LoginService {

	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	private UserService userService;

	@Autowired
	private ProfileService profileService;

	@Override
	@Transactional
	public LoginResponse login(String userName) {
		LoginResponse result = new LoginResponse();
		User user;
		try {
			user = userService.getUser(userName);
			List<ProfileMenu> menus = profileService.getProfileMenus(user);
			result.setUser(user);
			result.setProfileMenus(menus);

		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return result;
	}
}
