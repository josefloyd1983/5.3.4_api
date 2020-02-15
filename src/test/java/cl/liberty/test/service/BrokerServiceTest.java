/**
 * 
 */
package cl.liberty.test.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
import cl.liberty.model.Broker;
import cl.liberty.request.BrokerRequest;
import cl.liberty.response.OperationResponse;
import cl.liberty.services.BrokerService;

/**
 * @author jgarrido
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("local")
public class BrokerServiceTest {

	@Autowired
	BrokerService brokerService;

	@Test
	public void getBrokersTest() {
		List<Broker> brokers = brokerService.getBrokers();
		assertNotNull("Corredores es null", brokers);
	}

	@Test
	public void getBrokerTest() {
		Broker broker = brokerService.getBroker(1440032);
		assertNotNull("Corredor es null", broker);
	}

	@Test
	public void getBrokerByCodeTest() {
		Broker broker = brokerService.getBrokerByCode(1440032);
		assertNotNull("Corredor es null", broker);
	}

	@Test
	public void addBrokerTest() {
		BrokerRequest brokerRequest = new BrokerRequest();
		brokerRequest.setBrokerCode(2);
		brokerRequest.setBrokerDescription("Test2");
		try {
			OperationResponse result = brokerService.addBroker(brokerRequest);
			assertNotNull("Resultado de agregacion de convenio es null", result);
			assertTrue("Resultado de agregacion de convenio falla", Constantes.SUCCESS == result.getResult());
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

	@Test
	public void editBrokerTest() {
		BrokerRequest brokerEditRequest = new BrokerRequest();
		brokerEditRequest.setBrokerCode(2);
		brokerEditRequest.setBrokerDescription("corredor");
		try {
			OperationResponse result = brokerService.editBroker(brokerEditRequest);
			assertNotNull("Resultado de modificacion de corredor es null", result);
			assertTrue("Resultado de modificacion de corredor falla", Constantes.SUCCESS == result.getResult());
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

	@Test
	public void deleteBrokerTest() {
		Integer brokerCode = 2;
		try {
			OperationResponse result = brokerService.deleteBroker(brokerCode);
			assertNotNull("Resultado de eliminacion de corredor es null", result);
			assertTrue("Resultado de eliminacion de corredor falla", Constantes.SUCCESS == result.getResult());
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

	@Test
	public void validateBrokerExistTest() {
		try {
			boolean result = brokerService.validateBrokerExist(1440032);
			assertTrue("Codigo corredor no existe", result);
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}
}
