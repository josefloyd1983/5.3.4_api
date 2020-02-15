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
import cl.liberty.constantes.Constantes;
import cl.liberty.model.Property;
import cl.liberty.services.PropertyService;

/**
 * @author jgarrido
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("local")
public class PropertyServiceTest {

	@Autowired
	PropertyService propertyService;

	@Test
	public void getPropertyTest() {
		Property property = propertyService.getProperty(Constantes.PROPERTY_NAME_COVERAGE);
		assertNotNull("Property es null", property);
	}

	@Test
	public void getPropertysTest() {
		List<Property> propertys = propertyService.getPropertys(Constantes.PROPERTY_ID_PADRE);
		assertNotNull("Property es null", propertys);
	}
}
