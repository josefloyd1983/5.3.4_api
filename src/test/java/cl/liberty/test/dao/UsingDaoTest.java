/**
 * 
 */
package cl.liberty.test.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.liberty.configuration.Application;
import cl.liberty.dao.UsingDao;
import cl.liberty.model.Using;

/**
 * @author jgarrido
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("local")
public class UsingDaoTest {

	@Autowired
	UsingDao usingDao;

	@Test
	public void getUsingTest() {
		List<Using> usings = usingDao.getUsings();		
		assertNotNull("Uso es null", usings);
	}

	@Test
	public void getUsingByDescriptionTest() {
		Using using = usingDao.getUsingByDescription("Habitacional");
		assertNotNull("Uso es null", using);
	}

}
