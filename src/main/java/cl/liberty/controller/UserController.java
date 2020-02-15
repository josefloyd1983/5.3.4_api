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
import cl.liberty.model.User;
import cl.liberty.request.UserRequest;
import cl.liberty.response.OperationResponse;
import cl.liberty.response.ResponseBuilder;
import cl.liberty.response.ResponseContainer;
import cl.liberty.response.UserBuilder;
import cl.liberty.response.UserResponse;
import cl.liberty.services.UserService;

/**
 * @author jgarrido
 *
 */

@RestController
@RequestMapping("/users")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<UserResponse> users(@RequestParam Integer userId, @RequestParam Integer status, @RequestParam Integer profileId, @RequestParam Integer countryId,
			@RequestParam String name, @RequestParam String nameLastName, @RequestParam String userName) {
		logger.info("[users]");
		UserResponse userResponse = new UserResponse();
		List<User> users = new ArrayList<>();
		try {
			users = userService.getUsers(userId, status, profileId, countryId, name, nameLastName, userName);
			userResponse.setUsers(users);
			return new ResponseBuilder<UserResponse>().setData(userResponse).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<UserResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}

	@GetMapping(path = "/username", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<UserBuilder> userName(@RequestParam String userName) {
		logger.info("[userName]");
		UserBuilder userBuilder = new UserBuilder();
		try {
			User user = userService.getUserByUserName(userName);
			userBuilder.setUser(user);
			return new ResponseBuilder<UserBuilder>().setData(userBuilder).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<UserBuilder>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}

	@GetMapping(path = "/email", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<UserBuilder> email(@RequestParam String email) {
		logger.info("[email]");
		UserBuilder userBuilder = new UserBuilder();
		try {
			User user = userService.getUserByEmail(email);
			userBuilder.setUser(user);
			return new ResponseBuilder<UserBuilder>().setData(userBuilder).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<UserBuilder>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<OperationResponse> addUser(@RequestBody UserRequest userRequest) {
		logger.info("[addUser]");
		OperationResponse userResponse = new OperationResponse();
		try {
			userResponse = userService.addUser(userRequest);
			return new ResponseBuilder<OperationResponse>().setData(userResponse).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<OperationResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<OperationResponse> editUser(@RequestBody UserRequest userRequest) {
		logger.info("[editUser]");
		OperationResponse userResponse = new OperationResponse();
		try {
			userResponse = userService.editUser(userRequest);
			return new ResponseBuilder<OperationResponse>().setData(userResponse).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<OperationResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}
	
	@PutMapping(path = "/changestatus", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<OperationResponse> changeStatusUser(@RequestParam Integer userId, @RequestParam Integer status) {
		logger.info("[changeStatusUser]");
		OperationResponse userResponse = new OperationResponse();
		try {
			userResponse = userService.changeStatusUser(userId, status);
			return new ResponseBuilder<OperationResponse>().setData(userResponse).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<OperationResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}

	@DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<OperationResponse> deleteUser(@RequestParam Integer userId) {
		logger.info("[deleteUser]");
		OperationResponse userResponse = new OperationResponse();
		try {
			userResponse = userService.deleteUser(userId);
			return new ResponseBuilder<OperationResponse>().setData(userResponse).withSucess().build();
		} catch (Exception ex) {
			logger.error(Errores.MENSAJE_ERROR_SERVICES);
			logger.error(Errores.EXCEPTION_MESSAGE, ex.getMessage());
			logger.error(Errores.EXCEPTION_LOCALIZED, ex.getLocalizedMessage());
			return new ResponseBuilder<OperationResponse>()
					.withErrors(new ErrorNotification(Errores.EXCEPTION_MESSAGE + ex.getMessage())).build();
		}
	}
	
	
	@GetMapping(path = "/ldap/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseContainer<OperationResponse> ldapUser(@RequestParam String userName, @RequestParam String userPass) {
		logger.info("[ldapUser]");
		OperationResponse userResponse = new OperationResponse();
		try {
			if ("jgarrido".equals(userName) && "123456".equals(userPass)) {
				userResponse.setResult(0);
				userResponse.setMessage("Exito");
				return new ResponseBuilder<OperationResponse>().setData(userResponse).withSucess().build();
			} else if("sgarcia".equals(userName) && "123456".equals(userPass))  {
				userResponse.setResult(0);
				userResponse.setMessage("No Exito");
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
