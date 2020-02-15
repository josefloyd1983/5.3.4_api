/**
 * 
 */
package cl.liberty.test.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.liberty.configuration.Application;
import cl.liberty.dao.PropertyDao;
import cl.liberty.dao.WalletDao;
import cl.liberty.model.Wallet;

/**
 * @author jgarrido
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("local")
public class WalletDaoTest {

	@Autowired
	WalletDao walletDao;

	@Autowired
	PropertyDao propertyDao;

	@Test
	public void getWalletTest() {
		Integer brokerCode = -1;
		Integer policyNumber = 20323898;
		Integer contractorCode = -1;
		String validInYears = "2018";
		Wallet wallet = walletDao.getWallet(policyNumber, contractorCode, brokerCode, validInYears);
		assertNotNull("Cartera es null", wallet);
	}

	

}
