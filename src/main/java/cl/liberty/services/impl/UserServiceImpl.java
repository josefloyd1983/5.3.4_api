/**
 * 
 */
package cl.liberty.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.liberty.constantes.Constantes;
import cl.liberty.constantes.Errores;
import cl.liberty.dao.UserDao;
import cl.liberty.model.User;
import cl.liberty.request.UserRequest;
import cl.liberty.response.OperationResponse;
import cl.liberty.services.UserService;
import cl.liberty.utils.MD5HashingUtils;

/**
 * @author jgarrido
 *
 */

@Repository
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public User getUser(String userName) {
		User user = null;
		try {
			user = userDao.getUser(userName);
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return user;
	}

	@Override
	@Transactional
	public List<User> getUsers(Integer userId, Integer status, Integer profileId, Integer countryId, String name,
			String namelastName, String userName) {
		List<User> result = new ArrayList<>();
		try {
			result = userDao.getUsers(userId, status, profileId, countryId, name, namelastName, userName);
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);

		}
		return result;
	}

	@Override
	@Transactional
	public User getUser(Integer userId) {
		User result = null;
		try {
			result = userDao.getUser(userId);
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	@Transactional
	public User getUserByUserName(String userName) {
		User result = null;
		try {
			result = userDao.getUserByUserName(userName);
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	@Transactional
	public User getUserByEmail(String email) {
		User result = null;
		try {
			result = userDao.getUserByEmail(email);
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return result;
	}

	@Override
	@Transactional(readOnly = false)
	public OperationResponse addUser(UserRequest userRequest) {
		OperationResponse result = new OperationResponse();
		try {
			String encrypt = MD5HashingUtils.encrypt(userRequest.getPassWord());
			userRequest.setPassWord(encrypt);
			userDao.addUser(userRequest);
			result.setResult(Constantes.SUCCESS);
			result.setMessage("Usuario registrado exitosamente");
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
			result.setException(e);
			result.setResult(Constantes.ERROR);
			result.setMessage("Error al registrar usuario");
		}
		return result;

	}

	@Override
	@Transactional(readOnly = false)
	public OperationResponse editUser(UserRequest userRequest) {
		OperationResponse result = new OperationResponse();
		try {
			User user = userDao.getUser(userRequest.getUserId());
			if (user != null) {
				String encrypt = MD5HashingUtils.encrypt(userRequest.getPassWord());
				userRequest.setPassWord(encrypt);
				userDao.editUser(userRequest);
				result.setResult(Constantes.SUCCESS);
				result.setMessage("Usuario modificado exitosamente");
			} else {
				result.setResult(Constantes.ERROR);
				result.setMessage("Error al modificar usuario");
			}
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
			result.setException(e);
			result.setResult(Constantes.ERROR);
			result.setMessage("Error al registrar usuario");
		}
		return result;

	}
	
	@Override
	@Transactional(readOnly = false)
	public OperationResponse deleteUser(Integer userId) {
		OperationResponse result = new OperationResponse();
		try {
			userDao.deleteUser(userId);
			result.setResult(Constantes.SUCCESS);
			result.setMessage("Usuario eliminado exitosamente");

		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
			result.setException(e);
			result.setResult(Constantes.ERROR);
			result.setMessage("Error al eliminar usuario");
		}
		return result;

	}
	
	@Override
	@Transactional(readOnly = false)
	public OperationResponse addUserProfile(Integer userId, Integer profileId, Integer countryId) {
		OperationResponse result = new OperationResponse();
		try {
			userDao.addUserProfile(userId, profileId, countryId);
			result.setResult(Constantes.SUCCESS);
			result.setMessage("Usuario Perfil registrado exitosamente");
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
			result.setException(e);
			result.setResult(Constantes.ERROR);
			result.setMessage("Error al registrar usuario perfil");
		}
		return result;
	}
	
	@Override
	@Transactional(readOnly = false)
	public OperationResponse editUserProfile(Integer userId, Integer profileId, Integer countryId) {
		OperationResponse result = new OperationResponse();
		try {
			userDao.editUserProfile(userId, profileId, countryId);
			result.setResult(Constantes.SUCCESS);
			result.setMessage("Usuario Perfil actualizado exitosamente");
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
			result.setException(e);
			result.setResult(Constantes.ERROR);
			result.setMessage("Error al actualizar usuario perfil");
		}
		return result;
	}
	
	@Override
	@Transactional(readOnly = false)
	public OperationResponse deleteUserProfile(Integer userId) {
		OperationResponse result = new OperationResponse();
		try {
			userDao.deleteUserProfile(userId);
			result.setResult(Constantes.SUCCESS);
			result.setMessage("Usuario Perfil eliminado exitosamente");

		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
			result.setException(e);
			result.setResult(Constantes.ERROR);
			result.setMessage("Error al eliminar usuario perfil");
		}
		return result;
	}

	@Override
	@Transactional
	public boolean validateUserExist(Integer userId) {
		boolean exist = false;
		try {
			exist = userDao.validateUserExist(userId);
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
		}
		return exist;
	}

	@Override
	@Transactional(readOnly = false)
	public OperationResponse changeStatusUser(Integer userId, Integer status) {
		OperationResponse result = new OperationResponse();
		try {
			User user = userDao.getUser(userId);
			if (user != null) {
				userDao.changeStatusUser(userId, status);
				result.setResult(Constantes.SUCCESS);
				result.setMessage("Estado Usuario modificado exitosamente");
			} else {
				result.setResult(Constantes.ERROR);
				result.setMessage("Error al modificar estado usuario");
			}
		} catch (Exception e) {
			logger.error(Errores.MENSAJE_ERROR_DAO);
			logger.error(Errores.EXCEPTION_MESSAGE + e.getMessage(), e);
			logger.error(Errores.EXCEPTION_LOCALIZED, e.getLocalizedMessage(), e);
			result.setException(e);
			result.setResult(Constantes.ERROR);
			result.setMessage("Error al registrar estado usuario");
		}
		return result;
	}
}
