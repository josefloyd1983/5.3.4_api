/**
 * 
 */
package cl.liberty.test.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.liberty.configuration.Application;
import cl.liberty.response.LoginResponse;
import cl.liberty.services.LoginService;

/**
 * @author jgarrido
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("local")
public class LoginServiceTest {

	@Autowired
	LoginService loginService;
	
	@Test
	public void loginTest() {
		LoginResponse loginResponse = loginService.login("liberty");
		assertNotNull("Login es null", loginResponse);
	}
}
