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
import cl.liberty.model.Contractor;
import cl.liberty.request.ContractorRequest;
import cl.liberty.response.OperationResponse;
import cl.liberty.services.ContractorService;

/**
 * @author jgarrido
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("local")
public class ContractorServiceTest {

	@Autowired
	ContractorService contractorService;

	@Test
	public void getContractorTest() {
		List<Contractor> contractors = contractorService.getContractors();
		assertNotNull("Contratante es null", contractors);
	}

	@Test
	public void addContractorTest() {
		ContractorRequest contractorAddRequest = new ContractorRequest();
		contractorAddRequest.setContractorCode(2);
		contractorAddRequest.setContractorDescription("Test2");
		try {
			OperationResponse result = contractorService.addContractor(contractorAddRequest);
			assertNotNull("Resultado de agregacion de contratante es null", result);
			assertTrue("Resultado de agregacion de contratante falla", Constantes.SUCCESS == result.getResult());
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

	@Test
	public void deleteContractorTest() {
		Integer contractorCode = 5;
		try {
			OperationResponse result = contractorService.deleteContractor(contractorCode);
			assertNotNull("Resultado de eliminacion de contratante es null", result);
			assertTrue("Resultado de eliminacion de contratante falla", Constantes.SUCCESS == result.getResult());
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

	@Test
	public void validateContractorExistTest() {
		try {
			boolean result = contractorService.validateContractorExist(1);
			assertTrue("Codigo contratante no existe", result);
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

}
