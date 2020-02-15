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
import cl.liberty.constantes.Constantes;
import cl.liberty.dao.PropertyDao;
import cl.liberty.model.Property;

/**
 * @author jgarrido
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("local")
public class PropertyDaoTest {

	@Autowired
	PropertyDao propertyDao;
	
	@Test
	public void getPropertyTest() {
		Property property = propertyDao.getProperty(Constantes.PROPERTY_NAME_COVERAGE);
		assertNotNull("Propiedades es null", property);
	}
	
	@Test
	public void getPropertysTest() {
		List<Property> propertys = propertyDao.getPropertys(Constantes.PROPERTY_ID_PADRE);
		assertNotNull("Propiedades es null", propertys);
	}

}
