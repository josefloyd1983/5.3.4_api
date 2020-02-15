/**
 * 
 */
package cl.liberty.test.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.liberty.configuration.Application;
import cl.liberty.constantes.Constantes;
import cl.liberty.constantes.Errores;
import cl.liberty.dao.UserDao;
import cl.liberty.model.User;
import cl.liberty.request.UserRequest;
import cl.liberty.utils.MD5HashingUtils;

/**
 * @author jgarrido
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("local")
public class UserDaoTest {

	@Autowired
	UserDao userDao;

	@Test
	public void getUserLoginTest() {
		User user = userDao.getUser("jgarrido");
		assertNotNull("Usuario es null", user);
	}

	@Test
	public void getUserTest() {
		User user = userDao.getUser(1);
		assertNotNull("Usuario es null", user);
	}

	@Test
	public void getUsersTest() {
		Integer userId = -1;
		String userName = "-1";
		Integer countryId = -1;
		String namelastName = "-1";
		Integer profileId = -1;
		Integer status = 1;
		String name = "Nombr";
		List<User> users = userDao.getUsers(userId, status, profileId, countryId, name, namelastName, userName);
		assertNotNull("Corredor es null", users);
	}

	@Test
	public void getUserByUsernameTest() {
		String userName = "lfuentes";
		User user = userDao.getUserByUserName(userName);
		assertNotNull("Usuario  es null", user);
	}

	@Test
	public void getUserByEmailTest() {
		String email = "nombre.apelido3@liberty.cl";
		User user = userDao.getUserByEmail(email);
		assertNotNull("Usuario  es null", user);
	}

	@Test
	public void addUserTest() {

		UserRequest userRequest = new UserRequest();
		userRequest.setEmail("RRRRRRRRR.cl");
		userRequest.setLastName("RRRRRRRRRR");
		userRequest.setName("RRRRRRRRRRRRR");
		userRequest.setProfileId(1);
		userRequest.setStatus(1);
		userRequest.setUserName("RRRRRRRRRRRR");
		String encript;
		try {
			encript = MD5HashingUtils.encrypt("123456");

		} catch (NoSuchAlgorithmException e1) {
			encript = Constantes.EMPTY;
		}
		userRequest.setPassWord(encript);
		try {
			userDao.addUser(userRequest);
			assertTrue(true);
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

	@Test
	public void editUserTest() {
		UserRequest userRequest = new UserRequest();
		userRequest.setEmail("xxxxxxxxxxxxxxxxxxxx.cl");
		userRequest.setLastName("xxxxx");
		userRequest.setName("xxxxxxxx");
		userRequest.setProfileId(2);
		userRequest.setStatus(0);
		userRequest.setUserId(50);
		userRequest.setUserName("xxxxxxxxxxxxxxxx");

		String encript;
		try {
			encript = MD5HashingUtils.encrypt("123456511");

		} catch (NoSuchAlgorithmException e1) {
			encript = Constantes.EMPTY;
		}
		userRequest.setPassWord(encript);
		try {
			userDao.addUser(userRequest);
			assertTrue(true);
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}

		try {
			userDao.editUser(userRequest);
			assertTrue(true);
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

	@Test
	public void addUserPrifileTest() {
		try {
			Integer userId = 29;
			Integer countryId = 1;
			Integer profileId = 1;
			userDao.addUserProfile(userId, profileId, countryId);
			assertTrue(true);
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

	@Test
	public void editUserPrifileTest() {
		try {
			Integer userId = 29;
			Integer countryId = 1;
			Integer profileId = 2;
			userDao.editUserProfile(userId, profileId, countryId);
			assertTrue(true);
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

	@Test
	public void deleteUserProfileTest() {
		Integer userId = 38;
		try {
			userDao.deleteUserProfile(userId);
			assertTrue(true);
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

	@Test
	public void deleteUserTest() {
		Integer userId = 51;
		try {
			userDao.deleteUser(userId);
			assertTrue(true);
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

	@Test
	public void validateUserExistTest() {
		try {
			boolean result = userDao.validateUserExist(1);
			assertTrue("Usuario no existe", result);
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

	@Test
	public void changeStatusUserTest() {
		Integer userId = 1;
		Integer status = 0;
		try {
			userDao.changeStatusUser(userId, status);
			assertTrue(true);
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

}
