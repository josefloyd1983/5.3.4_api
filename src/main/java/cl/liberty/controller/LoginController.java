/**
 * 
 */
package cl.liberty.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.liberty.constantes.Errores;
import cl.liberty.enums.StatusEnum;
import cl.liberty.messaging.ErrorNotification;
import cl.liberty.model.User;
import cl.liberty.request.BodyReqAuth;
import cl.liberty.response.LoginResponse;
import cl.liberty.response.OperationResponse;
import cl.liberty.response.ResponseBuilder;
import cl.liberty.response.ResponseContainer;
import cl.liberty.services.LoginService;
import cl.liberty.services.UserService;
import cl.liberty.utils.MD5HashingUtils;

/**
 * @author jgarrido
 *
 */

@RestController
@RequestMapping("/login")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
    Environment env;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<LoginResponse> login(@RequestParam String userName, @RequestParam String password) {
		logger.info("[login]");
		LoginResponse loginResponse = new LoginResponse();
		User user;
		try {
			user = userService.getUser(userName);
			if (user != null) {
				if(user.getStatus() != StatusEnum.BLOCKED_USER.getCode()){
					Boolean equals=false;
					equals=MD5HashingUtils.compare(password, user.getPassword());
					if (equals) {
						logger.info("[LoginController login] success");
						loginResponse = loginService.login(userName);
						return new ResponseBuilder<LoginResponse>().setData(loginResponse).withSucess().setCode(200).setMessage("success").build();
					} else {
						logger.info("[LoginController login] Usuario o Password no corresponden");
						return new ResponseBuilder<LoginResponse>().setData(loginResponse).withSucess().setCode(1).setMessage("Usuario o Password no corresponden").build();
					}
				} else {
					logger.info("[LoginController login] Cuenta de Usuario Bloqueada");
					return new ResponseBuilder<LoginResponse>().setData(loginResponse).withSucess().setCode(1).setMessage("Cuenta de Usuario Bloqueada").build();
				}
			} else {
				logger.info("[LoginController login] Usuario no existe o esta inhabilitado");
				return new ResponseBuilder<LoginResponse>().setData(loginResponse).withSucess().setCode(1).setMessage("Usuario no existe o esta inhabilitado").build();
			}
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<LoginResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}
	
	
	@PostMapping(path = "/ldap", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<OperationResponse> ldap(@RequestBody BodyReqAuth bodyReqAuth) {
		logger.info("[ldap]");
		OperationResponse userResponse = new OperationResponse();
		try {
			if ("jgarrido".equals(bodyReqAuth.getUser()) && "123456".equals(bodyReqAuth.getPass())) {
				userResponse.setResult(0);
				userResponse.setMessage("Exito");
				return new ResponseBuilder<OperationResponse>().setData(userResponse).withSucess().build();
			} else {
				userResponse.setResult(1);
				userResponse.setMessage("No Exito");
				return new ResponseBuilder<OperationResponse>().setData(userResponse).withSucess().build();
			}
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<OperationResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}
}
