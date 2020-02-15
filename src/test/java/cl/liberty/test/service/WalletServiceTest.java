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
import cl.liberty.dao.WalletDao;
import cl.liberty.model.Property;
import cl.liberty.model.ValidityStart;
import cl.liberty.model.Wallet;
import cl.liberty.model.WalletHistory;
import cl.liberty.request.WalletRequest;
import cl.liberty.response.OperationResponse;
import cl.liberty.response.WalletByPolicyResponse;
import cl.liberty.services.PropertyService;
import cl.liberty.services.WalletService;

/**
 * @author jgarrido
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles("local")
public class WalletServiceTest {

	@Autowired
	WalletService walletService;

	@Autowired
	WalletDao walletDao;

	@Autowired
	PropertyService propertyService;

	@Test
	public void walletTest() {
		Integer brokerCode = 0;
		Integer policyNumber = 20323898;
		Integer contractorCode = 0;
		String validInYears = null;
		Property property = propertyService.getProperty(Constantes.PROPERTY_NAME_COVERAGE);
		WalletByPolicyResponse walletPolicyResponse = walletService.wallet(policyNumber, contractorCode, brokerCode,
				validInYears, property.getPropertyId());
		assertNotNull("Cartera es null", walletPolicyResponse);
	}

	@Test
	public void getWalletTest() {
		Integer brokerCode = 0;
		Integer policyNumber = 20323898;
		Integer contractorCode = 0;
		String validInYears = null;
		Wallet wallet = walletService.getWallet(policyNumber, contractorCode, brokerCode, validInYears);
		assertNotNull("Cartera es null", wallet);
	}

	@Test
	public void getWalletHistoryTest() {
		Integer policyNumber = 20323898;
		Integer idUser = 0;
		List<WalletHistory> walletHistorys = walletService.getWalletHistorys(policyNumber, idUser);
		assertNotNull("Historial Cartera es null", walletHistorys);
	}

	@Test
	public void getWalletsTest() {
		Integer brokerCode = 0;
		Integer policyNumber = 20323898;
		Integer contractorCode = 0;
		String validInYears = "0";
		Property property = propertyService.getProperty(Constantes.PROPERTY_NAME_COVERAGE);
		List<Wallet> wallets = walletService.wallets(policyNumber, contractorCode, brokerCode, validInYears,
				property.getPropertyId());
		assertNotNull("Carteras es null", wallets);

	}

	@Test
	public void addBrokerTest() {
		WalletRequest walletRequest = new WalletRequest();
		walletRequest.setWalletName("Incendio y Sismo 2018");
		walletRequest.setPolicyNumber(20323891);
		walletRequest.setValidityStartDate("2019-01-01 01:00:00");
		walletRequest.setValidityEndDate("2019-12-31 23:59:58");
		walletRequest.setContractorCode(1);
		walletRequest.setFlowId(1);
		walletRequest.setUsingId(1);
		walletRequest.setBrokerCode(1);
		walletRequest.setStatus(0);
		try {

			walletService.addWallet(walletRequest);
			assertTrue(true);
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

	@Test
	public void editBrokerTest() {
		WalletRequest walletRequest = new WalletRequest();
		walletRequest.setWalletId(36);
		walletRequest.setWalletName("Incendio y Sismo 2019");
		walletRequest.setPolicyNumber(20323891);
		walletRequest.setValidityStartDate("2019-01-01 01:00:00");
		walletRequest.setValidityEndDate("2019-12-31 23:59:58");
		walletRequest.setContractorCode(1);
		walletRequest.setFlowId(1);
		walletRequest.setUsingId(1);
		walletRequest.setBrokerCode(1);
		walletRequest.setStatus(0);

		try {
			walletService.editWallet(walletRequest);
			assertTrue(true);
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

	@Test
	public void deleteWalletTest() {

		Integer walletId = 4;
		try {
			OperationResponse result = walletService.deleteWallet(walletId);
			assertNotNull("Resultado de eliminacion de cartera es null", result);
			assertTrue("Resultado de eliminacion de cartera falla", Constantes.SUCCESS == result.getResult());
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

	@Test
	public void validateWalletExistTest() {
		try {
			boolean result = walletService.validateWalletExist(1);
			assertTrue("Codigo corredor no existe", result);
		} catch (Exception e) {
			Assert.fail(Errores.EXCEPTION_MESSAGE + e.getMessage());
		}
	}

	@Test
	public void getValidityStartsTest() {
		List<ValidityStart> validityStarts = walletService.getValidityStarts();
		assertNotNull("Cartera con Coberturas es null", validityStarts);
	}

}
