/**
 * 
 */
package cl.liberty.test.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.liberty.configuration.Application;
import cl.liberty.model.Using;
import cl.liberty.services.UsingService;

/**
 * @author jgarrido
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("local")
public class UsingServiceTest {

	@Autowired
	UsingService usingService;

	@Test
	public void getUsingTest() {
		List<Using> usings = usingService.getUsings();
		assertNotNull("Uso es null", usings);
	}

	@Test
	public void getBrokerByCodeTest() {
		Using using = usingService.getUsingByDescription("N/A");
		assertNotNull("Uso es null", using);
	}

}
