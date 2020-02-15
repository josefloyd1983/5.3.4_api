/**
 * 
 */
package cl.liberty.test.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.liberty.utils.MD5HashingUtils;

/**
 * @author jgarrido
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class MD5HashingUtilsTest {

	@Test
	public void encryptTest() {
		String encript;
		try {
			encript = MD5HashingUtils.encrypt("123456");
			assertNotNull("Encriptar es null", encript);
		} catch (Exception e) {
			Assert.fail("Error -> " + e.getMessage());
		}
	}

	@Test
	public void compareTest() {
		String passwNonEncripted = "123456";
		String passwEncripted = "e10adc3949ba59abbe56e057f20f883e";
		try {
			assertTrue(MD5HashingUtils.compare(passwNonEncripted, passwEncripted));
		} catch (Exception e) {
			Assert.fail("Error -> " + e.getMessage());
		}
	}

}
