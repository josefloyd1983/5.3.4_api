/**
 * 
 */
package cl.liberty.test.utils;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.liberty.configuration.Application;
import cl.liberty.constantes.Constantes;
import cl.liberty.request.BodyReqAuth;
import cl.liberty.response.BodyRespAuth;
import cl.liberty.utils.UtilAMS;

/**
 * @author jgarrido
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class UtilAMSTest {

	@Autowired
	Environment env;

	
	@Ignore
	@Test
	public void invokeResponseServiceAuthTest() {
		try {

			BodyReqAuth bodyReq = new BodyReqAuth();
			bodyReq.setUser("jgarrido");
			bodyReq.setPass("123456");
			BodyRespAuth bodyRespAuth = UtilAMS.invokeResponseServiceAuth(env.getProperty(Constantes.SERVICE_AUTH_URL),
					bodyReq);
			assertNotNull("Encriptar es null", bodyRespAuth);
		} catch (Exception e) {
			Assert.fail("Error -> " + e.getMessage());
		}
	}
}
