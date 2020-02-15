/**
 * 
 */
package cl.liberty.test.service;

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
import cl.liberty.model.User;
import cl.liberty.request.UserRequest;
import cl.liberty.services.UserService;
import cl.liberty.utils.MD5HashingUtils;

/**
 * @author jgarrido
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("local")
public class UserServiceTest {

	@Autowired
	UserService userService;

	@Test
	public void getUserLoginTest() {
		User user = userService.getUser("liberty");
		assertNotNull("Usuario es null", user);
	}

	@Test
	public void getUserTest() {
		User user = userService.getUser(1);
		assertNotNull("Usuario es null", user);
	}

	@Test
	public void getUsersTest() {
		Integer userId = -1;
		String userName = null;
		Integer countryId = -1;
		String namelastName = null;
		Integer profileId = -1;
		Integer status = 1;
		String name = null;
		List<User> users = userService.getUsers(userId, status, profileId, countryId, name, namelastName, userName);
		assertNotNull("Corredor es null", users);
	}

	@Test
	public void getUserByUsernameTest() {
		String userName = "lfuentes";
		User user = userService.getUserByUserName(userName);
		assertNotNull("Usuario  es null", user);
	}

	@Test
	public void getUserByEmailTest() {
		String email = "nombre.apelido1@liberty.cl";
		User user = userService.getUserByEmail(email);
		assertNotNull("Usuario  es null", user);
	}

	@Test
	public void addUserTest() {
		UserRequest userRequest = new UserRequest();
		userRequest.setEmail("test.cl");
		userRequest.setLastName("test");
		userRequest.setName("test");
		userRequest.setProfileId(1);
		userRequest.setStatus(1);
		userRequest.setUserName("test");

		String encript;
		try {
			encript = MD5HashingUtils.encrypt("123456511");

		} catch (NoSuchAlgorithmException e1) {
			encript = Constantes.EMPTY;
		}
		userRequest.setPassWord(encript);

		try {
			userService.addUser(userRequest);
			User user = userService.getUserByUserName(userRequest.getUserName());
			userService.addUserProfile(user.getUserId(), userRequest.getProfileId(), 1);
			assertTrue(true);
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

	@Test
	public void editUserTest() {
		UserRequest userRequest = new UserRequest();
		userRequest.setEmail("test.cl");
		userRequest.setLastName("xxxxx");
		userRequest.setName("xxxxx");
		userRequest.setProfileId(2);
		userRequest.setStatus(0);
		userRequest.setUserId(40);
		userRequest.setUserName("test");
		String encript;
		try {
			encript = MD5HashingUtils.encrypt("12345651122");

		} catch (NoSuchAlgorithmException e1) {
			encript = Constantes.EMPTY;
		}
		userRequest.setPassWord(encript);

		try {
			userService.editUser(userRequest);
			userService.editUserProfile(userRequest.getUserId(), userRequest.getProfileId(), 1);

			assertTrue(true);
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

	@Test
	public void addUserProfileTest() {

		try {
			Integer countryId = 1;
			Integer userId = 30;
			Integer profileId = 1;
			userService.addUserProfile(userId, profileId, countryId);
			assertTrue(true);
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

	@Test
	public void editUserProfileTest() {

		try {
			Integer countryId = 1;
			Integer userId = 30;
			Integer profileId = 2;
			userService.editUserProfile(userId, profileId, countryId);
			assertTrue(true);
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

	@Test
	public void deleteUserTest() {
		Integer userId = 40;
		try {
			userService.deleteUser(userId);
			assertTrue(true);
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

	@Test
	public void deleteUserProfileTest() {
		Integer userId = 30;
		try {
			userService.deleteUserProfile(userId);
			assertTrue(true);
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

	@Test
	public void validateUserExistTest() {
		try {
			boolean result = userService.validateUserExist(1);
			assertTrue("Usuario no existe", result);
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

	@Test
	public void changeStatusUserTest() {
		Integer userId = 1;
		Integer status = 1;
		try {
			userService.changeStatusUser(userId, status);
			assertTrue(true);
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

}
