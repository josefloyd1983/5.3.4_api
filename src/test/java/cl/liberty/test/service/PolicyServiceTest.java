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
import cl.liberty.model.Policy;
import cl.liberty.services.PolicyService;

/**
 * @author jgarrido
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("local")
public class PolicyServiceTest {

	@Autowired
	PolicyService policyService;

	@Test
	public void getPolicyTest() {
		int policyNumber = 20323898;
		int branchNumber = 0;
		Policy policy = policyService.getPolicy(policyNumber, branchNumber);
		assertNotNull("Policy es null", policy);
	}

	@Test
	public void policyTest() {
		Integer policyNumber = 20323898;
		Integer branchNumber = 0;
		List<Policy> brokers = policyService.policys(policyNumber, branchNumber, Constantes.PROPERTY_ID_PADRE);
		assertNotNull("Corredor es null", brokers);
	}

	@Test
	public void policyNonMortgagesTest() {
		Integer policyNumber = 20323898;
		List<Policy> brokers = policyService.policyNonMortgages(policyNumber, Constantes.PROPERTY_ID_PADRE);
		assertNotNull("Corredor es null", brokers);
	}

}
